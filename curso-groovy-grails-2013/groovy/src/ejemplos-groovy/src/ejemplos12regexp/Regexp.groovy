package ejemplos12regexp

// igual a abc
assert "abc" ==~ /abc/

// empieza por ab
assert "abcdef" ==~ /^ab.*/

// termina por ef
assert "abcdef" ==~ /.*ef$/

// empieza por a termina por d y tiene en medio una b o una c
assert "abd" ==~ /^a[b|c]d$/

// empieza por a termina por d y tiene en medio cualquier caracter
assert "acd" ==~ /^a.?d$/

// una o varias a y luego b
assert "aab" ==~ /a+b/

println "todo ok"