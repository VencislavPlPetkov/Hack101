package DroneDeliverySystem.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WarehouseManager implements WarehouseManagerInterface {
	
	private List<Warehouse> warehouses;

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}
	
	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public WarehouseManager(List<Warehouse> warehousesList) {
		this.warehouses = new ArrayList<Warehouse>();
		this.setWarehouses(warehousesList);
	}

	public void addWarehouse(Warehouse w) {
		getWarehouses().add(w);
	}
	
	private ProductWrapper searchProductAndQuantity(int id, int quantity) {
		for (Warehouse warehouse : getWarehouses()) {
			Map<Integer, ProductWrapper> products = warehouse.getProducts();
			
			if (products.containsKey(id)) {
				if (products.get(id).getQuantity() >= quantity) {
					return products.get(id);
				}
			}
		}
		return null;
	}

	public boolean isProductAvailable(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		
		if (product == null) {
			return false;
		}
		
		return true;
	}

	public double calcWeightUnit(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		
		if (product == null) {
			return -1;
		}
		
		return product.getProduct().getWeight() * quantity;
	}

	public void sendProduct(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		int newQuantity = product.getQuantity() - quantity;
		
		product.setQuantity(newQuantity);
	}
}