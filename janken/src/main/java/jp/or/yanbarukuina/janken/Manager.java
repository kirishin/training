package jp.or.yanbarukuina.janken;

public class Manager {
	public static final int GOO = 0;
	public static final int CHOKI = 1;
	public static final int PAR = 2;
	public static final int HAND_VER = 3;
	public static final int HAND_REF = 1;


	public static int create(){
		return (int)(Math.random()*3);
	}
	public static String getHandStr(int handInt){
		switch(handInt){
		case GOO:
			return "グー";
		case CHOKI:
			return "チョキ";
		case PAR:
			return "パー";
		default:
			return "不正です。";

		}
	}
	public static int check(int myHand, int rivalHand){
		return (HAND_REF - myHand + rivalHand + HAND_VER) % HAND_VER;
	}
}
