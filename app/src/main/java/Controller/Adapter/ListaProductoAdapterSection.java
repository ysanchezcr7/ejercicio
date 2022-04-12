package Controller.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import Model.Negocio.Extra;
import Model.Negocio.Precio;
import Model.Negocio.Producto;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import yosva.cu.example.DetallesProducto;
import yosva.cu.example.R;


public class ListaProductoAdapterSection extends SectionedRecyclerViewAdapter<ListaProductoAdapterSection.ProductoViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    public static ArrayList<Producto> productos;
    public static Context context;
    public static Producto producto;
    public static ListaProductoAdapterSection adapter;
    private static View.OnClickListener listener;


    public ArrayList<Producto> getArrayList() {
        return productos;
    }

    public ListaProductoAdapterSection(ArrayList<Producto> productos, Context context) {

        // Log.e("ASD", "" + productos);
        this.productos = productos;
        this.context = context;
        //adapter = this;


    }


    @Override
    public int getSectionCount() {
        return 0;
    }

    @Override
    public int getItemCount(int section) {
        return 0;
    }

    @Override
    public ListaProductoAdapterSection.ProductoViewHolder onCreateViewHolder(ViewGroup parent, boolean header) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(ListaProductoAdapterSection.ProductoViewHolder holder, int section) {

    }

    @Override
    public void onBindViewHolder(ListaProductoAdapterSection.ProductoViewHolder holder, int section, int relativePosition, int absolutePosition) {

    }



    public class ProductoViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        //private ImageView imgFotos;
        private ImageView imgProducto;
        private TextView position;
        private TextView tvTitle;
        private TextView tvdescription;
        private RecyclerView recyclerViewPrecio;
        private CardView item_show;


        public ProductoViewHolder(final View itemView) {

            super(itemView);
            //tvUsserId = itemView.findViewById(R.id.tvUsserID);
            // tvID = itemView.findViewById(R.id.tvId);
            position = itemView.findViewById(R.id.position);
            tvTitle = itemView.findViewById(R.id.tvtitleprod);
            tvdescription = itemView.findViewById(R.id.tvdescription);
            imgProducto = itemView.findViewById(R.id.imgProducto);
            recyclerViewPrecio = itemView.findViewById(R.id.rvPrecio);
            item_show = itemView.findViewById(R.id.cardProd);


            //context = itemView.getContext();
            //  itemView.setOnClickListener(this);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @SuppressLint("RestrictedApi")
//                @Override
//                public void onClick(View view) {
//
//                    int selected = getLayoutPosition();
//                   // int selected = Integer.parseInt(position.getText().toString());
//
//                    final String url = productos.get(selected).getUrlImagen();
//                    final String titulo = productos.get(selected).getTitulo();
//                    final String description = productos.get(selected).getDescripcion();
//                    //ArrayList<String> milista = new ArrayList<String>();
//                    final ArrayList<Precio> pre = productos.get(selected).getPrecios();
//
//                    final ArrayList<Extra> extras = productos.get(selected).getExtras();
//                   // ArrayList<Items> it ;
//                   // it = extras.get(selected).getItems();
//                    //Log.e("item","" + item);
//                    //Log.e("extras","e: "+ extras.get(selected).getItems());
//                   Toast.makeText(context,"pocision "+ selected +  titulo , Toast.LENGTH_LONG).show();
//
//                    //final String postId= productos.get(selected).getIdPosts();
//
//                  /*  @SuppressLint("RestrictedApi") MenuBuilder menuBuilder = new MenuBuilder(context);
//                    MenuInflater inflater = new MenuInflater(context);
//                    inflater.inflate(R.menu.menu_popou_verdetall_producto, menuBuilder);
//                    @SuppressLint("RestrictedApi") MenuPopupHelper optionsMenuComent = new MenuPopupHelper(context, menuBuilder, view);
//                    optionsMenuComent.setForceShowIcon(true);
//
//                    // Set Item Click Listener
//                    menuBuilder.setCallback(new MenuBuilder.Callback() {
//                        @Override
//                        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
//                            switch (item.getItemId()) {
//                                case R.id.action_detallesProducto: // Handle option1 Click
//
//                                    Intent inte = new Intent(context, DetallesProducto.class);
//                                    inte.putExtra("url", url);
//                                    inte.putExtra("titulo", titulo);
//                                    inte.putExtra("descrition", description);
//                                   // inte.putExtra("selected", selected);
//                                    inte.putParcelableArrayListExtra("arrayPre", pre);
//                                    inte.putParcelableArrayListExtra("arrayExtras", extras);
//                                   // inte.putParcelableArrayListExtra("arrayIt", it);
//                                    //inte.putExtra("arrayPrecios", precios);
//                                    context.startActivity(inte);
//                                    //overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
//
//                                    return true;
//                                default:
//                                    return false;
//                            }
//                        }
//
//
//                        @Override
//                        public void onMenuModeChange(MenuBuilder menu) {
//                        }
//                    });
//                    // Display the menu
//                    optionsMenuComent.show();*/
//
//                }
//            });

        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onClick(v);
//            int position = getAdapterPosition();
//            Toast.makeText(context, ""+productos.get(position).getTitulo(), Toast.LENGTH_SHORT).show();

        }


    }
}
