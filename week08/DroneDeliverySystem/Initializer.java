package DroneDeliverySystem;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import DroneDeliverySystem.drones.Drone;
import DroneDeliverySystem.drones.DroneManager;
import DroneDeliverySystem.request.RequestManager;
import DroneDeliverySystem.warehouse.Product;
import DroneDeliverySystem.warehouse.Warehouse;
import DroneDeliverySystem.warehouse.WarehouseManager;

public class Initializer {
	private static final Product[] initProducts = {new Product(1, "Keyboard", 0.6),
										new Product(2, "Table", 6.8),
										new Product(3, "Car", 1500),
										new Product(4, "Glass", 0.2)};
	
	private static final int[] initQuantities = {5, 3, 2, 4};
	
	public static RequestManager initRequestManager(){
		
		
		WarehouseManager wareHouseManager = new WarehouseManager(initWarehouses());
		
		DroneManager droneManager = initDroneManager();
		
		return new RequestManager(droneManager, wareHouseManager);
	}
	
	private static List<Warehouse> initWarehouses() {
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		warehouses.add(new Warehouse(initProducts, initQuantities, new Point(42, 42)));
		
		return warehouses;
	}
	
	private static DroneManager initDroneManager() {
		
		Drone drone = new Drone(1, 2000, 500, 5);
		
		DroneManager droneM = new DroneManager();
		droneM.addAvailableDrone(drone, 50);
		
		return droneM;
	}
}