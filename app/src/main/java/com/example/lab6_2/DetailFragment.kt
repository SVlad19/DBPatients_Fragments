package com.example.lab6_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class DetailFragment : Fragment() {
    private var name: String? = null
    private var age: String? = null
    private var gender: String? = null
    private var medicalHistory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1)
            age = it.getString(ARG_PARAM2)
            gender = it.getString(ARG_PARAM3)
            medicalHistory = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvNameD).text = name
        view.findViewById<TextView>(R.id.tvAgeD).text = age
        view.findViewById<TextView>(R.id.tvGenderD).text = gender
        view.findViewById<TextView>(R.id.tvMedicalHistoryD).text = medicalHistory
    }
    companion object {

        @JvmStatic
        fun newInstance(name: String, age: String, gender: String,medicalHistory: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                    putString(ARG_PARAM2, age)
                    putString(ARG_PARAM3, gender)
                    putString(ARG_PARAM4, medicalHistory)
                }
            }
    }
}