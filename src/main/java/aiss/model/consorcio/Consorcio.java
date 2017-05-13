
package aiss.model.consorcio;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "consorcios"
})
public class Consorcio {

    @JsonProperty("consorcios")
    private List<Consorcio_> consorcios = null;

    @JsonProperty("consorcios")
    public List<Consorcio_> getConsorcios() {
        return consorcios;
    }

    @JsonProperty("consorcios")
    public void setConsorcios(List<Consorcio_> consorcios) {
        this.consorcios = consorcios;
    }

}
