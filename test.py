class Car(object):
    condition = "new"
    def __init__(self, model, color, mpg):
        self.model = model
        self.color = color
        self.mpg   = mpg
    def display_car(self):
        print("This is a "+self.color " " + self.model +" with " + str(self.mpg) + " MPG")
my_car = Car("DeLorean", "silver", 88)
print my_car.condition
print my_car.model
print my_car.color
print my_car.mpg
my_car.display_car()
