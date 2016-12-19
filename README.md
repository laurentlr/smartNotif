# SmartNotifs
Progressive dev feedback
----------------------
1. If you use kotlin, use mock-kotlin for your mocks
2. Lint and retrolambda is not stable, you have to use a specific lombok lib (https://github.com/evant/gradle-retrolambda/issues/96)

PostFix CodeComplexion
----------------------

IntelliJ IDEA’s postfix code completion is now supported for Kotlin, with a large array of templates.
 Note that the feature depends on platform changes made in IntelliJ IDEA 2016.2 and is therefore unavailable in Android Studio 2.2;

Kotlin postfix code completion relies on platform changes in IntelliJ IDEA 2016.2.
 Android Studio 2.2 is based on IntelliJ IDEA 2016.1,
 which does not include those changes.
 
 Android studio 2.3 => Ok but broke IDE UT start
