/**
 * `Sealed classes` allow to set a specific number of states,
 * plus more capabilities than `Enums`.
 * (Know states ad compile time, avoid typos and get restrictive responses to states by using when.)
 */
sealed class Result<out T : Any>(val data: Any? = null, val message: String? = null) {
    class Success<out T : Any>(data: T) : Result<T>(data)
    class Error<out T : Any>(message: String, data: T? = null) : Result<T>(data, message)
    object Loading : Result<Nothing>()
}

/** making all `when` branches as mandatory to avoid errors */
val <T> T.exhaustive: T
    get() = this


/**
 * A more complex `Sealed classes` to handle multiple states with complex nested classes
 */
sealed class ComplexResult<out K : Any> {
    data class Success<out K : Any>(val data: K) : ComplexResult<K>()
    sealed class Error(val exception: Exception) : ComplexResult<Nothing>() {
        class Recoverable(exception: Exception) : ComplexResult.Error(exception)
        class NonRecoverable(exception: Exception) : ComplexResult.Error(exception)
    }

    object InProgress : ComplexResult<Nothing>()
}

fun main() {

    listOf(
        Result.Loading,
        Result.Success(1),
        Result.Loading,
        Result.Error("Error")
    )
        .forEach {
            handleResult(it)
        }


    listOf(
        ComplexResult.InProgress,
        ComplexResult.Success(1),
        ComplexResult.InProgress,
        ComplexResult.Error.NonRecoverable(Exception("Non recoverable error. Bye!")),
        ComplexResult.InProgress,
        ComplexResult.Error.Recoverable(Exception("Recoverable error. Retry!"))
    )
        .forEach {
            handleComplexResult(it)
        }
}

fun handleResult(result: Result<Int>) {
    when (result) {
        is Result.Success -> {
            println("Success with: ${result.data}")
        }
        is Result.Error -> {
            println("Oops! error: ${result.message}")
        }
        Result.Loading -> {
            println("Loading...")
        }
    }.exhaustive
}


fun handleComplexResult(result: ComplexResult<Int>) {
    when (result) {
        is ComplexResult.Error.NonRecoverable -> {
            result.exception.printStackTrace()
        }
        is ComplexResult.Error.Recoverable -> {
            result.exception.printStackTrace()
        }
        is ComplexResult.Success -> {
            println("Success with: ${result.data}")
        }
        ComplexResult.InProgress -> {
            println("In progress...")
        }
    }.exhaustive
}