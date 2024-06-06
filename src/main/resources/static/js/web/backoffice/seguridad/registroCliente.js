$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/seguridad/customer",
        contentType: "application/json",
        data: JSON.stringify({
            idusuario: $("#hddidusuariocliente").val(),
            nomusuario: $("#txtusuario").val(),
            nombres: $("#txtnombre").val(),
            apellidos: $("#txtapellido").val(),
            email: $("#txtemail").val(),
            password: $("#txtclave").val()
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            console.log($("#hddidusuariocliente").val())
            console.log($("#txtusuario").val())
            console.log($("#txtnombre").val())
            console.log($("#txtapellido").val())
            console.log($("#txtemail").val())
            console.log($("#txtclave").val())
        }
    });
});

