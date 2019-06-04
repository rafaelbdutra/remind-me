package com.dutra.remind.me.query

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
class CassandraConfig : AbstractReactiveCassandraConfiguration() {

    override fun getKeyspaceName(): String {
        return "remind_me"
    }

    override fun getPort(): Int {
        return 9042
    }

    override fun getContactPoints(): String {
        return "127.0.0.1"
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }

    override fun getEntityBasePackages(): Array<String> {
        return arrayOf("com.dutra.remind.me.query")
    }
}
