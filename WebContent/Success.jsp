<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "movieDB?useSSL=false";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>

<h2 align="center"><font><strong>Movies Information</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#29a55f">
<td><b>Id</b></td>
<td><b>Title</b></td>
<td><b>Genre</b></td>
<td><b>Description</b></td>
<td><b>Release Year</b></td>
<td><b>Language</b></td>
<td><b>Imdb Rating</b></td>
<td><b>Duration Minutes</b></td>
<td><b>Main Actors</b></td>
</tr>

<%
int results= 0;
String title = request.getParameter("title");
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
PreparedStatement ps =connection.prepareStatement("select * from movies where title=?");
//String sql ="SELECT * FROM movies WHERE title = ?";
ps.setString(1,title);
resultSet = ps.executeQuery();

while(resultSet.next()){
	results++;
%>

<tr bgcolor="#DEB887">


<td><%=resultSet.getInt("id") %></td>
<td><%=resultSet.getString("title") %></td>
<td><%=resultSet.getString("genre") %></td>
<td><%=resultSet.getString("description") %></td>
<td><%=resultSet.getInt("release_year") %></td>
<td><%=resultSet.getString("language") %></td>
<td><%=resultSet.getString("imdb_rating") %></td>
<td><%=resultSet.getString("duration_minutes") %></td>
<td><%=resultSet.getString("main_actors") %></td>
</tr>

<% 
}
connection.close();

} catch (Exception e) {
e.printStackTrace();
System.out.println("cant fetch data from database");
}
%>
</table>

 <%
   if(results == 0) {
   out.print("<center><h3>Sorry..Movie is not available <h3></center>");
     }
 %>
<br>
<br>

<script>
function goBack(){
	window.history.back()
}
</script>

<center><button onclick="goBack()">Go Back to Search </button></center>