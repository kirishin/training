package com.example.umatsu.trainingCRUD.controller;


import java.sql.Date;
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
@RequestMapping("/")
public class RootController {
	@Autowired
	private TbMemberMapper mapper;


	/** 全権検索実行・リスト画面への遷移
	 * @param model
	 * @return
	 */
	@Transactional
	@RequestMapping()
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
	@RequestMapping(params="selectMemberForm", method=RequestMethod.POST)
	public String selectAll(Model model ,SelectMemberForm form) {
		
		selictMember(model, form);
		model.addAttribute("selectMemberForm", form);
		model.addAttribute("requestFormPath" ,"");
		addInstanceMessage(model, "検索をしました");
		return PathConst.SELECT_MEMBERS;
	}

	/**　登録機能インプット画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("crud/insert/input")
	public String insertInsert(Model model, MemberForm form) {
		model.addAttribute("requestPath", "crud/insert/complete");
		putTitle(model ,"登録フォーム");
		model.addAttribute("member" ,form);
		return PathConst.FORM;
	}
	/**　登録機能実行
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("crud/insert/complete")
	public String insertComplete(Model model, MemberForm form) {
		insertMember(form);
		selectAll(model);
		return PathConst.SELECT_MEMBERS;
	}

	/** 更新機能インプット画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("crud/update/input")
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
	@RequestMapping("crud/update/confirm")
	public String updateConfirm(Model model, MemberForm form) {
		return updateComplete(model, form);
	}
	
	/** 更新機能実行後・全権検索・リスト画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "crud/update/complete", method = RequestMethod.POST)
	public String updateComplete(Model model, MemberForm form) {
		updateMember(form);
		return selectAll(model);
	}

	/** 削除機能（実行？）
	 * @param model
	 * @return
	 */
	@RequestMapping("crud/delete/confirm")
	public String deleteConfirm(Model model ,MemberForm form) {
		
		return deleteComplete(model, form);
	}
	/** 削除機能（実行？）
	 * @param model
	 * @return
	 */
	@RequestMapping("crud/delete/complete")
	public String deleteComplete(Model model ,MemberForm form){
		deleteMember(form);
		return selectAll(model);
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

	protected void insertMember(MemberForm form) {
		TbMember tbMember = setBean(form);
		tbMember.setId(null);
		mapper.insertSelective(tbMember);
	}

	protected void updateMember(MemberForm form) {
		TbMember tbMember = setBean(form);
		mapper.updateByPrimaryKeySelective(tbMember);
	}

	protected void deleteMember(MemberForm form) {
		TbMember tbMember = new TbMember();
		tbMember.setId(Integer.parseInt(form.getId()));
		tbMember.setDeleteFlag(1);
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
