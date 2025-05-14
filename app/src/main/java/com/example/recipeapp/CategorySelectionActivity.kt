package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.adapter.CategoryAdapter
import com.example.recipeapp.model.Category

class CategorySelectionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)

        setupRecyclerView()
        loadCategories()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.categoriesRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = CategoryAdapter { category ->
            when (category.id) {
                1 -> startActivity(Intent(this, MainDishActivity::class.java))
                2 -> startActivity(Intent(this, SoupActivity::class.java))
                3 -> startActivity(Intent(this, DessertActivity::class.java))
                4 -> startActivity(Intent(this, SaladActivity::class.java))
                5 -> startActivity(Intent(this, DrinkActivity::class.java))
                6 -> startActivity(Intent(this, BreakfastActivity::class.java))
                7 -> startActivity(Intent(this, SnacksActivity::class.java))
                else -> Toast.makeText(this, "${category.name} sayfası bulunamadı", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView.adapter = adapter
    }

    private fun loadCategories() {
        val categories = listOf(
            Category(
                1,
                "Ana Yemekler",
                R.drawable.dinner
            ),
            Category(
                2,
                "Çorbalar",
                R.drawable.soup
            ),
            Category(
                3,
                "Tatlılar",
                R.drawable.dessert
            ),
            Category(
                4,
                "Salatalar",
                R.drawable.salad
            ),
            Category(
                5,
                "İçecekler",
                R.drawable.drinkss
            ),
            Category(
                6,
                "Kahvaltılıklar",
                R.drawable.secmeli_kahvalti
            ),
            Category(
                7,
                "Atıştırmalıklar",
                R.drawable.snackss
            )
        )
        adapter.submitList(categories)
    }
} 