/**
*	dynamic objects (expandos)
*/
def a1  = [a:'a',b:'b',1:2,'foo':'bar']
def obj = new Expando(a1)
obj.sayfoo = { "foo: $foo" }	// <-- insert a dynamic method...
println obj.sayfoo()
obj.foo = "bas"
println obj.sayfoo()
println  "obj.foo ${obj.foo}"
