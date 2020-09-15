package pl.adamklemba.cvapp.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.R

@AndroidEntryPoint
class ExperienceFragment : Fragment() {

    private val viewModel: ExperienceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.experience_fragment, container, false)
    }
}