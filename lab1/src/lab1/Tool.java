package lab1;

public class Tool extends Item{
	String string;
	public Tool(double weight, String name, int price, int itemSlot, String string) {
		super(weight, name, price, itemSlot);
		this.string = string;
	}
	
	
	@Override
	public void doCommand(Player player) {
		if (player.getLocation().isWinGame()) {
			System.out.println("You win.");
		}
	}

}
