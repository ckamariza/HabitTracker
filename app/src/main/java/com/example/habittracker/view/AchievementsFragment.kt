package com.example.habittracker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.habittracker.databinding.FragmentAchievementsBinding

class AchievementsFragment: Fragment() {

private lateinit var binding: FragmentAchievementsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
