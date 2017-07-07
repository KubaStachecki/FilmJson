package com.example.kuba.com.filmjson;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("json/get/bSciNrOTCa?indent=2")
    Observable<List<Film>> getFilms();



    @GET("json/get/cfmyihOcjm?indent=2")
    Observable<List<OtherFilms>> getOtherFilms();




}




