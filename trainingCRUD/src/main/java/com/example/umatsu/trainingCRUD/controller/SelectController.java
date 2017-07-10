package com.example.umatsu.trainingCRUD.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.service.CRUDService;

/**
 * 検索画面用途
 */
@RequestMapping(value = "/crud/search")
@Controller
public class SelectController {
	@Autowired
	private CRUDService crudService;

	/**
	 * 全件検索実行・リスト画面への遷移
	 * 
	 * @param mav
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/", method={GET, POST})
	public ModelAndView selectAll() {

		ModelAndView mav = new ModelAndView();
		addInstanceMessage(mav, "全件検索をしました");
		mav.addObject("requestFormPath", "/crud/search/");
		return selectAll(new SelectMemberForm());

	}

	/**
	 * @param form
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/", params = "selectMemberForm", method = {GET, POST})
	public ModelAndView selectAll(SelectMemberForm form) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("memberList", crudService.selictMembers(form));
		mav.addObject("selectMemberForm", form);
		mav.addObject("requestFormPath", "/crud/search/");
		addInstanceMessage(mav, "検索をしました");

		mav.setViewName(ResourcePathConst.SELECT_MEMBERS);

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
