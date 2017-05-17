
package aiss.api.resources;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

    
    
    @JsonProperty("idComentario")
    public String getIdComentario() {
        return idComentario;
    }

    @JsonProperty("idComentario")
    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    @JsonProperty("texto")
    public String getNombre() {
        return texto;
    }

    @JsonProperty("texto")
    public void setNombre(String nombre) {
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
