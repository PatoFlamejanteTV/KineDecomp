package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
/* loaded from: classes.dex */
public class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final b.AbstractC0152b callbacks = new b.AbstractC0152b() { // from class: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1

        /* renamed from: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController$1$1 */
        /* loaded from: classes.dex */
        class RunnableC00591 implements Runnable {
            RunnableC00591() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        AnonymousClass1() {
        }

        @Override // io.fabric.sdk.android.b.AbstractC0152b
        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady()) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new Runnable() { // from class: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1.1
                    RunnableC00591() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
                    }
                });
            }
        }
    };
    private final ExecutorService executorService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends b.AbstractC0152b {

        /* renamed from: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController$1$1 */
        /* loaded from: classes.dex */
        class RunnableC00591 implements Runnable {
            RunnableC00591() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        AnonymousClass1() {
        }

        @Override // io.fabric.sdk.android.b.AbstractC0152b
        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady()) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new Runnable() { // from class: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1.1
                    RunnableC00591() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
                    }
                });
            }
        }
    }

    public ActivityLifecycleCheckForUpdatesController(b bVar, ExecutorService executorService) {
        this.executorService = executorService;
        bVar.a(this.callbacks);
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    public boolean isActivityLifecycleTriggered() {
        return true;
    }
}
