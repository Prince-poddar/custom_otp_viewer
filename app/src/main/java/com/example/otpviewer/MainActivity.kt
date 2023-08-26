package com.example.otpviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.otpviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        otp1TextWatcher()
        otp2TextWatcher()
        otp3TextWatcher()
        otp4TextWatcher()
        otp5TextWatcher()
        otp6TextWatcher()

        //GenericTextWatcher here works only for moving to next EditText when a number is entered
//first parameter is the current EditText and second parameter is next EditText
        binding.et1.addTextChangedListener(GenericTextWatcher(binding.et1, binding.et2))
        binding.et2.addTextChangedListener(GenericTextWatcher(binding.et2, binding.et3))
        binding.et3.addTextChangedListener(GenericTextWatcher(binding.et3, binding.et4))
        binding.et4.addTextChangedListener(GenericTextWatcher(binding.et4, binding.et5))
        binding.et5.addTextChangedListener(GenericTextWatcher(binding.et5, binding.et6))
        binding.et6.addTextChangedListener(GenericTextWatcher(binding.et6, null))

//GenericKeyEvent here works for deleting the element and to switch back to previous EditText
//first parameter is the current EditText and second parameter is previous EditText
        binding.et1.setOnKeyListener(GenericKeyEvent(binding.et1, null))
        binding.et2.setOnKeyListener(GenericKeyEvent(binding.et2, binding.et1))
        binding.et3.setOnKeyListener(GenericKeyEvent(binding.et3, binding.et2))
        binding.et4.setOnKeyListener(GenericKeyEvent(binding.et4, binding.et3))
        binding.et5.setOnKeyListener(GenericKeyEvent(binding.et5, binding.et4))
        binding.et6.setOnKeyListener(GenericKeyEvent(binding.et6, binding.et5))

        binding.btnVerify.setOnClickListener {
            isValid()
        }
    }

    private fun otp1TextWatcher() {
        binding.et1.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et1.setText(it[0].toString())
                }
            }
        }
    }


    private fun otp2TextWatcher() {
        binding.et2.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et2.setText(it[0].toString())
                }
            }
        }
    }

    private fun otp3TextWatcher() {
        binding.et3.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et3.setText(it[0].toString())
                }
            }
        }
    }

    private fun otp4TextWatcher() {
        binding.et4.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et4.setText(it[0].toString())
                }
            }
        }
    }

    private fun otp5TextWatcher() {
        binding.et5.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et5.setText(it[0].toString())
                }
            }
        }
    }

    private fun otp6TextWatcher() {
        binding.et6.doAfterTextChanged {
            if (it!=null){
                if (it.toString().length>1){
                    binding.et6.setText(it[0].toString())
                }
            }
        }
    }
    private fun isValid():Boolean{
       if (
           binding.et1.text.trim().toString().isEmpty() ||
           binding.et2.text.trim().toString().isEmpty() ||
           binding.et3.text.trim().toString().isEmpty() ||
           binding.et4.text.trim().toString().isEmpty() ||
           binding.et5.text.trim().toString().isEmpty() ||
           binding.et6.text.trim().toString().isEmpty()
       ) {
           binding.et6.error="Enter Otp"
          return false
       }
       return true
    }
}
