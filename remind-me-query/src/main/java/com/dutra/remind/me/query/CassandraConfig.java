package com.dutra.remind.me.query;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		return "remind_me";
	}

	@Override
	protected int getPort() {
		return 9042;
	}

	@Override
	protected String getContactPoints() {
		return "127.0.0.1";
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[]{"com.dutra.remind.me.query"};
	}
}
