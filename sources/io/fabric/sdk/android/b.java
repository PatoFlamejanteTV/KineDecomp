package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ActivityLifecycleManager.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private final Application f26833a;

    /* renamed from: b */
    private a f26834b;

    /* compiled from: ActivityLifecycleManager.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private final Set<Application.ActivityLifecycleCallbacks> f26835a = new HashSet();

        /* renamed from: b */
        private final Application f26836b;

        a(Application application) {
            this.f26836b = application;
        }

        @TargetApi(14)
        public void a() {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.f26835a.iterator();
            while (it.hasNext()) {
                this.f26836b.unregisterActivityLifecycleCallbacks(it.next());
            }
        }

        @TargetApi(14)
        public boolean a(AbstractC0152b abstractC0152b) {
            if (this.f26836b == null) {
                return false;
            }
            io.fabric.sdk.android.a aVar = new io.fabric.sdk.android.a(this, abstractC0152b);
            this.f26836b.registerActivityLifecycleCallbacks(aVar);
            this.f26835a.add(aVar);
            return true;
        }
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: io.fabric.sdk.android.b$b */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0152b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public abstract void onActivityStarted(Activity activity);

        public void onActivityStopped(Activity activity) {
        }
    }

    public b(Context context) {
        this.f26833a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f26834b = new a(this.f26833a);
        }
    }

    public boolean a(AbstractC0152b abstractC0152b) {
        a aVar = this.f26834b;
        return aVar != null && aVar.a(abstractC0152b);
    }

    public void a() {
        a aVar = this.f26834b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
