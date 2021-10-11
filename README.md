# kotlin-inline-when-bug

This project replicates the issue introduced while upgrading to kotlin version 1.5.x

Run `./gradlew clean build` to get the error

# Steps to replicate

1. Create an inline function with using an `when` clause
2. Create a unit test that call that function
3. Run `./gradlew clean build`
4. Get a similar error to this:

```
org.gradle.api.internal.tasks.testing.TestSuiteExecutionException: Could not execute test class 'rp199.bug.InlineWhenBugKtTest$inline func should be testable$$inlined$inlineEnumWhen$1$wm$InlineWhenBugKt$WhenMappings'. at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:53)
at java.base@11.0.4/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at java.base@11.0.4/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at java.base@11.0.4/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.base@11.0.4/java.lang.reflect.Method.invoke(Method.java:566)
at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
at com.sun.proxy.$Proxy2.processTestClass(Unknown Source)
at org.gradle.api.internal.tasks.testing.worker.TestWorker$2.run(TestWorker.java:176)
at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:129)
at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:100)
at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:60)
at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56)
at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:133)
at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:71)
at app//worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69)
at app//worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74)
Caused by: java.lang.IncompatibleClassChangeError: rp199.bug.InlineWhenBugKt and rp199.bug.InlineWhenBugKtTest$inline func should be testable$$inlined$inlineEnumWhen$1$wm$InlineWhenBugKt$WhenMappings disagree on InnerClasses attribute at java.base/java.lang.Class.getDeclaringClass0(Native Method)
at java.base/java.lang.Class.getEnclosingClass(Class.java:1517)
at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.isInnerClass(JUnitPlatformTestClassProcessor.java:104)
at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.access$200(JUnitPlatformTestClassProcessor.java:54)
at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.execute(JUnitPlatformTestClassProcessor.java:90)
at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.execute(JUnitPlatformTestClassProcessor.java:79)
at org.gradle.api.internal.tasks.testing.junit.AbstractJUnitTestClassProcessor.processTestClass(AbstractJUnitTestClassProcessor.java:62)
at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:51)
... 18 more
```

The test runs successfully with the IntelliJ runner, even when using the gradlew behind the hood.