package meetups



import org.junit.*
import grails.test.mixin.*

@TestFor(MeetupController)
@Mock(Meetup)
class MeetupControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/meetup/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.meetupInstanceList.size() == 0
        assert model.meetupInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.meetupInstance != null
    }

    void testSave() {
        controller.save()

        assert model.meetupInstance != null
        assert view == '/meetup/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/meetup/show/1'
        assert controller.flash.message != null
        assert Meetup.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/meetup/list'

        populateValidParams(params)
        def meetup = new Meetup(params)

        assert meetup.save() != null

        params.id = meetup.id

        def model = controller.show()

        assert model.meetupInstance == meetup
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/meetup/list'

        populateValidParams(params)
        def meetup = new Meetup(params)

        assert meetup.save() != null

        params.id = meetup.id

        def model = controller.edit()

        assert model.meetupInstance == meetup
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/meetup/list'

        response.reset()

        populateValidParams(params)
        def meetup = new Meetup(params)

        assert meetup.save() != null

        // test invalid parameters in update
        params.id = meetup.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/meetup/edit"
        assert model.meetupInstance != null

        meetup.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/meetup/show/$meetup.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        meetup.clearErrors()

        populateValidParams(params)
        params.id = meetup.id
        params.version = -1
        controller.update()

        assert view == "/meetup/edit"
        assert model.meetupInstance != null
        assert model.meetupInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/meetup/list'

        response.reset()

        populateValidParams(params)
        def meetup = new Meetup(params)

        assert meetup.save() != null
        assert Meetup.count() == 1

        params.id = meetup.id

        controller.delete()

        assert Meetup.count() == 0
        assert Meetup.get(meetup.id) == null
        assert response.redirectedUrl == '/meetup/list'
    }
}
