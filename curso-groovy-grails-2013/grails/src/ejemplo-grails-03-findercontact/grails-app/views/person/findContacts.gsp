<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>.:Busqueda de Parejas:.</title>
</head>
<body>
  <div class="content">
    <table border="0" class="albumsTable">
      <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Height</th>
      </tr>
      ${contacts.class} ${contacts.size()}
      <g:each in="${contacts}"  var="contact">
        <tr>
          <td>
            ${contact.name}
          </td>
          <td>
            ${contact.age}
          </td>
          <td>
            ${formatNumber(number:contact?.height,format:'0.00',locale:'ES')}
          </td>
        </tr>
      </g:each>
    </table>
    <div align="right" class="fieldcontain">
      <fieldset>
        <g:link controller="busquedasService" class="buttons">
          <g:message code="default.button.volver.label" default="Volver" />
        </g:link>
      </fieldset>
    </div>
  </div>
</body>
</html>