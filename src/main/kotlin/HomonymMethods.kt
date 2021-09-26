/**
 * You can use same name for similar methods by using @JvmName annotation
 * with different classifiers and the compiler will differentiate them
 */

@JvmName("sortStrings")
fun sort(strings: List<String>){

}

@JvmName("sortInts")
fun sort(ints: List<Int>){

}