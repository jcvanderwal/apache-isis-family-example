package com.example.family;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Child")
public interface ChildService {

  @MemberOrder(sequence = "1")
  public Child getChildByExample(String name);

  @MemberOrder(sequence = "2")
  public Child getChildByQuery(String name);

}