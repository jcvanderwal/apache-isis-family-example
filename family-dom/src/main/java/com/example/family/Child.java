package com.example.family;


import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Title;

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.UUIDHEX)
@javax.jdo.annotations.Queries( {
  @javax.jdo.annotations.Query(
      name="getChild", language="JDOQL",  
      value="SELECT FROM com.example.family.Child WHERE name == :name"),
})
public class Child extends AbstractDomainObject {

  // -------------------------------------------------------------------------
  // Attributes
  // -------------------------------------------------------------------------
  
  private String name; 
  private Parent parent; 
  
  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  public Child() {
    super();
  }

  // -------------------------------------------------------------------------
  // Getter / Setters
  // -------------------------------------------------------------------------
  
  @Title
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Parent getParent() {
    return parent;
  }
  
  public void setParent(Parent parent) {
    this.parent = parent;
  }

}