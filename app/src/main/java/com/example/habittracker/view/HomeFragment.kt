package com.example.habittracker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.model.HabitAdapter
import com.example.habittracker.databinding.FragmentHomeBinding
import com.example.habittracker.viewmodel.HabitViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var habitViewModel: HabitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        habitViewModel = ViewModelProvider(requireActivity()).get(HabitViewModel::class.java)

        binding.recyclerViewHabits.layoutManager = LinearLayoutManager(context)
        val adapter = HabitAdapter(emptyList())
        binding.recyclerViewHabits.adapter = adapter

        return binding.root
    }
}