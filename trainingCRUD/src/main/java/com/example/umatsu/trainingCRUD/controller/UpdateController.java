package com.example.umatsu.trainingCRUD.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;

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
public class UpdateController {
	@Autowired
	private TbMemberMapper mapper;

	/** 更新機能インプット画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/update/input")
	public String updateInsert(Model model, MemberForm form) {
		model.addAttribute("requestPath", "crud/update/confirm");
		setMember(model ,form);
		return PathConst.FORM;
	}
	/** 更新機能確認ト画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/update/confirm")
	public String updateConfirm(Model model, MemberForm form) {
		return updateComplete(model, form);
	}
	
	/** 更新機能実行後・全権検索・リスト画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/crud/update/complete", method = RequestMethod.POST)
	public String updateComplete(Model model, MemberForm form) {
		updateMember(form);
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

	/**
	 * 全権検索用(そのうち分けたい)
	 * 
	 * @param model
	 */
	protected void setMember(Model model, MemberForm form) {
		TbMember member = mapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		form = setForm(member);
		model.addAttribute("member", form);
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
