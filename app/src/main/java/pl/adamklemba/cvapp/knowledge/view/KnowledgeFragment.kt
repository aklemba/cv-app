package pl.adamklemba.cvapp.knowledge.view

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.knowledge_fragment.*
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.commonview.ErrorDialog
import pl.adamklemba.cvapp.commonview.listLoader.ReposLoadStateAdapter
import pl.adamklemba.cvapp.databinding.KnowledgeFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class KnowledgeFragment : BaseFragment<KnowledgeFragmentBinding, KnowledgeViewModel>() {

    override val viewModel: KnowledgeViewModel by viewModels()

    override fun getLayoutId() = R.layout.knowledge_fragment

    @Inject
    lateinit var knowledgeTopicAdapter: KnowledgeTopicAdapter

    private lateinit var loadStateAdapter: ReposLoadStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setupRecyclerView()
    }

    override fun KnowledgeViewModel.observeLiveData() {
        knowledgeTopics.observe { knowledgeTopicAdapter.submitList(it) }
        loadStatus.observe { loadStateAdapter.loadState = it }
    }

    private fun initAdapter() {
        loadStateAdapter = ReposLoadStateAdapter { viewModel.retry() }
    }

    private fun setupRecyclerView() {
        knowledgeTopicsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        knowledgeTopicsRecyclerView.adapter =
            ConcatAdapter(
                knowledgeTopicAdapter,
                loadStateAdapter
            )

    }
}