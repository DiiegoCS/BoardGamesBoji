package com.example.boardgamesboji.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boardgamesboji.GameDetailedView
import com.example.boardgamesboji.databinding.GameItemBinding
import com.example.boardgamesboji.model.BoardGame
import com.example.boardgamesboji.model.BoardGameModelo
import com.squareup.picasso.Picasso

const val BGAMEID_MESSAGE = "com.example.boardgamesboji.BGAMEID"

class BoardGameAdapter(private val datos:List<BoardGame>): RecyclerView.Adapter<BoardGameAdapter.ViewHolder>() {

    class ViewHolder(val binding: GameItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bgame = datos.get(position)
        with(holder.binding){
            tvNombre.text = bgame.nombre
            tvEditorial.text = "Publicado por: ${bgame.editorial}"
            tvPrecio.text = "$${bgame.precio}"
            Picasso.get().load(bgame.imagen)
                .resize(310, 320)
                .into(ivGame)
        }

        //onclick bgame item
        holder.binding.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, GameDetailedView::class.java).apply {
                putExtra(BGAMEID_MESSAGE, bgame.id)
            }
            it.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return datos.size
    }

}