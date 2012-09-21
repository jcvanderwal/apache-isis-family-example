package com.example.family.objstore;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.query.QueryDefault;

import com.example.family.Parent;
import com.example.family.ParentService;

public class ParentServiceDefault extends AbstractFactoryAndRepository implements
    ParentService {

  // {{ Id, iconName
  @Override
  public String getId() {
    return "parent";
  }

  public String iconName() {
    return "parent";
  }

  // }}

  @Override
  public Parent getParentByExample( String name ) {
    Parent parent = new Parent();   
    parent.setName(name); 

    List<Parent> parents = allMatches(Parent.class, parent);
    parent = null;
    if ( !parents.isEmpty() ) {
      parent = parents.get(0);
    }
    return parent;
  }
  
  @Override
  public Parent getParentByQuery( String name ) {     
    List<Parent> parents = allMatches(
        new QueryDefault<Parent>(Parent.class, "getParent", "name", name));
    Parent parent = null;
    if ( !parents.isEmpty() ) {
      parent = parents.get(0);
    }
    return parent;
  }
  
  @Override
  public Parent newParent( String name ) {
    Parent parent = newTransientInstance(Parent.class);
    parent.setName(name);
    persist( parent );
    return parent;
  }
}
