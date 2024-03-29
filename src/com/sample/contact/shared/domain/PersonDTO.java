package com.sample.contact.shared.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: zephyr
 * Date: May 8, 2011
 * Time: 2:58:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonDTO implements IsSerializable{

    private Integer id;
    private String firstName;
    private String lastName;
    private boolean deleted;

  public PersonDTO(){};
  public PersonDTO(Integer id, String firstName, String lastName, boolean deleted) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.deleted = deleted;
  }

  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
