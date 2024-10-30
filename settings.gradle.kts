pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MonobankCloneApp"
include(":app")
include(":core:data")
include(":feature:homescreen")
include(":core:database")
include(":core:datastore")
include(":core:common")
include(":core:designsystem")
include(":core:datastore-proto")
include(":core:domain")
include(":core:model")
include(":core:network")
