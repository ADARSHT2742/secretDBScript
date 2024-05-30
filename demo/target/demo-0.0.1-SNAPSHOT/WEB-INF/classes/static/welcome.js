$(document).ready(function(){
    // User ID to be updated
    var userId = 352; // Replace with the actual user ID

    // Update endpoint URL
    var updateUrl = 'http://localhost:8091/demo/users/update/' + userId;

    // User data to be updated
    var userData = {
        "fullname": "Updated Name",
        "username": "updatedusername",
        "mail": "updatedemail@example.com",
        "usercontact": 9876543210,
        "up": {
            "password": "newpassword123"
        }
    };

    // Make AJAX call
    $.ajax({
        url: updateUrl,
        method: "POST",
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(userData),
        success: function(response) {
            // Handle successful response here
            console.log('POST request successful:', response);
        },
        error: function(xhr, status, error) {
            // Handle errors here
            console.error('Error occurred during POST request:', error);
        }
    });
});
