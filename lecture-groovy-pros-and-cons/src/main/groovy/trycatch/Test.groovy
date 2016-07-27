package trycatch

class CountDown {
    int counter = 10
}

CountDown finalCountDown() {
    def countDown = new CountDown()
    try {
        countDown.counter = --countDown.counter
    } catch (ignored) {
        println "That will never happen."
        countDown.counter = Integer.MIN_VALUE
    } finally {
        return countDown
    }
}

println finalCountDown().counter