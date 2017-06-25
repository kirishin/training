package com.example.umatsu.trainingCRUD.common;

public class RequestPathConst {
	private RequestPathConst(){}
	
	//リクエスト用URL
	public static String REDIRECT_SELECT_MEMBERS = "redirect:/";

	public static String REQUEST_REGISTER_INPUT = "/crud/insert/input";
	public static String REQUEST_REGISTER_CONFIRM = "/crud/insert/confirm";
	public static String REQUEST_REGISTER_COMPLETE = "/crud/insert/complete";

	public static String REQUEST_UPDATE_INPUT = "/crud/update/input";
	public static String REQUEST_UPDATE_CONFIRM = "/crud/update/confirm";
	public static String REQUEST_UPDATE_COMPLETE = "/crud/update/complete";

	public static String REQUEST_DELETE_CONFIRM = "/crud/delete/confirm";
	public static String REQUEST_DELETE_COMPLETE = "/crud/delete/complete";

}
