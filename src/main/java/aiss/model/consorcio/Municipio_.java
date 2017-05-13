
package aiss.model.consorcio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idMunicipio",
    "datos"
})
public class Municipio_ {

    @JsonProperty("idMunicipio")
    private String idMunicipio;
    @JsonProperty("datos")
    private String datos;

    @JsonProperty("idMunicipio")
    public String getIdMunicipio() {
        return idMunicipio;
    }

    @JsonProperty("idMunicipio")
    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @JsonProperty("datos")
    public String getDatos() {
        return datos;
    }

    @JsonProperty("datos")
    public void setDatos(String datos) {
        this.datos = datos;
    }

}
