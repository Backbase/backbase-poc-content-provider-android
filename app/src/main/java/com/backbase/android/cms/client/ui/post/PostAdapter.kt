package com.backbase.android.cms.client.ui.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.backbase.android.cms.client.R
import com.backbase.android.cms.client.ui.post.model.Post
import com.backbase.android.cms.client.utils.fromHtml
import com.backbase.android.cms.client.utils.loadFromUrl
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
/**
 * This Adapter is used to help rendering the data in the recycle view
 */
class PostAdapter(private val clickListener: OnComponentClickListener) :
    RecyclerView.Adapter<PostAdapter.ComponentViewHolder>() {
    val dataSet = mutableListOf<Post>()

    class ComponentViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        private val titleView: MaterialTextView = view.findViewById(R.id.title)
        private val desc: MaterialTextView = view.findViewById(R.id.content)
        private val imageView: ShapeableImageView = view.findViewById(R.id.image)

        fun bind(post: Post, clickListener: OnComponentClickListener) {
            titleView.text = post.title.fromHtml()
            desc.text = post.desc.fromHtml()
            imageView.loadFromUrl(post.imageUrl)
            view.setOnClickListener {
                clickListener.onComponentClicked(post)
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ComponentViewHolder {
        return ComponentViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.post_list_item, viewGroup, false)
        )
    }
    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        holder.bind(dataSet[position], clickListener);

    }

    override fun getItemCount() = dataSet.size

    interface OnComponentClickListener {
        fun onComponentClicked(post: Post)
    }

}
