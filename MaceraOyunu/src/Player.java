import java.util.Scanner;

public class Player {
    Scanner inp = new Scanner(System.in);
    private int damage, health, money, realh;


    private String name, username;
    private Inventory inv;

    public Player(String name) {
        this.name = name;
        this.inv=new Inventory();
    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public void characterInfo() {
        switch (characterSelection()) {
            case 1:
                selectPlayer("Samuray", 5, 21, 25);
                break;
            case 2:
                selectPlayer("Okcu", 7, 18, 30);
                break;
            case 3:
                selectPlayer("Sovalye", 8, 24, 15);
                break;
            default:
                selectPlayer("Samuray", 5, 21, 25);
                break;
        }
        System.out.println("Karakteriniz: " + getUsername() + "\tHasar gucu: " + getDamage() + "\tSaglik: " + getHealth() + "\tParasi: " + getMoney());
    }

    public int characterSelection() {
        System.out.println("Secmek istediginiz karakterin numarasini giriniz.");
        System.out.println("-------KARAKTERLER-------");
        System.out.println("1-Samuray\tHasar: 5\t  Sağlık: 21\t  Para: 25");
        System.out.println("2-Okçu\t    Hasar: 7\t  Sağlık: 18\t  Para: 30");
        System.out.println("3-Sovalye\tHasar: 8\t  Sağlık: 24\t  Para: 15");
        System.out.println("Karakter seciminizi giriniz:");
        int secim = inp.nextInt();
        while (secim < 1 || secim > 3) {
            System.out.println("Lutfen gecerli bir secim yapiniz.");
            secim = inp.nextInt();
        }
        return secim;

    }

    public void selectPlayer(String nm, int dmg, int hlt, int mny) {
        setUsername(nm);
        setDamage(dmg);
        setHealth(hlt);
        setMoney(mny);
        setRealh(hlt);


    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getRealh() {
        return realh;
    }

    public void setRealh(int realh) {
        this.realh = realh;
    }
}
