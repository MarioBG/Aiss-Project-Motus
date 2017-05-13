
package aiss.model.consorcio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idConsorcio",
    "nombre",
    "nombreCorto"
})
public class Consorcio_ {

    @JsonProperty("idConsorcio")
    private String idConsorcio;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("nombreCorto")
    private String nombreCorto;

    @JsonProperty("idConsorcio")
    public String getIdConsorcio() {
        return idConsorcio;
    }

    @JsonProperty("idConsorcio")
    public void setIdConsorcio(String idConsorcio) {
        this.idConsorcio = idConsorcio;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("nombreCorto")
    public String getNombreCorto() {
        return nombreCorto;
    }

    @JsonProperty("nombreCorto")
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

}
