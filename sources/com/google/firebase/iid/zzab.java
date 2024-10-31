package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzab {

    /* renamed from: a, reason: collision with root package name */
    private static zzab f17403a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f17404b;

    /* renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f17405c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnectionC1605b f17406d = new ServiceConnectionC1605b(this);

    /* renamed from: e, reason: collision with root package name */
    private int f17407e = 1;

    private zzab(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f17405c = scheduledExecutorService;
        this.f17404b = context.getApplicationContext();
    }

    public static synchronized zzab a(Context context) {
        zzab zzabVar;
        synchronized (zzab.class) {
            if (f17403a == null) {
                f17403a = new zzab(context, Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("MessengerIpcClient")));
            }
            zzabVar = f17403a;
        }
        return zzabVar;
    }

    public final Task<Bundle> b(int i, Bundle bundle) {
        return a(new C1613j(a(), 1, bundle));
    }

    public final Task<Void> a(int i, Bundle bundle) {
        return a(new C1611h(a(), 2, bundle));
    }

    private final synchronized <T> Task<T> a(AbstractC1612i<T> abstractC1612i) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(abstractC1612i);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f17406d.a(abstractC1612i)) {
            this.f17406d = new ServiceConnectionC1605b(this);
            this.f17406d.a(abstractC1612i);
        }
        return abstractC1612i.f17357b.a();
    }

    private final synchronized int a() {
        int i;
        i = this.f17407e;
        this.f17407e = i + 1;
        return i;
    }
}
