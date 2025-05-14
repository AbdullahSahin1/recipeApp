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

        recyclerView = findViewById(R.id.categoryRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val categories = listOf(
            Category(1, "Ana Yemekler", R.drawable.main_dish),
            Category(2, "Çorbalar", R.drawable.soup),
            Category(3, "Tatlılar", R.drawable.dessert),
            Category(4, "Salatalar", R.drawable.salad),
            Category(5, "İçecekler", R.drawable.drinks),
            Category(6, "Kahvaltılıklar", R.drawable.breakfast)
        )

        adapter = CategoryAdapter(categories) { category ->
            // Kategori seçildiğinde yapılacak işlemler
            Toast.makeText(this, "${category.name} seçildi", Toast.LENGTH_SHORT).show()
            // Burada seçilen kategoriye göre yeni bir aktivite başlatabilirsiniz
        }

        recyclerView.adapter = adapter
    }
} 