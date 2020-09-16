package pl.adamklemba.cvapp.knowledge

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseFragment
import pl.adamklemba.cvapp.databinding.KnowledgeFragmentBinding

@AndroidEntryPoint
class KnowledgeFragment : BaseFragment<KnowledgeFragmentBinding, KnowledgeViewModel>() {

    override val viewModel: KnowledgeViewModel by viewModels()

    override fun getLayoutId() = R.layout.knowledge_fragment
}