package com.gift.lvpanda.bgworld

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_navigation_drawer.*

class MainActivity : AppCompatActivity() {

    val mDrawerToggle by lazy { android.support.v7.app.ActionBarDrawerToggle(this,navigationDrawer, 0,0) }
    var isFABOpened = false

    lateinit var openTranslatorFABStore: TranslateAnimation
    lateinit var openTranslatorFABAunctions: TranslateAnimation
    lateinit var closeTranslatorFABStore: TranslateAnimation
    lateinit var closeTranslatorFABAunctions: TranslateAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setHomeButtonEnabled(true)

        val mainFABOpenAnimation = AnimationUtils.loadAnimation(this.applicationContext,R.anim.rotate_foward)
        val mainFABCloseAnimation = AnimationUtils.loadAnimation(this.applicationContext,R.anim.rotate_backward)

        this.prepareFABsTranslateAnimation()

        this.mainScreenFAB.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                if(!isFABOpened) {
                    mainScreenFAB.startAnimation(mainFABOpenAnimation)
                    storesListFAB.startAnimation(mainFABOpenAnimation)
                    storesListFAB.startAnimation(openTranslatorFABStore)
                    auctionsListFAB.startAnimation(mainFABOpenAnimation)
                    auctionsListFAB.startAnimation(openTranslatorFABAunctions)
                    isFABOpened = true
                }else {
                    mainScreenFAB.startAnimation(mainFABCloseAnimation)
                    storesListFAB.startAnimation(mainFABOpenAnimation)
                    storesListFAB.startAnimation(closeTranslatorFABStore)
                    auctionsListFAB.startAnimation(mainFABOpenAnimation)
                    auctionsListFAB.startAnimation(closeTranslatorFABAunctions)
                    isFABOpened = false
                }
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (mDrawerToggle.onOptionsItemSelected(item)) return true

        return super.onOptionsItemSelected(item)
    }

    fun prepareFABsTranslateAnimation() {
        var mainFABoriginalPos = IntArray(2)
        this.mainScreenFAB.getLocationOnScreen(mainFABoriginalPos)

        openTranslatorFABStore = TranslateAnimation(mainFABoriginalPos[0].toFloat(), (mainFABoriginalPos[0].toFloat()-(250*0.258819).toFloat()),mainFABoriginalPos[1].toFloat(), mainFABoriginalPos[1].toFloat()-(250*0.965926).toFloat())
        openTranslatorFABAunctions = TranslateAnimation(mainFABoriginalPos[0].toFloat(), (mainFABoriginalPos[0].toFloat()-(250*0.965926).toFloat()),mainFABoriginalPos[1].toFloat(), mainFABoriginalPos[1].toFloat()-(250*0.258819).toFloat())
        openTranslatorFABStore.fillAfter = true
        openTranslatorFABAunctions.fillAfter = true
        openTranslatorFABStore.duration = 400
        openTranslatorFABAunctions.duration = 400

        closeTranslatorFABStore = TranslateAnimation((mainFABoriginalPos[0].toFloat()-(250*0.258819).toFloat()), mainFABoriginalPos[0].toFloat(),mainFABoriginalPos[1].toFloat()-(250*0.965926).toFloat(), mainFABoriginalPos[1].toFloat())
        closeTranslatorFABAunctions = TranslateAnimation((mainFABoriginalPos[0].toFloat()-(250*0.965926).toFloat()), mainFABoriginalPos[0].toFloat(), mainFABoriginalPos[1].toFloat()-(250*0.258819).toFloat(), mainFABoriginalPos[1].toFloat())
        closeTranslatorFABStore.fillAfter = true
        closeTranslatorFABAunctions.fillAfter = true
        closeTranslatorFABStore.duration = 400
        closeTranslatorFABAunctions.duration = 400
    }

}