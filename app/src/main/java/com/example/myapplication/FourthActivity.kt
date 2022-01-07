package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.*
import android.util.Log.*
import com.google.android.material.switchmaterial.SwitchMaterial

class FourthActivity : Activity() {


    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvUserData: TextView
    private lateinit var buttonSave: Button
    private lateinit var switchPassword: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        setUpUi()
        setUpClickListener()
    }

    /**
     * This will find the views
     **/
    private fun setUpUi() {
        etName = findViewById<EditText>(R.id.etName)
        etPhone = findViewById<EditText>(R.id.etPhone)
        etAddress = findViewById<EditText>(R.id.etAddress)
        etPassword = findViewById<EditText>(R.id.etPassword)
        tvUserData = findViewById<TextView>(R.id.textViewUserData)
        buttonSave = findViewById<Button>(R.id.buttonSave)
        switchPassword = findViewById<SwitchMaterial>(R.id.switchPassword)
    }


    /**
     * Set up click Handler
     * */
    private fun setUpClickListener() {
        buttonSave.setOnClickListener { it: View ->
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            val address = etAddress.text.toString()
            val password = etPassword.text.toString()

            val data = name + " " + phone + " " + address + " " + password
            tvUserData.text = data
            Toast.makeText(this@FourthActivity, data, Toast.LENGTH_LONG).show()
        }

        switchPassword.setOnCheckedChangeListener { compoundButton, isChecked ->

            if (isChecked) {
                etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPassword.setSelection(etPassword.text.length)

            /* if(isChecked){
                   etPassword.visibility=View.VISIBLE
               }else{
                   etPassword.visibility=View.GONE
               }*/
        }

    }
}