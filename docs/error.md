Executing tasks: [:app:assembleDebug] in project C:\Users\yogia\AndroidStudioProjects\PanjaluPDF

Calculating task graph as no cached configuration is available for tasks: :app:assembleDebug

> Configure project :app
> AGPBI: {"kind":"warning","text":"The option setting 'android.disallowKotlinSourceSets=false' is experimental.\nThe current default is 'true'.\nAdd android.sync.suppressAgpWarnings=UNSUPPORTED_PROJECT_OPTION_USE to the gradle.properties file to suppress this warning.","sources":[{}]}
> AGPBI: {"kind":"warning","text":"The option setting 'android.newDsl=false' is deprecated.\nThe current default is 'true'.\nIt will be removed in version 10.0 of the Android Gradle plugin.\nAdd android.sync.suppressAgpWarnings=UNSUPPORTED_PROJECT_OPTION_USE to the gradle.properties file to suppress this warning.","sources":[{}]}
> AGPBI: {"kind":"warning","text":"API 'applicationVariants' is obsolete and has been replaced with 'AndroidComponentsExtension'.\nIt will be removed in version 10.0 of the Android Gradle plugin.\nThe legacy variant API is disabled by default in AGP 9.0, but can be re-enabled by adding \n    android.newDsl=false\nto this project's gradle.properties file.\nFor more information, see http://developer.android.com/build/r/new-dsl.\n\nTo determine what is calling applicationVariants, use -Pandroid.debug.obsoleteApi=true on the command line to display more information.\nAdd android.sync.suppressAgpWarnings=DEPRECATED_DSL to the gradle.properties file to suppress this warning.","sources":[{}]}
> AGPBI: {"kind":"warning","text":"API 'testVariants' is obsolete and has been replaced with 'AndroidComponentsExtension'.\nIt will be removed in version 10.0 of the Android Gradle plugin.\nThe legacy variant API is disabled by default in AGP 9.0, but can be re-enabled by adding \n    android.newDsl=false\nto this project's gradle.properties file.\nFor more information, see http://developer.android.com/build/r/new-dsl.\n\nTo determine what is calling testVariants, use -Pandroid.debug.obsoleteApi=true on the command line to display more information.\nAdd android.sync.suppressAgpWarnings=DEPRECATED_DSL to the gradle.properties file to suppress this warning.","sources":[{}]}
> AGPBI: {"kind":"warning","text":"API 'unitTestVariants' is obsolete and has been replaced with 'AndroidComponentsExtension'.\nIt will be removed in version 10.0 of the Android Gradle plugin.\nThe legacy variant API is disabled by default in AGP 9.0, but can be re-enabled by adding \n    android.newDsl=false\nto this project's gradle.properties file.\nFor more information, see http://developer.android.com/build/r/new-dsl.\n\nTo determine what is calling unitTestVariants, use -Pandroid.debug.obsoleteApi=true on the command line to display more information.\nAdd android.sync.suppressAgpWarnings=DEPRECATED_DSL to the gradle.properties file to suppress this warning.","sources":[{}]}

> Task :app:generateDebugAssets UP-TO-DATE
> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:mergeDebugNativeDebugMetadata NO-SOURCE
> Task :app:createDebugCompatibleScreenManifests UP-TO-DATE
> Task :app:generateDebugGlobalSynthetics UP-TO-DATE
> Task :app:generateDebugResources UP-TO-DATE
> Task :app:writeDebugSigningConfigVersions UP-TO-DATE
> Task :app:writeDebugAppMetadata UP-TO-DATE
> Task :app:validateSigningDebug UP-TO-DATE
> Task :app:mapDebugSourceSetPaths UP-TO-DATE
> Task :app:extractDeepLinksDebug UP-TO-DATE
> Task :app:desugarDebugFileDependencies UP-TO-DATE
> Task :app:mergeDebugJniLibFolders UP-TO-DATE
> Task :app:packageDebugResources UP-TO-DATE
> Task :app:javaPreCompileDebug UP-TO-DATE
> Task :app:mergeDebugAssets UP-TO-DATE
> Task :app:compressDebugAssets
> Task :app:checkDebugDuplicateClasses UP-TO-DATE
> Task :app:processDebugNavigationResources UP-TO-DATE
> Task :app:checkDebugAarMetadata FAILED
> Task :app:mergeDebugResources UP-TO-DATE
> Task :app:mergeDebugNativeLibs UP-TO-DATE

