package com.gutsenko.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(text)
            dataTextView.text = "result = ${saveUserNameUseCase.execute(params)}"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}