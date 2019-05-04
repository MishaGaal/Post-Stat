package mike.galitsky.poststat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJmNGU5ZDA1MzU3MDI3MmFlMGZhZTMzM2Y4ZTY4ZWVlMWNiMzc0NmM0Mjg5NzI0ZTExNzJjM2Q4ODYzNDNkNDkyY2ZjZjI4Njg0NzQ0MGEwIn0.eyJhdWQiOiIyIiwianRpIjoiMmY0ZTlkMDUzNTcwMjcyYWUwZmFlMzMzZjhlNjhlZWUxY2IzNzQ2YzQyODk3MjRlMTE3MmMzZDg4NjM0M2Q0OTJjZmNmMjg2ODQ3NDQwYTAiLCJpYXQiOjE1MzY4MzE4ODcsIm5iZiI6MTUzNjgzMTg4NywiZXhwIjoxNTY4MzY3ODg3LCJzdWIiOiIzOCIsInNjb3BlcyI6W119.dRitRnoqNFS3xUgtLdLiDjDVVe7ZFNrh24Qm2ML9m-V7kZpgQgajArYoS44kMa1dz_MHUhq3pqk8SnAYIsULgfrOvewTUzmH1C92-yL64Uqnv7lqWizldX2fbJ2IbB8khOCtQ-CCNA_fGY_zEBJXLsOqr4Z00tbZE6fa0PX4Mu0SsuUakLeygXbXnKOmFyZmLJZWoXKpbqiSBU239nrcyqJftBon8DL1BAUuFiadap-gpVSXj8h6BX-FsJx5cgPHFiijIalcEgzOq4VCMkwbQE8xbTsmmxkZUOnM7oKab5inzl8EV5iUgcExeSbHT6k_phOkA7XUaR6PhVoKrSQTPcfdijhME1IHfPVDPGO0vhd6hKszRrhjEPEpoothBoB8ss0lmuCFURdxFv17q97rfpDn1OfO_Y3wYuRW2lqFAnw7sLd92CHjfONwQKswLDzwE4hiQhB8iS_UEbuL_UamNOiCLfjNnVWbVc9BvoReEa8jG4coc0Kv9VNJVWh3D_hGf8dLRZBd1a7zB6-nSpKGf0eAzB0_rBXsyBepjudC-5EFDjloJOxy1Mdruoq6mQa_tFcO99JRteUSd0CXHZO-CN4Bp4xND9kstdutjBn2UWT5xhNq_QRBmBsBDAwp647dUCyQofutN9GUlu2LxmhL0ojydazdND_d9rHtY9t-ndw";
    private String slug = "LeBxOWT5zSemiSvkuqBLXFjXlaA0bJlX";
    private int id = 2720;

    private TextView textView;


    private InratingTopApi inratingTopApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.inrating.top/v1/users/posts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        inratingTopApi = retrofit.create(InratingTopApi.class);

         getLikers();
        getReposters();
        getCommentators();
        getMention();
         getPost();
    }

    public void getLikers(){

        HashMap<String, Integer> body = new HashMap<>();
        body.put("id", id);

        Call<PersonsList> call = inratingTopApi.getLikers(token, body);

        call.enqueue(new Callback<PersonsList>() {
            @Override
            public void onResponse(Call<PersonsList> call, Response<PersonsList> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                MainFragment mainFragment = MainFragment.newInstance(response.body().data);
                getSupportFragmentManager().beginTransaction().replace(R.id.likers, mainFragment).commit();
            }

            @Override
            public void onFailure(Call<PersonsList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getReposters(){

        HashMap<String, Integer> body = new HashMap<>();
        body.put("id", id);

        Call<PersonsList> call = inratingTopApi.getReposters(token, body);

        call.enqueue(new Callback<PersonsList>() {
            @Override
            public void onResponse(Call<PersonsList> call, Response<PersonsList> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                RepostersFragment repostersFragment = RepostersFragment.newInstance(response.body().data);
                getSupportFragmentManager().beginTransaction().replace(R.id.reposters, repostersFragment).commit();
            }

            @Override
            public void onFailure(Call<PersonsList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getCommentators(){

        HashMap<String, Integer> body = new HashMap<>();
        body.put("id", id);

        Call<PersonsList> call = inratingTopApi.getCommentators(token, body);

        call.enqueue(new Callback<PersonsList>() {
            @Override
            public void onResponse(Call<PersonsList> call, Response<PersonsList> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                ComentatorsFragment comentatorsFragment = ComentatorsFragment.newInstance(response.body().data);
                getSupportFragmentManager().beginTransaction().replace(R.id.commentators, comentatorsFragment).commit();

            }

            @Override
            public void onFailure(Call<PersonsList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getMention(){

        HashMap<String, Integer> body = new HashMap<>();
        body.put("id", id);

        Call<PersonsList> call = inratingTopApi.getMention(token, body);

        call.enqueue(new Callback<PersonsList>() {
            @Override
            public void onResponse(Call<PersonsList> call, Response<PersonsList> response) {


                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                MentionedFragment mentionedFragment  = MentionedFragment.newInstance(response.body().data);
                getSupportFragmentManager().beginTransaction().replace(R.id.mentioned, mentionedFragment).commit();

            }

            @Override
            public void onFailure(Call<PersonsList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getPost(){

        HashMap<String, String> body = new HashMap<>();
        body.put("slug", slug);

        Call<Post> call = inratingTopApi.getPost(token, body);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code :" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                textView= findViewById(R.id.textView);
                Post p = response.body();
                String content = String.format("Viewed: %d, Liked: %d, Comments amount: %d, Reposted: %d, Bookmarks: %d", p.getViews_count(), p.getLikes_count(),
                        p.getComments_count(), p.getReposts_count(),  p.getBookmarks_count()  );


                textView.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
