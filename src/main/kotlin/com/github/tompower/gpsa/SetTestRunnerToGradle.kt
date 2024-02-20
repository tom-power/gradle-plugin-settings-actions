package com.github.tompower.gpsa

import org.jetbrains.plugins.gradle.settings.TestRunner

class SetTestRunnerToGradle : SetTestRunner() {
    override val actionTestRunner: TestRunner = TestRunner.GRADLE
}