<%@ page import="meetups2.Meetup"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'meetup.list', default: 'Meetup List')}" />
  <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
  <header data-title="${entityName}" class="extended"></header>
  <footer>
    <nav>
      <g:link action="list" data-icon="address" class="active" />
      <g:link action="create" data-icon="plus" />
    </nav>
  </footer>
  <article id="main-article" class="active list indented scroll">
    <div class="form">
      <fieldset data-icon="search">
        <input type="search" placeholder="Search...">
      </fieldset>
    </div>
    <ul>
      <g:each in="${meetupInstanceList}" var="meetupInstance">
        <li class="thumb selectable" data-action="search">
          <g:link action="edit" id="${meetupInstance.id}">
            <strong>${fieldValue(bean: meetupInstance, field: "name")}</strong>
            <small>${fieldValue(bean: meetupInstance, field: "url")}</small>
          </g:link>
        </li>
      </g:each>
    </ul>
  </article>
</body>
</html>
