object Libs {
    const val kotlinVersion = "1.3.72"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.0-beta-3"

    const val ktlint = "com.github.shyiko:ktlint:0.31.0"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val material = "com.google.android.material:material:1.1.0-beta01"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.2.0"
            const val fragment = "androidx.fragment:fragment-ktx:1.2.4"
            const val activity = "androidx.activity:activity-ktx:1.1.0"
            const val preferences = "androidx.preference:preference-ktx:1.1.0"
            const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"

            object Navigaiton {
                private const val version = "2.2.0-rc03"
                const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
                const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            }

            object LifeCycle {
                private const val lifeCycleVersion = "2.2.0-rc03"
                const val lifeCycle = "androidx.lifecycle:lifecycle-extensions:$lifeCycleVersion"
                const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion"
                const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
                const val test = "androidx.arch.core:core-testing:$lifeCycleVersion"
            }
        }
    }

    object Dagger {
        private const val daggerVersion = "2.25.2"
        const val core = "com.google.dagger:dagger:$daggerVersion"
        const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Coroutines {
        private const val version = "1.3.3"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }
}