> Task :app:stripDebugDebugSymbols
> Unable to strip the following libraries, packaging them as they are: libandroidx.graphics.path.so. Run with --info option to learn more.

> Task :app:compileDebugNavigationResources
> Task :app:parseDebugLocalResources
> Task :app:generateDebugRFile
> Task :app:processDebugMainManifest
> Task :app:processDebugManifest
> Task :app:processDebugManifestForPackage
> Task :app:mergeLibDexDebug
> Task :app:mergeExtDexDebug
> Task :app:kspDebugKotlin
> e: [ksp] java.lang.IllegalStateException: unexpected jvm signature V

> Task :app:kspDebugKotlin FAILED

FAILURE: Build completed with 2 failures.

1: Task failed with an exception.
---------------------------------

* What went wrong:
  Execution failed for task ':app:checkDebugAarMetadata' (registered by plugin 'com.android.internal.application').

> A failure occurred while executing com.android.build.gradle.internal.tasks.CheckAarMetadataWorkAction
> 4 issues were found when checking AAR metadata:

       1.  Dependency 'androidx.lifecycle:lifecycle-runtime-compose-android:2.11.0' requires libraries and applications that
           depend on it to compile against version 37 or later of the
           Android APIs.

           :app is currently compiled against android-36.1.

           Recommended action: Update this project to use a newer compileSdk
           of at least 37, for example 37.1.

           Note that updating a library or application's compileSdk (which
           allows newer APIs to be used) can be done separately from updating
           targetSdk (which opts the app in to new runtime behavior) and
           minSdk (which determines which devices the app can be installed
           on).

       2.  Dependency 'androidx.core:core-ktx:1.19.0' requires libraries and applications that
           depend on it to compile against version 37 or later of the
           Android APIs.

           :app is currently compiled against android-36.1.

           Recommended action: Update this project to use a newer compileSdk
           of at least 37, for example 37.1.

           Note that updating a library or application's compileSdk (which
           allows newer APIs to be used) can be done separately from updating
           targetSdk (which opts the app in to new runtime behavior) and
           minSdk (which determines which devices the app can be installed
           on).

       3.  Dependency 'androidx.core:core:1.19.0' requires libraries and applications that
           depend on it to compile against version 37 or later of the
           Android APIs.

           :app is currently compiled against android-36.1.

           Recommended action: Update this project to use a newer compileSdk
           of at least 37, for example 37.1.

           Note that updating a library or application's compileSdk (which
           allows newer APIs to be used) can be done separately from updating
           targetSdk (which opts the app in to new runtime behavior) and
           minSdk (which determines which devices the app can be installed
           on).

       4.  Dependency 'androidx.lifecycle:lifecycle-viewmodel-compose-android:2.11.0' requires libraries and applications that
           depend on it to compile against version 37 or later of the
           Android APIs.

           :app is currently compiled against android-36.1.

           Recommended action: Update this project to use a newer compileSdk
           of at least 37, for example 37.1.

           Note that updating a library or application's compileSdk (which
           allows newer APIs to be used) can be done separately from updating
           targetSdk (which opts the app in to new runtime behavior) and
           minSdk (which determines which devices the app can be installed
           on).

* Try:

> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

