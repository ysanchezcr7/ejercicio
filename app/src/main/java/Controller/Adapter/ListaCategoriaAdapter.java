package Controller.Adapter;


import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import Model.Negocio.CategoriasWithProd;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Model.Negocio.Producto;
import yosva.cu.example.R;


public class ListaCategoriaAdapter extends RecyclerView.Adapter<ListaCategoriaAdapter.CategoriaViewHolder> {

   private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public static ArrayList<CategoriasWithProd> categorias;
    public static Context context;
   // public static CategoriasWithProd categoria;
    public static ListaCategoriaAdapter adapter;
    private static View.OnClickListener listener;


    public ArrayList<CategoriasWithProd> getArrayList() {
        return categorias;
    }

    public ListaCategoriaAdapter(ArrayList<CategoriasWithProd> categorias, Context context) {

        this.categorias = categorias;
        this.context = context;
       // adapter = this;


    }
    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_categoria, parent, false);
        CategoriaViewHolder holder = new CategoriaViewHolder(v);
       // holder.setIsRecyclable(false);
        return holder;

    }


    @Override
    public void onBindViewHolder(CategoriaViewHolder catViewHolder, int position) {

        CategoriasWithProd categoria = categorias.get(position);
        catViewHolder.tvTitle.setText(categoria.getCategoria());
        catViewHolder.recyclerViewProductos.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(
//           catViewHolder.recyclerViewProductos.getContext(),
//           LinearLayoutManager.VERTICAL,false
//        );
     //   layoutManager.setInitialPrefetchItemCount(categoria.getProducto().size());

//
        ArrayList<Producto> productos_new = categoria.getProducto();
        ArrayList<Producto> productos = new ArrayList<Producto>();

        for(int i = 0; i<productos_new.size();i++){
            Producto item = (Producto) productos_new.get(i);
            item.setPos(i);
            productos.add(item);
        }

       // Log.e("lisProd","->" + categoria.getProducto() );
        ListaProductoAdapter listaProductoAdapter = new ListaProductoAdapter(productos,context);
       // catViewHolder.recyclerViewProductos.setLayoutManager(layoutManager);
        catViewHolder.recyclerViewProductos.setAdapter(listaProductoAdapter);
      //  catViewHolder.recyclerViewProductos.setRecycledViewPool(viewPool);
      //  listaProductoAdapter.notifyDataSetChanged();

       // catViewHolder.setIsRecyclable(true);

    }
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
    @Override
    public int getItemCount() {

        return categorias == null ? 0 : categorias.size() ;
    }
    public void setData(ArrayList<CategoriasWithProd> listcats) {

        this.categorias = listcats;
      //  Log.d("productos","" + listcats);
        notifyDataSetChanged();
    }


    public class CategoriaViewHolder extends RecyclerView.ViewHolder  implements AdapterView.OnClickListener {

        //private ImageView imgFotos;
        //private TextView tvUsserId;
        //private TextView tvID;
        private TextView tvTitle;
        private RecyclerView recyclerViewProductos;


        public CategoriaViewHolder(final View itemView) {

            super(itemView);
            //tvUsserId = itemView.findViewById(R.id.tvUsserID);
           // tvID = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.Categoria);
            recyclerViewProductos = itemView.findViewById(R.id.rvProductos);

            context = itemView.getContext();
            //itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onClick(v);
        }


    }
}
