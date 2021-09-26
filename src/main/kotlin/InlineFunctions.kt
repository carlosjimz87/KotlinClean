/**
 * inline functions and crossinline arguments reduce the number of calls
 * hence improve performance
 */
fun main(){
    val list = listOf(1,2,3,4,5)

    list.forEveryOther{
        println(it)
    }

    val list2 = listOf(5,3,2,6,2)

    list.zip(list2).forEach { pair->
        compareInts(pair.first,pair.second){
            println(it)
        }
    }
}

inline fun <T> Collection<T>.forEveryOther(block: (e:T) -> Unit) {

    for((i,item) in withIndex()){
        if(i%2 == 0){
            block(item)
        }
    }
}

inline fun compareInts(a: Int, b:Int, crossinline response: (String)-> Unit){
    println("Setting up comparison")
    val task = Runnable {
        if(a<b){
            response("a < b")
        }else if( a > b){
            response("a > b")
        } else {
            response("a == b")
        }
    }
    task.run()
    println("Comparison finished")
}