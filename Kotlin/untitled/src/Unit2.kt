fun main() {
//    var favoriteActor: String = "Sandra Oh"
//    println(favoriteActor.length)

//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor?.length)
//
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor!!.length)


//    val favoriteActor: String? = "Sandra Oh"
//    val lengthOfName = if(favoriteActor != null) {
//        favoriteActor.length
//    } else {
//        0
//    }
//    println("The number of characters in your favorite actor's name is $lengthOfName.")

    val favoriteActor: String? = "Sandra Oh"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")

}