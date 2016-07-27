package meetups

class Event {

	String name
	Date date
	
	static belongsTo = [ meetup: Meetup ]
	
    static constraints = {
		name(blank: false, unique: true)
		date(nullable: true)
    }
}
