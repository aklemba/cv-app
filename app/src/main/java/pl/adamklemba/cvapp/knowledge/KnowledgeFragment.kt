package pl.adamklemba.cvapp.knowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R

@AndroidEntryPoint
class KnowledgeFragment : Fragment() {

    private val viewModel: KnowledgeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.knowledge_fragment, container, false)
    }
}