package pl.adamklemba.cvapp.commonview.listLoader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.databinding.ReposLoadStateHeaderViewItemBinding

class ReposLoadStateViewHolder(
    private val binding: ReposLoadStateHeaderViewItemBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.also {
            it.setOnClickListener { retry.invoke() }
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.visibility = toVisibility(loadState == LoadState.Loading)
        binding.retryButton.visibility = toVisibility(loadState != LoadState.Loading)
        binding.errorMsg.visibility = toVisibility(loadState != LoadState.Loading)
    }

    private fun toVisibility(constraint: Boolean): Int = if (constraint) {
        View.VISIBLE
    } else {
        View.GONE
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): ReposLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.repos_load_state_header_view_item, parent, false)
            val binding = ReposLoadStateHeaderViewItemBinding.bind(view)
            return ReposLoadStateViewHolder(binding, retry)
        }
    }
}