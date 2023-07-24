package create;

/**
 * 싱글톤패턴(이중확인장금(DCL))
 * 이중확인잠금(Double Checked Locking). 인스턴스 생성여부를 싱글톤 패턴 잠금 전에 한번. 객체를 생성하기전에 한번 2번 체크하면
 * 인스턴스가 존재하지 않을때만 잠금을 걸 수 있기 때문에 앞서 생겼던 문제를 해결할 수 있다.
 */
public class Singleton05 {

    /**
     * volatile
     * 자바에서는 스레드가 2개가 열리면 변수를 메인 메모리(ram)으로부터 가져오는 것이 아니라 캐시메모리에서 각각의 케시메모리를 기반으로 가져오게 된다.
     * volatile 키워드를 사용하여 캐시메모리가 아닌 메인메모리에서 값을 가져올 수 있도록 한다.
     */
    private volatile Singleton05 instance;

    private Singleton05() {
    }

    public Singleton05 getInstance() {
        if(instance == null) {
            synchronized (Singleton05.class) {
                if(instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
