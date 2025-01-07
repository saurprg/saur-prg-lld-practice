from vehicle import VehicleType, Vehicle

class ParkingSpot:

    def __init__(self, type: VehicleType, id: str):
        self.type = type
        self.id = id
        self.parked_vehicle = None

    def park(self, vehicle: Vehicle):
        self.parked_vehicle = vehicle
    
    def un_park(self):
        self.parked_vehicle = None
            
    def is_occupied(self):
        return self.parked_vehicle != None