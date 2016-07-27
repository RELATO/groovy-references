<%@ page import="meetups.Meetup" %>



<div class="fieldcontain ${hasErrors(bean: meetupInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="meetup.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${meetupInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: meetupInstance, field: 'url', 'error')} required">
	<label for="url">
		<g:message code="meetup.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="url" name="url" required="" value="${meetupInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: meetupInstance, field: 'events', 'error')} ">
	<label for="events">
		<g:message code="meetup.events.label" default="Events" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${meetupInstance?.events?}" var="e">
    <li><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="event" action="create" params="['meetup.id': meetupInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')])}</g:link>
</li>
</ul>

</div>

