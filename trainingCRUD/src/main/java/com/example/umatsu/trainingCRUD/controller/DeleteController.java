package com.example.umatsu.trainingCRUD.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.RequestPathConst;
import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.controller.service.CRUDService;
import com.example.umatsu.trainingCRUD.form.MemberForm;

@Controller
public class DeleteController {

	@Autowired
	CRUDService crud;

	/** 削除機能（実行？）
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/crud/delete/confirm" ,method=RequestMethod.POST)
	public ModelAndView deleteConfirm(MemberForm form) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("requestPath", RequestPathConst.REQUEST_DELETE_COMPLETE);
		mav.addObject("member", crud.selectMember(form));
		mav.setViewName(ResourcePathConst.VIEW_FORM);

		return mav;
	}
	/** 削除機能（実行？）
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/crud/delete/complete" ,method=RequestMethod.POST)
	public ModelAndView deleteComplete(MemberForm form){

		ModelAndView mav = new ModelAndView();

		crud.deleteMember(form);
		
		mav.setViewName(RequestPathConst.REDIRECT_SELECT_MEMBERS);
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

}
