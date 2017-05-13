
package aiss.model.consorcio;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paradas"
})
public class Paradas {

    @JsonProperty("paradas")
    private List<Parada> paradas;

    @JsonProperty("paradas")
    public List<Parada> getParadas() {
        return paradas;
    }

    @JsonProperty("paradas")
    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }

}
