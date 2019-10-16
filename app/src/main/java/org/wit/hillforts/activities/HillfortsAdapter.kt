package org.wit.hillforts.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hillfort_card_xml.view.*
import org.wit.hillforts.R
import org.wit.hillforts.models.HillfortModel

class HillfortsAdapter constructor(private var placemarks: List<HillfortModel>) :
    RecyclerView.Adapter<HillfortsAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.hillfort_card_xml,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val placemark = placemarks[holder.adapterPosition]
        holder.bind(placemark)
    }

    override fun getItemCount(): Int = placemarks.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(placemark: HillfortModel) {
            itemView.hillfortName.text = placemark.name
            itemView.description.text = placemark.description
        }
    }
}