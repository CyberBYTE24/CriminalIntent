package com.sample.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.criminalintent.IntentListener
import com.sample.criminalintent.R
import com.sample.criminalintent.databinding.ItemIntentBinding
import com.sample.criminalintent.Intent
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import java.util.Date

class IntentAdapter(private var intents: List<Intent>, private var intentListener: IntentListener) : ListAdapter<Intent, IntentAdapter.IntentViewHolder>(
    MovieDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntentViewHolder {
        val binding = ItemIntentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IntentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntentViewHolder, position: Int) {
        holder.bind(intents[position])
        holder.bind(intentListener)
    }

    override fun getItemCount(): Int = intents.size

    fun updateMovies(newIntents: List<Intent>) {
        intents = newIntents
        notifyDataSetChanged()
    }

    fun updateNotify(){
        notifyDataSetChanged()
    }

    companion object{
        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ShapeableImageView, image: String?) {
            if (image == null) {
                Glide.with(imageView.context).clear(imageView)
            }
            Glide.with(imageView.context)
                .load(image)
                .into(imageView)

        }
        @JvmStatic
        @BindingAdapter("setDoneCondition")
        fun setFavouriteCondition(imageView: ShapeableImageView, isDone: Boolean) {
            if (isDone) {
                imageView.isVisible = true
            } else {
                imageView.isVisible = false
            }
        }
        @JvmStatic
        @BindingAdapter("setTitle")
        fun setTitle(textView: TextView, title: String?) {
            if (title == null) {
                textView.text = "No title"
            } else {
                textView.text = title
            }
        }
        @JvmStatic
        @BindingAdapter("setDescription")
        fun setDescription(textView: TextView, description: String?) {
            if (description == null) {
                textView.text = "No description"
            } else {
                textView.text = description
            }
        }
        @JvmStatic
        @BindingAdapter("setDateTime")
        fun setReleaseDate(textView: TextView, dateTime: Date?) {
            if (dateTime == null) {
                textView.text = "No date and time"
            } else {
                textView.text = "$dateTime"
            }
        }
    }


    inner class IntentViewHolder(private val binding: ItemIntentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(intent: Intent) {
            binding.intent = intent
            binding.executePendingBindings() // Ensures that the data is bound immediately
        }
        fun bind(listener: IntentListener){
            binding.listener = listener
            binding.executePendingBindings()
        }
    }
    class MovieDiffCallback : DiffUtil.ItemCallback<Intent>() {
        override fun areItemsTheSame(oldItem: Intent, newItem: Intent): Boolean {
            return oldItem.id == newItem.id // Assuming Movie has an id
        }

        override fun areContentsTheSame(oldItem: Intent, newItem: Intent): Boolean {
            return oldItem == newItem
        }
    }
}
