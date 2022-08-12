package br.senai.sp.jandira.imcoficial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    // Criação das variaáveis a serem utilizadas no cálculo
    var weight = 0
    var height = 0.0
    var bmi = 0.0

    // Declaração das views da Activity
    lateinit var buttonCalculate: Button
    lateinit var editWeight: EditText
    lateinit var editHeight: EditText
    lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retirada da 'action bar' (faixa superior)
        supportActionBar!!.hide()

        // Inctância das views
        buttonCalculate = findViewById(R.id.button_caculate)
        editWeight = findViewById(R.id.edit_weight)
        editHeight = findViewById(R.id.edit_height)
        textResult = findViewById(R.id.text_ValueResult)

        // Detectar o click no botão
        buttonCalculate.setOnClickListener {

            if (inputValidate()) {
                bmiCalculate()
            }

        }
    }

    private fun inputValidate(): Boolean {

        if (editWeight.text.isEmpty() && editHeight.text.isEmpty()) {
            editWeight.error = "Weight is required!"
            editHeight.error = "Height is required!"

            return false
        } else if (editWeight.text.isEmpty()) {
            editWeight.error = "Weight is required!"

            return false
        } else if (editHeight.text.isEmpty()) {
            editHeight.error = "Height is required!"

            return false
        }

        return true
    }

    private fun bmiCalculate() {

        // Cálculo do IMC
        // Recuperação dos valores digitados
        weight = editWeight.text.toString().toInt()
        height = editHeight.text.toString().toDouble()

        // Cálculo
        bmi = weight / height.pow(2)

        // textResult.text = bmi.toString()
        textResult.text = String.format("%.2f", bmi)
    }
}