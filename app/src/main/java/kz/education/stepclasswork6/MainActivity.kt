package kz.education.stepclasswork6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var buttonTask1Activity: Button? = null;
    var buttonTask2Activity: Button? = null;
    var buttonTask3Activity: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews();
        initializeListeners();
    }

    fun initializeViews(){
        buttonTask1Activity = findViewById(R.id.activity_main_button_task1)
        buttonTask2Activity = findViewById(R.id.activity_main_button_task2)
        buttonTask3Activity = findViewById(R.id.activity_main_button_task3)
    }

    fun initializeListeners(){
        buttonTask1Activity?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Task1Activity::class.java)
            startActivity(intent)
        })

        buttonTask2Activity?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Task2Activity::class.java)
            startActivity(intent)
        })

        buttonTask3Activity?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Task3Activity::class.java)
            startActivity(intent)
        })
    }


}