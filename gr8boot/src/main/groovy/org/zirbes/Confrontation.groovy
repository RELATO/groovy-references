package org.zirbes

class Confrontation {

    String author
    String subject

    Map toMap() {
        return [
            author: author,
            subject: subject
        ]
    }

    Confrontation(String author, String subject) {
        this.author = author
        this.subject = subject
    }

}
