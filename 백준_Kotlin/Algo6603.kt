import java.util.*

var K = 1
var lotto = Array(0,{0})
var answer = Array(6,{0})
fun main() {
    val sc: Scanner = Scanner(System.`in`)


    while(true){
        K = sc.nextInt()

        if(K==0) break;
        lotto = Array(K,{0})
        answer = Array(6,{0})
        for(i in 0..K-1){
            lotto[i] = sc.nextInt()
        }
        comb(0,0)
        println()
    }

}

fun comb(num : Int, cnt : Int){
    if(cnt>=6){
        for(i in 0..5) {
            print(answer[i])
            print(" ")
        }
        println()
        return
    }

    for(i in num..K-1){
        answer[cnt] = lotto[i]
        comb(i+1,cnt+1)
    }
}

