
package com.example.umatsu.trainingCRUD.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.RequestPathConst;
import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.service.CRUDService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class DeleteController {

	@Autowired
	CRUDService crudService;

	/**
	 * 削除機能（実行？）
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/crud/delete/confirm" ,method = RequestMethod.POST)
	public ModelAndView deleteConfirm(@Valid MemberForm form ,BindingResult bl) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("requestPath", RequestPathConst.REQUEST_DELETE_COMPLETE);
		mav.addObject("member", crudService.selectMember(form));

		mav.setViewName(ResourcePathConst.VIEW_FORM);

		return mav;
	}

	/**
	 * 削除機能（実行？）
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/crud/delete/complete" ,method = RequestMethod.POST)
	public ModelAndView deleteComplete(MemberForm form) {

		ModelAndView mav = new ModelAndView();

		crudService.deleteMember(form);

		mav.setViewName(RequestPathConst.REDIRECT_SELECT_MEMBERS);
		return mav;
	}

	/**
	 * 画面へのインスタンスメッセージ表示用(使わないかも)
	 * 
	 * @param mav
	 * @param message
	 */
	protected void addInstanceMessage(ModelAndView mav ,String message) {
		mav.addObject("instanceMessage", message);
	}

	protected void putTitle(ModelAndView mav ,String title) {
		mav.addObject("title", title);
	}

}
