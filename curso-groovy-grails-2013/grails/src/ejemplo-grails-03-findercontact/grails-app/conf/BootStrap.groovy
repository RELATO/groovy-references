import findercontact.Person
import findercontact.Role
import findercontact.User
import findercontact.UserRole

class BootStrap {

    def init = { servletContext ->

        new Person(name:"Adolfo", age:35, height:1.7f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Andres", age:25, height:1.6f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Javier", age:30, height:1.51f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Julio", age:40, height:1.69f, sex:Person.MAN).save(failOnErro:true)
        new Person(name:"Laura", age:35, height:1.6f, sex:Person.WOMAN).save(failOnErro:true)

        def role1 = new Role(authority: "ROLE_ADMIN").save(failOnError:true)
        def role2 = new Role(authority: "ROLE_USER").save(failOnError:true)

        def user1 = new User(username: "adolfo", enabled: true, password: 'pass').save(failOnError:true)
        def user2 = new User(username: "javier", enabled: true, password: 'pass').save(failOnError:true)


        UserRole.create(user1, role1, true)
        UserRole.create(user2, role2, true)
    }
    def destroy = {
    }
}
