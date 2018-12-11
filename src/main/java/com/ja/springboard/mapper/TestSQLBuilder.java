package com.ja.springboard.mapper;

import java.util.List;
import java.util.Map;

public class TestSQLBuilder {
	public String selectInTest(Map<String, Object> parameters) {
		List<String> listT_id = (List<String>) parameters.get("listT_id");
		StringBuilder builder = new StringBuilder("SELECT * FROM testtable where t_id IN('");
		for (String i : listT_id) {
			builder.append(i + "','");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.deleteCharAt(builder.length() - 1);

		builder.append(")");
		System.out.println(builder.toString());
		return builder.toString();
	}
}