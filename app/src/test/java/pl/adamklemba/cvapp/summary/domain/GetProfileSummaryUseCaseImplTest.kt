package pl.adamklemba.cvapp.summary.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.adamklemba.cvapp.model.ProfileSummary
import pl.adamklemba.cvapp.testutils.getRxLiveDataRule

class GetProfileSummaryUseCaseImplTest {

    @Rule
    @JvmField
    var testSchedulerRule = getRxLiveDataRule()

    private val profileSummaryRepository: ProfileSummaryRepository = mock()

    private lateinit var useCase: GetProfileSummaryUseCase

    @Before
    fun setUp() {
        useCase = GetProfileSummaryUseCaseImpl(profileSummaryRepository)
    }

    @Test
    fun `Should return profile summary on calling execute`() {
        // given
        val profileSummary = ProfileSummary("name", "introduction", "description")
        whenever(profileSummaryRepository.getProfileSummary()).thenReturn(Single.just(profileSummary))

        // when
        val result = useCase.execute().test()

        // then
        result.assertValue(profileSummary)
    }
}