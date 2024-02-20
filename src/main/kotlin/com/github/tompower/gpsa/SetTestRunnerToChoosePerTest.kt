package com.github.tompower.gpsa

import org.jetbrains.plugins.gradle.settings.TestRunner

class SetTestRunnerToChoosePerTest : SetTestRunner() {
    override val actionTestRunner: TestRunner = TestRunner.CHOOSE_PER_TEST
}