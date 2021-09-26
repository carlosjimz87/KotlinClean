import java.util.concurrent.Callable

fun main() {
    print(Placeholders().call())
}

/**
 * You can use TODOs to throw exceptions
 * and expose intention in a semantic way
 */
class Placeholders : Callable<String> {
    override fun call(): String {
        if ("some validation".isBlank()) {
            return "some work"
        } else {
            TODO("else()")      // you can use TODOs to throw exceptions in a more semantic way
        }
    }
}
