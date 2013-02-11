<%@ include file="header.jsp" %>
<f:view>
  <h:form id="signinForm">
    <h3>Sign in here</h3>
    <h:outputText value="Username"/>
    <h:inputText id="username" value="" label="Username"></h:inputText><br>
    <h:outputText value="Password"/><h:inputSecret id="password" value="" label="Password"></h:inputSecret><br>
    <h:commandButton id="submit" action="signinSuccess" value="Sign in"/>
    <h:message id="usernameError" for="username" showSummary="true" showDetail="false" style="color: red"/>
    <h:message id="passwordError" for="password" showSummary="true" showDetail="false" style="color: red"/>
  </h:form>
</f:view>