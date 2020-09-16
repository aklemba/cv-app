package pl.adamklemba.cvapp.experience

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.databinding.ExperienceFragmentBinding

@AndroidEntryPoint
class ExperienceFragment : BaseFragment<ExperienceFragmentBinding, ExperienceViewModel>() {

    override val viewModel: ExperienceViewModel by viewModels()

    override fun getLayoutId() = R.layout.experience_fragment
}