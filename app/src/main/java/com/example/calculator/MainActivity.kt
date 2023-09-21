package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        callBackMethodNumber()
        callBackMethodOpr()
    }

    private fun callBackMethodOpr() {
        binding.backspaceBtn.setOnClickListener {
            val length = binding.inputText.length()
            if (length > 0)
                binding.inputText.text = binding.inputText.text.subSequence(0,length-1)
        }
        binding.plus.setOnClickListener{
            binding.inputText.append("+")
        }
        binding.sub.setOnClickListener{
            binding.inputText.append("-")
        }
        binding.div.setOnClickListener{
            binding.inputText.append("/")
        }
        binding.multi.setOnClickListener{
            binding.inputText.append("*")
        }
        binding.mod.setOnClickListener{
            binding.inputText.append("%")
        }
        binding.result.setOnClickListener{
            showResult()
        }

    }

    private fun showResult() {
        try {
            val expression = binding.inputText.text.toString()
            val res = ExpressionBuilder(expression).build()
            val value = res.evaluate()

            binding.outputText.text = DecimalFormat("0.##").format(value).toString()

        }catch (e:Exception){
            binding.outputText.text = "Error"
        }
    }

    private fun callBackMethodNumber() {
        binding.oneBtn.setOnClickListener{
            binding.inputText.append("1")
        }

        binding.twoBtn.setOnClickListener{
            binding.inputText.append("2")
        }
        binding.threeBtn.setOnClickListener{
            binding.inputText.append("3")
        }
        binding.fourBtn.setOnClickListener{
            binding.inputText.append("4")
        }
        binding.fiveBtn.setOnClickListener{
            binding.inputText.append("5")
        }
        binding.sixBtn.setOnClickListener{
            binding.inputText.append("6")
        }
        binding.sevenBtn.setOnClickListener{
            binding.inputText.append("7")
        }
        binding.eightBtn.setOnClickListener{
            binding.inputText.append("8")
        }
        binding.nineBtn.setOnClickListener{
            binding.inputText.append("9")
        }

        binding.zeroBtn.setOnClickListener{
            binding.inputText.append("0")
        }

        binding.dotBtn.setOnClickListener{
            binding.inputText.append(".")
        }
    }

    private fun initViews() {
        binding.cBtn.setOnClickListener {
            binding.outputText.text = " "
            binding.inputText.text = " "
        }
    }
}