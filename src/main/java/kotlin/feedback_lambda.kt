fun main(args: Array<String>) {
    foo({ println("1") }, { println("2") })
}

fun foo(lambda1: () -> Unit = {}, lambda2: () -> Unit = {}) {
    lambda1()
    println("----")
    lambda2()
}
