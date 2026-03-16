# Define a basic class in Python
class Person:
    # Constructor to initialize the object
    def __init__(self, name, age):
        self.name = name
        self.age = age

    # Method to display person's details
    def display_info(self):
        print(f"Name: {self.name}, Age: {self.age}")

    # Method to update the age
    def update_age(self, new_age):
        self.age = new_age
        print(f"{self.name}'s age has been updated to {self.age}")

# Create an instance of the Person class
person1 = Person("Alice", 25)

# Display the person's details
person1.display_info()

# Update the person's age
person1.update_age(30)

# Display the updated details
person1.display_info()