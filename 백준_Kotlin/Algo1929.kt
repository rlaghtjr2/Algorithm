import java.util.*

var M = 0
var N = 0
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    M = sc.nextInt()
    N = sc.nextInt()

    var array = Array(N+1,{false})

    for(i in 2..N){
        for(j in 2..N){
            if(i*j>N) break;
            array[i*j] = true
        }
    }

    for(i in M..N){
        if(i==1) continue;
        if(!array[i]) println(i)
    }
}
