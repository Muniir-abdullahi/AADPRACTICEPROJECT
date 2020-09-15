package com.example.aadpracticeproject.views.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aadpracticeproject.ApiServices.model.SkillIQLearnersResponse
import com.example.aadpracticeproject.R
import com.example.aadpracticeproject.inflate
import com.example.aadpracticeproject.model.SkillIQLeadersEntity
import kotlinx.android.synthetic.main.skilliq_items.view.*

class SkillIQLeadersAdapter () : RecyclerView.Adapter<SkillIQLeadersAdapter.SkillIQViewHolder>() {

    private var items = ArrayList<SkillIQLearnersResponse>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SkillIQLeadersAdapter.SkillIQViewHolder = SkillIQViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SkillIQLeadersAdapter.SkillIQViewHolder, position: Int) =
        holder.bind(items[position])

    fun addItems( list: List<SkillIQLearnersResponse>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    inner class SkillIQViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(
            R.layout.skilliq_items
        )
    ) {
        @SuppressLint("SetTextI18n")
        fun bind(items: SkillIQLearnersResponse) {

            itemView.tvIqName.text = items.name
            itemView.tvIqScores.text = "${items.score} skill IQ Score,"
            itemView.tvIqCountry.text = items.country
            Glide
                .with(itemView.imgIq)
                .load(items.badgeUrl)
                .fitCenter()
                .placeholder(R.drawable.ic_skill_iq)
                .into(itemView.imgIq)

        }

    }
}