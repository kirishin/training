package com.example.umatsu.trainingCRUD.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.umatsu.trainingCRUD.common.PathConst;
import com.example.umatsu.trainingCRUD.controller.abstracts.ExController;
import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;

@Controller
@RequestMapping("/")
public class RootController extends ExController {

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
}
