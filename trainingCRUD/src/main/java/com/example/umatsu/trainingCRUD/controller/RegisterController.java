package com.example.umatsu.trainingCRUD.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Controller
public class RegisterController {
	@Autowired
	private TbMemberMapper mapper;

	/**　登録機能インプット画面への遷移
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/insert/input")
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
	@RequestMapping("/crud/insert/complete")
	public String insertComplete(Model model, MemberForm form) {
		insertMember(form);
		//謎コード？
//		selectAll(model);
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

	protected void insertMember(MemberForm form) {
		TbMember tbMember = setBean(form);
		tbMember.setId(null);
		mapper.insertSelective(tbMember);
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
}
