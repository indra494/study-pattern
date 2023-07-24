package create;

/**
 * 싱글톤패턴(정적맴버)
 * static 맴버나 블록은 런타임이 아니라 최초에 JVM이 클래스에 로딩될때 모든 클래스들을 로드할때 미리 인스턴스를 생성하는데 이를 이용하는 방법
 * 클래스 로딩과 동시에 싱글톤 인스턴스를 만든다. 그렇기 때문에 모듈들이 싱글톤인스턴스를 요청할때 그냥 만들어진 인스턴스를 반환하면 된다.
 * 단점 : 불필요한 자원낭비. 싱글톤 인스턴스가 필요 없는 경우도 무조건 싱글톤 클래스를 호출해 인스턴스를 만들어야 하기 때문.
 */
public class Singleton03 {

    private final static Singleton03 instance = new Singleton03();

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        return instance;
    }

    public static void main(String args[]) {
        Singleton03 singleton = Singleton03.getInstance();
    }

}
