package pl.adamklemba.cvapp.knowledge.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.databinding.KnowledgeTopicViewItemBinding
import pl.adamklemba.cvapp.model.KnowledgeTopic

class KnowledgeTopicViewHolder(
    private val binding: KnowledgeTopicViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(knowledgeTopic: KnowledgeTopic) {
        binding.knowledgeTopicNameTextView.text = knowledgeTopic.name
        binding.knowledgeTopicLevelTextView.text =
            binding.root.context.getString(knowledgeTopic.level.nameTextId)
    }

    companion object {

        fun create(parent: ViewGroup): KnowledgeTopicViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.knowledge_topic_view_item, parent, false)
            val binding = KnowledgeTopicViewItemBinding.bind(view)
            return KnowledgeTopicViewHolder(binding)
        }
    }
}