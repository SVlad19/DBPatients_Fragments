package com.example.lab6_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PatientAdapter(val listPatients: ArrayList<Patient>, val context: Context, val callback: PatientCallback):
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_patient,parent,false))
    }

    override fun getItemCount(): Int {
        return listPatients.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = listPatients[position].name
        holder.age.text = listPatients[position].age
        holder.gender.text = listPatients[position].gender
        holder.medHistory.text = listPatients[position].medicalHistory
        //holder.image.setImageBitmap(listPatients[position].image)

        holder.name.setOnClickListener(){
            callback.OnItemSelected(position)
        }

    }
}
class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    //val image: ImageView = itemView.findViewById(R.id.ivPatient)
    val name: TextView = itemView.findViewById(R.id.tvNameD)
    val age: TextView = itemView.findViewById(R.id.tvValOfAge)
    val gender: TextView = itemView.findViewById(R.id.tvGen)
    val medHistory: TextView = itemView.findViewById(R.id.tvMedicalHistoryD)
}

interface PatientCallback{
    fun OnItemSelected(i: Int)
}