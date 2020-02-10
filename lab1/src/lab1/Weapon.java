package lab1;

public class Weapon extends Item {

	public Weapon(double weight, String name, int price,int itemSlot) {
		super(weight, name, price, itemSlot);
	}
	
	public void fireWeapon() {
		System.out.println("You shoot your " + this.getName() + " at nothing.");
	}
	
}
