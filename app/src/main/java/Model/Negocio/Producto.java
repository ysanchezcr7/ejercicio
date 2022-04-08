package Model.Negocio;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Producto {

    @SerializedName("id")
    private String id;
    @SerializedName("tiendaId")
    private String tiendaId;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("urlImagen")
    private String urlImagen;
    @SerializedName("status")
    private int status;
    @SerializedName("descuento")
    private int descuento;

    private ArrayList<Precio> precios;

    private ArrayList<Extra> extras;

    public ArrayList<Extra> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<Extra> extras) {
        this.extras = extras;
    }

    public ArrayList<Precio> getPrecios() {
        return precios;
    }

    public void setPrecios(ArrayList<Precio> precios) {
        this.precios = precios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(String tiendaId) {
        this.tiendaId = tiendaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }


}
