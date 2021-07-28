package com.hfad.android.telegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.hfad.android.telegram.databinding.ActivityMainBinding
import com.hfad.android.telegram.ui.fragments.ChatsFragment
import com.hfad.android.telegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar) //Этот метод назначает Toolbar выполнять функции ActonBar(добавляет функциональность)
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsFragment())
            .commit()
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this,mToolbar)


    }
}