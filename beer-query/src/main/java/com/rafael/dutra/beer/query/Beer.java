package com.rafael.dutra.beer.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "beer")
public class Beer {

	@PrimaryKey
	private int id;
	private String name;
	private String type;

	public Beer(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("name", name)
				.append("type", type)
				.toString();
	}
}
