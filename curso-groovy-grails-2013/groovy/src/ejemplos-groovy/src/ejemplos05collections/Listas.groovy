package ejemplos05collections

def lista = []
println lista.class
println lista.size()

lista.add("uno")
lista += "dos"
lista << "tres"
lista.each { print it+" " }
println()

lista[5] = "cinco"
lista.each { print it+" " }
println()

lista[2] = "NUEVO"
lista.each { print it+" " }
println()

println lista[-1]
println lista[-2]

lista = [1,2,3,4]

test = true
if ( !test ) {
	throw new Exception()
}
assert test
// continuar con el programa

assert [1,2,3] == lista - [4]
assert [1,[2,3],4].flatten() == lista
assert lista.disjoint([0,5]) == true
assert lista.intersect([1,3,5]) == [1,3]
assert lista.collect { it + 2 } == [3,4,5,6]
assert [1,2,3,4,2,4].unique() == lista
assert lista.min() == 1
assert lista.max() == 4
assert lista.sum() == 10
assert lista.sum { it % 2 == 0 ? it : 0 } == 6
assert [4,2,3,1].sort() == lista
assert lista.find { it % 2 == 0 } == 2
assert lista.findAll { it % 2 == 0 } == [2,4]
println "asserts ok"