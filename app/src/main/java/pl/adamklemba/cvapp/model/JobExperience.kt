package pl.adamklemba.cvapp.model

import androidx.recyclerview.widget.DiffUtil
import java.util.*

data class JobExperience(
    val companyName: String,
    val role: String,
    val employmentStart: Date,
    val employmentEnd: Date,
    val companyLogoUrl: String
) {

    companion object {

        val DIFF_UTIL = object : DiffUtil.ItemCallback<JobExperience>() {
            override fun areItemsTheSame(oldItem: JobExperience, newItem: JobExperience) =
                oldItem.companyName == newItem.companyName

            override fun areContentsTheSame(oldItem: JobExperience, newItem: JobExperience) =
                oldItem == newItem
        }
    }
}
