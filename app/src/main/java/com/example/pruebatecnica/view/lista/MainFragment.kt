package com.example.pruebatecnica.view.lista


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.databinding.FragmentMainBinding
import com.example.pruebatecnica.viewmodel.SuperHeroesViewModel

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : SuperHeroesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(SuperHeroesViewModel::class.java)

        createUI()

        return view

    }

    private fun createUI(){

        binding.recyclerSuperHeroes.layoutManager = LinearLayoutManager(context)

        binding.recyclerSuperHeroes.adapter = SuperHeroesAdapter{

            val action = MainFragmentDirections.actionMainFragmentToDetallesHeroeFragment(it)

            view?.findNavController()?.navigate(action)
            //val intent = Intent(context, MainFragment::class.java)
            //intent.putExtra("id", it)
            //startActivity(intent)
        }

        viewModel.getHeroesList()

        viewModel.heroesList.observe(viewLifecycleOwner) { listaHeroes ->
            (binding.recyclerSuperHeroes.adapter as SuperHeroesAdapter).setData(listaHeroes)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}