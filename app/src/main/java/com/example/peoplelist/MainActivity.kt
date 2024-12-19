package com.example.peoplelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val people = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvPeople = findViewById<ListView>(R.id.people)

        val firstNames = resources.getStringArray(R.array.first_names)
        val lastNames = resources.getStringArray(R.array.last_names)

        val random = Random

        for (i in 0 until 3) {
            val firstName = firstNames[random.nextInt(firstNames.size)]
            val lastName = lastNames[random.nextInt(lastNames.size)]
            people.add("$firstName $lastName")
        }

        val adapter = ArrayAdapter<String>(this, R.layout.item, people)
        lvPeople.adapter = adapter
    }

    fun onAddPersonClick(view: View) {
        val editText = findViewById<EditText>(R.id.editTextPerson)
        val newPerson = editText.text.toString()

        if (newPerson.isNotEmpty()) {
            people.add(newPerson)
            val lvPeople = findViewById<ListView>(R.id.people)
            (lvPeople.adapter as ArrayAdapter<String>).notifyDataSetChanged()
            editText.text.clear()
        }
    }
}