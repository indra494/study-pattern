package create;

/**
 * 싱글톤패턴 (synchronized사용)
 * 인스턴스를 반환하기전까지 격리공간에 놓기 위해 synchronized 키워드로 잠금을 할수 있음
 * 단점 : 최초로 접근한 스레드가 해당 메서드를 호출시 다른스레드가 접근하지 못하도록 lock. 이때 getInstance() 메서드를 호출할때마다 lock이 발생하여 성능이 저하됨.
 */
public class Singleton02 {
    private static Singleton02 instance;

    private Singleton02() {
    }

    public static synchronized Singleton02 getInstance() {
        if(instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton02 singleton = Singleton02.getInstance();
    }

}
