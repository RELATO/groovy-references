package findercontact

class Person {

    final static Character MAN = 'M'
    final static Character WOMAN = 'W'

    String name
    Integer age
    Float height
    Character sex

    static constraints = {
        name(blank:false, size:2..10)
        age(range:18..99)
        height(min:0.0f)
        sex(inList:[MAN, WOMAN])
    }

    static mapping = {
        table 'Persons'
        id column:'person_id'
    }

    @Override
    public String toString() {

        "Person [name=${name}, age=${age}, height=${height}, sex=${sex}]"
    }
}
