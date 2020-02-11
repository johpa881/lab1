package lab1;

public abstract class Item {
	private final double weight;
	private final String name;
	private final int price;
	private int itemSlot;
	private boolean equipped = false;
	
	public Item(double weight, String name, int price, int itemSlot) {
		this.weight = weight;
		this.name = name;
		this.price = price;
		this.itemSlot = itemSlot;
	}

	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isEquipped() {
		return equipped;
	}

	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}

	public int getItemSlot() {
		return itemSlot;
	}

	public void setItemSlot(int itemSlot) {
		this.itemSlot = itemSlot;
	}
	
	public void printYourself() {
		
	}
	
	public abstract void doCommand(Player player);
	
	
}
