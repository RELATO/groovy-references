package etters

class Etters extends GroovyTestCase {

    void testRegular() {

        Person person = new Person("Григорий Петров", 22)

        println person.age

        person.name = "Афанасий Сидоров"
        println person
    }

    void testGetter() {

        Person person = new Person("Вася", 99)
        println person.name
    }

    void testSetter() {

        Person person = new Person("Вася", 99)
        person.age = 666
        println person
    }

    void testSetField() {

        Person person = new Person("Вася", 99)
        person.@age = 666
        println person
    }

    void testInnerAccess() {

        Person person = new Person("Вася", 99)
        person.anotherAgeSetter(666)
        println person
    }

    void testNoField() {

        Person person = new Person("Александр Пушкин", 215)
        println person.firstName
    }
}
