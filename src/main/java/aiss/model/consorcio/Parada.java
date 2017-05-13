
package aiss.model.consorcio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idParada",
    "idNucleo",
    "idZona",
    "nombre"
})
public class Parada {

    @JsonProperty("idParada")
    private String idParada;
    @JsonProperty("idNucleo")
    private String idNucleo;
    @JsonProperty("idZona")
    private String idZona;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("idParada")
    public String getIdParada() {
        return idParada;
    }

    @JsonProperty("idParada")
    public void setIdParada(String idParada) {
        this.idParada = idParada;
    }

    @JsonProperty("idNucleo")
    public String getIdNucleo() {
        return idNucleo;
    }

    @JsonProperty("idNucleo")
    public void setIdNucleo(String idNucleo) {
        this.idNucleo = idNucleo;
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

	@Override
	public String toString() {
		return "Parada [idParada=" + idParada + ", nombre=" + nombre + "]";
	}

}
