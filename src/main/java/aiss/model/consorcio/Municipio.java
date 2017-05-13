
package aiss.model.consorcio;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "municipios"
})
public class Municipio {

    @JsonProperty("municipios")
    private List<Municipio_> municipios = null;

    @JsonProperty("municipios")
    public List<Municipio_> getMunicipios() {
        return municipios;
    }

    @JsonProperty("municipios")
    public void setMunicipios(List<Municipio_> municipios) {
        this.municipios = municipios;
    }

}
