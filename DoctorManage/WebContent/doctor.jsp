<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.Doctor"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.0.min.js"></script>
<script src="Components/doctors.js"></script> 
</head>
<body>

	<div class="container">
    <div class="row">
        <div class="col-6">
            <h1>Doctor Management</h1>
            
            <form id="formDoctor" name="formDoctor" method="post" action="doctor.jsp">
                Doctor Name :
                <input id="docName" name="docName" type="text"
                       class="form-control form-control-sm">
                <br> 
                Doctor Specialization :
                <input id="docSpecial" name="docSpecial" type="text"
                       class="form-control form-control-sm">
                <br> 
                Address :
                <input id="docAddress" name="docAddress" type="text"
                       class="form-control form-control-sm">
                <br> 
                
                Phone Number :
                <input id="docPhone" name="docPhone" type="text"
                       class="form-control form-control-sm">
                <br>
                Email Address :
                <input id="docEmail" name="docEmail" type="text"
                       class="form-control form-control-sm">
               
                <input id="btnSave" name="btnSave" type="button" value="Save"
                       class="btn btn-primary">
                <input type="hidden" id="hiddocidSave" name="hiddocidSave" value="">
            </form>
            <div id="alertSuccess" class="alert alert-success"></div>
            <div id="alertError" class="alert alert-danger"></div>
            <br>
            <div id="divUsersGrid">
                <%
                    Doctor doctorObj = new Doctor();
                    out.print(doctorObj.readDoctors());
                %>
            </div>

        </div>
    </div>
</div>

</body>
</html>