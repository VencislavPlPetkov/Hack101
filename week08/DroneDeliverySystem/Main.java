package DroneDeliverySystem;

import java.util.*;

import DroneDeliverySystem.request.Request;

import DroneDeliverySystem.request.*;

public class Main {

	public static void main(String[] args) {
		
		Queue<Request> requests = readRequest();
		
		RequestManager reqM = Initializer.initRequestManager();
		
		
		Iterator<Request> iterator = requests.iterator();
		while (iterator.hasNext()) {
			reqM.processRequest(iterator.next());
		}
		
		int availableDronesNum = reqM.getDroneManager().getAvailableDrones().get(1).getQuantity();
		int unavalableDronesNum = reqM.getDroneManager().getUnavailableDrones().get(1).getQuantity();
		
		System.out.printf("Available drones number: %d", availableDronesNum);
		System.out.printf("Unavailable drones number: %d", unavalableDronesNum);
	}
	
	public static Queue<Request> readRequest() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter time stamp: ");
		String timeStamp = input.nextLine();
		
		System.out.print("Enter row: ");
		int row = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter column: ");
		int column = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter the number of deliveries: ");
		int n = Integer.parseInt(input.nextLine());
		
		Queue<Request> requests = new LinkedList<Request>();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter product id: ");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.print("Enter product quantity: ");
			int quantity = Integer.parseInt(input.nextLine());
			Request req = new Request(id, quantity);
			
			requests.add(req);
		}
		
		
		return requests;
	}

}