package com.example.healthyfood.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyfood.R
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import com.example.healthyfood.ui.fragments.home.HomeDirections

class RandomFoodAdapter : RecyclerView.Adapter<RandomFoodAdapter.RandomFoodVH>() {

    private var recipes: ArrayList<RandomRecipeApiResponse> = arrayListOf()
    private var onItemClick: ((recipe: RandomRecipeApiResponse, position: Int) -> Unit)? = null

    class RandomFoodVH(view: View) : RecyclerView.ViewHolder(view) {
        private val title = itemView.findViewById<TextView>(R.id.food_description)
        private val image = itemView.findViewById<ImageView>(R.id.food_image)
        private var currentRecipe: RandomRecipeApiResponse? = null

        fun onBind(
            recipe: RandomRecipeApiResponse,
            position: Int,
            onClick: (RandomRecipeApiResponse, Int) -> Unit
        ) {
            currentRecipe = recipe
            title.text = recipe.recipes[position].title

            itemView.setOnClickListener {
                onClick.invoke(recipe, position)
                val action = HomeDirections.actionHomeToFoodDetails()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomFoodVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return RandomFoodVH(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipe: ArrayList<RandomRecipeApiResponse>) {
        recipes = recipe
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RandomFoodVH, position: Int) {
        holder.onBind(recipes[position], position, onItemClick ?: { _, _ -> })
    }

    override fun getItemCount(): Int = recipes.size

}