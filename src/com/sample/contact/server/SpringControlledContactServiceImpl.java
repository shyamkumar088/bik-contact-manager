package com.sample.contact.server;

import com.sample.contact.client.contactService;
import com.sample.contact.server.dao.BasicDAO;
import com.sample.contact.server.domain.Person;
import com.sample.contact.shared.domain.PersonDTO;
import com.web.support.gwt.GwtRpcEndPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zephyr
 * Date: 5/28/11
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@GwtRpcEndPoint
/*@RequestMapping(value = "/contactService.rpc", method = RequestMethod.POST)*/
public class SpringControlledContactServiceImpl  /*extends GwtRpcController*/ implements contactService {
  private BasicDAO basicDAO;

  public void setBasicDAO(BasicDAO basicDAO) {
    this.basicDAO = basicDAO;
  }

   /* public SpringControlledContactServiceImpl(){
        super();
        this.setRemoteService(this);
    }*/
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
