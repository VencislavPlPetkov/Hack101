package DroneDeliverySystem.request;

import DroneDeliverySystem.warehouse.*;
import DroneDeliverySystem.drones.*;

public class RequestManager {
	
	private DroneManager droneManager;
	
	private WarehouseManager warehouseManager;
	
	
	public DroneManager getDroneManager() {
		return droneManager;
	}

	public void setDroneManager(DroneManager droneManager) {
		this.droneManager = droneManager;
	}

	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}

	public RequestManager(DroneManager droneManager, WarehouseManager warehouseManager) {
		this.setDroneManager(droneManager);
		this.setWarehouseManager(warehouseManager);
	}
	
	public void processRequest(Request request) {
		int requestId = request.getId();
		int requestQuantity = request.getQuantity();
		
		double weight = 0;
		int dronesNumber = 0;
		
		if (getWarehouseManager().isProductAvailable(requestId, requestQuantity)) {
			weight = getWarehouseManager().calcWeightUnit(requestId, requestQuantity);
			
		} else {
			System.out.printf("I am sorry, we don' t have enough quantity"
					+ " of product with id %d%n", requestId); 
			return;
		}
		
		if (getDroneManager().areThereAvailableDrones(weight)) {
			dronesNumber = getDroneManager().calcDronesNumber(weight);
			
		} else {
			System.out.printf("I am sorry, we don' t have available drones "
					+ "to deliver product with id %d%n", requestId);
			return;
		}
		
		getWarehouseManager().sendProduct(requestId, requestQuantity);
		
		getDroneManager().sendDrones(weight);
		
		System.out.printf("Product id %d delivered with %d drone(s).%n", requestId, 
																	   dronesNumber);
	}
}