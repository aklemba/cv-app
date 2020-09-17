package pl.adamklemba.cvapp.knowledge.view

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.adamklemba.cvapp.model.KnowledgeTopic

class KnowledgeTopicAdapter : ListAdapter<KnowledgeTopic, KnowledgeTopicViewHolder>(
    KnowledgeTopic.DIFF_UTIL
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeTopicViewHolder {
        return KnowledgeTopicViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: KnowledgeTopicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
