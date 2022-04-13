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

import java.util.ArrayList;

import Model.Data.Extra;
import Model.Data.Precio;
import Model.Data.Producto;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import yosva.cu.example.DetallesProducto;
import yosva.cu.example.R;


public class ListaProductoAdapter extends RecyclerView.Adapter<ListaProductoAdapter.ProductoViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    public static ArrayList<Producto> productos;
    public static Context context;
    public static Producto producto;
    public static ListaProductoAdapter adapter;
    private static View.OnClickListener listener;


    public ArrayList<Producto> getArrayList() {
        return productos;
    }

    public ListaProductoAdapter(ArrayList<Producto> productos, Context context) {

        // Log.e("ASD", "" + productos);
        this.productos = productos;
        this.context = context;
        //adapter = this;


    }



    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_productos, parent, false);
        ProductoViewHolder holder = new ProductoViewHolder(v);
       // holder.setIsRecyclable(false);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder productoViewHolder, final int position) {

         producto = productos.get(position);
        //String id = String.valueOf(post.getIdPosts());
        // postsViewHolder.tvTitle.setText(usserid);
        productoViewHolder.tvTitle.setText(producto.getTitulo());
        productoViewHolder.position.setText(String.valueOf(producto.getPos()));
        productoViewHolder.tvdescription.setText(producto.getDescripcion());
        final String url = producto.getUrlImagen();
       // Glide.with(context).load(producto.getUrlImagen()).into(productoViewHolder.imgProducto);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Glide.with(context).load(url).apply(options).into(productoViewHolder.imgProducto);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                productoViewHolder.recyclerViewPrecio.getContext(),
                LinearLayoutManager.HORIZONTAL, false
        );
        layoutManager.setInitialPrefetchItemCount(producto.getPrecios().size());

        // Log.e("lisProd","->" + categoria.getProducto() );
        ListaPrecioAdapter listaPrecAdapter = new ListaPrecioAdapter(producto.getPrecios(), context);
        productoViewHolder.recyclerViewPrecio.setLayoutManager(layoutManager);
        productoViewHolder.recyclerViewPrecio.setAdapter(listaPrecAdapter);
        productoViewHolder.recyclerViewPrecio.setRecycledViewPool(viewPool);
        productoViewHolder.setIsRecyclable(true);


       //textViewNombre= itemView.findViewById(R.id.showNameCard);


        productoViewHolder.item_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //productoViewHolder.recyclerViewPrecio.getAdapter();
                final String titulo = (String) productoViewHolder.tvTitle.getText();
                final String urlIn = url;
                final String description = (String) productoViewHolder.tvdescription.getText();
                final ArrayList<Precio> pre = producto.getPrecios();
                final ArrayList<Extra> extras = producto.getExtras();
                Intent inte = new Intent(context, DetallesProducto.class);
                inte.putExtra("url", url);
                inte.putExtra("titulo", titulo);
                inte.putExtra("descrition", description);
                // inte.putExtra("selected", selected);
                inte.putParcelableArrayListExtra("arrayPre", pre);
                inte.putParcelableArrayListExtra("arrayExtras", extras);
                // inte.putParcelableArrayListExtra("arrayIt", it);
                //inte.putExtra("arrayPrecios", precios);
                context.startActivity(inte);
                Toast.makeText(context,"pocision "+ position +  productoViewHolder.tvTitle.getText() , Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(view.getContext(), ShowDetailActivity.class);
//                // envías los TextView de esta forma:
//                intent.putExtra("clave1", textViewNombre.getText());
//                // para las imágenes de esta forma:
//                intent.putExtra("clave2", shows.get(getAdapterPosition()).getImg_show());
//                view.getContext().startActivity(intent);
            }
        });

    }

//    public static Bitmap getBitmapFromURL(String src) {
//        try {
//            URL url = new URL(src);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            return myBitmap;
//        } catch (IOException e) {
//            // Log exception
//            return null;
//        }
//    }

    @Override
    public int getItemCount() {

        return productos == null ? 0 : productos.size();
    }

    public void setData(ArrayList<Producto> productos) {

        this.productos = productos;
        notifyDataSetChanged();
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
