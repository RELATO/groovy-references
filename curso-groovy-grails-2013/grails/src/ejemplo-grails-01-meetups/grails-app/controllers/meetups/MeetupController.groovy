package meetups

import org.springframework.dao.DataIntegrityViolationException

class MeetupController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def dinamic(String param) {
	
		def meetups = Meetup.findAllByNameLikeAndUrlLike("%1%", "")
		meetups.each {
			log.debug it.name
		}
		log.debug meetups.size()
		render(view: "list", model:  [meetupInstanceList: meetups, meetupInstanceTotal: meetups.size()])
	}
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //[meetupInstanceList: Meetup.list(params), meetupInstanceTotal: Meetup.count()]
        [meetupInstanceList: Meetup.findAllByNameLikeAndUrlLike("%1%", "%2%"), meetupInstanceTotal: Meetup.count()]
    }

    def create() {
        [meetupInstance: new Meetup(params)]
    }

    def save() {
        def meetupInstance = new Meetup(params)
        if (!meetupInstance.save(flush: true)) {
            render(view: "create", model: [meetupInstance: meetupInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'meetup.label', default: 'Meetup'), meetupInstance.id])
        redirect(action: "show", id: meetupInstance.id)
    }

    def show(Long id) {
        def meetupInstance = Meetup.get(id)
        if (!meetupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "list")
            return
        }

        [meetupInstance: meetupInstance]
    }

    def edit(Long id) {
        def meetupInstance = Meetup.get(id)
        if (!meetupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "list")
            return
        }

        [meetupInstance: meetupInstance]
    }

    def update(Long id, Long version) {
        def meetupInstance = Meetup.get(id)
        if (!meetupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (meetupInstance.version > version) {
                meetupInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'meetup.label', default: 'Meetup')] as Object[],
                          "Another user has updated this Meetup while you were editing")
                render(view: "edit", model: [meetupInstance: meetupInstance])
                return
            }
        }

        meetupInstance.properties = params

        if (!meetupInstance.save(flush: true)) {
            render(view: "edit", model: [meetupInstance: meetupInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'meetup.label', default: 'Meetup'), meetupInstance.id])
        redirect(action: "show", id: meetupInstance.id)
    }

    def delete(Long id) {
        def meetupInstance = Meetup.get(id)
        if (!meetupInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "list")
            return
        }

        try {
            meetupInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'meetup.label', default: 'Meetup'), id])
            redirect(action: "show", id: id)
        }
    }
}
