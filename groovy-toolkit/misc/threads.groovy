
def threads = []

['AA','BB','CC','DD','EE','FF'].each { cd ->
  def th = Thread.start { 
        println "thread ${cd} start"
	sleep 1000
        println "thread ${cd} woke"
    }
  threads << th
}

println "out of creation loop"

threads.each { t ->
        t.join(1000000)
    }

println 'finished'

