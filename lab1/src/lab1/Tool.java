package lab1;

public class Tool extends Item{
	
	public Tool(double weight, String name, int price, int itemSlot) {
		super(weight, name, price, itemSlot);
	}
	
	public void useTool(Player player) {
		if (player.getLocation().isWinGame()) {
			System.out.println("You win.");
		}

	}

}
