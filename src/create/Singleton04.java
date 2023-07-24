package create;

/**
 * 싱글톤패턴(정적맴버와 Lazy Holder(중첩 클래스))
 * singleInstanceHolder라는 내부클래스를 하나 더 만듬으로써, Singleton클래스가 최초에 로딩되더라도
 * 함께 초기화가 되지 않고, getInstance()가 호출될때 singleInstanceHolder클래스가 로딩되어 인스턴스를 생성됨
 * 가장많이 사용함.
 */
public class Singleton04 {

    private static class singleInstanceHolder {
        private static final Singleton04 INSTANCE = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return singleInstanceHolder.INSTANCE;
    }


}
