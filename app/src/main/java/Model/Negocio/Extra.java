package Model.Negocio;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Extra implements Parcelable {
    public Extra (String id, String titulo, String descripcion,
                  int status, int maximo,int minimo ,
                  int obligatorio ,ArrayList<Items> items) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.status = status;
        this.maximo = maximo;
        this.minimo = minimo;
        this.obligatorio = obligatorio;
        this.items = items;
    }

    //private int pos =-1;

    @SerializedName("id")
    public String id;

    @SerializedName("titulo")
    public String titulo;

    @SerializedName("descripcion")
    public String descripcion;

    @SerializedName("status")
    public int status;

    @SerializedName("maximo")
    public int maximo;

    @SerializedName("minimo")
    public int minimo;

    @SerializedName("obligatorio")
    public int obligatorio;


    @SerializedName("items")
    public ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    protected Extra(Parcel in) {
        this.id = in.readString();
        this.titulo = in.readString();
        this.descripcion = in.readString();
        this.status = in.readInt();
        this.maximo = in.readInt();
        this.minimo = in.readInt();
        this.obligatorio = in.readInt();
        this.items = (ArrayList<Items>) in.readValue(Items.class.getClassLoader());

        //  this.items = in.createBinderArray();
        //in.readList(this.items, getClass().getClassLoader());

        //in.readTypedList(items, Items.CREATOR);

        //items=in.readArrayList();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(int obligatorio) {
        this.obligatorio = obligatorio;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeInt(status);
        dest.writeInt(maximo);
        dest.writeInt(minimo);
        dest.writeInt(obligatorio);
        dest.writeValue(items);

        //dest.writeTypedList(items);


    }
    public static final Creator<Extra> CREATOR = new Creator<Extra>() {
        @Override
        public Extra createFromParcel(Parcel in) {
            return new Extra(in);
        }

        @Override
        public Extra[] newArray(int size) {
            return new Extra[size];
        }
    };


}
