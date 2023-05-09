package com.example.lab6_2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random
import javax.security.auth.callback.Callback

class ListFragment : Fragment(), PatientCallback {
    val patients = getListPatients()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvPatient = view.findViewById<RecyclerView>(R.id.rvPatient)
        val adapter = PatientAdapter(patients, requireContext(),this)


        rvPatient.adapter = adapter
        rvPatient.layoutManager = LinearLayoutManager(activity)

    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ListFragment()
    }

    override fun OnItemSelected(i: Int){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.flDetails,DetailFragment.newInstance(patients[i].name,patients[i].age,patients[i].gender,patients[i].medicalHistory))
            .addToBackStack(null)
            .commit()
    }

    fun getListPatients(): ArrayList<Patient>{
        val value = Random()

        val listName = ArrayList<String>(listOf(
            "John Smith","Olivia Williams","Ethan Brown","Ava Rodriguez","Liam Garcia",
            "Emma Martinez","William Davis","Sophia Hernandez","James Wilson","Charlotte Anderson",
            "Benjamin Jackson","Mia Lee","Michael Gonzalez","Isabella Taylor","Daniel Martin"
        ))

        val listAge = ArrayList<String>(listOf(
            "21","22","15","55","63","28","36","42","53","18"
        ))

        val listGender = ArrayList<String>(listOf(
            "Male", "Female"
        ))

        val listMedicalHistory = ArrayList<String>(listOf(
            "Recently diagnosed with high blood pressure.",
            "Recovering from a minor surgery for appendicitis.",
            "Has a history of allergies to certain medications.",
            "Recently diagnosed with diabetes and is learning to manage it.",
            "Suffered from a concussion during a sports game last month.",
            "Recovering from a broken leg after a fall from stairs.",
            "Recently underwent surgery to remove a tumor in the stomach.",
            "Has a history of asthma and requires regular medication.",
            "Has high cholesterol and is making dietary changes to improve it.",
            "Recently suffered from a severe case of the flu.",
            "Recovering from a sports injury to the knee.",
            "Recently diagnosed with depression and is receiving treatment.",
            "Has a family history of heart disease and is being monitored regularly.",
            "Recovering from a car accident and has a broken arm.",
            "Has a history of migraines and is currently trying a new medication."
        ))

        val listImage = ArrayList<Int>(listOf(R.drawable.patient1,R.drawable.patient2,R.drawable.patient3,
            R.drawable.patient4,R.drawable.patient5
        ))

        val patientList = ArrayList<Patient>()

        for(i in 0..14){
            patientList.add(Patient(listName[i],listAge[value.nextInt(10)],listGender[value.nextInt(2)],listMedicalHistory[i]/*,
                BitmapFactory.decodeResource(resources,listImage[value.nextInt(5)])*/))
        }

        return patientList
    }
}