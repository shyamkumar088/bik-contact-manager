package com.web.support.gwt;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Spring HandlerMapping that detects beans annotated with @GwtRpcEndPoint and registers their
 * URLs.
 *
 * @author Chris Lee
 */
public class GwtAnnotationHandlerMapping extends AbstractDetectingUrlHandlerMapping {

    private String prefix = "";

    private String suffix = "";

    protected String[] buildUrls(Class handlerType, String beanName) {

        String remoteServiceName = null;
        Class[] interfaces = handlerType.getInterfaces();
        for (Class itf : interfaces) {
            // find the interface that extends RemoteService
            if (RemoteService.class.isAssignableFrom(itf)) {
                remoteServiceName = itf.getName();
            }
        }

        if (remoteServiceName == null) {
            throw new IllegalArgumentException("Unable to generate name for " + handlerType.getName()
                    + "; cannot locate interface that is a subclass of RemoteService");
        }
        String classPath = StringUtils.replace(remoteServiceName, ".", "/");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(classPath);
        sb.append(suffix);
        return new String[]{sb.toString()};
    }

    @Override
    protected final String[] determineUrlsForHandler(String beanName) {
        String[] urls = new String[0];
        Class handlerType = getApplicationContext().getType(beanName);
        if (handlerType.isAnnotationPresent(GwtRpcEndPoint.class)) {
            GwtRpcEndPoint endPointAnnotation = (GwtRpcEndPoint) handlerType.getAnnotation(GwtRpcEndPoint.class);
            if (StringUtils.hasText(endPointAnnotation.value())) {
                urls = new String[]{endPointAnnotation.value()};
            } else {
                urls = buildUrls(handlerType, beanName);
            }
        }

        return urls;
    }

    public final void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public final void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
