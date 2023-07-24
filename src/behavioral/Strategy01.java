package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 전략패턴
 * (캡슐화한 알고리즘을 컨텍스트 안에서 바꿔주면서 상호 교체가 가능하게 만드는 디자인 패턴)
 */
public class Strategy01 {

    public static void main(String args[]) {

        BlockchainApi blockchainApi = new BlockchainApi();

        Item A = new Item("test01",300);
        Item B = new Item("test02",200);

        blockchainApi.addItem(A);
        blockchainApi.addItem(B);

        blockchainApi.balance(new BnbStrategy("BNB","apiUrl"));
        blockchainApi.balance(new EthStrategy("ETH","uuidddd"));

    }
}


class EthStrategy implements BlockchainStrategy {
    private String name;
    private String uuid;

    public EthStrategy(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    @Override
    public void balance(int cost, int tot) {
        System.out.println(uuid + " eth balnace!");
        System.out.println(" cost :: " + cost + " , tot :: " + tot);
    }
}

class BnbStrategy implements BlockchainStrategy {
    private String email;
    private String apiUrl;

    public BnbStrategy(String email, String apiUrl) {
        this.email = email;
        this.apiUrl = apiUrl;
    }

    @Override
    public void balance(int cost, int tot) {
        System.out.println(email + " bnb balance!");
        System.out.println(" cost :: " + cost + " , tot :: " + tot);
    }
}

class Item {
    private String description;
    private int price;

    public Item(String description, int cost) {
        this.description = description;
        this.price = cost;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

}

class BlockchainApi {
    List<Item> items;

    public BlockchainApi() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void remoteItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for(Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }


    public void balance(BlockchainStrategy blockchainStrategy) {
        int tot = calculateTotal();
        for(int i=0; i<items.size(); i++) {
            blockchainStrategy.balance(items.get(i).getPrice(), tot);
        }
    }
}

interface BlockchainStrategy {
    public void balance(int cost, int tot);
}
