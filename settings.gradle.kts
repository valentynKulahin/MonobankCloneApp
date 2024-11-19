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
include(":core:database")
include(":core:datastore")
include(":core:common")
include(":core:designsystem")
include(":core:datastore-proto")
include(":core:domain")
include(":core:network")

include(":ui:dashboard")
include(":ui:credits")
include(":ui:savings")
include(":ui:cashback")
include(":ui:more")
include(":core:models")
include(":feature:auth")
include(":feature:transfermoney")
include(":feature:depositmoney")
include(":feature:expensemoney")
include(":feature:accountInfo")
include(":feature:accountsettings")
