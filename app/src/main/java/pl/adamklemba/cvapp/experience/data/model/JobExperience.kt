package pl.adamklemba.cvapp.experience.data.model

import java.util.*

data class JobExperience(
    val companyName: String,
    val role: String,
    val employmentStart: Date,
    val employmentEnd: Date,
    val companyLogoUrl: String
)
