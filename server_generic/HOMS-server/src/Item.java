/**
 * Created by Ian on 30/03/2015.
 *
 * Item Object Constructor
 */
final class Item {

	private final String I_Id;
	private final String Item_Name;
	private final String Item_Description;
	private final String Item_Price;
	private final String Item_Available;
	private final String Item_Is_Vegetarian;
	private final String Item_Is_Vegan;
	private final String Item_Is_Spicy;

	public Item(String iid, String itemName, String itemDescription, String itemPrice, String itemAvailable, String itemIsVegetarian, String itemIsVegan, String itemIsSpicy) {
		this.I_Id = iid;
		this.Item_Name = itemName;
		this.Item_Description = itemDescription;
		this.Item_Price = itemPrice;
		this.Item_Available = itemAvailable;
		this.Item_Is_Vegetarian = itemIsVegetarian;
		this.Item_Is_Vegan = itemIsVegan;
		this.Item_Is_Spicy = itemIsSpicy;
	}


	public String getItem_Is_Spicy() {
		return Item_Is_Spicy;
	}

	public String getI_Id() {
		return I_Id;
	}

	public String getItem_Name() {
		return Item_Name;
	}

	public String getItem_Description() {
		return Item_Description;
	}

	public String getItem_Price() {
		return Item_Price;
	}

	public String getItem_Available() {
		return Item_Available;
	}

	public String getItem_Is_Vegetarian() {
		return Item_Is_Vegetarian;
	}

	public String getItem_Is_Vegan() {
		return Item_Is_Vegan;
	}
}
