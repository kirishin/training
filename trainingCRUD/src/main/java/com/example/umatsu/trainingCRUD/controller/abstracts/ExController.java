package com.example.umatsu.trainingCRUD.controller.abstracts;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

/**
 * コントローラーの拡張
 * 
 * @author yanbarukuina
 * 統合の為一時非推奨設定
 *
 */
@Deprecated
public abstract class ExController {

	@Autowired
	private TbMemberMapper mapper;

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
