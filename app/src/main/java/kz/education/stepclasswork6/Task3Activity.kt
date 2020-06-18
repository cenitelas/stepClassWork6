package kz.education.stepclasswork6

import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class Task3Activity : AppCompatActivity() {

    var questions = initializeQuestions();
    var totalResult:Int = 0;
    var textViewQuest:TextView? = null;
    var buttonAnswer1:Button? = null;
    var buttonAnswer2:Button? = null;
    var buttonAnswer3:Button? = null;
    var buttonAnswer4:Button? = null;
    var textViewResult:TextView? = null;
    var totalQuest:QuestionUseCase? = null;

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)
        initializeViews();
        initiateQuest()
        initializeListeners();
    }

    fun initializeQuestions():ArrayList<QuestionUseCase>{
        var questions = ArrayList<QuestionUseCase>()
        questions.add(QuestionUseCase("Какое растение существует на самом деле?", arrayListOf("Лох чилийский","Лох индийский","Лох греческий","Лох русский"),"Лох индийский"))
        questions.add(QuestionUseCase("Что за место, попав в которое, человек делает селфи на кухне, которую не может себе позволить?", arrayListOf("Рим","Париж","Лондон","Икея"),"Икея"))
        questions.add(QuestionUseCase("Какой город объявлен официальной родиной русского Деда Мороза?", arrayListOf("Малая Вишера","Великий Устюг","Вышний Волочек","Нижний Новгород"),"Великий Устюг"))
        questions.add(QuestionUseCase("Что проводит боксер, наносящий удар противнику снизу?", arrayListOf("Свинг","Хук","Апперкот","Джэб"),"Апперкот"))
        questions.add(QuestionUseCase("К кому первому обратились за помощью дед и бабка, не справившись с репкой?", arrayListOf("К Жучке","К дочке","К внучке","К залу"),"К внучке"))
        return  questions;
    }

    fun initializeViews(){
        textViewQuest = findViewById(R.id.activity_task3_text_view_quest)
        buttonAnswer1 = findViewById(R.id.activity_task3_button_answer1)
        buttonAnswer2 = findViewById(R.id.activity_task3_button_answer2)
        buttonAnswer3 = findViewById(R.id.activity_task3_button_answer3)
        buttonAnswer4 = findViewById(R.id.activity_task3_button_answer4)
        textViewResult = findViewById(R.id.activity_task3_text_view_result)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initiateQuest(){
        buttonAnswer1?.setBackgroundColor(getColor(R.color.grey))
        buttonAnswer2?.setBackgroundColor(getColor(R.color.grey))
        buttonAnswer3?.setBackgroundColor(getColor(R.color.grey))
        buttonAnswer4?.setBackgroundColor(getColor(R.color.grey))
        if(questions.count()>0){
            var quest = questions.first();
            textViewQuest!!.setText(quest.quest)
            buttonAnswer1!!.setText(quest.answers[0])
            buttonAnswer2!!.setText(quest.answers[1])
            buttonAnswer3!!.setText(quest.answers[2])
            buttonAnswer4!!.setText(quest.answers[3])
            totalQuest=quest;
        }else{
            textViewQuest!!.visibility = View.INVISIBLE
            buttonAnswer1!!.visibility = View.INVISIBLE
            buttonAnswer2!!.visibility = View.INVISIBLE
            buttonAnswer3!!.visibility = View.INVISIBLE
            buttonAnswer4!!.visibility = View.INVISIBLE
            textViewResult?.setText("Количество правильных ответов = $totalResult")
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners(){
        buttonAnswer1?.setOnClickListener(View.OnClickListener {
            if(buttonAnswer1?.text.toString()==totalQuest?.result){
                buttonAnswer1?.setBackgroundColor(getColor(R.color.green))
                totalResult+=1;
            }else{
                buttonAnswer1?.setBackgroundColor(getColor(R.color.red))
                if(buttonAnswer2?.text.toString()==totalQuest?.result)buttonAnswer2?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer3?.text.toString()==totalQuest?.result)buttonAnswer3?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer4?.text.toString()==totalQuest?.result)buttonAnswer4?.setBackgroundColor(getColor(R.color.green))
            }
            Handler().postDelayed({
                questions.remove(totalQuest)
                initiateQuest()
            }, 2000)
        })

        buttonAnswer2?.setOnClickListener(View.OnClickListener {
            if(buttonAnswer2?.text.toString()==totalQuest?.result){
                buttonAnswer2?.setBackgroundColor(getColor(R.color.green))
                totalResult+=1;
            }else{
                buttonAnswer2?.setBackgroundColor(getColor(R.color.red))
                if(buttonAnswer1?.text.toString()==totalQuest?.result)buttonAnswer1?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer3?.text.toString()==totalQuest?.result)buttonAnswer3?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer4?.text.toString()==totalQuest?.result)buttonAnswer4?.setBackgroundColor(getColor(R.color.green))
            }
            Handler().postDelayed({
                questions.remove(totalQuest)
                initiateQuest()
            }, 2000)
        })

        buttonAnswer3?.setOnClickListener(View.OnClickListener {
            if(buttonAnswer3?.text.toString()==totalQuest?.result){
                buttonAnswer3?.setBackgroundColor(getColor(R.color.green))
                totalResult+=1;
            }else{
                buttonAnswer3?.setBackgroundColor(getColor(R.color.red))
                if(buttonAnswer1?.text.toString()==totalQuest?.result)buttonAnswer1?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer2?.text.toString()==totalQuest?.result)buttonAnswer2?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer4?.text.toString()==totalQuest?.result)buttonAnswer4?.setBackgroundColor(getColor(R.color.green))
            }
            Handler().postDelayed({
                questions.remove(totalQuest)
                initiateQuest()
            }, 2000)
        })

        buttonAnswer4?.setOnClickListener(View.OnClickListener {
            if(buttonAnswer4?.text.toString()==totalQuest?.result){
                buttonAnswer4?.setBackgroundColor(getColor(R.color.green))
                totalResult+=1;
            }else{
                buttonAnswer4?.setBackgroundColor(getColor(R.color.red))
                if(buttonAnswer1?.text.toString()==totalQuest?.result)buttonAnswer1?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer3?.text.toString()==totalQuest?.result)buttonAnswer3?.setBackgroundColor(getColor(R.color.green))
                if(buttonAnswer2?.text.toString()==totalQuest?.result)buttonAnswer2?.setBackgroundColor(getColor(R.color.green))
            }
            Handler().postDelayed({
                questions.remove(totalQuest)
                initiateQuest()
            }, 2000)
        })
    }
}