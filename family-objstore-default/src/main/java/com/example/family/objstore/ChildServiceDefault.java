package com.example.family.objstore;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.query.QueryDefault;

import com.example.family.Child;
import com.example.family.ChildService;

public class ChildServiceDefault extends AbstractFactoryAndRepository implements
    ChildService {

  // {{ Id, iconName
  @Override
  public String getId() {
    return "child";
  }

  public String iconName() {
    return "child";
  }

  // }}

  @Override
  public Child getChildByExample( String name ) {
    Child child = new Child();   
    child.setName(name); 

    List<Child> childs = allMatches(Child.class, child);
    child = null;
    if ( !childs.isEmpty() ) {
      child = childs.get(0);
    }
    return child;
  }
  
  @Override
  public Child getChildByQuery( String name ) {     
    List<Child> childs = allMatches(
        new QueryDefault<Child>(Child.class, "getChild", "name", name));
    Child child = null;
    if ( !childs.isEmpty() ) {
      child = childs.get(0);
    }
    return child;
  }
  
}
