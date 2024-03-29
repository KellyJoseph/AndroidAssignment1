package org.wit.hillforts.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hillfort_card_xml.view.*
import org.wit.hillforts.R
import org.wit.hillforts.helpers.readImageFromPath
import org.wit.hillforts.models.HillfortModel

interface HillfortListener {
    fun onHillfortClick(hillfort: HillfortModel)
}

class HillfortsAdapter constructor(
    private var hillforts: List<HillfortModel>,
    private val listener: HillfortListener
): RecyclerView.Adapter<HillfortsAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.hillfort_card_xml,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val hillfort = hillforts[holder.adapterPosition]
        holder.bind(hillfort, listener)
    }

    override fun getItemCount(): Int = hillforts.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(hillfort: HillfortModel, listener: HillfortListener) {
            itemView.hillfortName.text = hillfort.name
            itemView.description.text = hillfort.description
            itemView.dateVisited.text = hillfort.visitedDate
            if (hillfort.images.size > 0) {
                itemView.imageIcon.setImageBitmap(
                    readImageFromPath(
                        itemView.context,
                        hillfort.images[0]
                    )
                )
            }
            itemView.setOnClickListener { listener.onHillfortClick(hillfort) }
        }
    }
}