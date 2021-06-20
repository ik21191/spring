<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 
    <title>Spring 3 MVC Series - Contact Manager</title>
 
 
<h2>Add Contact Details</h2>
<form:form method="post" action="addcontact.htm">
 
    <table>
    <tbody><tr>
        <td>First Name</td>
        <td><form:input path="firstname"></form:input></td> 
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone</form:label></td>
        <td><form:input path="telephone"></form:input></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Contact">
        </td>
    </tr>
</tbody></table>    
     
</form:form>