fun main() {

    val user = User(
        "Michael Kotlin",
        55
    )

    printUser(user)
    printUser(null)
}

data class User(
    val name:String,
    val age: Int
)

/**
 * Elvis operator to check condition and preset default value for null object case
 */
fun printUser(user: User?){
    val name = user?.name ?: "John Smith"
    val age = user?.age ?: 30

    println("User is $name and has $age years old")
}