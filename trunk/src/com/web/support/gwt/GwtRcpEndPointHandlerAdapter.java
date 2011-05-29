package com.web.support.gwt;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Spring HandlerAdapter to dispatch GWT-RPC requests. Relies on handlers
 * registered by GwtAnnotationHandlerMapper
 *
 * @author Chris Lee, Martin Zdila
 *
 */
public class GwtRcpEndPointHandlerAdapter extends RemoteServiceServlet implements HandlerAdapter, ApplicationContextAware {

 private static ThreadLocal< Object> handlerHolder = new ThreadLocal< Object>();
 private static final long serialVersionUID = -7421136737990135393L;
 private ApplicationContext applicationContext;


 @Override
 public long getLastModified(final HttpServletRequest request, final Object handler) {
  return -1;
 }


 @Override
 public ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
  try {
   // store the handler for retrieval in processCall()
   handlerHolder.set(handler);
   doPost(request, response);
  } finally {
   // clear out thread local to avoid resource leak
   handlerHolder.set(null);
  }

  return null;
 }


 protected Object getCurrentHandler() {
  return handlerHolder.get();
 }


 @Override
 public boolean supports(final Object handler) {
  return handler instanceof RemoteService /*&& handler.getClass().isAnnotationPresent(GwtRpcEndPoint.class)*/;
 }


 @Override
 public String processCall(final String payload) throws SerializationException {
  /*
   * The code below is borrowed from RemoteServiceServet.processCall, with
   * the following changes:
   *
   * 1) Changed object for decoding and invocation to be the handler
   * (versus the original 'this')
   */

     try {
   final RPCRequest rpcRequest = RPC.decodeRequest(payload, getCurrentHandler().getClass() /* this.getClass() */, this);
   return RPC.invokeAndEncodeResponse(getCurrentHandler() /* this */, rpcRequest.getMethod(), rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());
  } catch (final IncompatibleRemoteServiceException ex) {
   getServletContext().log("An IncompatibleRemoteServiceException was thrown while processing this call.", ex);
   return RPC.encodeResponseForFailure(null, ex);
  }
 }


 @Override
 public ServletContext getServletContext() {
  return ((WebApplicationContext) applicationContext).getServletContext();
 }


 @Override
 public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
  this.applicationContext = applicationContext;
 }

}