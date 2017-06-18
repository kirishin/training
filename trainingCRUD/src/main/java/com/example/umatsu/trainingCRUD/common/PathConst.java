package com.example.umatsu.trainingCRUD.common;

public class PathConst {
	private PathConst(){}
	
	//htmlのパス
	public static String SELECT_MEMBERS = "/crud/select_members";
	public static String FORM = "/crud/member_form";
	public static String CONFIRM = "/crud/member_confirm";

	//リダイレクト用URL
	public static String REDIRECT_SELECT_MEMBERS = "redirect:/";
}
