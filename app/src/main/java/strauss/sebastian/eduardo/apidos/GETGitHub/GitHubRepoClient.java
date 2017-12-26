package strauss.sebastian.eduardo.apidos.GETGitHub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRepoClient {

    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposFromUser(@Path("user") String user);

}
