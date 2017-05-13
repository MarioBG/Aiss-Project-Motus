<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
 <head>
 	
     <meta charset="UTF-8">
     <meta name="viewport" content=""/>
     <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
     
     <title>Motus</title>
     
     <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="css/interfaz-est.css">

     <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> <!-- import para las rutas -->
     <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
     <script type="text/javascript"  src="code.js"></script>
     <script type="text/javascript"  src="jquery.js"></script> 
         
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXlDbb8XBqiWlkIUbxWJ7AjZ5z2ZELFGI&v=3.exp&sensor=false&libraries=places"></script>
     <!--  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXlDbb8XBqiWlkIUbxWJ7AjZ5z2ZELFGI&callback=initMap"></script>
     <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXlDbb8XBqiWlkIUbxWJ7AjZ5z2ZELFGI&libraries=adsense&sensor=true&language=es"></script>
     -->
       <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXlDbb8XBqiWlkIUbxWJ7AjZ5z2ZELFGI&libraries=places&callback=initMap"
        async defer></script>
     
 </head>
 <body>
 
     <aside id="a1" class="visible col-xs-4 col-sm-4 col-md-4 col-lg-4">
     <br>
     <div class="container">

    <div style="position:fixed; z-index:100; max-width:350px; margin-top:35%; margin-left:33%;">
     <p><strong> Tokens de OAuth </strong></p>
     <table>
    	<tr><th>Google Drive:<th><td><c:out value='${sessionScope["GoogleDrive-token"]}' />
    	
     </table>
    </div>
       <section class="main row">
       </section>
       </div>
         <img id="img1" src="./images/Logo.png"  class="img-responsive"   alt="Img"/>
         <br><br>
         <button id="ub" class="btn btn-info form-control">
           <img style="-webkit-filter: invert(1); filter: invert(1); position: relative; top:-2px" src="http://freeiconbox.com/icon/256/18563.png" width="20" />
            <span class="ubs2"><strong>Tu ubicación</strong></span>
         </button>
         <br><br>
         
         <div style="display:inline-block; width:100%">        
          <div style="float:left; width:87%">
           <div class="form-group">
            <div class="">
             <div class="input-group">
              <span class="ia input-group-addon">
               <img src="http://oi63.tinypic.com/t7xv5w.jpg" width="20" height="20"/>
              </span>
              <input type="text" class="start form-control" name="origen" id="start" placeholder="-Introduce origen"/>
             </div>
            </div>
           </div>

          <div class="form-group">
           <div class="">
            <div class="input-group">
             <span class="ia2 input-group-addon">
              <img src="http://www.cycconsulting.net/images/ver_mapa.png" width="20" height="20"/>
             </span>
             <input type="text" class="end form-control" name="destino" id="end" placeholder="-Introduce destino"/>
            </div>
           </div>
          </div>
         </div>
         
         
       
          <div style="float:right; width:11%; height:83px;">
           <button id="ch" style="height:100%" class="btn btn-info form-control"> 
            <img class="rotate90" src="https://cdn3.iconfinder.com/data/icons/defcon/512/refresh-512.png" width="20" height="20"></img>
           </button>
          <br>
          <br>      
          </div>
         </div>
         
         <button id="ch2" style="padding-left:40%; padding-right:40%" class="btn btn-info form-control"> 
          <img class="rotate90" src="https://cdn3.iconfinder.com/data/icons/defcon/512/refresh-512.png" width="20" height="20"></img>
         </button>
         <br><br>      
         
          <input type="text" class="form-control" name="destino" id="a" placeholder="-Introduce destino"/>
      
        
         <div class="form-group" style="width:100%">
          <div class="input-group">
           <span class="ia3 input-group-addon">
            <img src="https://www.itewiki.fi/images/info2/paikkatieto-gis.png" width="20" height="20"/>
           </span>
     	   <select style="border-color: #3FCCA9;" id="travelMode" class="routeOptions form-control" >
           	  <option value="WALKING">Caminando</option>
           	  <option value="TRANSIT">Por autobús</option> 
         	</select>
          </div>
         </div>

         <button id="search" style="display:inline-block" class="send btn btn-info form-control">
          <img id="img2" src="https://image.flaticon.com/icons/png/128/34/34202.png" width="15"/> 
           <span class="ubs"><strong>Busqueda</strong></span>
         </button>
         <br><br> 
        
         <div id="dp">
          <div id="directions_panel" class="table-responsive">
          </div>
         </div>
  
         <div id="row1" class="form-group">
          <div class="checkbox">
            <div class="radio">
              <label><input id="r1" type="radio" name="optradio1">Rutas ordenadas por duración</label>
            </div>
          </div>
         </div> 
         
         <div id="row2" class="form-group">
          <div class="checkbox">
           <div class="radio">
             <label><input id="r2" type="radio" name="optradio2">Rutas ordenadas por distancia</label>
           </div>
          </div>
         </div> 
         


         <div class="foot visible col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <button style="padding:0px" class="btn btn-info form-control">
           <img style="-webkit-filter: invert(1); filter: invert(1); position: relative; top:-2px" src="http://simpleicon.com/wp-content/uploads/gear.png" width="20" />
           <span class="oo"><strong>Otras Opciones</strong></span>
          </button>        
         </div>
         <br><br>
      </aside>

      <div id="map_canvas" class="visible col-xs-8 col-sm-8 col-md-8 col-lg-8"></div>
    

     <div id="guardar"> 
     <br><br>
      <span style="align:center">¿Quiere guardar la ruta seleccionada?</span>
      <br><br>
      <img src="http://www.freeiconspng.com/uploads/save-icon-png--4.png" alt="Img" height="60" width="60">
      <div style="padding: 20px">
      </div>
     </div>
     
     <!-- Formulario consorcio --> 
     
     <div class="visible col-xs-2 col-sm-2 col-md-4 col-lg-4" id="paradas"> 
      <form action="/ConsorcioListController" method="GET">
      <br>
        <input name="idConsorcio" style="width:65%" autocomplete="off" type="text" class="form-control" id="idConsorcio" placeholder="-Introduce Consorcio"/>
        <br>
        <input name="idMunicipio" style="width:65%" autocomplete="off" type="text" class="form-control"  id="idMunicipio" placeholder="-Introduce Municipio"/>
        <br>
        <input name="idNucleo" style="width:65%" autocomplete="off" type="text" class="form-control" id="idNucleo" placeholder="-Introduce Nucleo"/>
        <br>
        <input style="border-radius:5px" type="submit" value="Guardar"/>
      </form>
     </div>
    
 
    <!--  botón que te dirige al controlador que administra la lista de ficheros de Google Drive -->
  	
  	<form action="/googleDriveSave" method="POST">
  	<input type="text" name="origen" id="origen" style="display:none;"/>
  	<input  type="text" name="destino" id="destino" style="display:none;" />
  	<input type="submit" id="bsucc" class="btn btn-info form-control"  value="Guardar"/>
    </form>
	
	<a id="bsucc2" href="/googleDriveDisplay" class="btn btn-info form-control" role="button"><strong>Display</strong></a>
   	<!-- 
	<div id="ht" style="right:30px; top:50px; z-index:1300; width:600px; height:500px; position:relative;">
	<iframe style="position:fixed; width:600px; height:500px;" src="" ></iframe>
	 </div>
    -->
    <script type="text/javascript"  src="code2.js"></script>

 </body>
</html>