public class SafeHouse extends NormalLoc {
    SafeHouse(Player player) {

        super(player, "Guvenli ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getRealh());
        System.out.println("Caniniz yenilendi.\nSu an guvenli evdesiniz.");
        return true;
    }
}
