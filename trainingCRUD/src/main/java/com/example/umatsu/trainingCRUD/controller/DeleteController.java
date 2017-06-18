package com.example.umatsu.trainingCRUD.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class DeleteController {
	@Autowired
	private TbMemberMapper mapper;

	/** 削除機能（実行？）
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/crud/delete/confirm" ,method=RequestMethod.POST)
	public String deleteConfirm(Model model ,MemberForm form) {
		
		return deleteComplete(model, form);
	}
	/** 削除機能（実行？）
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/crud/delete/complete" ,method=RequestMethod.POST)
	public String deleteComplete(Model model ,MemberForm form){
		deleteMember(form);
		return PathConst.REDIRECT_SELECT_MEMBERS;
	}
	
	/**
	 * 画面へのインスタンスメッセージ表示用(使わないかも)
	 * 
	 * @param model
	 * @param message
	 */
	protected void addInstanceMessage(Model model, String message) {
		model.addAttribute("instanceMessage", message);
	}

	protected void putTitle(Model model, String title) {
		model.addAttribute("title", title);
	}

	protected void deleteMember(MemberForm form) {
		TbMember tbMember = new TbMember();
		tbMember.setId(Integer.parseInt(form.getId()));
		tbMember.setDeleteFlag(1);
		mapper.updateByPrimaryKeySelective(tbMember);
	}
}
