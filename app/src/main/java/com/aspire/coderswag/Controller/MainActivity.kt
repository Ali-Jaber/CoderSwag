package com.aspire.coderswag.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aspire.coderswag.Adapters.CategoryAdapter
import com.aspire.coderswag.Adapters.CategoryRecycleAdapter
import com.aspire.coderswag.R
import com.aspire.coderswag.Services.DataService
import com.aspire.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private lateinit var adapter: CategoryAdapter
    private lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->  
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManger = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManger
        categoryListView.setHasFixedSize(true)
    }
}