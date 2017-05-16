
package aiss.model.consorcio;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paradas"
})
public class ParadasDatos {

    @JsonProperty("paradas")
    private List<ParadaDatos> paradas;

    @JsonProperty("paradas")
    public List<ParadaDatos> getParadas() {
        return paradas;
    }

    @JsonProperty("paradas")
    public void setParadas(List<ParadaDatos> paradas) {
        this.paradas = paradas;
    }

}
