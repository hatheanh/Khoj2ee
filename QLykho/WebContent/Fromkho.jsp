<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Quan Ly Kho</title>
</head>
<body>
<center>
		<h1>Kho Management</h1>
        <h2>
        	<a href="new">Add New Kho</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Kho</a>
        	
        </h2>
	</center>
	<div align="center">
		<c:if test="${a != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${a == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${a != null}">
            			Edit a
            		</c:if>
            		<c:if test="${a == null}">
            			Add New a
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${a != null}">
        		
        			<input type="hidden" name="id" value="<c:out value='${a.id}' />" />
        		</c:if> 
        		        
        		          
        		
        		<tr>
        		<c:if test="${a == null}">
        		<th>ID: </th>  
        		<td>
        			<input type="text" name="id" size="45" value="<c:out value='${a.id}' />" />
        		</c:if> 
        		</td>
        		</tr>
            <tr>
                <th>Ten Kho: </th>
                <td>
                	<input type="text" name="tenkho" size="45"
                			value="<c:out value='${a.tenkho}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Dia diem: </th>
                <td>
                	<input type="text" name="diadiem" size="45"
                			value="<c:out value='${a.diadiem}' />"
                	/>
                </td>
            </tr>
           
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>