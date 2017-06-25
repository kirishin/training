package com.example.umatsu.trainingCRUD.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class SelectController {
	@Autowired
	private TbMemberMapper mapper;

	/**
	 * 全権検索実行・リスト画面への遷移
	 * 
	 * @param mav
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/")
	public ModelAndView selectAll() {

		ModelAndView mav = new ModelAndView();

		addInstanceMessage(mav, "全権検索をしました");

		return selectAll(new SelectMemberForm());

	}

	/**
	 * @param mav
	 * @param form
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/", params = "selectMemberForm", method = RequestMethod.POST)
	public ModelAndView selectAll(SelectMemberForm form) {

		ModelAndView mav = new ModelAndView();

		selictMember(mav, form);
		mav.addObject("selectMemberForm", form);
		mav.addObject("requestFormPath", "/");
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

	/**
	 * 全権検索用(そのうち分けたい)
	 * 
	 * @param mav
	 */
	protected void selictMember(ModelAndView mav, SelectMemberForm form) {
		List<TbMember> memberList = mapper.findMember(form);
		mav.addObject("memberList", memberList);
	}

	/**
	 * 全権検索用(そのうち分けたい)
	 * 
	 * @param mav
	 */
	protected void setMember(ModelAndView mav, MemberForm form) {
		TbMember member = mapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		form = setForm(member);
		mav.addObject("member", form);
	}

	private MemberForm setForm(TbMember member) {
		MemberForm form = new MemberForm();
		form.setId("" + member.getId());
		form.setName(member.getName());
		form.setBirthday(new SimpleDateFormat("yyyy/MM/dd").format(member.getBirthday()));
		return form;
	}

}
