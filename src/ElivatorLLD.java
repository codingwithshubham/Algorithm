// Multi Elivator System

->Reuirements:

 -> Multiple Elivators at Each floor
 -> External button (UP/Down) to get elivator 
 -> Internal Buttons for floor.


 -> Objects:

 	External Button (Direction, FloorId, Dispatcher)
 	ElivatorCar (ElivatorId, List<Internal Buttons>, CurrentFloorId, State, Direction)
 	ElivatorCarController(controllerId, ElivatorCar, []pendingReq, minHeap (UP), maxHeap (down))
 	InternalButton (floorId, controllerId);

 	Dispatcher(List<controllerId> ids, FloorId, Direction); // algo



 	// POJO
 	class ElivatorCar {
 		int elivatorId;
 		int floorId; // current floor of Elivator
 		List<InternalButton> internalButtons;
 		State currentState;
 		Direction direction;


 		// getters & setters
 	}

 	enum State {
 		IDLE, MOVING, OUT_OF_SERVICE;
 	}

 	enum Direction {
 		UP, DOWN;
 	}


 	class ElivatorController {
 		int controllerId;
 		ElivatorCar elivatorCar;
 		int[] pendingRequests; // floors to serve
 		PriorityQueue<Integer> minHeap;  // to serve the UP direction Requests
 		PriorityQueue<Integer> maxHeap;  // to serve the Down direction Requests


 		serveRequest(ExternalRequest request) {
 			// business Logic
 		}
 	}

 	class ElivatorControllerManager {
 		List<ElivatorController> controllers;
 		List<ExternalRequest> externalRequests; // requests to serve
 		ElivatorPicker elivatorPicker;


 		// business Logic to choose and dispatch request to corresponding Controller;

 		ElivatorController elivatorController = elivatorPicker.findElivator();
 		elivatorController.serveRequet(request);

 	}


 	class Dispatcher {
 		int dispatcherId;
 		ElivatorControllerManager controllerManager;
 		ExternalRequest externalRequest; 

 	}

 	class ExternalRequest {
		Direction direction;
 		int floorId;
 	}

 	class InternalButton {
 		int floorId;
 		ElivatorController elivatorController;
 	}

 	class ExternalButton {
 		int floorId; // destination for Elivator Car to pick the person
 		Direction direction; 
 		Dispatcher requestDispatcher;
 	}



 	=================================

 	 Interface ElivatorPicker {
 	 	// returns the Elivator Controller based on Business logic
 	 	ElivatorController findElivator(List<ElivatorController> controllers, ExternalRequest request);
 	 }

 	 // strategy 1
 	 class SweepAlgoElivatorPickerImpl implements ElivatorPicker {

 	 	@Override
 	 	ElivatorController findElivator(List<ElivatorController> controllers, ExternalRequest request) {
 	 		// logic
 	 	}
 	 }

 	 class LookFirstAlgoElivatorPickerImpl implements ElivatorPicker {

 	 	@Override
 	 	ElivatorController findElivator(List<ElivatorController> controllers, ExternalRequest request) {
 	 		// logic
 	 	}
 	 }

 	 ===================================



 	 Look First Algo :


 	 	Elivator currentFloor;
 	 	Elivator state;
 	 	Elivator Direction;




















