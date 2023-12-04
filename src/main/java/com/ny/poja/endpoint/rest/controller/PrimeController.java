package com.ny.poja.endpoint.rest.controller;

import java.math.BigInteger;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.math.BigInteger.probablePrime;

@RestController
public class PrimeController {

  @GetMapping("/new-prime")
  public BigInteger generatePrime() {
    var rnd = new Random();
    return probablePrime(10_000, rnd);
  }

}
