package com.example.umatsu.trainingCRUD.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

import lombok.extern.log4j.Log4j;

@Controller
public class RegisterController {
	@Autowired
	private TbMemberMapper mapper;

	/**　登録機能インプット画面への遷移
	 * @param mav
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/insert/input")
	public ModelAndView insertInsert(MemberForm form) {

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("requestPath", "crud/insert/complete");
		putTitle(mav ,"登録フォーム");
		mav.addObject("member" ,form);
		
		mav.setViewName(PathConst.FORM);
		
		return mav;
	}
	/**　登録機能実行
	 * @param mav
	 * @param form
	 * @return
	 */
	@RequestMapping("/crud/insert/complete")
	public ModelAndView insertComplete(MemberForm form) {

		ModelAndView mav = new ModelAndView();

		insertMember(form);
		//謎コード？
//		selectAll(mav);
		
		mav.setViewName(PathConst.REDIRECT_SELECT_MEMBERS);
		
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
