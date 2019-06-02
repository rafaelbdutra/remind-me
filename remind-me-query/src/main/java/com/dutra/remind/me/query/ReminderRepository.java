package com.dutra.remind.me.query;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface ReminderRepository extends ReactiveCassandraRepository<Reminder, UUID> {
}
