package com.hypersocket.attributes;

import com.hypersocket.tables.Column;

public enum AttributeCategoryColumns implements Column {

	NAME;

	public String getColumnName() {
		switch (this.ordinal()) {
		default:
			return "name";
		}
	}
}