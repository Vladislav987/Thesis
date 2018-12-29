package content;

import java.io.Serializable;

public class User implements Serializable {
    private final String name;
    private final int age;
    private long money;
    private PlayList myPlayLists = new PlayList("Мой лэйлист");

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getMoney() {
        return money;
    }

    public PlayList getMyPlayLists() {
        return myPlayLists;
    }

    public void pay(long price) {
        if (money < price) {
            throw new Video.NoMoneyException("Недостаточно денег");
        } else {
            money = money - price;
        }
    }

    public void replenishAccount(long moneyTot) {
        money = money + moneyTot;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", myPlayLists=" + myPlayLists +
                '}';
    }
}
