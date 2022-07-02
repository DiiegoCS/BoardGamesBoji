package com.example.boardgamesboji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boardgamesboji.adapter.BGAMEID_MESSAGE
import com.example.boardgamesboji.databinding.ActivityGameDetailedViewBinding

class GameDetailedView : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailedViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameId = intent.getIntExtra(BGAMEID_MESSAGE, 0)
    }
}