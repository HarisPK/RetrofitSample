package com.techxora.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
