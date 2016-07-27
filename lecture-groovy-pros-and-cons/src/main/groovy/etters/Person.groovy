package etters

class Person {

    String name
    int age

    Person(String name, int age) {
        this.name = name
        this.age = age
    }

    String getName() {
        return name.contains(" ") ? name : name + " Иванов"
    }

    void setAge(int age) {
        if (age == 666) {
            throw new Exception("the evil exception")
        }
        this.age = age
    }

    void anotherAgeSetter(int age) {
        this.age = age
    }

    String getFirstName(){
        return name.replaceFirst('\\s.+$', "")
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
