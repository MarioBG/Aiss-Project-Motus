
package aiss.model.consorcio;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nucleos"
})
public class Nucleo {

    @JsonProperty("nucleos")
    private List<Nucleo_> nucleos = null;

    @JsonProperty("nucleos")
    public List<Nucleo_> getNucleos() {
        return nucleos;
    }

    @JsonProperty("nucleos")
    public void setNucleos(List<Nucleo_> nucleos) {
        this.nucleos = nucleos;
    }

}
