package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.moneyway.databinding.ActivityCalculatorsListBinding

class CalculatorsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navCalculators.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@CalculatorsListActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@CalculatorsListActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> startActivity(Intent(this@CalculatorsListActivity, BudgetPlansActivity::class.java))
                    R.id.account -> startActivity(Intent(this@CalculatorsListActivity, LogInActivity::class.java))
                }
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.openMenu -> binding.drawerCalculators.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}