public abstract class BattleLoc extends Location {
    protected Monster monster;
    protected String award;

    BattleLoc(Player player, String name, Monster monster, String award) {
        super(player);
        this.monster = monster;
        this.name = name;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int monsCount = monster.monsterCount();
        System.out.println("Su anda " + this.getName() + " bolgesindesiniz.");
        System.out.println("Dikkat! Burada " + monsCount + " tane " + monster.getName() + " var!");
        System.out.println("1-Savas\n2-Kac");
        int selCase = inp.nextInt();
        if (selCase == 1) {
            if (combat(monsCount)) {
                System.out.println(this.getName() + "  bolgesindeki tum canavarlari yendiniz!");
                if (this.award.equals("Yemek") && player.getInv().isFood() == false) {
                    System.out.println(this.award + (" kazandiniz!"));
                    player.getInv().setFood(true);
                } else if (this.award.equals("Su") && player.getInv().isWater() == false) {
                    System.out.println(this.award + (" kazandiniz!"));
                    player.getInv().setWater(true);
                } else if (this.award.equals("Odun") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + (" kazandiniz!"));
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if (player.getHealth() <= 0) {
                System.out.println("Oldunuz :(");
                return false;
            }

        }
        return true;

    }

    public boolean combat(int monsCount) {
        for (int i = 0; i < monsCount; i++) {
            int defMonsHealth = monster.getHealth();
            playerStats();
            enemyStats();
            while (monster.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("1-Vur\n2-Kac");
                int selCase = inp.nextInt();
                if (selCase == 1) {
                    System.out.println("Siz vurdunuz!");
                    monster.setHealth(monster.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (monster.getHealth() > 0) {
                        System.out.println(monster.getName() + " vurdu!");
                        player.setHealth(player.getHealth() - (monster.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else {
                        return false;
                    }
                }
                if (monster.getHealth() < player.getHealth()) {
                    System.out.println("Canavari yendiniz!");
                    player.setMoney(player.getMoney() + monster.getAward());
                    System.out.println("Guncel paraniz: " + player.getMoney());
                    monster.setHealth(defMonsHealth);
                }
            else {
                    return false;
                }
            }
            return true;
        }





    public void playerStats() {
        System.out.println("Guncel caniniz: " + player.getHealth());
        System.out.println("Guncel hasariniz: " + player.getTotalDamage());
        System.out.println("Guncel paraniz: " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Guncel silahiniz: " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Guncel kalkaniniz: " + player.getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println(monster.getName() + " can: " + monster.getHealth());
        System.out.println(monster.getName() + " hasar: " + monster.getDamage());
        System.out.println(monster.getName() + " odul: " + monster.getAward());
    }
    public void afterHit() {
        System.out.println("Sizin caniniz: " + player.getHealth());
        System.out.println(monster.getName() + " cani: " + monster.getHealth());
        System.out.println();
    }
}
