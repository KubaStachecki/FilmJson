package com.example.kuba.com.filmjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    String url = "http://www.json-generator.com/api/";

    @Inject
    Retrofit retrofit;

    private ApiInterface apiInterface;

    ServiceComponent serviceComponent;

    List<Film> films = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injecServiceComponent();
        connectFilmApi();

    }

    private void injecServiceComponent() {
        serviceComponent = DaggerServiceComponent.builder()
                .serviceModule(new ServiceModule(url))
                .build();
        serviceComponent.inject(this);
        apiInterface = retrofit.create(ApiInterface.class);

    }

    public void connectFilmApi() {

        apiInterface.getOtherFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<OtherFilms>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                        Log.d("STAAAAART", "LOLOLO");


                    }

                    @Override
                    public void onNext(@NonNull List<OtherFilms> films) {
                        films.addAll(films);
                        Log.d("LOGOGOGGO", Integer.toString(films.size()));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("WYJEBANY", "LOLOLO");

                    }

                    @Override
                    public void onComplete() {

                        Log.d("COMPLETE", "LOLOLO");


                    }
                });


    }
}
