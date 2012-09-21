package com.example.family;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Parent")
public interface ParentService {

  @MemberOrder(sequence = "1")
  public Parent getParentByExample(String name);

  @MemberOrder(sequence = "2")
  public Parent getParentByQuery(String name);

  @MemberOrder(sequence = "3")
  public Parent newParent(@Named("Name") String name);

}