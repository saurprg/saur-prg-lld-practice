from enum import Enum

class VehicleType(Enum):
    BIKE = 1
    CAR = 2
    TRUCK = 3

class Vehicle:
    def __init__(self, type: VehicleType, number_id: str):
        self.type = type
        self.number_id = number_id
    
    def __str__(self):
        return f"{self.type} : {self.number_id}"
