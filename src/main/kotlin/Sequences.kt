import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main() {
    measure {
        val list = generateSequence(seed = 1) {it+1}.take(50_000_000)
//            .toList() // remove this line to compare performance (between sequence vs list)
        val result = list.filter { it % 3 == 0 }.average()
        println(result)
    }
}

fun measure(block:()->Unit){
    val nanoTime = measureNanoTime(block)
    val millis = TimeUnit.NANOSECONDS.toMillis(nanoTime)
    println("$millis ms")
}