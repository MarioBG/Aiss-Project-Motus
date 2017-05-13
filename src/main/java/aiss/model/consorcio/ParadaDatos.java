
package aiss.model.consorcio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idParada",
    "idNucleo",
    "idMunicipio",
    "idZona",
    "nombre",
    "latitud",
    "longitud",
    "descripcion",
    "observaciones",
    "principal",
    "inactiva",
    "municipio",
    "nucleo",
    "correspondecias"
})
public class ParadaDatos {

    @JsonProperty("idParada")
    private String idParada;
    @JsonProperty("idNucleo")
    private String idNucleo;
    @JsonProperty("idMunicipio")
    private String idMunicipio;
    @JsonProperty("idZona")
    private String idZona;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("latitud")
    private String latitud;
    @JsonProperty("longitud")
    private String longitud;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("observaciones")
    private String observaciones;
    @JsonProperty("principal")
    private String principal;
    @JsonProperty("inactiva")
    private String inactiva;
    @JsonProperty("municipio")
    private String municipio;
    @JsonProperty("nucleo")
    private String nucleo;
    @JsonProperty("correspondecias")
    private String correspondecias;

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

    @JsonProperty("latitud")
    public String getLatitud() {
        return latitud;
    }

    @JsonProperty("latitud")
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @JsonProperty("longitud")
    public String getLongitud() {
        return longitud;
    }

    @JsonProperty("longitud")
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @JsonProperty("descripcion")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    @JsonProperty("observaciones")
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonProperty("principal")
    public String getPrincipal() {
        return principal;
    }

    @JsonProperty("principal")
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @JsonProperty("inactiva")
    public String getInactiva() {
        return inactiva;
    }

    @JsonProperty("inactiva")
    public void setInactiva(String inactiva) {
        this.inactiva = inactiva;
    }

    @JsonProperty("municipio")
    public String getMunicipio() {
        return municipio;
    }

    @JsonProperty("municipio")
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @JsonProperty("nucleo")
    public String getNucleo() {
        return nucleo;
    }

    @JsonProperty("nucleo")
    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    @JsonProperty("correspondecias")
    public String getCorrespondecias() {
        return correspondecias;
    }

    @JsonProperty("correspondecias")
    public void setCorrespondecias(String correspondecias) {
        this.correspondecias = correspondecias;
    }

}
