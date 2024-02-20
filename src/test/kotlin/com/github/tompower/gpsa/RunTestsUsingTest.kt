package com.github.tompower.gpsa

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.impl.SimpleDataContext
import com.intellij.openapi.project.Project
import com.intellij.testFramework.RunAll
import com.intellij.testFramework.UsefulTestCase
import com.intellij.testFramework.fixtures.IdeaProjectTestFixture
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory
import com.intellij.util.ThrowableRunnable
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.settings.GradleSettings
import org.jetbrains.plugins.gradle.settings.TestRunner.*

class RunTestsUsingTest : UsefulTestCase() {
    private lateinit var fixture: IdeaProjectTestFixture
    private lateinit var project: Project
    private lateinit var gradleProjectSettings: GradleProjectSettings

    override fun setUp() {
        super.setUp()
        fixture =
            IdeaTestFixtureFactory.getFixtureFactory()
                .createFixtureBuilder(name)
                .fixture.apply { setUp() }
        project = fixture.project
        gradleProjectSettings = GradleProjectSettings().apply { externalProjectPath = project.basePath }
        GradleSettings.getInstance(project).linkProject(gradleProjectSettings)
    }

    override fun tearDown() {
        RunAll(
            ThrowableRunnable { fixture.tearDown() },
            ThrowableRunnable { super.tearDown() }
        ).run()
    }

    fun testCanUpdateTestRunnerToPlatform() {
        assertEquals(GRADLE, gradleProjectSettings.testRunner)

        ActionManager.getInstance()
            .getAction("RunTestsUsingPlatform")
            .actionPerformed(actionFor())

        assertEquals(PLATFORM, gradleProjectSettings.testRunner)
    }

    fun testCanUpdateTestRunnerToChoosePerTest() {
        assertEquals(GRADLE, gradleProjectSettings.testRunner)

        ActionManager.getInstance()
            .getAction("RunTestsUsingChoosePerTest")
            .actionPerformed(actionFor())

        assertEquals(CHOOSE_PER_TEST, gradleProjectSettings.testRunner)
    }

    fun testCanUpdateTestRunnerMultiple() {
        assertEquals(GRADLE, gradleProjectSettings.testRunner)

        ActionManager.getInstance()
            .getAction("RunTestsUsingPlatform")
            .actionPerformed(actionFor())

        assertEquals(PLATFORM, gradleProjectSettings.testRunner)

        ActionManager.getInstance()
            .getAction("RunTestsUsingChoosePerTest")
            .actionPerformed(actionFor())

        assertEquals(CHOOSE_PER_TEST, gradleProjectSettings.testRunner)

        ActionManager.getInstance()
            .getAction("RunTestsUsingGradle")
            .actionPerformed(actionFor())

        assertEquals(GRADLE, gradleProjectSettings.testRunner)
    }

    private fun actionFor(): AnActionEvent =
        AnActionEvent
            .createFromDataContext(
                /* place = */ "",
                /* presentation = */ null,
                /* dataContext = */ SimpleDataContext.getProjectContext(project)
            )
}
