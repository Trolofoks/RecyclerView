package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.PlantItemBinding
import java.util.ArrayList

//принимаем сигнал с интерефейса в виде listener
class PlantAdapter(val listener: Listener): RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    val plantModelList = ArrayList<PlantModel>()
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)

        //и сюда listener
        fun bind(plantModel: PlantModel, listener: Listener) = with(binding){
            im.setImageResource(plantModel.imageId)
            tvTitle.text = plantModel.title
            //тот самый onClick
            itemView.setOnClickListener {
                listener.onCLick(plantModel)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        //и сюда listener
        holder.bind(plantModelList[position], listener)
    }

    override fun getItemCount(): Int {
        return plantModelList.size
    }

    fun addPlant(plantModel: PlantModel){
        plantModelList.add(plantModel)
        notifyDataSetChanged()
    }

    //связующий интерфейс
    interface Listener{
        fun onCLick(plantModel: PlantModel)
    }
}