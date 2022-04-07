package com.example.pruebatecnica.view.detalle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.pruebatecnica.databinding.FragmentDetallesHeroeBinding

import com.example.pruebatecnica.viewmodel.HeroeViewModel

class DetallesHeroeFragment : Fragment() {

    private var _binding : FragmentDetallesHeroeBinding? = null
    private val biding get() = _binding!!
    private lateinit var viewModel : HeroeViewModel
    private val args: DetallesHeroeFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetallesHeroeBinding.inflate(inflater, container, false)
        val view = biding.root

        viewModel = ViewModelProvider(this).get(HeroeViewModel::class.java)

        createUI()

        return view
    }

    private fun createUI (){

        viewModel.getHeroe(args.id)
        viewModel.heroe.observe(viewLifecycleOwner) { heroeDestino ->

            biding.heroeNombre.text = heroeDestino.name
            biding.heroeInteligencia.text = heroeDestino.powerstats.intelligence
            biding.heroeFuerza.text = heroeDestino.powerstats.strength
            biding.heroeVelocidad.text = heroeDestino.powerstats.speed
            biding.heroeResistencia.text = heroeDestino.powerstats.durability
            biding.heroePoder.text = heroeDestino.powerstats.power
            biding.heroeCombate.text = heroeDestino.powerstats.combat

            biding.heroenombreCompleto.text = heroeDestino.biography.fullName
            biding.heroeAlterEgos.text = heroeDestino.biography.alterEgos
            biding.heroeAliases.text = heroeDestino.biography.aliases[0]
            biding.heroeLugarDeNacimiento.text = heroeDestino.biography.placeOfBirth
            biding.heroePrimeraAparicion.text = heroeDestino.biography.firstAppearance
            biding.heroePublicacion.text = heroeDestino.biography.publisher
            biding.heroeAlineamiento.text = heroeDestino.biography.alignment

            biding.heroeGenero.text = heroeDestino.appearance.gender
            biding.heroeRaza.text = heroeDestino.appearance.race
            biding.heroeEstatura.text = heroeDestino.appearance.height[1]
            biding.heroePeso.text = heroeDestino.appearance.weight[1]
            biding.heroeColorDeOjos.text = heroeDestino.appearance.eyeColor
            biding.heroeColorDePelo.text = heroeDestino.appearance.hairColor

            biding.heroeOcupacion.text = heroeDestino.work.occupation
            biding.heroeBaseDeOperaciones.text = heroeDestino.work.occupation

            biding.heroeGrupoDeAfiliaciN.text = heroeDestino.connections.groupAffiliation
            biding.heroeRelativos.text = heroeDestino.connections.relatives


            /*
            Glide.with(this)
                .load(heroeDestino.image.url)
                .apply(RequestOptions().override(600,600))
                .circleCrop()
                .into(biding.imagenHeroe)

             */

        }
    }
}