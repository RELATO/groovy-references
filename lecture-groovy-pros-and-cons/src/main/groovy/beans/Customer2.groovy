package beans

class Customer2 {
    // properties
    Integer id
    String name
    Date dob

    // sample code
    static void main(args) {
        def customer = new Customer2(id: 1, name: "Gromit", dob: new Date())
        println("Hello ${customer.name}")

        def customer1 = new Customer1(id: 2, name: "Wallace", dob: new Date() - 7)
        println("Hello ${customer1.name}")
    }
}