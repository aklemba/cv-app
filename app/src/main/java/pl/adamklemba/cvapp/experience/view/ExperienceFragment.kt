package pl.adamklemba.cvapp.experience.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.experience_fragment.*
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.commonview.listLoader.ReposLoadStateAdapter
import pl.adamklemba.cvapp.databinding.ExperienceFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class ExperienceFragment : BaseFragment<ExperienceFragmentBinding, ExperienceViewModel>() {

    override val viewModel: ExperienceViewModel by viewModels()

    override fun getLayoutId() = R.layout.experience_fragment

    @Inject
    lateinit var jobExperienceAdapter: JobExperienceAdapter

    private lateinit var loadStateAdapter: ReposLoadStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setupRecyclerView()
    }

    override fun ExperienceViewModel.observeLiveData() {
        jobExperiences.observe { jobExperienceAdapter.submitList(it) }
        loadStatus.observe { loadStateAdapter.loadState = it }
    }

    private fun initAdapter() {
        loadStateAdapter = ReposLoadStateAdapter { viewModel.retry() }
    }

    private fun setupRecyclerView() {
        jobExperienceRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        jobExperienceRecyclerView.adapter =
            ConcatAdapter(
                jobExperienceAdapter,
                loadStateAdapter
            )

        ContextCompat.getDrawable(
            requireContext(),
            R.drawable.ic_job_experience_divider
        )?.let { drawable -> setItemDecorationForRecyclerView(drawable) }
    }

    private fun setItemDecorationForRecyclerView(drawable: Drawable) {
        jobExperienceRecyclerView.addItemDecoration(
            DividerItemDecoration(context, VERTICAL).apply { setDrawable(drawable) }
        )
    }
}