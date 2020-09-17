package pl.adamklemba.cvapp.experience.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.databinding.JobExperienceViewItemBinding
import pl.adamklemba.cvapp.model.JobExperience
import java.text.SimpleDateFormat
import java.util.*

class JobExperienceViewHolder(
    private val binding: JobExperienceViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(jobExperience: JobExperience) {
        binding.jobExperienceCompanyNameTextView.text = jobExperience.companyName
        binding.jobExperienceRoleTextView.text = jobExperience.role
        binding.jobExperienceEmploymentPeriodTextView.text = getEmploymentPeriodText(
            jobExperience.employmentStart,
            jobExperience.employmentEnd
        )
        initLogoLoading(jobExperience.companyLogoUrl)
    }

    private fun initLogoLoading(logoUrl: String) = Glide.with(binding.root.context)
        .load(logoUrl)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(binding.jobExperienceLogoImageView)

    private fun getEmploymentPeriodText(start: Date, end: Date): String {
        val dateFormatter = SimpleDateFormat(DATE_DISPLAY_FORMAT, Locale.getDefault())
        return binding.root.context.getString(
            R.string.job_experience_employment_period,
            dateFormatter.format(start),
            dateFormatter.format(end)
        )
    }

    companion object {

        fun create(parent: ViewGroup): JobExperienceViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.job_experience_view_item, parent, false)
            val binding = JobExperienceViewItemBinding.bind(view)
            return JobExperienceViewHolder(binding)
        }

        const val DATE_DISPLAY_FORMAT = "MM-yyyy"
    }
}