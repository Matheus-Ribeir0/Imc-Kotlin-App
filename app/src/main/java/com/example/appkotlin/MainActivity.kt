package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            var calculoImc = calculoImc(it_peso.text.toString().toDouble(), it_altura.text.toString().toDouble())
            tv_result.text=res(calculoImc)
        }
    }

    private fun calculoImc(peso : Double, altura: Double): Double {
        return peso / altura.pow(2.0)
    }

    fun res(x : Double): String {
       when (x) {
            in 0.0..18.5 -> return "Abaixo do peso"
            in 18.5..25.0 -> return "com peso normal"
            in 25.0..30.0 -> return "com peso normal"
            in 30.0..35.0 -> return "Obesidade grau I"
            in 35.0..40.0 -> return "Obesidade grau II"
            in 40.0..80.5 -> return "Obesidade grau III"

            else -> return "Digite um número válido"
        }
    }
}
