package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.internal.ActivityLifecycleListener;
import com.google.firebase.storage.internal.SmartHandler;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class v<TListenerType, TResult extends StorageTask.ProvideError> {

    /* renamed from: a */
    private final Queue<TListenerType> f18201a = new ConcurrentLinkedQueue();

    /* renamed from: b */
    private final HashMap<TListenerType, SmartHandler> f18202b = new HashMap<>();

    /* renamed from: c */
    private StorageTask<TResult> f18203c;

    /* renamed from: d */
    private int f18204d;

    /* renamed from: e */
    private a<TListenerType, TResult> f18205e;

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface a<TListenerType, TResult> {
        void a(TListenerType tlistenertype, TResult tresult);
    }

    @PublicApi
    public v(StorageTask<TResult> storageTask, int i, a<TListenerType, TResult> aVar) {
        this.f18203c = storageTask;
        this.f18204d = i;
        this.f18205e = aVar;
    }

    @PublicApi
    public void a(Activity activity, Executor executor, TListenerType tlistenertype) {
        boolean z;
        SmartHandler smartHandler;
        Preconditions.a(tlistenertype);
        synchronized (this.f18203c.i()) {
            boolean z2 = true;
            z = (this.f18203c.f() & this.f18204d) != 0;
            this.f18201a.add(tlistenertype);
            smartHandler = new SmartHandler(executor);
            this.f18202b.put(tlistenertype, smartHandler);
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed()) {
                        z2 = false;
                    }
                    Preconditions.a(z2, "Activity is already destroyed!");
                }
                ActivityLifecycleListener.a().a(activity, tlistenertype, s.a(this, tlistenertype));
            }
        }
        if (z) {
            smartHandler.a(t.a(this, tlistenertype, this.f18203c.t()));
        }
    }

    @PublicApi
    public void a() {
        if ((this.f18203c.f() & this.f18204d) != 0) {
            TResult t = this.f18203c.t();
            for (TListenerType tlistenertype : this.f18201a) {
                SmartHandler smartHandler = this.f18202b.get(tlistenertype);
                if (smartHandler != null) {
                    smartHandler.a(u.a(this, tlistenertype, t));
                }
            }
        }
    }

    @PublicApi
    public void a(TListenerType tlistenertype) {
        Preconditions.a(tlistenertype);
        synchronized (this.f18203c.i()) {
            this.f18202b.remove(tlistenertype);
            this.f18201a.remove(tlistenertype);
            ActivityLifecycleListener.a().a(tlistenertype);
        }
    }
}
