package create;

/**
 * 싱글톤패턴
 * (단순한 메서드 호출)
 * 단점 : 메서드의 원자성이 결여되어있음. 멀티스레드 환경에서는 싱글톤 인스턴스를 2개 이상 만들어질 수 있음
 */
public class Singleton01 {
    private static Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if(instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton01 singleton = Singleton01.getInstance();
    }

}
