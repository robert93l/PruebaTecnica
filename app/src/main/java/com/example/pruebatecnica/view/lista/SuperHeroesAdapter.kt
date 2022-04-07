package com.example.pruebatecnica.view.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pruebatecnica.databinding.HeroesRenglonBinding
import com.example.pruebatecnica.model.SuperHeroe

class SuperHeroesAdapter (val heroeClick : (Int) -> Unit) : RecyclerView.Adapter<SuperHeroesAdapter.HeroeViewHolder>() {

    var heroelist : List<SuperHeroe> = emptyList<SuperHeroe>()

    fun setData( list: List<SuperHeroe>){
        heroelist = list
        notifyDataSetChanged()
    }

    inner class HeroeViewHolder(val binding : HeroesRenglonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val binding = HeroesRenglonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroeViewHolder(binding)
    }

    override fun getItemCount() = heroelist.size

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        val heroe = heroelist[position]

        holder.binding.nombreSuperHeroe.text = heroe.name

        Glide.with(holder.itemView.context)
            .load(heroe.image.url)
            .apply(RequestOptions().override(600,600))
            .circleCrop()
            .into(holder.binding.imageSuperHeroe)

        holder.itemView.setOnClickListener { heroeClick(heroe.id.toInt()) }
    }

}