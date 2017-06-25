package com.example.umatsu.trainingCRUD.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.RequestPathConst;
import com.example.umatsu.trainingCRUD.common.ResourcePathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class UpdateController {
	@Autowired
	private TbMemberMapper mapper;

	/** 更新機能インプット画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/update/input")
	public ModelAndView updateInsert(MemberForm form) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requestPath", "crud/update/confirm");
		setMember(mav ,form);
		mav.setViewName(ResourcePathConst.INPUT_FORM);
		return mav;
	}
	/** 更新機能確認ト画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/update/confirm")
	public ModelAndView updateConfirm(MemberForm form) {
//		ModelAndView mav = new ModelAndView();
		return updateComplete(form);
	}
	
	/** 更新機能実行後・全権検索・リスト画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/crud/update/complete", method = RequestMethod.POST)
	public ModelAndView updateComplete(MemberForm form) {
		ModelAndView mav = new ModelAndView();
		updateMember(form);
		mav.setViewName(RequestPathConst.REDIRECT_SELECT_MEMBERS);
		return mav;
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

	/**
	 * 全権検索用(そのうち分けたい)
	 * 
	 * @param model
	 */
	protected void setMember(ModelAndView mav, MemberForm form) {
		TbMember member = mapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		form = setForm(member);
		mav.addObject("member", form);
	}

	protected void updateMember(MemberForm form) {
		TbMember tbMember = setBean(form);
		mapper.updateByPrimaryKeySelective(tbMember);
	}

	private TbMember setBean(MemberForm form) {
		TbMember tbMember = new TbMember();
		try {
			tbMember.setId(Integer.parseInt(form.getId()));
		} catch (Exception e) {
		}
		tbMember.setName(form.getName());
		tbMember.setBirthday(Date.valueOf(form.getBirthday().replaceAll("/", "-")));
		return tbMember;
	}

	private MemberForm setForm(TbMember member) {
		MemberForm form = new MemberForm();
		form.setId(""+member.getId());
		form.setName(member.getName());
		form.setBirthday(new SimpleDateFormat("yyyy/MM/dd").format(member.getBirthday()));
		return form;
	}

}
