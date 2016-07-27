<%@ page contentType="text/html;charset=UTF-8" import="findercontact.Person"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>.:Fider Contact:.</title>
</head>
<body>
  <div class="content">
    <h3 class="fieldcontain" align="center">
      <g:message code="busquedas.mensaje.bienvenida"
        default="¡Introduce tus datos y encuentra tu pareja ideal!" />
    </h3>
    <g:form action="findContacts">
      <div
        class="fieldcontain ${hasErrors(bean:user,field:'name','errors')}">
        <label for="name"> <g:message code="person.name.label"
            default="Name" /></label>
        <g:textField name="name" value="${user?.name}" />
      </div>
      <div
        class="fieldcontain ${hasErrors(bean:user,field:'age','errors')}">
        <label for="age"> <g:message code="person.age.label"
            default="Age" /></label>
        <g:textField name="age" value="${user?.age}" />
      </div>
      <div
        class="fieldcontain ${hasErrors(bean:user,field:'height','errors')}">
        <label for="height"> <g:message
            code="person.height.label" default="Height" /></label>
            <g:textField name="height"
               value="${formatNumber(number:user?.height,format:'0.00',locale:'ES')}" />
      </div>
      <div
        class="fieldcontain  ${hasErrors(bean:user,field:'height','errors')}">
        <label for="sex"> <g:message code="person.sex.label"
            default="Sex" /></label>
        <g:message code="person.sex.man.label" default="Man" />
        <g:radio name="sex" value="${Person.MAN}"
          checked="${user?.sex==Person.MAN}" />
        <g:message code="person.sex.woman.label" default="Woman" />
        <g:radio name="sex" value="${Person.WOMAN}"
          checked="${user?.sex==Person.WOMAN}" />
        <g:renderErrors bean="${user}" field="sex" />
      </div>
      <br />
      <div align="right" class="fieldcontain">
        <fieldset>
          <input type="submit"
            value="${message(code: 'default.button.buscar.label', default: 'Buscar')}"
            class="buttons" />
        </fieldset>
      </div>

    </g:form>
    <div class="${hasErrors(bean:user,'errors')}">
      <g:renderErrors bean="${user}" />
    </div>
  </div>
</body>
</html>