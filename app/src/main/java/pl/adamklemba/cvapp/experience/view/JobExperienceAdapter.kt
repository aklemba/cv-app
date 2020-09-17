package pl.adamklemba.cvapp.experience.view

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.adamklemba.cvapp.model.JobExperience

class JobExperienceAdapter : ListAdapter<JobExperience, JobExperienceViewHolder>(
    JobExperience.DIFF_UTIL
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobExperienceViewHolder {
        return JobExperienceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: JobExperienceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
