import meetups.Event
import meetups.Meetup

class BootStrap {

    def init = { servletContext ->
		if ( !Meetup.count() ) {

			(1..30).each { meetupNumber ->
				
				def meetup = new Meetup(name:"Madrid${meetupNumber}", url:"http://madrid${meetupNumber}.es")
				meetup.save(failOnError: true)
				
				(1..5).each { eventNumber ->
					def event = new Event(name:"MadridEvent${meetupNumber}-${eventNumber}", meetup:meetup)
					event.save(failOnError: true)
				}
			}
		}
    }
    def destroy = {
    }
}
