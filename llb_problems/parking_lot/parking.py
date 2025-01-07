from level import Level
from vehicle import Vehicle, VehicleType

DEFAULT_LEVELS = 5

class Singleton(type):
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]

class Parking(metaclass=Singleton):

    #make this singleton
    def __init__(self, name: str, levels: int = DEFAULT_LEVELS):
        self.levels = [Level(level_number) for level_number in range(levels)]
    
    def un_park(self, vehicle: Vehicle):
        for level in self.levels:
            if level.un_park(vehicle):
                return True
        return False

    def park(self, vehicle: Vehicle):
        for level in self.levels:
            if level.has_space(vehicle.type):
                status = level.park(vehicle)
                return status
        return False
    
    def display(self):
        for level in self.levels:
            level.display()