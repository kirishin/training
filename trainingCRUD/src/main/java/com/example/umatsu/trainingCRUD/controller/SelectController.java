package com.example.umatsu.trainingCRUD.controller;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class SelectController {
	@Autowired
	private TbMemberMapper mapper;


	/** 全権検索実行・リスト画面への遷移
	 * @param model
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/" ,method=RequestMethod.POST)
	public String selectAll(Model model) {
		addInstanceMessage(model, "全権検索をしました");
		return selectAll(model, new SelectMemberForm());
	}
	/**
	 * @param model
	 * @param form
	 * @return
	 */
	@Transactional
	@RequestMapping(params="/selectMemberForm", method=RequestMethod.POST)
	public String selectAll(Model model ,SelectMemberForm form) {
		
		selictMember(model, form);
		model.addAttribute("selectMemberForm", form);
		model.addAttribute("requestFormPath" ,"");
		addInstanceMessage(model, "検索をしました");
		return PathConst.SELECT_MEMBERS;
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
	protected void selictMember(Model model, SelectMemberForm form) {
		List<TbMember> memberList = mapper.findMember(form);
		model.addAttribute("memberList", memberList);
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

	private MemberForm setForm(TbMember member) {
		MemberForm form = new MemberForm();
		form.setId(""+member.getId());
		form.setName(member.getName());
		form.setBirthday(new SimpleDateFormat("yyyy/MM/dd").format(member.getBirthday()));
		return form;
	}

}
