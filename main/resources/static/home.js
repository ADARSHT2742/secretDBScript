$(document).ready(function() {
    $("#signup_form").css("display", "none");
    $("#login_form").css("display", "block");

    $("#signup").on("click", function() {
        $("#signup_form").css("display", "block");
        $("#login_form").css("display", "none");
        $("#forgot_password").css("display","none");
    });

    $("#login").on("click", function() {
        $("#signup_form").css("display", "none");
        $("#login_form").css("display", "block");
        $("#forgot_password").css("display","block");
    });

    function password_validation(){
        let pass=$("#password_signup").val();
        let cpass=$("#cpassword_signup").val();
        if(pass===cpass){
            $("#messages").text("");
            $("#signup_button").prop("disabled",false);
        }else{
            $("#messages").text("Password and Confirm password fields must be same");
            $("#messages").css("color","red");            
            $("#signup_button").prop("disabled",true);
        }
    }

    $("#password_signup").on("input",password_validation);

    $("#cpassword_signup").on("input",password_validation);

    // $("#signup_button").on("click",function(event){
    //     event.preventDefault();
    //     let userfullname=$("#fullname").val();
    //     let useremail=$("#usermail").val();
    //     let usercontactnumber=$("#contact").val();
    //     let username=$("#username_signup").val();
    //     let userpassword=$("#cpassword_signup").val();
    //     console.table(userfullname,useremail,usercontactnumber,username,userpassword);
    //     $.ajax({
    //         url:"http://localhost:8081/authentication/signup",
    //         method:"POST",
    //         data:{
    //             "userfullname":userfullname,
    //             "useremail":useremail,
    //             "usercontactnumber":usercontactnumber,
    //             "username":username,
    //             "userpassword":userpassword
    //         },
    //         success:function(result){
    //             console.log(result);
    //             $("#messages").text(result["success"]).addClass("success").removeClass("error");
    //         },
    //         error:function(xhr,status,error){
    //             console.table(xhr,status,error);
    //             var errorMessage = JSON.parse(xhr.responseText).error;
    //             $("#messages").text(errorMessage).addClass("error").removeClass("success");
    //         }
    //     });
    // })
});
