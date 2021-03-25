package com.example.viewpager2.base

import android.os.Bundle
import android.renderscript.Script
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

abstract class BindingFragment<T : ViewDataBinding>(@LayoutRes private val layoutResID: Int) :
    Fragment() {
        protected lateinit var binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResID, container,false)
        return binding.root
    }

    protected inner class LifecycleEventLogger (private val className : String): LifecycleObserver{
        fun registerLogger(lifecycle: Lifecycle){
            lifecycle.addObserver(this)
        }

        fun log(){
            Log.d("${className}LifeCycleEvent", "${lifecycle.currentState}")
        }
    }
}