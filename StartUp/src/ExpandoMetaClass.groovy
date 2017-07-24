//class Book {
//   String title
//}
//
//Book.metaClass.textChange << {-> title = "Haha" }
//Book.metaClass.toUp << {-> title.toUpperCase()}
//
//def b = new Book(title:"The Stand")
//
//assert b.textChange() == "Haha"
//
//println b.textChange()
//println b.toUp()

interface Vehicle {
	String getName()
}

// Category annotation style
@Category(Vehicle)
class FlyingAbility {
	def fly() { "I'm the ${name} and I fly!" }
}

// traditional category style
class DivingAbility {
	static dive(Vehicle self) { "I'm the ${self.name} and I dive!" }
}

// provided by a third-party, so can't augment using Mixin annotation
class JamesBondVehicle implements Vehicle {
	String getName() { "James Bond's vehicle" }
}

// Can be added via metaClass, e.g.:
// JamesBondVehicle.metaClass.mixin DivingAbility, FlyingAbility
// Or using shorthand through DGM method on Class
JamesBondVehicle.mixin DivingAbility, FlyingAbility

println new JamesBondVehicle().fly() == "I'm the James Bond's vehicle and I fly!"
println new JamesBondVehicle().dive() == "I'm the James Bond's vehicle and I dive!"

@Category(Brand)
class Coffee{
	def taste(){
		"I love the taste of ${name}"
	}
}
interface Brand{
	String getName()
}
class DarkCoffee implements Brand{
	String getName(){
		"dark coffee"
	}
}

DarkCoffee.mixin Coffee

println new DarkCoffee().taste() == "I love the taste of dark coffee"

