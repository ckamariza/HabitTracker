package com.example.habittracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habittracker.model.Habit

class HabitViewModel: ViewModel() {
    val habitList = MutableLiveData<MutableList<Habit>>(mutableListOf())
    fun addHabit(name:String, frequency:Int) {
        val id = System.currentTimeMillis()
        val newHabit = Habit(id, name, frequency)
        val currentList = habitList.value?:mutableListOf()
        currentList.add(newHabit)
        habitList.value = currentList
    }

}