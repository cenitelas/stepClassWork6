package kz.education.stepclasswork6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Task1SecondActivity : AppCompatActivity() {

    var textViewResult: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1_secoand)
        val message = intent.getStringExtra("DATA")
        if (message != null) {
            initializeViews(message)
        }

    }

    fun initializeViews(message: String){
        textViewResult = findViewById(R.id.activity_task1_second_text_view_result)
        if (textViewResult != null) textViewResult!!.setText(message) else "";
    }

}