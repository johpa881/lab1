package lab1;

public class WearableItem extends Item{
	int extrahp;
	public WearableItem(double weight, String name, int price, int itemSlot, int extrahp) {
		super(weight, name, price, itemSlot);
		this.extrahp = extrahp;
	}
	
	public void putOn(Player player) {
		player.equipItem(this);
		player.setHealth(100 + extrahp);
		System.out.println("You now have " + getName() + " on you.");
		System.out.println("Your health is now " + player.getHealth());
	}
}
