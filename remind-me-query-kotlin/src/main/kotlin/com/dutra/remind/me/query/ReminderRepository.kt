package com.dutra.remind.me.query

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import java.util.*

interface ReminderRepository : ReactiveCassandraRepository<Reminder, UUID>