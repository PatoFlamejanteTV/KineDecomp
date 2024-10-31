package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class ActivityLifecycleListener {

    /* renamed from: a */
    private static final ActivityLifecycleListener f18150a = new ActivityLifecycleListener();

    /* renamed from: b */
    private final Map<Object, a> f18151b = new HashMap();

    /* renamed from: c */
    private final Object f18152c = new Object();

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private final Activity f18153a;

        /* renamed from: b */
        private final Runnable f18154b;

        /* renamed from: c */
        private final Object f18155c;

        public a(Activity activity, Runnable runnable, Object obj) {
            this.f18153a = activity;
            this.f18154b = runnable;
            this.f18155c = obj;
        }

        public Activity a() {
            return this.f18153a;
        }

        public Object b() {
            return this.f18155c;
        }

        public Runnable c() {
            return this.f18154b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.f18155c.equals(this.f18155c) && aVar.f18154b == this.f18154b && aVar.f18153a == this.f18153a;
        }

        public int hashCode() {
            return this.f18155c.hashCode();
        }
    }

    private ActivityLifecycleListener() {
    }

    public static ActivityLifecycleListener a() {
        return f18150a;
    }

    public void a(Activity activity, Object obj, Runnable runnable) {
        synchronized (this.f18152c) {
            a aVar = new a(activity, runnable, obj);
            b.b(activity).a(aVar);
            this.f18151b.put(obj, aVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class b extends LifecycleCallback {

        /* renamed from: b */
        private final List<a> f18156b;

        private b(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.f18156b = new ArrayList();
            this.f10774a.a("StorageOnStopCallback", this);
        }

        public static b b(Activity activity) {
            LifecycleFragment a2 = LifecycleCallback.a(new LifecycleActivity(activity));
            b bVar = (b) a2.a("StorageOnStopCallback", b.class);
            return bVar == null ? new b(a2) : bVar;
        }

        public void a(a aVar) {
            synchronized (this.f18156b) {
                this.f18156b.add(aVar);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void e() {
            ArrayList arrayList;
            synchronized (this.f18156b) {
                arrayList = new ArrayList(this.f18156b);
                this.f18156b.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    Log.d("StorageOnStopCallback", "removing subscription from activity.");
                    aVar.c().run();
                    ActivityLifecycleListener.a().a(aVar.b());
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f18156b) {
                this.f18156b.remove(aVar);
            }
        }
    }

    public void a(Object obj) {
        synchronized (this.f18152c) {
            a aVar = this.f18151b.get(obj);
            if (aVar != null) {
                b.b(aVar.a()).b(aVar);
            }
        }
    }
}
