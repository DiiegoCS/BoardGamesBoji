package com.example.boardgamesboji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.boardgamesboji.adapter.BoardGameAdapter
import com.example.boardgamesboji.databinding.ActivityMainBinding
import com.example.boardgamesboji.view.BgameViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val bgameViewModel: BgameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recylcer
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        bgameViewModel.cargarBgames()

        bgameViewModel.bgames.observe(this, Observer { bgames ->
            binding.recyclerView.adapter = BoardGameAdapter(bgames)
        })

    }
}