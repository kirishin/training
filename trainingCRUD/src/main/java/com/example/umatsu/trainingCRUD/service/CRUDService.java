package com.example.umatsu.trainingCRUD.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.umatsu.trainingCRUD.form.MemberForm;
import com.example.umatsu.trainingCRUD.form.SelectMemberForm;
import com.example.umatsu.trainingCRUD.mapper.TbMemberMapper;
import com.example.umatsu.trainingCRUD.model.TbMember;

@Service
public class CRUDService {
	
	public static final int RESULT_SUCCESS = 1;
	public static final int RESULT_FAIL = 0;
	
	@Autowired
	private TbMemberMapper mapper;
	
	/** IDから1件のmember情報を取得する
　　　　 *　　
	 */
	public MemberForm selectMember(MemberForm form) {
		TbMember member = mapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		form = setForm(member);
		return form;
	}

	/**
	 * 任意の検索条件に当てはまる未削除のmember情報を取得する
	 * 
	 * @param form
	 */
	public List<TbMember> selictMembers(SelectMemberForm form) {
		return mapper.findMember(form);
	}

	public boolean updateMember(MemberForm form) {
		TbMember tbMember = setBean(form);

		return mapper.updateByPrimaryKeySelective(tbMember) == RESULT_SUCCESS;
	}


	public void insertMember(MemberForm form) {
		TbMember tbMember = setBean(form);
		tbMember.setId(null);
		mapper.insertSelective(tbMember);
	}

	/**
	 * 該当するIDのメンバーのdelete_flagを1にする
	 * @param form
	 * @return
	 */
	public boolean deleteMember(MemberForm form) {
		TbMember tbMember = new TbMember();
		tbMember.setId(Integer.parseInt(form.getId()));
		tbMember.setDeleteFlag(1);

		return mapper.updateByPrimaryKeySelective(tbMember) == RESULT_SUCCESS;
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
