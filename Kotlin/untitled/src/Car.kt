data class Car(val name: String, val price: Double)
data class Customer(val name: String, val carsBought: MutableList<Car> = mutableListOf())

fun SumPayment(totalPrice: Double): Double {
    return when {
        totalPrice < 20_000 -> totalPrice * 1.05 // 5% tax for total below 20,000
        totalPrice in 20_000.0..50_000.0 -> totalPrice * 1.10 // 10% tax for total between 20,000 and 50,000
        else -> totalPrice * 1.15 // 15% tax for total above 50,000
    }
}
fun main() {
    val cars = listOf(
        Car("Car1", 18_000.0),
        Car("Car2", 25_000.0),
        Car("Car3", 60_000.0),
        Car("Car4", 90_000.0)
    )

    println("Available cars:")
    cars.forEachIndexed { index, car ->
        println("${index + 1}. ${car.name} - \$${car.price}")
    }

    val customer = Customer(name = "AnRyeNyn")
    println("\nHello, ${customer.name}!")
    println("\nEnter the numbers of the cars you want to buy, separated by commas (e.g., 1,2,3):")

    val input = readLine()
    val choices = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: emptyList()

    val selectedCars = choices.mapNotNull { index -> cars.getOrNull(index - 1) }

    if (selectedCars.isNotEmpty()) {
        customer.carsBought.addAll(selectedCars)

        val totalPrice = selectedCars.sumOf { it.price }
        val totalPayment = SumPayment(totalPrice)

        println("\n${customer.name} bought the following cars:")
        selectedCars.forEach { car ->
            println("- ${car.name} for \$${car.price}")
        }
        println("Total price before tax: \$${"%.2f".format(totalPrice)}")
        println("Total payment including tax: \$${"%.2f".format(totalPayment)}")
    } else {
        println("Invalid choice or no cars selected. No cars were bought.")
    }
}