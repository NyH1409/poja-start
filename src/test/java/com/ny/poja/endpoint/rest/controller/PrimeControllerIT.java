package com.ny.poja.endpoint.rest.controller;

import com.ny.poja.conf.FacadeIT;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeControllerIT extends FacadeIT {

  @Autowired PrimeController primeController;

  @Test
  void generatePrime() {
    BigInteger primeNumber = primeController.generatePrime();
    assertEquals(10_000, primeNumber.bitLength());
  }

}
