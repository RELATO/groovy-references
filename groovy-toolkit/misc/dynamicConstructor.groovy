import groovy.transform.ToString

@ToString
class MyClass {
  def a = 'a'
  def b = 'b'
  def c
  def foo
  def bar
}


MyClass.metaClass.constructor << {
	String foo, String bar ->
	new MyClass(foo:foo,bar:bar,
		a : foo[0],
		b : foo[1],
		c : foo[2]
	)
}


println 'before:'+new MyClass()
println 'after:'+new MyClass('foo','bar')
