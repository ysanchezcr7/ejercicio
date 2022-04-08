package Api;




import java.util.ArrayList;

import Model.Data.CategoriaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//import java.util.List;

public interface InterfasRetrofit {

    @GET("categoriasWithProd.php")
    Call <ArrayList<CategoriaResponse>> getCategorias();
//
//    @GET("comments")
//    Call <ArrayList<PostsComent>> getPostsComents(
//            @Query("postId") int id);

}
