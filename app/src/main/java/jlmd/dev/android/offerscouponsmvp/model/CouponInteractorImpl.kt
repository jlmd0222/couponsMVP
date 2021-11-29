package jlmd.dev.android.offerscouponsmvp.model

import jlmd.dev.android.offerscouponsmvp.presenter.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter): CouponInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }

    override fun getCouponsDB() {
        TODO("Not yet implemented")
    }
}