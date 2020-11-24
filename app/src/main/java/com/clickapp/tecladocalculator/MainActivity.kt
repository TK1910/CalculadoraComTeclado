package com.clickapp.tecladocalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.clickapp.tecladocalculator.R.id.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    //EDITEXT
    var exibeNum: EditText? = null
    var exibeNum2: EditText? = null
    //TEXTVIEW
    var exibeOperador: TextView? = null
    var exibeResultado: TextView? = null
    //BUTTON OPERACOES
    var limpaBotao: Button? = null
    var somarBtn: Button? = null
    var subBtn: Button? = null
    var multBtn: Button? = null
    var divBtn: Button? = null
    //BUTTON TECLADO
    var botao_0: Button? = null
    var botao_1: Button? = null
    var botao_2: Button? = null
    var botao_3: Button? = null
    var botao_4: Button? = null
    var botao_5: Button? = null
    var botao_6: Button? = null
    var botao_7: Button? = null
    var botao_8: Button? = null
    var botao_9: Button? = null
    //SWITCH BUTTON
    var switch: Switch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EXIBE NUMEROS
        exibeNum = findViewById(mostraNum) as EditText
        exibeNum2 = findViewById(mostraNum2) as EditText
        exibeOperador = findViewById(R.id.mostraOperador) as TextView
        exibeResultado = findViewById(R.id.mostraResult) as TextView
        //TECLAS OPERACOES
        limpaBotao = findViewById(R.id.buttonClear) as Button
        somarBtn = findViewById(R.id.botaoSoma) as Button
        subBtn = findViewById(R.id.botaoSubtra) as Button
        multBtn = findViewById(R.id.botaoMultipli) as Button
        divBtn = findViewById(R.id.botaoDivisao) as Button
        //VALOR TECLAS 0-9
        botao_0 = findViewById(R.id.botao0)
        botao_1 = findViewById(R.id.botao1)
        botao_2 = findViewById(R.id.botao2)
        botao_3 = findViewById(R.id.botao3)
        botao_4 = findViewById(R.id.botao4)
        botao_5 = findViewById(R.id.botao5)
        botao_6 = findViewById(R.id.botao6)
        botao_7 = findViewById(R.id.botao7)
        botao_8 = findViewById(R.id.botao8)
        botao_9 = findViewById(R.id.botao9)

        //TECLAS 0-9 LISTENERS
        botao_0?.setOnClickListener() {
            val valorBotao = 0.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_1?.setOnClickListener() {
            val valorBotao = 1.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_2?.setOnClickListener() {
            val valorBotao = 2.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_3?.setOnClickListener() {
            val valorBotao = 3.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_4?.setOnClickListener() {
            val valorBotao = 4.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_5?.setOnClickListener() {
            val valorBotao = 5.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_6?.setOnClickListener() {
            val valorBotao = 6.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_7?.setOnClickListener() {
            val valorBotao = 7.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_8?.setOnClickListener() {
            val valorBotao = 8.toString()
                exibeNum?.setText(valorBotao).toString()
        }
        botao_9?.setOnClickListener() {
            val valorBotao = 9.toString()
                exibeNum?.setText(valorBotao).toString()
        }

        //TECLA SOMA
        somarBtn?.setOnClickListener() {
            val valorBotao = "+"
            exibeOperador?.setText(valorBotao).toString()
            if (checkVazio()) {
                val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                exibeResultado?.text = input1.add(input2).toString()
            }
        }
        //TECLA SUBTRACAO
        subBtn?.setOnClickListener() {
            val valorBotao = "-"
            exibeOperador?.setText(valorBotao).toString()
            if (checkVazio()) {
                val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                exibeResultado?.text = input1.subtract(input2).toString()
            }
        }
        //TECLA MULTIPLICACAO
        multBtn?.setOnClickListener() {
            val valorBotao = "*"
            exibeOperador?.setText(valorBotao).toString()
            if (checkVazio()) {
                val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                exibeResultado?.text = input1.multiply(input2).toString()
            }
        }
        //TECLA DIVISAO
        divBtn?.setOnClickListener() {
            val valorBotao = "/"
            exibeOperador?.setText(valorBotao).toString()
            if (checkVazio()) {
                val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                if (input2.compareTo(BigDecimal.ZERO) == 0) {
                    exibeNum2?.error = "Invalid input"
                } else {
                    exibeResultado?.text = input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
                }
            }
        }

        //CLIQUE TECLADO

        //BOTAO VAZIO CHECK

        //BOTAO CE
        limpaBotao?.setOnClickListener() {
            exibeNum?.setText("").toString()
            exibeNum2?.setText("").toString()
            exibeResultado?.setText("").toString()
            exibeOperador?.setText("").toString()
        }


    }

    fun checkVazio(): Boolean {
            var b = true
            if (exibeNum?.text.toString().trim().isEmpty()) {
                exibeNum?.error = "Required"
                b = false
            }
            if (exibeNum2?.text.toString().trim().isEmpty()) {
                exibeNum2?.error = "Required"
                b = false
            }
            return b

        }
    }

    //OPERACAO SOMA

    //OPERACAO SUBTRACAO

    //OPERACAO DIVISAO

    //OPERACAO MULTIPLICACAO
