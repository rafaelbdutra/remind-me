package com.dutra.remind.me.query;

import com.datastax.driver.core.DataType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table(value = "reminder")
public class Reminder {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String remindTo;
    private String type;

    public Reminder(UUID id, String remindTo, String type) {
        this.id = id;
        this.remindTo = remindTo;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getRemindTo() {
        return remindTo;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("remindTo", remindTo)
                .append("type", type)
                .toString();
    }
}