* Exception is:
  org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':app:checkDebugAarMetadata' (registered by plugin 'com.android.internal.application').
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:135)
  at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:288)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:133)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:121)
  at org.gradle.api.internal.tasks.execution.ProblemsTaskPathTrackingTaskExecuter.execute(ProblemsTaskPathTrackingTaskExecuter.java:41)
  at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
  at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
  at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
  at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:74)
  at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
  at org.gradle.execution.plan.DefaultNodeExecutor.executeLocalTaskNode(DefaultNodeExecutor.java:55)
  at org.gradle.execution.plan.DefaultNodeExecutor.execute(DefaultNodeExecutor.java:34)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:355)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:343)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.lambda$execute$0(DefaultTaskExecutionGraph.java:339)
  at org.gradle.internal.operations.CurrentBuildOperationRef.with(CurrentBuildOperationRef.java:84)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:339)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:328)
  at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:459)
  at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:376)
  at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
  at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
  Caused by: org.gradle.workers.internal.DefaultWorkerExecutor$WorkExecutionException: A failure occurred while executing com.android.build.gradle.internal.tasks.CheckAarMetadataWorkAction
  at org.gradle.workers.internal.DefaultWorkerExecutor$WorkItemExecution.waitForCompletion(DefaultWorkerExecutor.java:278)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.lambda$waitForItemsAndGatherFailures$2(DefaultAsyncWorkTracker.java:132)
  at org.gradle.internal.Factories$1.create(Factories.java:30)
  at org.gradle.internal.work.DefaultWorkerLeaseService.lambda$withoutLocksBlocking$3(DefaultWorkerLeaseService.java:390)
  at org.gradle.internal.work.ResourceLockStatistics$1.measure(ResourceLockStatistics.java:43)
  at org.gradle.internal.work.DefaultWorkerLeaseService.withoutLocksBlocking(DefaultWorkerLeaseService.java:385)
  at org.gradle.internal.work.DefaultWorkerLeaseService.blocking(DefaultWorkerLeaseService.java:239)
  at org.gradle.internal.work.DefaultWorkerLeaseService.blocking(DefaultWorkerLeaseService.java:221)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.lambda$waitForItemsAndGatherFailures$3(DefaultAsyncWorkTracker.java:128)
  at org.gradle.internal.Factories$1.create(Factories.java:30)
  at org.gradle.internal.resources.AbstractResourceLockRegistry.whileDisallowingLockChanges(AbstractResourceLockRegistry.java:50)
  at org.gradle.internal.work.DefaultWorkerLeaseService.whileDisallowingProjectLockChanges(DefaultWorkerLeaseService.java:244)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForItemsAndGatherFailures(DefaultAsyncWorkTracker.java:127)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForItemsAndGatherFailures(DefaultAsyncWorkTracker.java:93)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForAll(DefaultAsyncWorkTracker.java:79)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForCompletion(DefaultAsyncWorkTracker.java:67)
  at org.gradle.api.internal.tasks.execution.TaskExecution$3.run(TaskExecution.java:267)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:30)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:27)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.run(DefaultBuildOperationRunner.java:48)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeAction(TaskExecution.java:244)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeActions(TaskExecution.java:227)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeWithPreviousOutputFiles(TaskExecution.java:210)
  at org.gradle.api.internal.tasks.execution.TaskExecution.execute(TaskExecution.java:176)
  at org.gradle.internal.execution.steps.ExecuteStep.executeInternal(ExecuteStep.java:167)
  at org.gradle.internal.execution.steps.ExecuteStep.access$000(ExecuteStep.java:47)
  at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:137)
  at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:134)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
  at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:134)
  at org.gradle.internal.execution.steps.ExecuteStep$Mutable.execute(ExecuteStep.java:80)
  at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:42)
  at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:75)
  at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:55)
  at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:51)
  at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:29)
  at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:67)
  at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:39)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:42)
  at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:24)
  at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:69)
  at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:46)
  at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:39)
  at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:28)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.BuildCacheStep.executeWithoutCache(BuildCacheStep.java:189)
  at org.gradle.internal.execution.steps.BuildCacheStep.lambda$execute$1(BuildCacheStep.java:76)
  at org.gradle.internal.Either$Right.fold(Either.java:176)
  at org.gradle.internal.execution.caching.CachingState.fold(CachingState.java:62)
  at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:74)
  at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:49)
  at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:46)
  at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:35)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:75)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$2(SkipUpToDateStep.java:53)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:53)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:35)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:37)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:27)
  at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:70)
  at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:32)
  at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:69)
  at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:37)
  at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:63)
  at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:34)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:79)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:65)
  at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:99)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.execute(ValidateStep.java:65)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.executeMutable(CaptureMutableStateBeforeExecutionStep.java:86)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:65)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:45)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeWithNonEmptySources(SkipEmptyMutableWorkStep.java:210)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:85)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:53)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsStartedStep.execute(MarkSnapshottingInputsStartedStep.java:38)
  at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:36)
  at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:23)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:77)
  at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:43)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.lambda$executeMutable$0(AssignMutableWorkspaceStep.java:34)
  at org.gradle.api.internal.tasks.execution.TaskExecution$4.withWorkspace(TaskExecution.java:305)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:30)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:21)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:40)
  at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:23)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.lambda$execute$2(ExecuteWorkBuildOperationFiringStep.java:67)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:67)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:39)
  at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:46)
  at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:34)
  at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:56)
  at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:38)
  at org.gradle.internal.execution.impl.DefaultExecutionEngine$1.execute(DefaultExecutionEngine.java:68)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:132)
  ... 30 more
  Caused by: java.lang.RuntimeException: 4 issues were found when checking AAR metadata:

  1. Dependency 'androidx.lifecycle:lifecycle-runtime-compose-android:2.11.0' requires libraries and applications that
     depend on it to compile against version 37 or later of the
     Android APIs.

     :app is currently compiled against android-36.1.

     Recommended action: Update this project to use a newer compileSdk
     of at least 37, for example 37.1.

     Note that updating a library or application's compileSdk (which
     allows newer APIs to be used) can be done separately from updating
     targetSdk (which opts the app in to new runtime behavior) and
     minSdk (which determines which devices the app can be installed
     on).
  2. Dependency 'androidx.core:core-ktx:1.19.0' requires libraries and applications that
     depend on it to compile against version 37 or later of the
     Android APIs.

     :app is currently compiled against android-36.1.

     Recommended action: Update this project to use a newer compileSdk
     of at least 37, for example 37.1.

     Note that updating a library or application's compileSdk (which
     allows newer APIs to be used) can be done separately from updating
     targetSdk (which opts the app in to new runtime behavior) and
     minSdk (which determines which devices the app can be installed
     on).
  3. Dependency 'androidx.core:core:1.19.0' requires libraries and applications that
     depend on it to compile against version 37 or later of the
     Android APIs.

     :app is currently compiled against android-36.1.

     Recommended action: Update this project to use a newer compileSdk
     of at least 37, for example 37.1.

     Note that updating a library or application's compileSdk (which
     allows newer APIs to be used) can be done separately from updating
     targetSdk (which opts the app in to new runtime behavior) and
     minSdk (which determines which devices the app can be installed
     on).
  4. Dependency 'androidx.lifecycle:lifecycle-viewmodel-compose-android:2.11.0' requires libraries and applications that
     depend on it to compile against version 37 or later of the
     Android APIs.

     :app is currently compiled against android-36.1.

     Recommended action: Update this project to use a newer compileSdk
     of at least 37, for example 37.1.

     Note that updating a library or application's compileSdk (which
     allows newer APIs to be used) can be done separately from updating
     targetSdk (which opts the app in to new runtime behavior) and
     minSdk (which determines which devices the app can be installed
     on).
     at com.android.build.gradle.internal.tasks.CheckAarMetadataWorkAction.execute(CheckAarMetadataTask.kt:251)
     at org.gradle.workers.internal.DefaultWorkerServer.execute(DefaultWorkerServer.java:68)
     at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:64)
     at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:61)
     at org.gradle.internal.classloader.ClassLoaderUtils.executeInClassloader(ClassLoaderUtils.java:102)
     at org.gradle.workers.internal.NoIsolationWorkerFactory$1.lambda$execute$0(NoIsolationWorkerFactory.java:61)
     at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:44)
     at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:41)
     at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
     at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
     at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
     at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
     at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
     at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
     at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
     at org.gradle.workers.internal.AbstractWorker.executeWrappedInBuildOperation(AbstractWorker.java:41)
     at org.gradle.workers.internal.NoIsolationWorkerFactory$1.execute(NoIsolationWorkerFactory.java:58)
     at org.gradle.workers.internal.DefaultWorkerExecutor.lambda$submitWork$0(DefaultWorkerExecutor.java:174)
     at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runExecution(DefaultConditionalExecutionQueue.java:191)
     at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.access$500(DefaultConditionalExecutionQueue.java:112)
     at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner$1.run(DefaultConditionalExecutionQueue.java:168)
     at org.gradle.internal.Factories$1.create(Factories.java:30)
     at org.gradle.internal.work.DefaultWorkerLeaseService.lambda$withLocksAcquired$0(DefaultWorkerLeaseService.java:280)
     at org.gradle.internal.work.ResourceLockStatistics$1.measure(ResourceLockStatistics.java:43)
     at org.gradle.internal.work.DefaultWorkerLeaseService.withLocksAcquired(DefaultWorkerLeaseService.java:278)
     at org.gradle.internal.work.DefaultWorkerLeaseService.withLocks(DefaultWorkerLeaseService.java:270)
     at org.gradle.internal.work.DefaultWorkerLeaseService.runAsWorkerThread(DefaultWorkerLeaseService.java:129)
     at org.gradle.internal.work.DefaultWorkerLeaseService.runAsWorkerThread(DefaultWorkerLeaseService.java:134)
     at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runBatch(DefaultConditionalExecutionQueue.java:163)
     at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.run(DefaultConditionalExecutionQueue.java:125)
     ... 2 more

