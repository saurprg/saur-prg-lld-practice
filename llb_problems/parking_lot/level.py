from parking_spot import ParkingSpot
from vehicle import VehicleType, Vehicle

VEHICLE_TYPE_SPOTS_PER_LEVEL = {
    VehicleType.CAR: 1,
    VehicleType.BIKE: 2,
    VehicleType.TRUCK: 1
}

class NoSpaceException(Exception):
    pass

class Level:

    def __init__(self, height: int):
        self.parking_layout = {
            VehicleType.CAR: [ParkingSpot(VehicleType.CAR, f'L{height}::{spot}') for spot in range(VEHICLE_TYPE_SPOTS_PER_LEVEL[VehicleType.CAR])],
            VehicleType.BIKE: [ParkingSpot(VehicleType.BIKE, f'L{height}::{spot}') for spot in range(VEHICLE_TYPE_SPOTS_PER_LEVEL[VehicleType.BIKE])],
            VehicleType.TRUCK: [ParkingSpot(VehicleType.TRUCK, f'L{height}::{spot}') for spot in range(VEHICLE_TYPE_SPOTS_PER_LEVEL[VehicleType.TRUCK])]
        }
        self.height = height
        
    
    def park(self, vehicle: Vehicle):
        for parking_spot in self.parking_layout[vehicle.type]:
            if not parking_spot.is_occupied():
                parking_spot.park(vehicle)
                return True
        return False

    def un_park(self, vehicle: Vehicle):
        for parking_spot in self.parking_layout[vehicle.type]:
            if parking_spot.is_occupied() and parking_spot.parked_vehicle == vehicle:
                parking_spot.un_park()
                return True
        return False
    
    def has_space(self, vehicle_type: VehicleType):
        return any([not spot.is_occupied() for spot in (self.parking_layout[vehicle_type])])
    
    def display(self):
        for type, spots in self.parking_layout.items():
            print(f"L{self.height} : {type} : {[spot.parked_vehicle.number_id for spot in spots if spot.is_occupied()]}")


