package com.ny.poja.service;

import com.ny.poja.model.Prime;
import com.ny.poja.repository.PrimeRepository;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static java.math.BigInteger.probablePrime;
import static java.util.UUID.randomUUID;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class PrimeService {
  private static final int BIT_LENGTH = 1000;

  private final PrimeRepository repository;

  public List<BigInteger> tenthLastGeneratedPrime() {
    var allValue = repository.findAll(Sort.by(DESC, "creationDatetime")).stream()
        .map(prime -> new BigInteger(prime.getValue()))
        .toList();
    return allValue.size() > 10 ? allValue.subList(0, 10) : allValue;
  }

  public BigInteger generatePrime() {
    var rnd = new Random();
    BigInteger value = probablePrime(BIT_LENGTH, rnd);
    var generated = repository
        .save(
            Prime.builder()
                .id(randomUUID().toString())
                .creationDatetime(Instant.now())
                .value(value.toString())
                .build()).getValue();
    return new BigInteger(generated);
  }
}
