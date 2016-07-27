
def file = new File("../../../../pom.xml")

def project = new XmlSlurper().parseText(file.text)

println "module ${project.groupId}:${project.artifactId}:${project.version}"
project.dependencies.dependency.each { dep ->
    println "dependency ${dep.groupId}:${dep.artifactId}:${dep.version}"
}
