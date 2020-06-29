package com.example.projectlancuoikhongmuoncobug.Service;


import com.example.projectlancuoikhongmuoncobug.Model.Album;
import com.example.projectlancuoikhongmuoncobug.Model.Baihat;
import com.example.projectlancuoikhongmuoncobug.Model.Baihatyeuthich;
import com.example.projectlancuoikhongmuoncobug.Model.ChuDe;
import com.example.projectlancuoikhongmuoncobug.Model.Chudengay;
import com.example.projectlancuoikhongmuoncobug.Model.PlayList;
import com.example.projectlancuoikhongmuoncobug.Model.Quangcao;
import com.example.projectlancuoikhongmuoncobug.Model.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<PlayList>> GetDataPlayList();


    @GET("chudevatheloaitrongngay.php")
    Call<Chudengay> GetDataChuDeNgay();
    @GET("album.php")
    Call<List<Album>> GetAlbum();

    @GET("baihathot.php")
    Call<List<Baihat>> GetBaihatyeuthich();

    @FormUrlEncoded
    @POST("test.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);
    @GET("danhsachcacplaylist.php")
    Call<List<PlayList>> GetDanhsachcacPlaylist();
    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllChude();
    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);
    @GET("tatcacacalbum.php")
    Call<List<Album>> GetAllAlbum();
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);
    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> Updateluotthich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);
    @FormUrlEncoded
    @POST("timkiem.php")
    Call<List<Baihat>> GetSearchBaihat(@Field("tukhoa") String tukhoa);
}