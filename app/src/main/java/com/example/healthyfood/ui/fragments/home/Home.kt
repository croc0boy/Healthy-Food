package com.example.healthyfood.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.healthyfood.R
import com.example.healthyfood.data.remote.RandomFoodRetrofitService
import com.example.healthyfood.databinding.ActivityMainBinding
import com.example.healthyfood.databinding.FragmentHomeBinding
import com.example.healthyfood.ui.fragments.home.adapter.RandomFoodAdapter
import com.example.healthyfood.ui.fragments.home.vm.HomeViewModel
import com.example.healthyfood.util.vmfactory.ViewModelFactory
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Home : Fragment(R.layout.fragment_home) {

    private val randomFoodViewModel by viewModels<HomeViewModel> {
        ViewModelFactory()
    }
    private val myAdapter by lazy { RandomFoodAdapter() }

    private val binding by viewBinding(FragmentHomeBinding::bind, R.layout.fragment_home)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val data = RandomFoodRetrofitService.getRandomFoodService().getRandomFood("10")


            Log.d("RETRO", "body = ${data.body().toString()}")
            Log.d("RETRO", "CODE: ${data.code()}")
            Log.d("Retro", "DATA")
        }

//        setupRecyclerView()
//
//        lifecycleScope.launchWhenCreated {
//            randomFoodViewModel.getRandomFood().catch {
//
//            } .collect { recipe ->
//                Log.d("Recipe", "OnRecieve: $recipe")
//                myAdapter.setData(recipe)
//            }
//        }

    }

    private fun setupRecyclerView() {
        binding.recycleViewer.apply {
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = myAdapter
        }
    }
}