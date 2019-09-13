# RetrofitSample
Sample Retrofit Structure

follow the steps for simply to implement retrofit in your project.

************************************************
Inside MainActivity Class:
************************************************

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseModelClass> call = service.getResponse("Zfg8sSa4SZk3Ypf9ApjR23CisgJplc7G");
        call.enqueue(new Callback<ResponseModelClass>() {
            @Override
            public void onResponse(Call<ResponseModelClass> call, Response<ResponseModelClass> response) {
                Log.d("Response","success");
            }

            @Override
            public void onFailure(Call<ResponseModelClass> call, Throwable t) {
                Log.d("Response","failure");
            }
        });
    }
}


************************************************
add dependency inside the app gradle
************************************************
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
implementation 'com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0'

************************************************
create Sample Response Model class,  SerializedName with field variable
************************************************

public class ResponseModelClass {

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

************************************************
create singleton instance of Retrofit
************************************************

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

************************************************
Create interface for call Query with end url
************************************************
public interface GetDataService {
    
    @GET("all-sections/7.json")
    Call<ResponseModelClass> getResponse(@Query("api-key") String apiKey);
}

************************************************
add internet permission inside manifest file
************************************************

 <uses-permission android:name="android.permission.INTERNET" />
