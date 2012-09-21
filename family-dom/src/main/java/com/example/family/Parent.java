package com.example.family;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Title;

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.UUIDHEX)
@javax.jdo.annotations.Queries( {
  @javax.jdo.annotations.Query(
      name="getParent", language="JDOQL",  
      value="SELECT FROM com.example.family.Parent WHERE name == :name"),
})
public class Parent extends AbstractDomainObject {

  // -------------------------------------------------------------------------
  // Attributes
  // -------------------------------------------------------------------------
  
  private String name;

  @Persistent(mappedBy="parent")
  private final List<Child> children = new ArrayList<Child>();
  
  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  public Parent() {
    super();
  }

  // -------------------------------------------------------------------------
  // Getter / Setters
  // -------------------------------------------------------------------------
  
  public List<Child> getChildren() {
    return children;
  }
  
  public void addToChildren(Child child) {
    if(child == null || children.contains(child)) {
      return;
    }
    child.setParent(this);
    children.add(child);
  }
  
  @Title
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  // -------------------------------------------------------------------------
  // Isis Actions 
  // -------------------------------------------------------------------------

  public void addChild( @Named("Name") String name ) {
    final Child child = newTransientInstance(Child.class);
    child.setName(name);
    addToChildren(child);
    persist(child);
  }
}