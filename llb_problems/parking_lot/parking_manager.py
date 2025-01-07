from parking import Parking
from vehicle import Vehicle
from level import NoSpaceException

class ParkingManager:

    def __init__(self):
        self.parking = Parking("Phoenix mall parking", 2)
    
    def park(self, vehicle: Vehicle):
        status = self.parking.park(vehicle)
        print(f"Successfully Parked {vehicle}") if status else print(f"No space for {vehicle}")
    
    def un_park(self, vehicle: Vehicle):
        status = self.parking.un_park(vehicle)
        print(f"Successfully Un-Parked {vehicle}") if status else print(f"Vehicle not found {vehicle}")