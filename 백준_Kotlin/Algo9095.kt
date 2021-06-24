import java.util.*

var T = 0
var N = 0
var answer = 0
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    T = sc.nextInt()

    for(i in 1..T){
        answer = 0
        N = sc.nextInt()

        com(0)
        println(answer)
    }
}

fun com(num : Int){
    if(num>N) return
    if(num==N){
        answer++
        return
    }
    else{
        com(num+1)
        com(num+2)
        com(num+3)
    }
}