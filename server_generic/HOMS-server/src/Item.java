/**
 * Created by Ian on 30/03/2015.
 *
 * Item Object Constructor
 */
final class Item {

	private final int I_Id;
	private final String Item_Name;
	private final String Item_Description;
	private final int Item_Price;
	private final int Item_Available;
	private final int Item_Is_Vegetarian;
	private final int Item_Is_Vegan;
	private final int Item_Is_Spicy;

	public Item(int iid, String itemName, String itemDescription, int itemPrice, int itemAvailable, int itemIsVegetarian, int itemIsVegan, int itemIsSpicy) {
		this.I_Id = iid;
		this.Item_Name = itemName;
		this.Item_Description = itemDescription;
		this.Item_Price = itemPrice;
		this.Item_Available = itemAvailable;
		this.Item_Is_Vegetarian = itemIsVegetarian;
		this.Item_Is_Vegan = itemIsVegan;
		this.Item_Is_Spicy = itemIsSpicy;
	}


	public int getItem_Is_Spicy() {
		return Item_Is_Spicy;
	}

	public int getI_Id() {
		return I_Id;
	}

	public String getItem_Name() {
		return Item_Name;
	}

	public String getItem_Description() {
		return Item_Description;
	}

	public int getItem_Price() {
		return Item_Price;
	}

	public int getItem_Available() {
		return Item_Available;
	}

	public int getItem_Is_Vegetarian() {
		return Item_Is_Vegetarian;
	}

	public int getItem_Is_Vegan() {
		return Item_Is_Vegan;
	}
}
