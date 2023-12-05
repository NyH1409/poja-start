package com.ny.poja.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ny.poja.conf.FacadeIT;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PrimeControllerIT extends FacadeIT {

  @Autowired PrimeController primeController;

  @Test
  void generatePrime() {
    BigInteger primeNumber = primeController.generatePrime();
    assertEquals(10_000, primeNumber.bitLength());
  }

  @Test
  void generatedPrimes() {
    List<BigInteger> ninePrimeNumbers = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      BigInteger generated = primeController.generatePrime();
      ninePrimeNumbers.add(generated);
    }

    BigInteger lastPrime = primeController.generatePrime();
    List<BigInteger> primeNumbers = primeController.generatedPrimes();

    assertEquals(10, primeNumbers.size());
    assertEquals(lastPrime, primeNumbers.get(0));
    assertTrue(primeNumbers.containsAll(ninePrimeNumbers));
  }
}
