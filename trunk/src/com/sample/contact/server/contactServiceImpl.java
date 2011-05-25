package com.sample.contact.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.contact.client.contactService;
import com.sample.contact.server.dao.BasicDAO;
import com.sample.contact.shared.domain.Person;

import java.util.*;

public class contactServiceImpl extends RemoteServiceServlet implements contactService {
  private BasicDAO basicDAO;

  public void setBasicDAO(BasicDAO basicDAO) {
    this.basicDAO = basicDAO;
  }

  // Implementation of sample interface method
  public String getMessage(String msg) {
    return "Client said: \"" + msg + "\"<br>Server answered: \"Hello!\"";
  }

  public List<Person> findAllPersons() {
    return basicDAO.findAllPerson();
  }
}