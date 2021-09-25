fun main() {
    print("Enter a dividend: ")
    val dividend = try {
        readLine()?.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    } finally {
        println("[readline() executed]")
    }

    print("Enter the divisor: ")
    val divisor = try {
        readLine()?.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    } finally {
        println("[readline() executed]")
    }

    val result = try {
        divide(dividend!!,divisor!!)
    }catch (e: DivisionByZeroException){
        0.0
    }
    finally {
        println("[division by zero exception]")
    }

    println("Result of division is $result")
}

class DivisionByZeroException : Exception("Can't make division by zero, choose another number")

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw DivisionByZeroException()
    }
    return a / b
}
