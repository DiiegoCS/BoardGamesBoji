package com.example.boardgamesboji.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boardgamesboji.app.BoardGamesBoji
import com.example.boardgamesboji.model.BoardGame
import com.example.boardgamesboji.model.BoardGameModelo
import com.example.boardgamesboji.service.BoardGameRepository
import kotlinx.coroutines.launch

class BgameViewModel(application: Application):AndroidViewModel(application) {

    val bgames = MutableLiveData<List<BoardGame>>()

    fun cargarBgames(){
        viewModelScope.launch {
            val app= getApplication<BoardGamesBoji>()
            val repo = BoardGameRepository(app.bgameService, app.bgameDao)
            val bgamesFromRepo = repo.findAll()
            if(!bgamesFromRepo.isNullOrEmpty()){
                bgames.postValue(bgamesFromRepo)
            }
        }
    }
}