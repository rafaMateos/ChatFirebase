package com.example.rafael.chatfirebase;

import com.example.rafael.chatfirebase.Notifications.MyResponse;
import com.example.rafael.chatfirebase.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceApi {

    @Headers({

            "Content-Type:application/json",
            "Authorization:Key=AAAAliCIcuk:APA91bFXy4pfB2ZOylx_Gd-mxySvAjXiMjsluar6UYKnkO2f9rdTLTaOJak1oBcMRjffKoRgPyXftpAYM6r0ftNs0M_pYqtBJyJCAHorMRJ0DieaZttStlxlt0eO-it76p3QnCHdt_Dg"
    })


    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);



}
