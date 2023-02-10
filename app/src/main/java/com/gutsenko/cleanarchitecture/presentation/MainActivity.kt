package com.gutsenko.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.gutsenko.cleanarchitecture.R
import com.gutsenko.cleanarchitecture.data.repository.UserRepositoryImpl
import com.gutsenko.cleanarchitecture.data.storage.sharedPrefs.SharedPrefsUserStorage
import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        com.gutsenko.cleanarchitecture.data.repository.UserRepositoryImpl(
            userStorage = com.gutsenko.cleanarchitecture.data.storage.sharedPrefs.SharedPrefsUserStorage(
                applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam(text)
            dataTextView.text = "result = ${saveUserNameUseCase.execute(params)}"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}