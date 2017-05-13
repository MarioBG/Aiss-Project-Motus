       function initMap() {
         var map = new google.maps.Map(document.getElementById('map_canvas'), {
           center: {lat: 37.3753501, lng: -6.0250983},
           zoom: 8
         });
       	
         var input = /** @type {!HTMLInputElement} */(
             document.getElementById('start'));
         var input2 = /** @type {!HTMLInputElement} */(
                 document.getElementById('end'));
             
    
         var autocomplete = new google.maps.places.Autocomplete(input);
         var autocomplete = new google.maps.places.Autocomplete(input2);
         autocomplete.bindTo('bounds', map);

         var infowindow = new google.maps.InfoWindow();
         var marker = new google.maps.Marker({
           map: map,
           anchorPoint: new google.maps.Point(0, -29)
         });

         autocomplete.addListener('place_changed', function() {
           infowindow.close();
           marker.setVisible(false);
           var place = autocomplete.getPlace();
           if (!place.geometry) {
             // User entered the name of a Place that was not suggested and
             // pressed the Enter key, or the Place Details request failed.
             window.alert("No details available for input: '" + place.name + "'");
             return;
           }

           // If the place has a geometry, then present it on a map.
           if (place.geometry.viewport) {
             map.fitBounds(place.geometry.viewport);
           } else {
             map.setCenter(place.geometry.location);
             map.setZoom(17);  // Why 17? Because it looks good.
           }
           marker.setIcon(/** @type {google.maps.Icon} */({
             url: place.icon,
             size: new google.maps.Size(71, 71),
             origin: new google.maps.Point(0, 0),
             anchor: new google.maps.Point(17, 34),
             scaledSize: new google.maps.Size(35, 35)
           }));
           marker.setPosition(place.geometry.location);
           marker.setVisible(true);

           var address = '';
           if (place.address_components) {
             address = [
               (place.address_components[0] && place.address_components[0].short_name || ''),
               (place.address_components[1] && place.address_components[1].short_name || ''),
               (place.address_components[2] && place.address_components[2].short_name || '')
             ].join(' ');
           }

           infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
           infowindow.open(map, marker);
         });

         // Sets a listener on a radio button to change the filter type on Places
         // Autocomplete.
         function setupClickListener(id, options) {
           var radioButton = document.getElementById(id);
           radioButton.addEventListener('click', function() {
             autocomplete.setTypes(options);
           });
         }

         setupClickListener('changetype-all', []);
         setupClickListener('changetype-address', ['address']);
         setupClickListener('changetype-establishment', ['establishment']);
         setupClickListener('changetype-geocode', ['geocode']);
       }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
    var map = null;
  	var directionsDisplay = null;
  	var directionsService = null;

  	function initialize() {
  		directionsDisplay = new google.maps.DirectionsRenderer();
  		directionsService = new google.maps.DirectionsService();
  	    var myLatlng = new google.maps.LatLng(37.3753501,-6.0250983);
  	    var myOptions = {
  	        zoom: 8,
  	        center: myLatlng,
  	        mapTypeId: google.maps.MapTypeId.ROADMAP
  	    };
  	    map = new google.maps.Map($("#map_canvas").get(0), myOptions);
  	    directionsDisplay.setMap(map);
  	
  	}
  	
  	function getDirections2(){
  		var start = $('#start').val();
  		var end = $('#end').val();
  
		document.getElementById("origen").value = start;
		document.getElementById("destino").value = end;

  		if(!start || !end){
  			$('#directions_panel').css('visibility','hidden');
  			$('#row1').css('visibility','hidden');
  			$('#row2').css('visibility','hidden');
  			alert("Complete el origen y el destino");
  			return;
  		}
  		var request = {
  		        origin: start,
  		        destination: end,
  		        travelMode: google.maps.DirectionsTravelMode[$('#travelMode').val()],
  		        provideRouteAlternatives: true
  	    };
  		directionsService.route(request, function(response, status) {
  	        
  			if (status == google.maps.DirectionsStatus.OK) {
  	            directionsDisplay.setMap(map);
  	            directionsDisplay.setPanel($("#directions_panel").get(0));
  	            directionsDisplay.setDirections(response);
  	        directionsDisplay.style.display = 'block';

  	        } else {
  	        	$('#directions_panel').css('visibility','hidden');
  	  			$('#row1').css('visibility','hidden');
  	  			$('#row2').css('visibility','hidden');

  	            alert("No hay direcciones disponibles entre esos dos puntos");
  	        }
  	    });
  	}


  

  	$('#search').live('click', function(){ 
  		document.getElementById("directions_panel").innerHTML = "";
  		$('#directions_panel').css('visibility','visible');
			$('#row1').css('visibility','visible');
			$('#row2').css('visibility','visible');
  		getDirections2();
  		initialize(); //NADA

  		
  		$("#directions_panel").show();
  		$("#row1").show();
  		$("#row2").show();
  		});
  	
  	$('.routeOptions').live('change', function(){ 
  		getDirections2(); 
  		
  	});
  	$(document).ready(function() {
  		initialize();
     gmaps_ads(); //inicializa mapa
  		
  	});       

  	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
   function localize(){
       document.getElementById("directions_panel").innerHTML = "";
		/* Si se puede obtener la localización */
		if (navigator.geolocation)
	    {
		navigator.geolocation.getCurrentPosition(mapa,error);
		}
		/* Si el navegador no soporta la recuperación de la geolocalización */
		else
		  {
		  alert('Tu navegador no soporta geolocalización.');
		  }
		 }
    function mapa(pos)
	    {
	    /* Obtenemos los parámetros de la API de geolocalización HTML*/
	    var latitud = pos.coords.latitude;
	    var longitud = pos.coords.longitude;
		var precision = pos.coords.accuracy;
		 
	    /* A través del DOM obtenemos el div que va a contener el mapa */
		var contenedor = document.getElementById("map_canvas")
	    /* Posicionamos un punto en el mapa con las coordenadas que nos ha proporcionado la API*/
        var centro = new google.maps.LatLng(latitud,longitud);
		            
	    /* Definimos las propiedades del mapa */
	    var propiedades =
	    {
		    zoom: 15,
		    center: centro,
		    mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		/* Creamos el mapa pasandole el div que lo va a contener y las diferentes propiedades*/
		var map = new google.maps.Map(contenedor, propiedades);
		            
	    var start = document.getElementById("start");
	    start.value = latitud +","+ longitud;

		/* Un servicio que proporciona la API de GM es colocar marcadores sobre el mapa */
	    var marcador = new google.maps.Marker(
	    {
		    position: centro,
		    map: map,	
		    title: "Tu localizacion"
		});
		}
	 /* Gestion de errores */
     function error(errorCode)
	    {
		if(errorCode.code == 1)
		  alert("No has permitido buscar tu localizacion")
		else if (errorCode.code==2)
		  alert("Posicion no disponible")
		else
		  alert("Ha ocurrido un error")
	    }
		      
     $('#ub').live('click', function(){ 
		localize();
	    mapa(pos);
	    });
		        
  
  	
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
 	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     $('.end').each(function() {
	    $(this).data('placeholder', $(this).attr('placeholder'));
	    });

	 function changePlaceholder() {
	    if( $(window).width() <= 640){
		    $('.end').attr('placeholder','Destino');
		} else {
		    $('.end').each(function() {
	   	    $('.end').attr('placeholder','-Introduce destino');
	     });
	   }   
	 }
     $(window).resize( changePlaceholder ).trigger('resize');
     
 	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		        
     $('.start').each(function() {
	    $(this).data('placeholder', $(this).attr('placeholder'));
	    });

    function changePlaceholder2() {
	   if( $(window).width() <= 640){
	       $('.start').attr('placeholder','Origen');
	   } else {
		   $('.start').each(function() {
	   	   $('.start').attr('placeholder','-Introduce origen');
		});
	   }   
      }
     $(window).resize( changePlaceholder2 ).trigger('resize');
      
  	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		      
    