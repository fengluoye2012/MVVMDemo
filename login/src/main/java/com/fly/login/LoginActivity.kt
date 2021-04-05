package com.fly.login

import android.view.View
import androidx.lifecycle.Observer
import com.fly.compontservice.http.base.BaseVMActivity
import com.fly.compontservice.http.model.LoginModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseVMActivity<LoginViewModel, LoginModel>(), View.OnClickListener {
    override fun getLayoutResID(): Int {
        return R.layout.activity_login
    }

    override fun providerVMClass(): Class<LoginViewModel>? {
        return LoginViewModel::class.java
    }

    override fun intView() {

    }

    override fun intDat() {
        tv_login.setOnClickListener(this)

        viewModel.getLogin().observe(this, Observer {
            if (it.code == 0) {


            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_login -> {
                viewModel.loginData("", "")
            }
        }
    }
}
