package mike.galitsky.poststat;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InratingTopApi {

    @POST("get")
    Call<Post> getPost(@Header("Authorization") String token, @Body HashMap<String, String> body);

    @POST("likers/all")
    Call<PersonsList> getLikers(@Header("Authorization") String token, @Body HashMap<String, Integer> body);

    @POST("reposters/all")
    Call<PersonsList> getReposters(@Header("Authorization") String token, @Body HashMap<String, Integer> body);

    @POST("commentators/all")
    Call<PersonsList> getCommentators(@Header("Authorization") String token, @Body HashMap<String, Integer> body);

    @POST("mentions/all")
    Call<PersonsList> getMention(@Header("Authorization") String token,  @Body HashMap<String, Integer> body);
}
