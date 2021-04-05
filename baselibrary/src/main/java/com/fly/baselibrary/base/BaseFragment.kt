package com.fly.baselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResID(), container, false)
    }

    abstract fun getLayoutResID(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        intView()
        intDat()
        super.onViewCreated(view, savedInstanceState)
    }


    abstract fun intView()
    abstract fun intDat()

}