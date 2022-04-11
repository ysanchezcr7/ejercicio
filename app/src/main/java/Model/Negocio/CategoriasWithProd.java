package Model.Negocio;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriasWithProd {

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("productos")
    private ArrayList<Producto> producto;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

}
