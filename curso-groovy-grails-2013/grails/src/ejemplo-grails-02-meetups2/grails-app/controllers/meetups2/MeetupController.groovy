package meetups2

class MeetupController {

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        [meetupInstanceList: Meetup.findAll()]
    }
}
