package com.ulbra.AgendaCulturalMobile.api;

import com.ulbra.AgendaCulturalMobile.models.EventoResponse;
import com.ulbra.AgendaCulturalMobile.models.LoginResponse;
import com.ulbra.AgendaCulturalMobile.models.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    // Endpoint: https://ac.infinitydev.com.br/api/APPfeedPrincipal.php?id=1
    @GET("APPfeedPrincipal.php")
    Call<EventoResponse> getEvento(@Query("id") int id);

    // Endpoint: https://ac.infinitydev.com.br/api/APPeditarPerfil.php?id=1
    @GET("APPeditarPerfil.php")
    Call<Usuario> getUsuario(@Query("id") int id);

    @FormUrlEncoded
    @POST("APPlogin.php") // 🔹 endpoint do login
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("senha") String senha
    );
}
