package com.github.tompower.gpsa

import org.jetbrains.plugins.gradle.settings.TestRunner

class SetTestRunnerToPlatform : SetTestRunner() {
    override val actionTestRunner: TestRunner = TestRunner.PLATFORM
}