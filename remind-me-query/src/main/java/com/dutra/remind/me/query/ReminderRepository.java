package com.dutra.remind.me.query;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ReminderRepository extends ReactiveCassandraRepository<Reminder, String> {
}
