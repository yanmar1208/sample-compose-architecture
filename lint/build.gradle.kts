@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java-library")
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // 以下二つのライブラリのバージョンは、Android Gradle Pluginのメジャーバージョンに23を足した値を指定すること
    // e.g. AGP: 8.0.0 -> 31.0.0
    // https://github.com/googlesamples/android-custom-lint-rules#lint-version
    compileOnly(libs.lint.api)
    compileOnly(libs.lint.checks)
}