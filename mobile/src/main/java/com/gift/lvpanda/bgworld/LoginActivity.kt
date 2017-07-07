package com.gift.lvpanda.bgworld

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import com.facebook.FacebookSdk
//import com.facebook.appevents.AppEventsLogger
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.ludopediaLogin.setOnClickListener {
            val intent = Intent(this,MainActivity :: class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}
