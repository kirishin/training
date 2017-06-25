package com.example.umatsu.trainingCRUD.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class DeleteController {
	@Autowired
	private TbMemberMapper mapper;

	/** 削除機能（実行？）
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/crud/delete/confirm" ,method=RequestMethod.POST)
	public ModelAndView deleteConfirm(ModelAndView mav ,MemberForm form) {

//		ModelAndView mav = new ModelAndView();

		return deleteComplete(form);
	}
	/** 削除機能（実行？）
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/crud/delete/complete" ,method=RequestMethod.POST)
	public ModelAndView deleteComplete(MemberForm form){

		ModelAndView mav = new ModelAndView();

		deleteMember(form);
		
		mav.setViewName(PathConst.REDIRECT_SELECT_MEMBERS);
		return mav;
	}
	
	/**
	 * 画面へのインスタンスメッセージ表示用(使わないかも)
	 * 
	 * @param mav
	 * @param message
	 */
	protected void addInstanceMessage(ModelAndView mav, String message) {
		mav.addObject("instanceMessage", message);
	}

	protected void putTitle(ModelAndView mav, String title) {
		mav.addObject("title", title);
	}

	protected void deleteMember(MemberForm form) {
		TbMember tbMember = new TbMember();
		tbMember.setId(Integer.parseInt(form.getId()));
		tbMember.setDeleteFlag(1);
		mapper.updateByPrimaryKeySelective(tbMember);
	}
}
