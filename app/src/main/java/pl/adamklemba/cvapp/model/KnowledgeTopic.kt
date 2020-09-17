package pl.adamklemba.cvapp.model

import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import pl.adamklemba.cvapp.R

data class KnowledgeTopic(
    val name: String,
    val level: KnowledgeLevel
) {

    enum class KnowledgeLevel(@StringRes val nameTextId: Int) {
        BASIC(R.string.knowledge_level_basic),
        INTERMEDIATE(R.string.knowledge_level_intermediate),
        ADVANCED(R.string.knowledge_level_advanced)
    }

    companion object {

        val DIFF_UTIL = object : DiffUtil.ItemCallback<KnowledgeTopic>() {
            override fun areItemsTheSame(oldItem: KnowledgeTopic, newItem: KnowledgeTopic) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: KnowledgeTopic, newItem: KnowledgeTopic) =
                oldItem == newItem
        }
    }
}