package pl.adamklemba.cvapp.summary.view

import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.commonview.ErrorDialog
import pl.adamklemba.cvapp.databinding.SummaryFragmentBinding

@AndroidEntryPoint
class SummaryFragment : BaseFragment<SummaryFragmentBinding, SummaryViewModel>() {

    override val viewModel by viewModels<SummaryViewModel>()

    override fun getLayoutId() = R.layout.summary_fragment

    override fun SummaryViewModel.observeLiveData() {
        errorMessageId.observe { showErrorDialog(it) }
    }

    private fun showErrorDialog(@StringRes messageId: Int) {
        ErrorDialog(messageId)
            .show(this@SummaryFragment.parentFragmentManager, ErrorDialog.TAG)
    }
}