==============================================================================

2: Task failed with an exception.
---------------------------------

* What went wrong:
  Execution failed for task ':app:kspDebugKotlin' (registered by plugin 'com.android.internal.application').

> A failure occurred while executing com.google.devtools.ksp.gradle.KspAAWorkerAction
> unexpected jvm signature V

* Try:

> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

* Exception is:
  org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':app:kspDebugKotlin' (registered by plugin 'com.android.internal.application').
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:135)
  at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:288)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:133)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:121)
  at org.gradle.api.internal.tasks.execution.ProblemsTaskPathTrackingTaskExecuter.execute(ProblemsTaskPathTrackingTaskExecuter.java:41)
  at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
  at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
  at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
  at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:74)
  at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
  at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
  at org.gradle.execution.plan.DefaultNodeExecutor.executeLocalTaskNode(DefaultNodeExecutor.java:55)
  at org.gradle.execution.plan.DefaultNodeExecutor.execute(DefaultNodeExecutor.java:34)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:355)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:343)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.lambda$execute$0(DefaultTaskExecutionGraph.java:339)
  at org.gradle.internal.operations.CurrentBuildOperationRef.with(CurrentBuildOperationRef.java:84)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:339)
  at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:328)
  at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:459)
  at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:376)
  at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
  at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
  at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
  at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
  at java.base/java.lang.Thread.run(Unknown Source)
  Caused by: org.gradle.workers.internal.DefaultWorkerExecutor$WorkExecutionException: A failure occurred while executing com.google.devtools.ksp.gradle.KspAAWorkerAction
  at org.gradle.workers.internal.DefaultWorkerExecutor$WorkItemExecution.waitForCompletion(DefaultWorkerExecutor.java:278)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.lambda$waitForItemsAndGatherFailures$2(DefaultAsyncWorkTracker.java:132)
  at org.gradle.internal.Factories$1.create(Factories.java:30)
  at org.gradle.internal.work.DefaultWorkerLeaseService.lambda$withoutLocksBlocking$3(DefaultWorkerLeaseService.java:390)
  at org.gradle.internal.work.ResourceLockStatistics$1.measure(ResourceLockStatistics.java:43)
  at org.gradle.internal.work.DefaultWorkerLeaseService.withoutLocksBlocking(DefaultWorkerLeaseService.java:385)
  at org.gradle.internal.work.DefaultWorkerLeaseService.blocking(DefaultWorkerLeaseService.java:239)
  at org.gradle.internal.work.DefaultWorkerLeaseService.blocking(DefaultWorkerLeaseService.java:221)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.lambda$waitForItemsAndGatherFailures$3(DefaultAsyncWorkTracker.java:128)
  at org.gradle.internal.Factories$1.create(Factories.java:30)
  at org.gradle.internal.resources.AbstractResourceLockRegistry.whileDisallowingLockChanges(AbstractResourceLockRegistry.java:50)
  at org.gradle.internal.work.DefaultWorkerLeaseService.whileDisallowingProjectLockChanges(DefaultWorkerLeaseService.java:244)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForItemsAndGatherFailures(DefaultAsyncWorkTracker.java:127)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForItemsAndGatherFailures(DefaultAsyncWorkTracker.java:93)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForAll(DefaultAsyncWorkTracker.java:79)
  at org.gradle.internal.work.DefaultAsyncWorkTracker.waitForCompletion(DefaultAsyncWorkTracker.java:67)
  at org.gradle.api.internal.tasks.execution.TaskExecution$3.run(TaskExecution.java:267)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:30)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:27)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.run(DefaultBuildOperationRunner.java:48)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeAction(TaskExecution.java:244)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeActions(TaskExecution.java:227)
  at org.gradle.api.internal.tasks.execution.TaskExecution.executeWithPreviousOutputFiles(TaskExecution.java:210)
  at org.gradle.api.internal.tasks.execution.TaskExecution.execute(TaskExecution.java:176)
  at org.gradle.internal.execution.steps.ExecuteStep.executeInternal(ExecuteStep.java:167)
  at org.gradle.internal.execution.steps.ExecuteStep.access$000(ExecuteStep.java:47)
  at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:137)
  at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:134)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
  at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:134)
  at org.gradle.internal.execution.steps.ExecuteStep$Mutable.execute(ExecuteStep.java:80)
  at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:42)
  at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:75)
  at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:55)
  at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:51)
  at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:29)
  at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:67)
  at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:39)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:42)
  at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:24)
  at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:69)
  at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:46)
  at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:39)
  at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:28)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.BuildCacheStep.executeWithoutCache(BuildCacheStep.java:189)
  at org.gradle.internal.execution.steps.BuildCacheStep.lambda$execute$1(BuildCacheStep.java:76)
  at org.gradle.internal.Either$Right.fold(Either.java:176)
  at org.gradle.internal.execution.caching.CachingState.fold(CachingState.java:62)
  at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:74)
  at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:49)
  at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:46)
  at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:35)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:75)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$2(SkipUpToDateStep.java:53)
  at java.base/java.util.Optional.orElseGet(Unknown Source)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:53)
  at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:35)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:37)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:27)
  at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:70)
  at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:32)
  at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:69)
  at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:37)
  at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:63)
  at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:34)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:79)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:65)
  at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:99)
  at org.gradle.internal.execution.steps.ValidateStep$Mutable.execute(ValidateStep.java:65)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.executeMutable(CaptureMutableStateBeforeExecutionStep.java:86)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:65)
  at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:45)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeWithNonEmptySources(SkipEmptyMutableWorkStep.java:210)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:90)
  at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:53)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsStartedStep.execute(MarkSnapshottingInputsStartedStep.java:38)
  at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:36)
  at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:23)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:77)
  at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:43)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.lambda$executeMutable$0(AssignMutableWorkspaceStep.java:34)
  at org.gradle.api.internal.tasks.execution.TaskExecution$4.withWorkspace(TaskExecution.java:305)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:30)
  at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:21)
  at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
  at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:40)
  at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:23)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.lambda$execute$2(ExecuteWorkBuildOperationFiringStep.java:67)
  at java.base/java.util.Optional.orElseGet(Unknown Source)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:67)
  at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:39)
  at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:46)
  at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:34)
  at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:56)
  at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:38)
  at org.gradle.internal.execution.impl.DefaultExecutionEngine$1.execute(DefaultExecutionEngine.java:68)
  at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:132)
  ... 33 more
  Caused by: java.lang.IllegalStateException: unexpected jvm signature V
  at androidx.room.compiler.processing.javac.kotlin.JvmDescriptorUtilsKt.typeNameFromJvmSignature(JvmDescriptorUtils.kt:105)
  at androidx.room.compiler.processing.ksp.KSTypeJavaPoetExtKt.asJTypeName(KSTypeJavaPoetExt.kt:110)
  at androidx.room.compiler.processing.ksp.KSTypeJavaPoetExtKt.asJTypeName(KSTypeJavaPoetExt.kt:194)
  at androidx.room.compiler.processing.ksp.KSTypeJavaPoetExtKt.asJTypeName(KSTypeJavaPoetExt.kt:170)
  at androidx.room.compiler.processing.ksp.DefaultKspType.resolveJTypeName(DefaultKspType.kt:36)
  at androidx.room.compiler.processing.ksp.KspType$xTypeName$2.invoke(KspType.kt:85)
  at androidx.room.compiler.processing.ksp.KspType$xTypeName$2.invoke(KspType.kt:73)
  at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:86)
  at androidx.room.compiler.processing.ksp.KspType.getXTypeName(KspType.kt:73)
  at androidx.room.compiler.processing.ksp.KspType.asTypeName(KspType.kt:67)
  at androidx.room.compiler.processing.ksp.KspRawType$xTypeName$2.invoke(KspRawType.kt:36)
  at androidx.room.compiler.processing.ksp.KspRawType$xTypeName$2.invoke(KspRawType.kt:34)
  at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:86)
  at androidx.room.compiler.processing.ksp.KspRawType.getXTypeName(KspRawType.kt:34)
  at androidx.room.compiler.processing.ksp.KspRawType.access$getXTypeName(KspRawType.kt:23)
  at androidx.room.compiler.processing.ksp.KspRawType$typeName$2.invoke(KspRawType.kt:31)
  at androidx.room.compiler.processing.ksp.KspRawType$typeName$2.invoke(KspRawType.kt:30)
  at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:86)
  at androidx.room.compiler.processing.ksp.KspRawType.getTypeName(KspRawType.kt:30)
  at androidx.room.processor.ShortcutMethodProcessor.extractReturnType(ShortcutMethodProcessor.kt:52)
  at androidx.room.processor.DeletionMethodProcessor.process(DeletionMethodProcessor.kt:35)
  at androidx.room.processor.DaoProcessor.process(DaoProcessor.kt:158)
  at androidx.room.processor.DatabaseProcessor$doProcess$daoMethods$3.invoke(DatabaseProcessor.kt:122)
  at androidx.room.processor.DatabaseProcessor$doProcess$daoMethods$3.invoke(DatabaseProcessor.kt:96)
  at kotlin.sequences.TransformingSequence$iterator$1.next(Sequences.kt:243)
  at kotlin.sequences.FilteringSequence$iterator$1.calcNext(Sequences.kt:203)
  at kotlin.sequences.FilteringSequence$iterator$1.hasNext(Sequences.kt:227)
  at kotlin.sequences.SequencesKt___SequencesKt.toList(_Sequences.kt:817)
  at androidx.room.processor.DatabaseProcessor.doProcess(DatabaseProcessor.kt:125)
  at androidx.room.processor.DatabaseProcessor.process(DatabaseProcessor.kt:60)
  at androidx.room.DatabaseProcessingStep$process$databases$1$1.invoke(DatabaseProcessingStep.kt:68)
  at androidx.room.DatabaseProcessingStep$process$databases$1$1.invoke(DatabaseProcessingStep.kt:64)
  at androidx.room.processor.Context.collectLogs(Context.kt:192)
  at androidx.room.DatabaseProcessingStep.process(DatabaseProcessingStep.kt:64)
  at androidx.room.compiler.processing.CommonProcessorDelegate.processRound(XBasicAnnotationProcessor.kt:130)
  at androidx.room.compiler.processing.ksp.KspBasicAnnotationProcessor.process(KspBasicAnnotationProcessor.kt:62)
  at com.google.devtools.ksp.impl.KotlinSymbolProcessing$execute$1$1.invoke(KotlinSymbolProcessing.kt:562)
  at com.google.devtools.ksp.impl.KotlinSymbolProcessing$execute$1$1.invoke(KotlinSymbolProcessing.kt:560)
  at ksp.com.google.devtools.ksp.common.IncrementalContextBase.closeFilesOnException(IncrementalContextBase.kt:400)
  at com.google.devtools.ksp.impl.KotlinSymbolProcessing.execute(KotlinSymbolProcessing.kt:560)
  at com.google.devtools.ksp.impl.KSPLoader$Companion.loadAndRunKSP(KSPLoader.kt:37)
  at com.google.devtools.ksp.impl.KSPLoader.loadAndRunKSP(KSPLoader.kt)
  at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(Unknown Source)
  at java.base/java.lang.reflect.Method.invoke(Unknown Source)
  at com.google.devtools.ksp.gradle.KspAAWorkerAction.execute(KspAATask.kt:628)
  at org.gradle.workers.internal.DefaultWorkerServer.execute(DefaultWorkerServer.java:68)
  at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:64)
  at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:61)
  at org.gradle.internal.classloader.ClassLoaderUtils.executeInClassloader(ClassLoaderUtils.java:102)
  at org.gradle.workers.internal.NoIsolationWorkerFactory$1.lambda$execute$0(NoIsolationWorkerFactory.java:61)
  at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:44)
  at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:41)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
  at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
  at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
  at org.gradle.workers.internal.AbstractWorker.executeWrappedInBuildOperation(AbstractWorker.java:41)
  at org.gradle.workers.internal.NoIsolationWorkerFactory$1.execute(NoIsolationWorkerFactory.java:58)
  at org.gradle.workers.internal.DefaultWorkerExecutor.lambda$submitWork$0(DefaultWorkerExecutor.java:174)
  at java.base/java.util.concurrent.FutureTask.run(Unknown Source)
  at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runExecution(DefaultConditionalExecutionQueue.java:191)
  at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.access$500(DefaultConditionalExecutionQueue.java:112)
  at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner$1.run(DefaultConditionalExecutionQueue.java:168)
  at org.gradle.internal.Factories$1.create(Factories.java:30)
  at org.gradle.internal.work.DefaultWorkerLeaseService.lambda$withLocksAcquired$0(DefaultWorkerLeaseService.java:280)
  at org.gradle.internal.work.ResourceLockStatistics$1.measure(ResourceLockStatistics.java:43)
  at org.gradle.internal.work.DefaultWorkerLeaseService.withLocksAcquired(DefaultWorkerLeaseService.java:278)
  at org.gradle.internal.work.DefaultWorkerLeaseService.withLocks(DefaultWorkerLeaseService.java:270)
  at org.gradle.internal.work.DefaultWorkerLeaseService.runAsWorkerThread(DefaultWorkerLeaseService.java:129)
  at org.gradle.internal.work.DefaultWorkerLeaseService.runAsWorkerThread(DefaultWorkerLeaseService.java:134)
  at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runBatch(DefaultConditionalExecutionQueue.java:163)
  at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.run(DefaultConditionalExecutionQueue.java:125)
  at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Unknown Source)
  at java.base/java.util.concurrent.FutureTask.run(Unknown Source)
  ... 5 more

==============================================================================

BUILD FAILED in 1m 43s
29 actionable tasks: 12 executed, 17 up-to-date
Configuration cache entry stored.
