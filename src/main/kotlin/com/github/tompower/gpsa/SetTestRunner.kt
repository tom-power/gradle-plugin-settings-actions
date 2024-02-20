package com.github.tompower.gpsa

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.settings.GradleSettings
import org.jetbrains.plugins.gradle.settings.TestRunner

abstract class SetTestRunner : AnAction(), DumbAware {
    abstract val actionTestRunner: TestRunner

    override fun actionPerformed(actionEvent: AnActionEvent) {
        actionEvent.project!!.getService(GradleSettings::class.java).apply {
            linkedProjectsSettings = linkedProjectsSettings.withTestRunner()
        }
    }

    private fun Iterable<GradleProjectSettings>.withTestRunner(): List<GradleProjectSettings> =
        this.map { projectSettings ->
            projectSettings.apply {
                testRunner = actionTestRunner
            }
        }
}