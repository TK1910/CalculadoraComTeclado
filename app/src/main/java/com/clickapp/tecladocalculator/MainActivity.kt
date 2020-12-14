package com.clickapp.tecladocalculator

import android.content.Context
import android.inputmethodservice.KeyboardView
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.text.trimmedLength
import com.clickapp.tecladocalculator.R.id.*
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.nio.file.WatchEvent

class MainActivity : AppCompatActivity() {
    //EDITEXT
    private var exibeNum: EditText? = null
    private var exibeNum2: EditText? = null
    //TEXTVIEW
    private var exibeOperador: TextView? = null
    private var exibeResultado: TextView? = null
    //BUTTON OPERACOES
    private var igualBotao: Button? = null
    private var limpaBotao: Button? = null
    private var somarBtn: Button? = null
    private var subBtn: Button? = null
    private var multBtn: Button? = null
    private var divBtn: Button? = null
    //BUTTON TECLADO
    private var btnDot: Button? = null
    private var btn0: Button? = null
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private var btn9: Button? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LISTA ULTIMOS RESULTADOS
        val listView  = findViewById<ListView>(R.id.ListViewResults)

        listView.adapter = MyCustomAdapter(this)
        //CAIXAS DE EXIBICAO
        exibeNum = findViewById(mostraNum) as EditText
        exibeNum!!.showSoftInputOnFocus = false
        exibeNum2 = findViewById(mostraNum2) as EditText
        exibeNum2!!.showSoftInputOnFocus = false
        exibeOperador = findViewById(mostraOperador) as TextView
        exibeResultado = findViewById(mostraResult) as TextView
        //TECLAS OPERACOES
        igualBotao = findViewById(botaoIgual) as Button
        limpaBotao = findViewById(buttonClear) as Button
        somarBtn = findViewById(botaoSoma) as Button
        subBtn = findViewById(botaoSubtra) as Button
        multBtn = findViewById(botaoMultipli) as Button
        divBtn = findViewById(botaoDivisao) as Button
        //VALOR TECLAS 0-9 - DOT
        btnDot = findViewById(botaoPonto)
        btn0 = findViewById(botao0)
        btn1 = findViewById(botao1)
        btn2 = findViewById(botao2)
        btn3 = findViewById(botao3)
        btn4 = findViewById(botao4)
        btn5 = findViewById(botao5)
        btn6 = findViewById(botao6)
        btn7 = findViewById(botao7)
        btn8 = findViewById(botao8)
        btn9 = findViewById(botao9)
        //TECLAS 0-9 LISTENERS - DOT
        btnDot?.setOnClickListener(){
        val valorBotao = "."
            if (exibeNum?.text.toString().length >=0 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else if (exibeOperador?.text.toString() != ""){
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn0?.setOnClickListener() {
            val valorBotao = 0.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
                }
            }
        btn1?.setOnClickListener() {
            val valorBotao = 1.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn2?.setOnClickListener() {
            val valorBotao = 2.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn3?.setOnClickListener() {
            val valorBotao = 3.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == ""){
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn4?.setOnClickListener() {
            val valorBotao = 4.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn5?.setOnClickListener() {
            val valorBotao = 5.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn6?.setOnClickListener() {
            val valorBotao = 6.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn7?.setOnClickListener() {
            val valorBotao = 7.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn8?.setOnClickListener() {
            val valorBotao = 8.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        btn9?.setOnClickListener() {
            val valorBotao = 9.toString()
            if (exibeNum?.text.toString() == "" && exibeOperador?.text.toString() == "" || exibeNum?.text.toString().length<10 && exibeOperador?.text.toString() == "") {
                exibeNum?.append(valorBotao).toString()
            }else{
                exibeNum2?.append(valorBotao).toString()
            }
        }
        //TECLA EQUAL - RESULTADO
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
                        exibeResultado?.text =
                            input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
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
    private fun cleanCheckVazio() {
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
    //INSERE SINAL DE ERROR
    private fun checkVazio(): Boolean {
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
    //GERENCIA LISTVIEW RESULTADOS
    private class MyCustomAdapter(context: Context): BaseAdapter(){
        private val mContext: Context
        private val lastResults = arrayListOf<String>(
              "1", "2", "3", "4", "5"
        )

        init{
            mContext = context
        }
        override fun getCount(): Int {
            return lastResults.size
        }
        override fun getItem(position: Int): Any {
            return "Test String"
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater =  LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val positionTextView = rowMain.findViewById<TextView>(position_textview)
            positionTextView.text = "$position"
            return rowMain
        }
    }

}
