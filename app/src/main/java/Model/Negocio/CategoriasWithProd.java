package Model.Negocio;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriasWithProd {

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("productos")
    private ArrayList<Producto> producto;

}
