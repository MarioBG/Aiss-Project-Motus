
package aiss.api.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonPropertyOrder({
    "idComentario",
    "texto",
    "usuario",
    "fecha"
})
public class Comentario {

    @JsonProperty("idComentario")
    private String idComentario;
    @JsonProperty("texto")
    private String texto;
    @JsonProperty("usuario")
    private String usuario;
    @JsonProperty("fecha")
    private String fecha;
    private List<Integer> idsUsadas=new ArrayList<Integer>();

    public Comentario (String texto){
    	Random r = new Random();
    	Integer sb = null;
    	while (sb==null || idsUsadas.contains(sb)){
    		sb = r.nextInt(99999999);
    	}
        idComentario = String.valueOf(sb);
        this.texto=texto;
        this.usuario="STANDARD_CREATOR";
        this.fecha=LocalDateTime.now().toString();
    }
    
    @JsonProperty("idComentario")
    public String getIdComentario() {
        return idComentario;
    }

    @JsonProperty("idComentario")
    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    @JsonProperty("texto")
    public String getTexto() {
        return texto;
    }

    @JsonProperty("texto")
    public void setTexto(String nombre) {
        this.texto = nombre;
    }

    @JsonProperty("usuario")
    public String getUsuario() {
        return usuario;
    }

    @JsonProperty("usuario")
    public void setUsuario(String nombreCorto) {
        this.usuario = nombreCorto;
    }
    
    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
