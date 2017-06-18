package com.example.umatsu.trainingCRUD.mapper.provider;

import static org.apache.ibatis.jdbc.SelectBuilder.AND;
import static org.apache.ibatis.jdbc.SelectBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SelectBuilder.FROM;
import static org.apache.ibatis.jdbc.SelectBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SelectBuilder.SELECT;
import static org.apache.ibatis.jdbc.SelectBuilder.SQL;
import static org.apache.ibatis.jdbc.SelectBuilder.WHERE;

import java.util.Map;

import com.example.umatsu.trainingCRUD.form.SelectMemberForm;

public class MySelectProvider {

	public String findBy(Map<String, SelectMemberForm> params) {
		SelectMemberForm form = params.get("selectMemberForm");
		BEGIN();
		SELECT("id,name,birthday");
		FROM("TB_MEMBER");

		boolean first = true;
		if (form.getId() != null && form.getId().length() != 0) {
			and(first);
			WHERE("id = '" + form.getId() + "'");
		}

		if (form.getName() != null && form.getName().length() != 0) {
			and(first);
			WHERE("name LIKE '%" + form.getName() + "%'");
		}

		String birthdayMin = null;
		String birthdayMax = null;
		and(first);
		if (form.getBirthdayMin() != null && form.getBirthdayMin().length() != 0) {
			birthdayMin = form.getBirthdayMin().replaceAll("/", "-");
		} else {
			birthdayMin = "1000-1-1";
		}
		if (form.getBirthdayMax() != null && form.getBirthdayMax().length() != 0) {
			birthdayMax = form.getBirthdayMax().replaceAll("/", "-");
		} else {
			birthdayMax = "9999-12-31";
		}
		WHERE("birthday BETWEEN '" + birthdayMin + "' AND '" + birthdayMax + "'");
		AND();
		WHERE("delete_flag = 0");
		ORDER_BY("id");
		return SQL();
	}

	private void and(boolean first) {
		if (first) {
			first = false;
		} else {
			AND();
		}
	}
}
