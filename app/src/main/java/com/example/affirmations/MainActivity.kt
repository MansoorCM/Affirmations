package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.affirmations.adapter.AffirmationListAdapter
import com.example.affirmations.databinding.ActivityMainBinding
import com.example.affirmations.model.DataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var affirmationListAdapter: AffirmationListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        affirmationListAdapter = AffirmationListAdapter()
        binding.recyclerView.adapter = affirmationListAdapter
        affirmationListAdapter.submitList(DataSource().loadAffirmations())

    }
}