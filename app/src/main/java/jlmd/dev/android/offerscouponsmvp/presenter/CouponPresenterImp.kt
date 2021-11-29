package jlmd.dev.android.offerscouponsmvp.presenter

import jlmd.dev.android.offerscouponsmvp.model.Coupon
import jlmd.dev.android.offerscouponsmvp.model.CouponInteractor
import jlmd.dev.android.offerscouponsmvp.model.CouponInteractorImpl
import jlmd.dev.android.offerscouponsmvp.view.CouponView

class CouponPresenterImp(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponInteractor = CouponInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}