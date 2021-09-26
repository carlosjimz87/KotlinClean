import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun methodToMeasure() {
    (1..100).forEach { _ ->
        println("running...")
    }

}

/**
 * easy way to measure time in blocks of code
 */
fun main() {
    val timeNano = measureNanoTime {
            methodToMeasure()
    }
    val timeMillis = measureTimeMillis {
        methodToMeasure()
    }
    println("methodToMeasure() took $timeMillis ms ($timeNano ns)")
}