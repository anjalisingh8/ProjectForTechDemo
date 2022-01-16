package Demo

import java.util.*

fun main(args : Array<String>){
//    print(${args[0]})

//    println("Hello, ${args[0]}")
    println()
    dayOfWeek()

}

fun dayOfWeek(){
    println("What day of the week it is ?")
    var str = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when(str){
        1 -> println("The first day of the week is Sunday")
        2-> println("The day is Monday")
        3-> println("The day is Tuesday")
        4-> println("The day is WednesDay")
    }

}
