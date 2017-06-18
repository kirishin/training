package jp.or.yanbarukuina.janken;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	final int WIN = 2;
    	final int DROW = 1;
    	final int ROSE = 0;


        int myHand = Manager.create();
        int rivalHand = Manager.create();


        System.out.println("私は"+Manager.getHandStr(myHand)+"です。");
        System.out.println("相手は"+Manager.getHandStr(rivalHand)+"です。");

        switch (Manager.check(myHand, rivalHand)) {
		case WIN:
			System.out.println("勝利");
			break;
		case DROW:
			System.out.println("引き分け");
			break;
		case ROSE:
			System.out.println("敗北");
			break;

		default:
			System.out.println("不明");
			break;
		}
    }
}
