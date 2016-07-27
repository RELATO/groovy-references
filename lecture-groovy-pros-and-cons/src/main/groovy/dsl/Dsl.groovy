package dsl

class Dsl {

    static class DslFruits {
        String name
        int number
    }

    static class DslGiven {
        String person
        DslFruits fruits

        DslGiven "has"(DslFruits fruits) {
            this.fruits = fruits
            return this
        }
    }

    static class DslWhen {
        String sender
        String receiver
        DslFruits fruits

        DslWhen "gives"(DslFruits fruits) {
            this.fruits = fruits
            return this
        }

        DslWhen "to"(String person) {
            this.receiver = person
            return this
        }
    }

    static class DslThen {
        String person
        DslFruits fruits

        def state

        DslThen "does"(String person) {
            this.person = person
            return this
        }

        def "getHave"() {
            return state[person][fruits.name] ?: 0
        }
    }

    def given = []
    def when = []

    def calculate() {
        def state = [:]
        given.each { DslGiven given ->
            if (!state.containsKey(given.person)) {
                state[given.person] = [:]
            }
            state[given.person][given.fruits.name] = given.fruits.number
        }
        when.each { DslWhen when ->
            if (!state.containsKey(when.sender)) {
                state[when.sender] = [:]
            }
            if (!state.containsKey(when.receiver)) {
                state[when.receiver] = [:]
            }
            if (!state[when.sender].containsKey(when.fruits.name)) {
                state[when.sender][when.fruits.name] = 0
            }
            if (!state[when.receiver].containsKey(when.fruits.name)) {
                state[when.receiver][when.fruits.name] = 0
            }
            state[when.sender][when.fruits.name] -= when.fruits.number
            state[when.receiver][when.fruits.name] += when.fruits.number
        }
        return state
    }

    DslGiven given(String person) {
        return new DslGiven(person: person).with { given << it; it }
    }

    DslWhen when(String person) {
        return new DslWhen(sender: person).with { when << it; it }
    }

    DslThen howMany(String fruit) {
        return new DslThen(fruits: 0."${fruit}", state: calculate())
    }

    static class FruitCategory {
        public static DslFruits getApples(final Integer self) {
            return new DslFruits(number: self, name: "apple");
        }

        public static DslFruits getApple(final Integer self) {
            return new DslFruits(number: self, name: "apple");
        }

        public static DslFruits getOrange(final Integer self) {
            return new DslFruits(number: self, name: "orange");
        }

        public static DslFruits getOranges(final Integer self) {
            return new DslFruits(number: self, name: "orange");
        }
    }


    public static void main(String[] a) {

        def context = new Dsl()
        println use(FruitCategory) {
            delegate = context

            given "jimmy" has 5.apples
            given "mark" has 2.apples
            given "mark" has 3.oranges
            given "jimmy" has 3.oranges
            when "jimmy" gives 2.apples to "mark"
            when "mark" gives 1.orange to "jimmy"
            when "jimmy" gives 2.oranges to "mark"
            when "mark" gives 1.orange to "bob"
            when "jimmy" gives 2.apples to "mark"
            when "mark" gives 3.apples to "jimmy"
            when "jimmy" gives 2.apples to "bob"
            howMany "apples" does "jimmy" have
        }
    }

}
