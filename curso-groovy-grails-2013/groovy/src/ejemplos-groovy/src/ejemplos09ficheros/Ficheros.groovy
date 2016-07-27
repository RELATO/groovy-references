package ejemplos09ficheros

def directorio = new File(".")

// imprimimos todo
directorio.eachFile { println it }
println "---"

// imprimimos los subdirectorios
directorio.eachDir { println it }
println "---"

// imprimimos los subdirectorios recursivamente
directorio.eachDirRecurse { println it }
println "---"

// imprimimos los subdirectorios que contengan b
directorio.eachDirMatch ~/.*b.*/, {println it}
println "---"

def file = new File('datos.dat')
file.write """
Hola
Todo bien?
Adios
"""
file << "P.D. Un beso"
file.append "\nOtro beso"

// todo el texto
println file.text
println "---"

// línea a línea
file.eachLine { println "->$it" }
println "---"

// size in bytes
println file.size()

// unallocated bytes in the partition
println file.getFreeSpace()

// availabled bytes in this virtual machine
println file.getUsableSpace()

// size in bytes of the partition
println file.getTotalSpace()

println "---"

println "exists="+file.exists()
println "isFile="+file.isFile()
println "canRead="+file.canRead()
println "canWrite="+file.canWrite()
println "isDirectory="+file.isDirectory()
println "isHidden="+file.isHidden()

def fileTest = new File("test.txt")
fileTest.createNewFile()
fileTest.setReadOnly()

println "---"

println "exists="+fileTest.exists()
println "isFile="+fileTest.isFile()
println "canRead="+fileTest.canRead()
println "canWrite="+fileTest.canWrite()
println "isDirectory="+fileTest.isDirectory()
println "isHidden="+fileTest.isHidden()

println "---"

def fileKK = new File("kk.txt")

// crear un fichero
fileKK.createNewFile()

// borrar un fichero
fileKK.delete()

// crear un fichero temporal
File.createTempFile("kkk", "txt")

def dir = new File("kk1/kk2")

// crear directorios
dir.mkdirs()

println "todo ok"