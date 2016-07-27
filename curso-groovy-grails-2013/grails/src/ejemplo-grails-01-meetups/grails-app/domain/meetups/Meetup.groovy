package meetups

class Meetup {

	String name
	String url
	
	static hasMany = [ events : Event ]
	
    static constraints = {
		name(unique: true, blank: false)
		url(url: true, blank: false)
    }
}
