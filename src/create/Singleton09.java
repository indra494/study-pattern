public class Singleton09 {

    /***
     * 싱글톤 예제
     */
    private String text = "설정된 텍스트 없어.";
    private static Singleton09 INSTANCE;

    Singleton09(String text) {
        this.text = text;
    }

    public static Singleton09 getInstance(String text) {
        if(INSTANCE == null) INSTANCE = new Singleton09(text);
        return INSTANCE;
    }

    public void getTest() {
        System.out.println("## singleton test :: " + text);
    }

    public static void main(String args[]) {
        Singleton09 singleton09 = Singleton09.getInstance("내가잴먼저만들었어.");
        Singleton09 singleton0102 = Singleton09.getInstance("난 두번째로 먼저만들었어.");
        singleton09.getTest();
        singleton0102.getTest();
    }

}


