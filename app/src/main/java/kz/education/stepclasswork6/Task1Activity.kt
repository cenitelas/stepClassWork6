package kz.education.stepclasswork6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Task1Activity : AppCompatActivity() {

    var buttonTask1SecondActivity: Button? = null;
    var textViewTask1ActivitySend: EditText? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        initializeViews()
        initializeListeners()
    }


    fun initializeViews(){
        buttonTask1SecondActivity = findViewById(R.id.activity_task1_button_task1_second_activity)
        textViewTask1ActivitySend =findViewById(R.id.activity_task1_button_task1_edit_text_send)
    }

    fun initializeListeners(){
        buttonTask1SecondActivity?.setOnClickListener(View.OnClickListener {
            if(textViewTask1ActivitySend!!.text.isNotEmpty()) {
                val intent = Intent(this, Task1SecondActivity::class.java).apply {
                    putExtra("DATA", textViewTask1ActivitySend!!.text.toString())
                }
                startActivity(intent)
            }
        })
    }

}