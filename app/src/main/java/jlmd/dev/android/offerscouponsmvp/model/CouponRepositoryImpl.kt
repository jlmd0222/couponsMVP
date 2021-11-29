package jlmd.dev.android.offerscouponsmvp.model

import android.util.Log
import android.widget.Toast
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import jlmd.dev.android.offerscouponsmvp.presenter.CouponPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    //TODA LA LOGICA DE CONEXION
    override fun getCouponsAPI() {
        //CONTROLLER
        var coupons: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()
        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
                //Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                couponPresenter.showCoupons(coupons)
            }
        })
        //CONTROLLER
    }
}