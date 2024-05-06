
import java.util.Scanner;

public class Game {
    Scanner inp = new Scanner(System.in);
    Player player;
    Location location;

    public void login() {

        System.out.println("Macera oyununa hos geldiniz!");
        System.out.println("Lutfen isminizi giriniz.");
        String playerName = inp.nextLine();
        player = new Player(playerName);
        player.characterInfo();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("---------------------");
            System.out.println();
            System.out.println("Lutfen konumunuzu seciniz.");
            System.out.println("1-Guvenli ev:\t Size ait guvenli bir mekan,dusman yok.");
            System.out.println("2-Magara:     \t Karsiniza zombi cikabilir!");
            System.out.println("3-Orman:     \t Karsiniza vampir cikabilir!");
            System.out.println("4-Nehir:     \t Karsiniza ayi cikabilir!");
            System.out.println("5-Magaza:     \t Silah veya kalkan alabilirsiniz.");
            int selLoc = inp.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.println("Lutfen gecerli bir secim yapiniz.");
                selLoc = inp.nextInt();
            }
            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;

            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isWater() && player.getInv().isFood()) {
                    System.out.println("Tebrikler,oyunu basariyla tamamladiniz.");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Oyun bitti!");
                break;
            }
        }
    }
}

