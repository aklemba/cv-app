package pl.adamklemba.cvapp.commonview.listLoader

sealed class LoadState {

    object Loading : LoadState()

    object Done : LoadState()

    data class Error(val error: Throwable) : LoadState() {
        override fun toString() = "Error: $error"
    }
}