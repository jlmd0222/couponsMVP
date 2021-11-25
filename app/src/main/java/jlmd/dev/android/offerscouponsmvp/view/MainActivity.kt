package jlmd.dev.android.offerscouponsmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jlmd.dev.android.offerscouponsmvp.R
import jlmd.dev.android.offerscouponsmvp.model.Coupon
import jlmd.dev.android.offerscouponsmvp.presenter.CouponPresenter
import jlmd.dev.android.offerscouponsmvp.presenter.CouponPresenterImp

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImp(this)

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = CouponAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}