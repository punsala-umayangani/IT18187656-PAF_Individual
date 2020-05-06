$(document).ready(function() {

    $("#alertSuccess").hide();
    $("#alertError").hide();

});

// Save
$(document).on("click", "#btnSave", function(event) {

    // Clear alerts
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();

    // Form validation
    var status = validateUserForm();
    if (status != true) {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }

    // If valid
    var type = ($("#hiddocidSave").val() == "") ? "POST" : "PUT";

    $.ajax(
        {
            url : "DoctorAPI",
            type : type,
            data : $("#formDoctor").serialize(),
            dataType : "text",
            complete : function(response, status)
            {
                onUserSaveComplete(response.responseText, status);
            }
        });

});

function onUserSaveComplete(response, status) {

    if (status == "success") {

        var resultSet = JSON.parse(response);

        if (resultSet.status.trim() == "success") {

            $("#alertSuccess").text("Successfully saved.");
            $("#alertSuccess").show();
            $("#divUsersGrid").html(resultSet.data);

        } else if (resultSet.status.trim() == "error") {

            $("#alertError").text(resultSet.data);
            $("#alertError").show();

        }
    } else if (status == "error") {

        $("#alertError").text("Error while saving.");
        $("#alertError").show();

    } else {

        $("#alertError").text("Unknown error while saving..");
        $("#alertError").show();

    }

    $("#hiddocidSave").val("");
    $("#formDoctor")[0].reset();

}

// Update
$(document).on("click", ".btnUpdate", function(event)
{
    $("#hiddocidSave").val($(this).closest("tr").find('#hiddocidUpdate').val());
    $("#docName").val($(this).closest("tr").find('td:eq(0)').text());
    $("#docSpecial").val($(this).closest("tr").find('td:eq(1)').text());
    $("#docAddress").val($(this).closest("tr").find('td:eq(2)').text());;
    $("#docPhone").val($(this).closest("tr").find('td:eq(3)').text());
    $("#docEmail").val($(this).closest("tr").find('td:eq(4)').text());
});

//Remove
$(document).on("click", ".btnRemove", function(event)
{
    $.ajax(
        {
            url : "DoctorAPI",
            type : "DELETE",
            data : "docid=" + $(this).data("docid"),
            dataType : "text",
            complete : function(response, status)
            {
                onUserDeleteComplete(response.responseText, status);
            }
        });
});

function onUserDeleteComplete(response, status) {

    if (status == "success") {

        var resultSet = JSON.parse(response);

        if (resultSet.status.trim() == "success") {

            $("#alertSuccess").text("Successfully deleted.");
            $("#alertSuccess").show();
            $("#divUsersGrid").html(resultSet.data);

        } else if (resultSet.status.trim() == "error") {

            $("#alertError").text(resultSet.data);
            $("#alertError").show();

        }

    } else if (status == "error") {

        $("#alertError").text("Error while deleting.");
        $("#alertError").show();

    } else {

        $("#alertError").text("Unknown error while deleting..");
        $("#alertError").show();

    }

}

// Client Model
function validateUserForm() {

    // NAME
    if ($("#docName").val().trim() == "")
    {
        return "Insert Doctor Name.";
    }
    // ID NO.
    if ($("#docSpecial").val().trim() == "")
    {
        return "Insert Specialization.";
    }

    // ADDRESS
    if ($("#docAddress").val().trim() == "")
    {
        return "Insert Address.";
    }
    
    // PHONE NO
    if ($("#docPhone").val().trim() == "")
    {
        return "Insert Phone Number.";
    }
    
    // E-MAIL ADDRESS
   	if ($("#docEmail").val().trim() == "")
    {
        return "Insert Email Address.";
    }
   	
    return true;
}
