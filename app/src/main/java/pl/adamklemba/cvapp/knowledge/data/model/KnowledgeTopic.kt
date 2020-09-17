package pl.adamklemba.cvapp.knowledge.data.model

data class KnowledgeTopic(
    val name: String,
    val level: KnowledgeLevel
) {

    enum class KnowledgeLevel {
        BASIC,
        INTERMEDIATE,
        ADVANCED
    }
}
