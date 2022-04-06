package com.example.timesheetapp.view.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.timesheetapp.R
import com.example.timesheetapp.viewmodel.MainActivityViewModel


class FebruaryFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_february, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]

        view.findViewById<Button>(R.id.button)?.setOnClickListener {
            viewModel.liveData.value = "hello from fragment"
        }
    }
}