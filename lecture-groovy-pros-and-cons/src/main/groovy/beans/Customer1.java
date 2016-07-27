package beans;

import java.util.Date;

public class Customer1 {
    // properties
    private Integer id;
    private String name;
    private Date dob;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // sample code
    public static void main(String[] args) {
        Customer1 customer = new Customer1();
        customer.setId(1);
        customer.setName("Gromit");
        customer.setDob(new Date());

        System.out.println("Hello " + customer.getName());
    }
}