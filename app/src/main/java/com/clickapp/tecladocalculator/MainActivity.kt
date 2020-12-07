package com.clickapp.tecladocalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.*
import androidx.core.text.trimmedLength
import com.clickapp.tecladocalculator.R.id.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.nio.file.WatchEvent

class MainActivity : AppCompatActivity() {
    //EDITEXT
    var exibeNum: EditText? = null
    var exibeNum2: EditText? = null
    //TEXTVIEW
    var exibeOperador: TextView? = null
    var exibeResultado: TextView? = null
    //BUTTON OPERACOES
    var igualBotao: Button? = null
    var limpaBotao: Button? = null
    var somarBtn: Button? = null
    var subBtn: Button? = null
    var multBtn: Button? = null
    var divBtn: Button? = null
    //BUTTON TECLADO
    var botao_dot: Button? = null
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EXIBE NUMEROS
        exibeNum = findViewById(mostraNum) as EditText
        exibeNum2 = findViewById(mostraNum2) as EditText
        exibeOperador = findViewById(mostraOperador) as TextView
        exibeResultado = findViewById(mostraResult) as TextView
        //TECLAS OPERACOES
        igualBotao = findViewById(botaoIgual) as Button
        limpaBotao = findViewById(buttonClear) as Button
        somarBtn = findViewById(botaoSoma) as Button
        subBtn = findViewById(botaoSubtra) as Button
        multBtn = findViewById(botaoMultipli) as Button
        divBtn = findViewById(botaoDivisao) as Button
        //VALOR TECLAS 0-9 - dot
        botao_dot = findViewById(botaoPonto)
        botao_0 = findViewById(botao0)
        botao_1 = findViewById(botao1)
        botao_2 = findViewById(botao2)
        botao_3 = findViewById(botao3)
        botao_4 = findViewById(botao4)
        botao_5 = findViewById(botao5)
        botao_6 = findViewById(botao6)
        botao_7 = findViewById(botao7)
        botao_8 = findViewById(botao8)
        botao_9 = findViewById(botao9)
        //TECLAS 0-9 LISTENERS - DOT

        botao_dot?.setOnClickListener(){
        val valorBotao = "."
            if (exibeNum?.text.toString().length >=0 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else if (exibeOperador?.text.toString() != ""){
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_0?.setOnClickListener() {
            val valorBotao = 0.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
                }
            }
        botao_1?.setOnClickListener() {
            val valorBotao = 1.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_2?.setOnClickListener() {
            val valorBotao = 2.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_3?.setOnClickListener() {
            var valorBotao = 3.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == ""){
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_4?.setOnClickListener() {
            val valorBotao = 4.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_5?.setOnClickListener() {
            val valorBotao = 5.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_6?.setOnClickListener() {
            val valorBotao = 6.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_7?.setOnClickListener() {
            val valorBotao = 7.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_8?.setOnClickListener() {
            val valorBotao = 8.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        botao_9?.setOnClickListener() {
            val valorBotao = 9.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        igualBotao?.setOnClickListener(){
            if (checkVazio() && exibeOperador?.text.toString() == "+" ){
                    val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                    val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                    exibeResultado?.text = input1.add(input2).toString()
                }
            if(checkVazio() && exibeOperador?.text.toString() == "-"){
                    val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                    val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                    exibeResultado?.text = input1.subtract(input2).toString()
                }
            if(checkVazio() && exibeOperador?.text.toString() == "*"){
                    val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                    val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                    exibeResultado?.text = input1.multiply(input2).toString()
                }
            if(checkVazio() && exibeOperador?.text.toString() == "/"){
                    val input1 = exibeNum?.text.toString().trim().toBigDecimal()
                    val input2 = exibeNum2?.text.toString().trim().toBigDecimal()
                    if (input2.compareTo(BigDecimal.ZERO) == 0) {
                        exibeNum2?.error = "Invalid input"
                    } else {
                        exibeResultado?.text = input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
                  }
            }
        }
        //TECLA SOMA
        somarBtn?.setOnClickListener() {
            exibeResultado?.setText("").toString()
            val valorBotao = "+"
            exibeOperador?.setText(valorBotao).toString()
        }
        //TECLA SUBTRACAO
        subBtn?.setOnClickListener() {
            exibeResultado?.setText("").toString()
            val valorBotao = "-"
            exibeOperador?.setText(valorBotao).toString()
        }
        //TECLA MULTIPLICACAO
        multBtn?.setOnClickListener() {
            exibeResultado?.setText("").toString()
            val valorBotao = "*"
            exibeOperador?.setText(valorBotao).toString()
        }
        //TECLA DIVISAO
        divBtn?.setOnClickListener() {
            exibeResultado?.setText("").toString()
            val valorBotao = "/"
            exibeOperador?.setText(valorBotao).toString()
        }
        //BOTAO CE
        limpaBotao?.setOnClickListener() {
            cleanCheckVazio()
            exibeNum?.setText("").toString()
            exibeNum2?.setText("").toString()
            exibeResultado?.setText("").toString()
            exibeOperador?.setText("").toString()
        }
    }
    //RETIRA SINAL DE ERROR
    fun cleanCheckVazio() {
        if (exibeNum.toString() != "".orEmpty()){
            exibeNum?.error = null
        }
        if(exibeNum2.toString() != "".orEmpty()){
            exibeNum2?.error = null
        }
        if (exibeOperador.toString() != "".orEmpty()){
            exibeOperador?.error = null
        }
    }
    // INSERE SINAL DE ERROR
    fun checkVazio(): Boolean {
        var b = true
        if (exibeNum?.text.toString().trim().isEmpty()) {
            exibeNum?.error = ""
            b = false
        }
        if (exibeNum2?.text.toString().trim().isEmpty()) {
            exibeNum2?.error = ""
            b = false
        }
        if (exibeOperador?.text.toString().trim().isEmpty()) {
            exibeOperador?.error = ""
            b = false
        }
        return b
    }
}
