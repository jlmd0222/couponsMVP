package jlmd.dev.android.offerscouponsmvp.view

import jlmd.dev.android.offerscouponsmvp.model.Coupon

interface CouponView {
    //Va al Presenter
    fun getCoupons()
    //Va a la View
    fun showCoupons(coupons: ArrayList<Coupon>?)

}