/**
 * lazy fun guarantees one time initialization by
 * double check locking (thread safe) of the variable.
 * Also has a parameter to define the safety mode in (NONE, PUBLISHED AND SYNCHRONIZED
 */
class NamePrinter(private val firstName: String, private val lastName: String){
    private val fullName: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED){"$firstName $lastName"}

    fun printName(){
        println(fullName)
    }
}

fun main() {
    NamePrinter("John","Smith").printName()
}