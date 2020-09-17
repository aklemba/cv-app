package pl.adamklemba.cvapp.summary.view

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import pl.adamklemba.cvapp.model.ProfileSummary
import pl.adamklemba.cvapp.summary.domain.GetProfileSummaryUseCase
import pl.adamklemba.cvapp.testutils.TestObserver
import pl.adamklemba.cvapp.testutils.getRxLiveDataRule

class SummaryViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = getRxLiveDataRule()

    private val getProfileSummaryUseCase: GetProfileSummaryUseCase = mock()

    private val nameObserver = TestObserver<String>()
    private val introductionObserver = TestObserver<String>()
    private val descriptionObserver = TestObserver<String>()

    private lateinit var viewModel: SummaryViewModel

    @Test
    fun `Should post profile summary on start`() {
        // given
        val profileSummary = ProfileSummary("name", "introduction", "description")
        val executeResult = Single.just(profileSummary)
        whenever(getProfileSummaryUseCase.execute()).thenReturn(executeResult)

        // when
        setUp()
        viewModel.name.observeForever(nameObserver)
        viewModel.introduction.observeForever(introductionObserver)
        viewModel.description.observeForever(descriptionObserver)

        // then
        verify(getProfileSummaryUseCase).execute()
        assertEquals(nameObserver.value, profileSummary.name)
        assertEquals(introductionObserver.value, profileSummary.introduction)
        assertEquals(descriptionObserver.value, profileSummary.description)
    }

    private fun setUp() {
        viewModel = SummaryViewModel(getProfileSummaryUseCase)
    }
}