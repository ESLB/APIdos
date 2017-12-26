package strauss.sebastian.eduardo.apidos.POSTTodo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import strauss.sebastian.eduardo.apidos.GETGitHub.GitHubRepo;

public interface TodoClient {

    @POST("todos")
    Call<Todo> createAccount(@Body Todo todo);

    @PATCH("todos/{id}")
    Call<Todo> updateAccount(@Path("id") String id,@Body Todo Todo);

}
