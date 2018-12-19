package com.example.user.knuhui.networkmanager.service;

import com.example.user.knuhui.networkmanager.model.User;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate.GetRevDate;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDept;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDoc;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime.GetRevTime;
import com.example.user.knuhui.networkmanager.model.reservation.booking.reservation.Reservation;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevList;
import com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel.PutRevCancel;
import com.example.user.knuhui.networkmanager.model.userinfo.findPid.FindPid;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfo;
import com.example.user.knuhui.networkmanager.model.userinfo.updateAddress.UpdateAddress;
import com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo.UpdateTelNo;
import com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo.UpdateVehicleNo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RelayService {

    @GET("/users")
    Call<List<User>> getUsers();

//    @GET("/results")
//    Call<List<Result>> getResults();

//    @GET("/results")
//    Call<Resultinfo> getResults();
//
//    @GET("/results")
//    Call<GetRevDoc> getResults();

    @GET("/service")
    Call<List<User>> getServiceUser(@Query("server") String server);



    // ---------------------  실제 서비스에 들어갈 Call method
    //예약가능한 진료과
    @GET("?domain=com&submit_id=TRZIF00019&business_id=com&hospitalCd=031")
    Call<GetRevDept> getRevDept();
    @GET("/results")
    Call<GetRevDept> getRevDeptTest();

    //진료과 의사
    @GET("?domain=com&submit_id=TRZIF00024&hospitalCd=031&business_id=com")
    Call<GetRevDoc> getRevDoc(@Query("departmentCd") String departmentCd, @Query("pId") String pId);

    //의사의 예약가능날짜
    @GET("?domain=com&submit_id=TRZIF00020&business_id=com&hospitalCd=031&reglscheyn=N&internetyn=Y")
    Call<GetRevDate> getRevDate(@Query("departmentCd") String departmentCd, @Query("doctorId") String doctorId, @Query("startYearMonth") String startYearMonth);

    //날짜에 시간
    @GET("?domain=com&submit_id=TRZIF00021&hospitalCd=031&business_id=com")
    Call<GetRevTime> getRevTime(@Query("departmentCd") String departmentCd, @Query("doctorId") String doctorId, @Query("dataDate") String dataDate, @Query("pId") String pId, @Query("pNm") String pNm);

    //진료예약
    @POST("?domain=com&submit_id=TXZIF00025&hospitalCd=031&business_id=com&histstat=T")
    Call<Reservation> reservation(@Query("departmentCd") String departmentCd, @Query("doctorId") String doctorId, @Query("dataDate") String dataDate,
                                  @Query("pId") String pId, @Query("pNm") String pNm, @Query("dataTime") String dataTime, @Query("symptom") String symptom);

    //예약 리스트
    @GET("?domain=com&submit_id=TRZIF00022&hospitalCd=031&business_id=com")
    Call<GetRevList> getRevList(@Query("pId") String pId, @Query("startDt") String startDt, @Query("endDt") String endDt);

    //예약 취소
    @POST("?domain=com&submit_id=TXZIF00025&hospitalCd=031&business_id=com&histstat=X")
    Call<PutRevCancel> putRevCancel(@Query("departmentCd") String departmentCd, @Query("doctorId") String doctorId, @Query("dataDate") String dataDate,
                                    @Query("pNm") String pNm, @Query("pId") String pId, @Query("receiptNo") String receiptNo);

    //환자정보 조회
    @GET("?domain=hit&submit_id=TRZIF00002&business_id=com&hospitalCd=031")
    Call<GetUserInfo> getUserInfo(@Query("pId") String pId);

    //환자번호 찾기
    @GET("?domain=hit&submit_id=TRZIF00002&business_id=com&hospitalCd=031")
    Call<FindPid> findPid(@Query("pNm") String pNm, @Query("cellphoneNo") String cellphoneNo);

    //차량번호 수정
    @POST("?domain=hit&submit_id=TXZIF00010&business_id=com&hospitalCd=031")
    Call<UpdateVehicleNo> updateVehicleNo(@Query("pId") String pId, @Query("vehicleNo") String vehicleNo);

    //환자 전화번호 수정
    @POST("?domain=hit&submit_id=TXZIF00008&business_id=com&hospitalCd=031")
    Call<UpdateTelNo> updateTelNo(@Query("pId") String pId, @Query("cellphoneNo") String cellphoneNo);

    //환자 주소 수정
    @POST("?domain=hit&submit_id=TXZIF00009&business_id=com&hospitalCd=031")
    Call<UpdateAddress> updateAddress(@Query("pId") String pId, @Query("zipCode") String zipCode, @Query("zipCodeTxt") String zipCodeTxt, @Query("address") String address);
}
