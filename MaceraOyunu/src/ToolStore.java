public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Paraniz: " + player.getMoney());
        System.out.println("1-Silahlar");
        System.out.println("2-Kalkanlar");
        System.out.println("3-Cikis");
        System.out.println("Seciminiz: ");
        int selTool = inp.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;

            default:
                break;
        }
        return true;
    }

    public int weaponMenu() {
        System.out.println("1-Tabanca\tHasar: 2\t Para: 25");
        System.out.println("2-Kilic\t    Hasar: 3\t Para: 35");
        System.out.println("3-Tufek\t    Hasar: 7\t Para: 45");
        System.out.println("4-Cikis");
        System.out.println("Lutfen seciminizi giriniz: ");
        int selWeaponID = inp.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        if (itemID > 0 || itemID < 4) {
            switch (itemID) {
                case 1:
                    damage = 2;
                    price = 25;
                    wName = "Tabanca";
                    break;
                case 2:
                    damage = 3;
                    price = 35;
                    wName = "Kilic";
                    break;
                case 3:
                    damage = 7;
                    price = 45;
                    wName = "Tufek";
                    break;
                case 4:
                    System.out.println("Cikis yapiliyor.");
                    break;
                default:
                    System.out.println("Gecersiz bir islem yaptiniz.");
                    break;

            }
            if(price>0) {
                if (player.getMoney() >= price) {
                    player.getInv().setDamage(damage);
                    player.getInv().setwName(wName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println(wName + " satin aldiniz.Onceki hasar: " + player.getDamage() + " Guncel hasar: " + (player.getTotalDamage()));
                    System.out.println("Kalan paraniz: " + player.getMoney());
                } else {
                    System.out.println("Yeterli paraniz bulunmamaktadir.");
                }
            }
        }

    }

    public int armorMenu() {
        System.out.println("1-Hafif\t Engelleme: 1\t Para: 15");
        System.out.println("2-Orta\t Engelleme: 3\t Para:25");
        System.out.println("3-Agir\t Engelleme: 5\t Para: 40");
        System.out.println("4-Cikis");
        System.out.println("Lutfen seciminizi giriniz: ");
        int selArmorID = inp.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String aName = null;
        if (itemID > 0 || itemID < 4) {
            switch (itemID) {
                case 1:
                    avoid = 1;
                    price = 15;
                    aName = "Hafif kalkan";
                    break;
                case 2:
                    avoid = 3;
                    price = 25;
                    aName = "Orta kalkan";
                    break;
                case 3:
                    avoid = 5;
                    price = 40;
                    aName = "Agir kalkan";
                    break;
                case 4:
                    System.out.println("Cikis yapiliyor.");
                    break;
                default:
                    System.out.println("Gecersiz bir islem yaptiniz.");
                    break;

            }
            if(price>0) {
                if (player.getMoney() >= price) {
                    player.getInv().setArmor(avoid);
                    player.getInv().setaName(aName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println(aName + " satin aldiniz. Engellenen hasar: "+player.getInv().getArmor());
                    System.out.println("Kalan paraniz: " + player.getMoney());
                } else {
                    System.out.println("Yeterli paraniz bulunmamaktadir.");
                }
            }
        }



    }
}
