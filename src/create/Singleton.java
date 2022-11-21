public class Singleton {

    /***
     * 싱글톤 예제
     */
    private String text = "설정된 텍스트 없어.";
    private static Singleton INSTANCE;

    Singleton(String text) {
        this.text = text;
    }

    public static Singleton getInstance(String text) {
        if(INSTANCE == null) INSTANCE = new Singleton(text);
        return INSTANCE;
    }

    public void getTest() {
        System.out.println("## singleton test :: " + text);
    }

    public static void main(String args[]) {
        Singleton singleton01 = Singleton.getInstance("내가잴먼저만들었어.");
        Singleton singleton02 = Singleton.getInstance("난 두번째로 먼저만들었어.");
        singleton01.getTest();
        singleton02.getTest();
    }

}


