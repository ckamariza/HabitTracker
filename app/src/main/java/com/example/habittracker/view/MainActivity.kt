package com.example.habittracker.view

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.R
import com.example.habittracker.databinding.ActivityMainBinding
import com.example.habittracker.viewmodel.HabitViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HabitViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        // Initialize Bottom Navigation and Fragment Container
        val bottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    binding.fabAddHabit.show()
                    true
                }
                R.id.nav_achievements -> {
                    loadFragment(AchievementsFragment())
                    binding.fabAddHabit.hide()
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.nav_home

        binding.fabAddHabit.setOnClickListener {
            openAddHabitDialog()

        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun openAddHabitDialog() {
        val dialog = Dialog(this)

        dialog.setContentView(R.layout.dialog_add_habit)

        val editTextHabitName = dialog.findViewById<EditText>(R.id.editTextHabitName)
        val buttonAddHabit = dialog.findViewById<Button>(R.id.buttonAddHabit)

        buttonAddHabit.setOnClickListener {
            val habitName = editTextHabitName.text.toString()
            if (habitName.isNotEmpty()) {
                Toast.makeText(this, "Habit '$habitName' added!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Please enter a habit name", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }
}