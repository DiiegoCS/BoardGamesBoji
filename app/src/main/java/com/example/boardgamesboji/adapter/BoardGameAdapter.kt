package com.example.boardgamesboji.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boardgamesboji.databinding.GameItemBinding
import com.example.boardgamesboji.model.BoardGameModelo
import com.squareup.picasso.Picasso

class BoardGameAdapter(private val datos:List<BoardGameModelo>): RecyclerView.Adapter<BoardGameAdapter.ViewHolder>() {

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
                .resize(300, 330)
                .into(ivGame)
        }

        //onclick libro item
       /* holder.binding.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, DetalleActivity::class.java)
            it.context.startActivity(intent)
        })*/
    }

    override fun getItemCount(): Int {
        return datos.size
    }

}