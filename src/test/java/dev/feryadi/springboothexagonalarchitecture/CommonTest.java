package dev.feryadi.springboothexagonalarchitecture;

import org.junit.jupiter.api.Test;

import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerIn;


public class CommonTest {


  @Test
  public void test1() {
    System.out.println("hello world!");

    GetCustomerIn in = new GetCustomerIn(1L);

    System.out.println(in);
  }

} 
