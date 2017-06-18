package com.example.umatsu.trainingCRUD.criteria;

import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.model.TbMemberExample;

public class MemberExampleManager{
	TbMemberExample example = new TbMemberExample();

	public TbMemberExample create(SelectMemberForm form){
		example.createCriteria().andBirthdayEqualTo(null);
		return example;
	}
//	void 
}
