package com.dutra.remind.me.query

import com.datastax.driver.core.DataType
import org.springframework.data.cassandra.core.mapping.CassandraType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table(value = "reminder")
data class Reminder(
        @PrimaryKey
        @CassandraType(type = DataType.Name.UUID)
        var id: UUID,
        var remindTo: String,
        var type: String
)