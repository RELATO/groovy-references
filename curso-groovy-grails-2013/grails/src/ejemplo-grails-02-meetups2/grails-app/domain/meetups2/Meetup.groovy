package meetups2

class Meetup {

    String name
    String url

    static constraints = {
        name(unique: true, blank: false)
        url(url: true, blank: false)
    }
}
