package strauss.sebastian.eduardo.apidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import strauss.sebastian.eduardo.apidos.GETGitHub.GitHubRepo;
import strauss.sebastian.eduardo.apidos.GETGitHub.GitHubRepoAdapter;
import strauss.sebastian.eduardo.apidos.GETGitHub.GitHubRepoClient;
import strauss.sebastian.eduardo.apidos.POSTTodo.Todo;
import strauss.sebastian.eduardo.apidos.POSTTodo.TodoClient;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pagination)
    ListView mListView;
    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        //Retrofit Use
        GitHubRepoClient client = retrofit.create(GitHubRepoClient.class);
        Call<List<GitHubRepo>> call = client.reposFromUser("fs-opensource");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
                //El Adapter creado en la otra clase
                mListView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Todo todo = new Todo("PruebaNueva", null,null, true);

                sendNetworkRequest(todo);
            }
        });

    }


    private void sendNetworkRequest(Todo todo){

        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClientBuilder.addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://serene-brushlands-19371.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(okhttpClientBuilder.build());

        final Retrofit retrofit = builder.build();

        TodoClient client = retrofit.create(TodoClient.class);
        Call<Todo> call = client.createAccount(todo);

        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Toast.makeText(MainActivity.this, "Hola" + response.body().getText()+ " " +
                        response.body().getId()+" " + response.body().isCompleted(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
