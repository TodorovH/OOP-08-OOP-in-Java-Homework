package OneLvShop;

import java.time.LocalDate;
import java.sql.Date;

public class PurchaseManager {
	
	public static void processPurchase(Product product, Customer customer) {
		
		checkForOutOfStock(product);
		checkForExpiredDate(product);
		checkForEnoughMoney(customer, product);
		checkForAgeRestriction(customer, product);
		
		double newBalance = customer.getBalance() - product.getPrice();
		int newQuantity = product.getQuantity() - 1;
		customer.setBalance(newBalance);
		product.setQuantity(newQuantity);
	}

	private static void checkForAgeRestriction(Customer customer,
			Product product) {
		if(product.getAgeRestriction() == AgeRestriction.Adult){
			if (customer.getAge() < 18){
				throw new RuntimeException(customer.getName() + " is too young to buy this product.");
			}
		}
	}

	private static void checkForEnoughMoney(Customer customer, Product product) {
		if (customer.getBalance() < product.getPrice()){
			throw new RuntimeException("Not enough money in the balance for this product.");
		}
	}

	private static void checkForExpiredDate(Product product) {
		if (product instanceof Expirable) {
			Expirable expirableProduct = (Expirable)product;
			Date now = Date.valueOf(LocalDate.now());
			if (expirableProduct.getExpirationDate().before(now)) {
				throw new RuntimeException(product.getName() + " is past its date." );
			}
		}
	}

	private static void checkForOutOfStock(Product product){
		if (product.getQuantity() <= 0){
			throw new RuntimeException("Not enough quantity of this prodict.");
		}
	}
}
