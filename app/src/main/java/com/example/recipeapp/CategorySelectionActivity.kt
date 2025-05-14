package com.example.recipeapp

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
            Toast.makeText(this, "${category.name} seçildi", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }

    private fun loadCategories() {
        val categories = listOf(
            Category(1, "Ana Yemekler", R.drawable.main_dish),
            Category(2, "Çorbalar", R.drawable.soup),
            Category(3, "Tatlılar", R.drawable.dessert),
            Category(4, "Salatalar", R.drawable.salad),
            Category(5, "İçecekler", R.drawable.drinks),
            Category(6, "Kahvaltılıklar", R.drawable.breakfast),
            Category(7, "Atıştırmalıklar", R.drawable.snacks),
            Category(8, "Soğuk İçecekler", R.drawable.beverages)
        )
        adapter.submitList(categories)
    }
} 