package strauss.sebastian.eduardo.apidos.POSTTodo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TodoClient {

    @POST("todos")
    Call<Todo> createAccount(@Body Todo todo);



}
