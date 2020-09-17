package pl.adamklemba.cvapp.commonview.listLoader

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ReposLoadStateAdapter(private val retry: () -> Unit) : RecyclerView.Adapter<ReposLoadStateViewHolder>() {

    var loadState: LoadState = LoadState.Done
        set(loadState) {
            if (field != loadState) {
                val displayOldItem = displayLoadStateAsItem(field)
                val displayNewItem = displayLoadStateAsItem(loadState)

                if (displayOldItem && !displayNewItem) {
                    notifyItemRemoved(0)
                } else if (displayNewItem && !displayOldItem) {
                    notifyItemInserted(0)
                } else if (displayOldItem && displayNewItem) {
                    notifyItemChanged(0)
                }
                field = loadState
            }
        }

    override fun onBindViewHolder(holder: ReposLoadStateViewHolder, position: Int) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposLoadStateViewHolder {
        return ReposLoadStateViewHolder.create(parent, retry)
    }

    override fun getItemViewType(position: Int): Int = 0

    override fun getItemCount(): Int = if (displayLoadStateAsItem(loadState)) 1 else 0

    private fun displayLoadStateAsItem(loadState: LoadState): Boolean {
        return loadState is LoadState.Loading || loadState is LoadState.Error
    }
}