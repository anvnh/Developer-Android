fun main() {
    val count: Int = 10
    println("You have count unread messages.")
    println("You have $count unread messages.")

    val unreadCount = 5
    val readCount = 100
    println("You have ${unreadCount + readCount} total messages in your inbox.")

    val numberOfPhotos = 100
    val photosDeleted = 10
    println("$numberOfPhotos photos")
    println("$photosDeleted photos deleted")
    println("${numberOfPhotos - photosDeleted} photos left")

   // val cartTotal = 0 can't
    var cartTotal = 0 //can be changed
    println("Total: $cartTotal")
    cartTotal = 20
    println("Total: $cartTotal")

    var num = 10
    println("You have $num unread messages.")
    num = num + 1
    println("You have $num unread messages.")
    num++
    num--
    println("You have $num unread messages.")


    val trip1: Double = 3.20
    val trip2: Double = 4.10
    val trip3: Double = 1.72
    val totalTripLength: Double = trip1 + trip2 + trip3

     println("$totalTripLength miles left to destination")
    val trip4 = 3.20
    val trip5 = 4.10
    val trip6 = 1.72
    val totalTripLength2 = trip4 + trip5 + trip6
    println("$totalTripLength2 miles left to destination")

    val nextMeeting = "Next meeting is: "
    val date = "January 1"
    val reminder = nextMeeting + date + " at work"
    println(reminder)

    println("Say \"hello\"") //  " = /"

    val notificationsEnabled1: Boolean = true
    println(notificationsEnabled1)

    val notificationsEnabled2: Boolean = false
    println("Are notifications enabled? " + notificationsEnabled2)
   // Sử dụng biểu tượng + để nối các chuỗi với nhau. Bạn cũng có thể nối các biến thuộc các kiểu dữ liệu khác như Int và Boolean với Strings

    birthdayGreeting()

    val greeting = birthdayGreeting2()
    println(greeting)
    //or
    println(birthdayGreeting2())

    println(birthdayGreeting3("Nhi"))
    println(birthdayGreeting4("Nhi", 2))
    println(birthdayGreeting4(age = 2, name = "Rex"))
    println(birthdayGreeting5(age = 2))

    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.\n" +
            "When you define a function, you define the parameters that can be passed to it.\n" +
            "When you call a function, you pass arguments for the parameters.")

    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    println(offer)

    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")

    val numOfAdults = 20
    val numOfKids = 30
    val totalnum = numOfAdults + numOfKids
    println("The total party size is: $totalnum")

    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = "$baseSalary + $bonusAmount"
    val totalSalary2 = baseSalary + bonusAmount

    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    println("Congratulations for your bonus! You will receive a total of $totalSalary2 (additional bonus).")

    val firstNumber = 10
    val secondNumber = 5
    val result= firstNumber + secondNumber


    println("result = $result"  )

    val firstNum = 10
    val secondNum = 5
    val thirdNum = 8

    val result1 = add(firstNum, secondNum)
    val anotherResult = add(firstNum, thirdNum)
    println("$firstNum + $secondNum = $result1")
    println("$firstNum + $thirdNum = $anotherResult")

    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"
    println(displayAlertMessage(operatingSystem, emailId))
}
fun displayAlertMessage(a: String, b:String){
    println("There's a new sign-in request on $a for your Google Account $b")
}
fun add(a: Int, b: Int): Int {
    return a + b
}

fun birthdayGreeting(){
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")

}
fun birthdayGreeting2(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
fun birthdayGreeting3(name:String ): String {
    val nameGreeting = "Happy Birthday $name"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
fun birthdayGreeting4(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}
fun birthdayGreeting5(name: String = "Rover", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}