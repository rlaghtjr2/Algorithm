import java.util.*

var N = 0
var M = 0
var K = 0
var map = Array<IntArray>(0,{IntArray(0)})
var dx = arrayOf(0,1,0,-1)
var dy = arrayOf(1,0,-1,0)
var answer = arrayListOf<Int>()

fun main(){
    var sc : Scanner = Scanner(System.`in`)

    M = sc.nextInt()
    N = sc.nextInt()
    K = sc.nextInt()

    map = Array<IntArray>(M,{IntArray(N)})

    for(i in 0..K-1){
        var x1 = sc.nextInt()
        var y1 = sc.nextInt()
        var x2 = sc.nextInt()
        var y2 = sc.nextInt()

        for(x in x1..x2-1){
            for(y in (M-y2)..(M-y1-1)){
                map[y][x] = 1
            }
        }
    }

    for( i in 0..M-1){
        for(j in 0..N-1){
            if(map[i][j]==0) {
                var cnt = dfs(i,j)
                answer.add(cnt)
            }
        }
    }
    Collections.sort(answer)

    println(answer.size)
    for(i in 0..answer.size-1){
        print("${answer.get(i)} ")
    }

}
fun dfs(y : Int, x : Int) : Int{
    var count = 0
    map[y][x] = 2
    for(i in 0..3){
        var ry = y + dy[i]
        var rx = x + dx[i]

        if(!indexCheck(ry,rx)) continue
        if(map[ry][rx]!=0) continue

        count+=dfs(ry,rx)
    }

    return count+1
}

fun indexCheck(y : Int, x : Int) : Boolean{
    if(y>=M || y <0 || x >=N || x<0) return false;

    return true;
}
fun print(){
    for(y in 0..M-1){
        for(x in 0..N-1){
            print(map[y][x])
        }
        println()
    }
}