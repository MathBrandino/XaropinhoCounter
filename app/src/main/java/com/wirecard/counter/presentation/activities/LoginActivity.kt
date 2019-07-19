package com.wirecard.counter.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.wirecard.counter.R
import com.wirecard.counter.vm.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        entrar.setOnClickListener {

            val email = loginValue.text.toString()
            val password = passwordValue.text.toString()

            userViewModel.login(email, password)

            loading()
        }


        userViewModel.logged().observe(this, Observer {
            toMain()
            finish()
        })

        userViewModel.error().observe(this, Observer {
            Toast.makeText(this, "Algo deu errado", Toast.LENGTH_LONG).show()
            normal()
        })
    }

    private fun loading() {
        entrar.isEnabled = false
        entrar.text = "Loading..."
    }

    private fun normal() {
        entrar.isEnabled = true
        entrar.text = "Entrar"
    }

    fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}