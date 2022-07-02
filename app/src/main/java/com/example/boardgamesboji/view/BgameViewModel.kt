package com.example.boardgamesboji.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boardgamesboji.model.BoardGameModelo
import com.example.boardgamesboji.service.BoardGameRepository
import kotlinx.coroutines.launch

class BgameViewModel:ViewModel() {

    val bgames = MutableLiveData<List<BoardGameModelo>>()

    fun cargarBgames(){
        viewModelScope.launch {
            val repo = BoardGameRepository()
            val bgamesFromRepo = repo.findAll()
            if(!bgamesFromRepo.isNullOrEmpty()){
                bgames.postValue(bgamesFromRepo)
            }
        }
    }
}