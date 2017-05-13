     
      
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
   
     function cambio()
     {
      document.getElementById("a").value = document.getElementById("start").value;
      document.getElementById("start").value = document.getElementById("end").value;
      document.getElementById("end").value = document.getElementById("a").value;;
     }
  
     $("#ch").click(function(){
	     cambio();
     });
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     function cambio2()
     {
      document.getElementById("a").value = document.getElementById("start").value;
      document.getElementById("start").value = document.getElementById("end").value;
      document.getElementById("end").value = document.getElementById("a").value;;
     }
  
     $("#ch2").click(function(){
	     cambio2();
     });
     

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     $(document).ready(function()
    		 {
    		   var slider_width = $('#guardar').width();//get width automaticaly
    		   $('#bsucc').click(function() {
    			 
    		     if($("#guardar").is(":visible") && $("#guardar").width()!=0)
    		     {
    		    	 $('#guardar').animate({"width":0});
    		        
    		     }
    		     if($("#guardar").width()==0){
    		    	      $('#guardar').animate({"margin-right":-2});
    		    	      $('#guardar').animate({"width":350});
    		     }
    		     else
    		     {
    		         if(!$("#guardar").is(':animated'))//perevent double click to double margin
    		         {
    		        	 $('#guardar').show();
    		             $('#guardar').animate({"margin-right":-2});
    		         }
    		     }


    		   });
    		  });     
   
    