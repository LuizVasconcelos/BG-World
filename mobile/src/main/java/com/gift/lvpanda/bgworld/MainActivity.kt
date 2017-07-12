package com.gift.lvpanda.bgworld

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_navigation_drawer.*

class MainActivity : AppCompatActivity() {

    val mDrawerToggle by lazy { android.support.v7.app.ActionBarDrawerToggle(this,navigationDrawer, 0,0) }
    var isFABOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setHomeButtonEnabled(true)

        val mainFABOpenAnimation = AnimationUtils.loadAnimation(this.applicationContext,R.anim.rotate_foward)
        val mainFABCloseAnimation = AnimationUtils.loadAnimation(this.applicationContext,R.anim.rotate_backward)

        this.mainScreenFAB.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if(!isFABOpened) {
                    mainScreenFAB.startAnimation(mainFABOpenAnimation)
                    isFABOpened = true
                }else {
                    mainScreenFAB.startAnimation(mainFABCloseAnimation)
                    isFABOpened = false
                }
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (mDrawerToggle.onOptionsItemSelected(item)) return true

        return super.onOptionsItemSelected(item)
    }

}