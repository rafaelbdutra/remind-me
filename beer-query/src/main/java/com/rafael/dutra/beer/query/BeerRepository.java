package com.rafael.dutra.beer.query;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface BeerRepository extends ReactiveCassandraRepository<Beer, Integer> {
}
