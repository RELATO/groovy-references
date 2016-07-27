import meetups2.Meetup

class BootStrap {

    def init = { servletContext ->
        if ( !Meetup.count() ) {

            (1..30).each { meetupNumber ->

                def meetup = new Meetup(name:"Madrid${meetupNumber}", url:"http://madrid${meetupNumber}.es")
                meetup.save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
