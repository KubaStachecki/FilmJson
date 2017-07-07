package com.example.kuba.com.filmjson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class})
public interface ServiceComponent {
    void inject(MainActivity activity);


}
