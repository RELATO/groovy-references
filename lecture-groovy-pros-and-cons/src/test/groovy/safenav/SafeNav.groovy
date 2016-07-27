package safenav

class SafeNav extends GroovyTestCase {

    def list = [
            [
                    status     : 200,
                    description: "OK",
                    response   : [
                            html: [
                                    head: [title: "Page title"],
                                    body: [text: "Page text"]
                            ]
                    ]
            ],
            [
                    status     : 200,
                    description: "OK",
                    response   : [
                            html: [
                                    body: [text: "Hello world!"]
                            ]
                    ]
            ],
            [
                    status     : 404,
                    description: "Not found",
                    response   : [
                            html: [
                                    head: [title: "Page not found"],
                                    body: [text: "404 - Page not found"]
                            ]
                    ]
            ],
    ]

    void testUnsafe() {
        println list.collect { page -> page.response.html.head.title }
    }

    void testSafe() {
        println list.collect { page -> page.response?.html?.head?.title }
    }

    void testElvis() {
        println list.collect { page -> page.response?.html?.head?.title ?: "No title" }
    }

    void testAs() {
        println (((("100" as int) + 1) as String) + "2")
    }
}
