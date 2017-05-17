
package aiss.api.resources;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "comentarios"
})
public class Comentarios {

    @JsonProperty("comentarios")
    private List<Comentario> comentarios = null;

    @JsonProperty("comentarios")
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @JsonProperty("comentarios")
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
