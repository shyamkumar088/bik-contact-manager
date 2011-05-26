package com.sample.contact.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.contact.client.contactService;
import com.sample.contact.server.dao.BasicDAO;
import com.sample.contact.server.domain.Person;
import com.sample.contact.shared.domain.PersonDTO;

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

  public List<PersonDTO> findAllPersons() {

    return createPersonDto(basicDAO.findAllPerson());
  }

  private List<PersonDTO> createPersonDto(List<Person> persons){
    List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
    for(Person person : persons){
      personDTOs.add(new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.isDeleted()));
    }
    return personDTOs;
  }
}