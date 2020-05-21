package com.example.refractorrecyclerview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.refractorrecyclerview.adapter.InputText
import com.example.refractorrecyclerview.adapter.InputViewModel
import com.example.refractorrecyclerview.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: InputViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val recyclerAdapter = RecyclerAdapter()
        val inputViewModel = ViewModelProviders.of(this).get(InputViewModel::class.java)
        btnAdd.setOnClickListener {


            var inputText = InputText(txtInput.text.toString())
            inputViewModel.settext(inputText)


        }
        inputViewModel.getText().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.data.add(it)
        })

        recyclerView.adapter = recyclerAdapter
    }

}
