
package aiss.model.consorcio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idNucleo",
    "idMunicipio",
    "idZona",
    "nombre"
})
public class Nucleo_ {

    @JsonProperty("idNucleo")
    private String idNucleo;
    @JsonProperty("idMunicipio")
    private String idMunicipio;
    @JsonProperty("idZona")
    private String idZona;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("idNucleo")
    public String getIdNucleo() {
        return idNucleo;
    }

    @JsonProperty("idNucleo")
    public void setIdNucleo(String idNucleo) {
        this.idNucleo = idNucleo;
    }

    @JsonProperty("idMunicipio")
    public String getIdMunicipio() {
        return idMunicipio;
    }

    @JsonProperty("idMunicipio")
    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @JsonProperty("idZona")
    public String getIdZona() {
        return idZona;
    }

    @JsonProperty("idZona")
    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
