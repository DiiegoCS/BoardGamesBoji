package com.example.boardgamesboji

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.boardgamesboji.adapter.BGAMEID_MESSAGE
import com.example.boardgamesboji.databinding.ActivityGameDetailedViewBinding
import com.example.boardgamesboji.view.BgameDetailedViewModel
import com.squareup.picasso.Picasso

class GameDetailedView : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailedViewBinding
    private val bgameDetailedViewModel: BgameDetailedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameId = intent.getIntExtra(BGAMEID_MESSAGE, 0)

        //cargar datos con viewModel
        bgameDetailedViewModel.cargarBgame(gameId)

        bgameDetailedViewModel.bgame.observe(this, Observer { bgame ->
            with(binding) {
                txtNombre.text = bgame.nombre
                txtEditorial.text = bgame.editorial
                txtPrecio.text = bgame.precio
                txtJugador.text = bgame.jugadores
                txtEdad.text = bgame.edad
                txtTiempo.text = bgame.tiempoDeJuego
                txtAnno.text = bgame.anno.toString()
                txtDesigner.text = "Diseñador: ${bgame.disennador}"
                txtArtist.text = "Artista: ${bgame.artista}"
                txtDescrpcion.text = "Descripción: ${bgame.descripcion}"
                Picasso.get().load(bgame.imagen).into(imageDetalle)

            }

            //envetos btns
            binding.btnComprar.setOnClickListener {
                val textoCorreo= """
                    Hola
                    Quisiera reservar este juego de mesa ${bgame.nombre}, favor de contactar a este correo o al
                    siguiente número _________
                    Quedo atent@.
                """.trimIndent()

                val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                    type = "msage/rfc822" //fix TO
                    data = Uri.parse("mailto:")
                    val para:Array<String> = arrayOf("Info@boji-games.cl")
                    putExtra(Intent.EXTRA_EMAIL, para)
                    putExtra(Intent.EXTRA_SUBJECT, "Consulta por el Juego: ${bgame.nombre}")
                    putExtra(Intent.EXTRA_TEXT, textoCorreo)
                }

                startActivity(intentMail)
            }


        })
    }
}