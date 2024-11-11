function actualizarReg(idUsu){
    

    let idusu = idUsu;

    $.post("updateUsuario.php", {idusu: idusu}, function(result){

      $("#contenidoModalUpdate").html(result);
      $('#contenidoModalUpdate').show();
    });
}


function eliminar(usu){
  //alert("Usuario: " + usu)
  let usuario = usu;
  $.post("deleteUsuario.php", {idusu: usuario}, function(result){
    window.location.href = "http://localhost:8080/TIENDA/listausuarios.php";
  });
}