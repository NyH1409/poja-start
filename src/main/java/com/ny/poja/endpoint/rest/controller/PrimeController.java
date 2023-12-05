package com.ny.poja.endpoint.rest.controller;

import com.ny.poja.service.PrimeService;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PrimeController {
  private final PrimeService service;

  @GetMapping("/new-prime")
  public BigInteger generatePrime() {
    return service.generatePrime();
  }

  @GetMapping("/generated-primes")
  public List<BigInteger> generatedPrimes() {
    return service.tenthLastGeneratedPrime();
  }
}
