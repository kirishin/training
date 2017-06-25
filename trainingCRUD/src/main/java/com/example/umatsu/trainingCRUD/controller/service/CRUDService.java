package com.example.umatsu.trainingCRUD.controller.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Service
public class CRUDService {
	@Autowired
	private TbMemberMapper mapper;
	
	/** IDからmember情報を取得する
　　　　 *　　
	 */
	public MemberForm selectMember(MemberForm form) {
		TbMember member = mapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		form = setForm(member);
		return form;
	}


	public void deleteMember(MemberForm form) {
		TbMember tbMember = new TbMember();
		tbMember.setId(Integer.parseInt(form.getId()));
		tbMember.setDeleteFlag(1);
		mapper.updateByPrimaryKeySelective(tbMember);
	}
	
	private MemberForm setForm(TbMember member) {
		MemberForm form = new MemberForm();
		form.setId(""+member.getId());
		form.setName(member.getName());
		form.setBirthday(new SimpleDateFormat("yyyy/MM/dd").format(member.getBirthday()));
		return form;
	}

}
