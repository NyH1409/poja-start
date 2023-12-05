package com.ny.poja.service;

import static java.math.BigInteger.probablePrime;
import static java.util.UUID.randomUUID;
import static org.springframework.data.domain.Sort.Direction.DESC;

import com.ny.poja.model.Prime;
import com.ny.poja.repository.PrimeRepository;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrimeService {
  private static final int BIT_LENGTH = 10_000;

  private final PrimeRepository repository;

  public List<BigInteger> tenthLastGeneratedPrime() {
    return repository.findAll(Sort.by(DESC, "creationDatetime")).stream()
        .map(prime -> new BigInteger(prime.getValue().getBytes()))
        .collect(Collectors.toList())
        .subList(0, 10);
  }

  public BigInteger generatePrime() {
    var rnd = new Random();
    BigInteger value = probablePrime(BIT_LENGTH, rnd);
    String generated =
        repository
            .save(
                Prime.builder()
                    .id(randomUUID().toString())
                    .creationDatetime(Instant.now())
                    .value(value.toString())
                    .build())
            .getValue();
    return new BigInteger(generated.getBytes());
  }
}
