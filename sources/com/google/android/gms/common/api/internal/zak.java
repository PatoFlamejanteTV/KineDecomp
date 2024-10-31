package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zak {

    /* renamed from: d, reason: collision with root package name */
    private int f10947d;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<zai<?>, String> f10945b = new ArrayMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource<Map<zai<?>, String>> f10946c = new TaskCompletionSource<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f10948e = false;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<zai<?>, ConnectionResult> f10944a = new ArrayMap<>();

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        Iterator<? extends GoogleApi<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.f10944a.put(it.next().zak(), null);
        }
        this.f10947d = this.f10944a.keySet().size();
    }

    public final Task<Map<zai<?>, String>> a() {
        return this.f10946c.a();
    }

    public final Set<zai<?>> b() {
        return this.f10944a.keySet();
    }

    public final void a(zai<?> zaiVar, ConnectionResult connectionResult, String str) {
        this.f10944a.put(zaiVar, connectionResult);
        this.f10945b.put(zaiVar, str);
        this.f10947d--;
        if (!connectionResult.R()) {
            this.f10948e = true;
        }
        if (this.f10947d == 0) {
            if (this.f10948e) {
                this.f10946c.a(new AvailabilityException(this.f10944a));
            } else {
                this.f10946c.a((TaskCompletionSource<Map<zai<?>, String>>) this.f10945b);
            }
        }
    }
}
