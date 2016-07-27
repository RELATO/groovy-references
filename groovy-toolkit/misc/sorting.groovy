import groovy.transform.ToString

assert ['Chad','James','Travis'] == ['James','Travis','Chad'].sort()

@ToString
class Person {
  String id
  String name
}

def list = [new Person(id: '1', name: 'James'),new Person(id: '2', name: 'Travis'), new Person(id: '3', name: 'Chad')]

println "list.before: ${list}"
list.sort()
println "list.after.A: ${list}"
list.sort{it.id}
println "list.after.B: ${list}"
