## Gradle Settings Actions [![ci status][badge]][workflow]

[workflow]: https://github.com/tom-power/gradle-plugin-settings-actions/actions/workflows/gradle.yml
[badge]: https://img.shields.io/github/actions/workflow/status/tom-power/gradle-plugin-settings-actions/gradle.yml?style=flat-round&logo=github&label=CI%20status

Plugin providing actions to update the Jetbrains Gradle plugin settings, particularly which Test Runner to use.

To access open [Search everywhere](https://www.jetbrains.com/help/idea/searching-everywhere.html#find_action), and type `Run tests using` to see options, your settings should be updated and tests will use whichever one you selected.

You currently need to change these in settings, and it's something that I do reasonably regularly, so prefer an action. It's possibe that having options in separate actions, instead of in a [drop-down list](https://jetbrains.design/intellij/controls/drop_down/), isn't great UX but think that's ok.

![actions](https://github.com/tom-power/gradle-plugin-settings-actions/blob/main/assets/buildRunTestActions.png)

![settings](https://github.com/tom-power/gradle-plugin-settings-actions/blob/main/assets/buildRunTestSettings.png)
