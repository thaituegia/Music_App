package com.example.projectlancuoikhongmuoncobug.Service;

public class APIService {
    private  static String basr_url ="https://musicbachchien.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(basr_url).create(Dataservice.class);
    }
}
