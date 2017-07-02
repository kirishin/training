package com.example.umatsu.trainingCRUD.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Validated
public class MemberForm {
	private String id;
	private String name;
	private String birthday;
}
