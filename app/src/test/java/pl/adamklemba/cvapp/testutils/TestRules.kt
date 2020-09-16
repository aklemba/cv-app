package pl.adamklemba.cvapp.testutils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

fun getRxLiveDataRule(): TestRule = RuleChain
    .emptyRuleChain()
    .around(getRxRule())
    .around(getLiveDataRule())

fun getRxRule(
    ioScheduler: Scheduler = Schedulers.trampoline(),
    computationScheduler: Scheduler = Schedulers.trampoline(),
    newThreadScheduler: Scheduler = Schedulers.trampoline(),
    initMainThreadScheduler: Scheduler = Schedulers.trampoline()
): TestRule = RxTestRule(
    ioScheduler,
    computationScheduler,
    newThreadScheduler,
    initMainThreadScheduler
)

fun getLiveDataRule(): TestRule {
    return InstantTaskExecutorRule()
}

class RxTestRule(
    val ioScheduler: Scheduler,
    val computationScheduler: Scheduler,
    val newThreadScheduler: Scheduler,
    val initMainThreadScheduler: Scheduler
) : TestRule {

    override fun apply(base: Statement, description: Description?) = object : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            RxJavaPlugins.setIoSchedulerHandler { ioScheduler }
            RxJavaPlugins.setComputationSchedulerHandler { computationScheduler }
            RxJavaPlugins.setNewThreadSchedulerHandler { newThreadScheduler }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { initMainThreadScheduler }
            try {
                base.evaluate()
            } finally {
                RxJavaPlugins.reset()
                RxAndroidPlugins.reset()
            }
        }
    }
}
