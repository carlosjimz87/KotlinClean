import com.sun.crypto.provider.Preconditions

fun main() {
    val list = listOf("a","b","c","d","e")
    val result = join("|",list)
    println("working join: $result")
    // failed join because invalid separator, error thrown
    val result2 = join("sds",list)
}

/**
 * Use require and other semantic validation for cleanliness
 * require(), requireNotNull(), check(), checkNotNull(), assert()
 */
fun join(sep:String,strings:List<String>): String {
    require(sep.length < 2) { "sep is less than 2" }
    return strings.joinToString(sep)
}