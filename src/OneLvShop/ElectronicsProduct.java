package OneLvShop;

public class ElectronicsProduct extends Product{
	private int guaranteePeriodInMonths;

	public ElectronicsProduct(String name, double price, int quantity,
			AgeRestriction ageRestriction, int guaranteePeriodInMonths) {
		super(name, price, quantity, ageRestriction);
		this.guaranteePeriodInMonths = guaranteePeriodInMonths;
	}
}
