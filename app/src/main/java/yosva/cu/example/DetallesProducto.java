package yosva.cu.example;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import Controller.Adapter.ListaCategoriaAdapter;
import Controller.Adapter.ListaExtrasAdapter;
import Controller.Adapter.ListaItemsAdapter;
import Controller.Adapter.ListaPrecioAdapter;
import Model.Negocio.CategoriasWithProd;
import Model.Negocio.Extra;
import Model.Negocio.Items;
import Model.Negocio.Precio;
import Model.Negocio.Producto;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetallesProducto extends AppCompatActivity {

    private ListaPrecioAdapter adapterprecio;
    private ListaExtrasAdapter adapterextra;

    private Context context;
   // ArrayList<CategoriasWithProd> categorias;
    RecyclerView rvpreciodetall , rvExtras;
    ImageView imageViewDetall;
    TextView tituloDetall,descricionDetall;
    String titulo,descricion,url;
    int selec;
    private ArrayList <Precio> precios  ;
    private ArrayList <Extra> extras  ;


    int onStartCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_productos);

        onStartCount = 1;
        if (savedInstanceState == null) // 1st time
        {
            this.overridePendingTransition(R.anim.anim_slide_in_left,
                    R.anim.anim_slide_out_left);
        } else // already created so reverse animation
        {
            onStartCount = 2;
        }
       //productos.get(selec).getPrecios();
        rvExtras = findViewById(R.id.rvExtras);
        rvpreciodetall = findViewById(R.id.rvpreciodetall);
        imageViewDetall = findViewById(R.id.imgdetalleProd);
        tituloDetall = findViewById(R.id.tvtitleprodetall);
        descricionDetall = findViewById(R.id.tvdescriptiondetall);

       // Bundle bundle = getIntent().getExtras();
        //ListObjetos = bundle.getParcelableArrayList("ListaObjetos");
        if (getIntent() != null) {
            Intent informacion = getIntent();
            Bundle b = informacion.getExtras();
            if (b != null && b.getString("titulo") != null)
                titulo = b.getString("titulo");
            if (b.getString("descrition") != null)
                descricion = b.getString("descrition");
            if (b.getString("url") != null)
                url = b.getString("url");
           // if (b.getString("mylist") != null)
               // precios = (ArrayList<Precio>) getIntent().getSerializableExtra("arrayPrecios");
            precios = getIntent().getParcelableArrayListExtra ("arrayPre");
            extras =  getIntent().getParcelableArrayListExtra("arrayExtras");
           // itemsArrayList =  getIntent().getParcelableArrayListExtra("arrayIt");

            //selec = b.("selected");

//            if (b.getParcelable("imagenContact") != null)
//                bitmap = b.getParcelable("imagenContact");

        }

        tituloDetall.setText(titulo);
        descricionDetall.setText(descricion);
        inicializarAdaptadorPrecio();
        inicializarAdaptadorExtra();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvpreciodetall.setLayoutManager(llm);

        LinearLayoutManager llmext = new LinearLayoutManager(this);
        llmext.setOrientation(LinearLayoutManager.VERTICAL);
        rvExtras.setLayoutManager(llmext);


    }


    private void inicializarAdaptadorPrecio() {
        adapterprecio = new ListaPrecioAdapter(precios, this );
        rvpreciodetall.setAdapter(adapterprecio);


    }
    private void inicializarAdaptadorExtra() {

        adapterextra= new ListaExtrasAdapter(extras,this);
        rvExtras.setAdapter(adapterextra);

    }
//    private void inicializarAdaptadorItems() {
////        itemsAdapter= new ListaItemsAdapter(itemsArrayList,this);
////        rvExtras.setAdapter(itemsAdapter);
//
//    }
}