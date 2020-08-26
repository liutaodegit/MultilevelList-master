package com.example.frame;

import com.example.data.TestData;
import io.reactivex.Observable;
import retrofit2.http.GET;

import retrofit2.http.Url;

public interface IService {
    @GET
    Observable<TestData> getTestNetWork(@Url String url);
}
