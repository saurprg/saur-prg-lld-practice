from parking_manager import ParkingManager
from parking import Parking
from vehicle import Vehicle, VehicleType

if __name__ == "__main__":
    car1 = Vehicle(VehicleType.CAR, "MH30DD1234")
    car2 = Vehicle(VehicleType.CAR, "MH30DD1284")
    car3 = Vehicle(VehicleType.CAR, "MH30DD1230")

    bike1 = Vehicle(VehicleType.BIKE, "MH30DD1734")
    bike2 = Vehicle(VehicleType.BIKE, "MH30DD0234")
    bike3 = Vehicle(VehicleType.BIKE, "MH30DD1634")

    truck = Vehicle(VehicleType.TRUCK, "MH30DD1034")

    parking_manager = ParkingManager()
    parking_manager.park(car1)
    parking_manager.park(car2)

    parking_manager2 = ParkingManager()
    parking_manager2.un_park(car1)
    parking_manager.park(car3)
    parking_manager2.park(bike1)
    parking_manager2.park(bike2)
    parking_manager2.park(bike3)
    
    parking_manager.park(truck)

    parking_manager.parking.display()