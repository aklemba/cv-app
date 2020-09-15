package pl.adamklemba.cvapp.summary

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.databinding.SummaryFragmentBinding

@AndroidEntryPoint
class SummaryFragment : BaseFragment<SummaryFragmentBinding>() {

    override val viewModel: SummaryViewModel by viewModels()

    override fun getLayoutId() = R.layout.summary_fragment
}