package jlmd.dev.android.offerscouponsmvp.presenter

import jlmd.dev.android.offerscouponsmvp.model.Coupon

interface CouponPresenter {
    //Va a la View
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Va al Interactor
    fun getCoupons()
}