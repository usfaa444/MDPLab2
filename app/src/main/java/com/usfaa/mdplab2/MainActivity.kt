package com.usfaa.mdplab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var lblDish: TextView
    private lateinit var txtAddFood: EditText
    private lateinit var btnAddFood: Button
    private lateinit var btnDecide: Button

    private val foods = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lblDish = findViewById(R.id.lbl_dish)
        txtAddFood = findViewById(R.id.txt_add_food)
        btnAddFood = findViewById(R.id.btn_add_food)
        btnDecide = findViewById(R.id.btn_decide)

        btnDecide.setOnClickListener {
            lblDish.text = getRandomFood()
        }

        btnAddFood.setOnClickListener {
            if (txtAddFood.text.toString().isNotEmpty()) {
                val food = txtAddFood.text.toString()
                if (!foods.contains(food)) {
                    foods.add(food)
                }
                lblDish.text = food
            } else {
                txtAddFood.error = getString(R.string.enter_food_error)
            }
        }
    }

    private fun getRandomFood(): String {
        val randomIndex = Random.nextInt(0, foods.size-1)
        return foods[randomIndex]
    }
}