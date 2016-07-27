modules = {

    search {
        dependsOn 'lungojs'
        resource url:'js/search.js'
    }

    lungojs {
        dependsOn 'quojs, lungocss'
        resource url:'lib/lungo/lungo.js'
    }

    lungocss {
        defaultBundle 'monolith'
        resource url:'lib/lungo/lungo.css'
        resource url:'lib/lungo/lungo.icon.brand.css'
        resource url:'lib/lungo/lungo.icon.css'
        resource url:'lib/lungo/theme.lungo.css'
    }

    quojs { resource url:'lib/quojs/quo.js' }

    application { resource url:'js/application.js' }
}