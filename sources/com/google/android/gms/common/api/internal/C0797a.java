package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0797a implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a, reason: collision with root package name */
    private SignInConnectionListener f10818a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zax f10819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0797a(zax zaxVar, SignInConnectionListener signInConnectionListener) {
        this.f10819b = zaxVar;
        this.f10818a = signInConnectionListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f10818a.onComplete();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        Map map;
        Map map2;
        boolean a2;
        Map map3;
        Map map4;
        Map map5;
        Map map6;
        ConnectionResult h2;
        Condition condition;
        Map map7;
        Map map8;
        Map map9;
        lock = this.f10819b.f10965f;
        lock.lock();
        try {
            z = this.f10819b.n;
            if (!z) {
                this.f10818a.onComplete();
                return;
            }
            if (task.e()) {
                zax zaxVar = this.f10819b;
                map7 = this.f10819b.f10961b;
                zaxVar.p = new ArrayMap(map7.size());
                map8 = this.f10819b.f10961b;
                for (zaw zawVar : map8.values()) {
                    map9 = this.f10819b.p;
                    map9.put(zawVar.zak(), ConnectionResult.f10647a);
                }
            } else if (task.a() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.a();
                z2 = this.f10819b.l;
                if (z2) {
                    zax zaxVar2 = this.f10819b;
                    map = this.f10819b.f10961b;
                    zaxVar2.p = new ArrayMap(map.size());
                    map2 = this.f10819b.f10961b;
                    for (zaw zawVar2 : map2.values()) {
                        Object zak = zawVar2.zak();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zawVar2);
                        a2 = this.f10819b.a((zaw<?>) zawVar2, connectionResult);
                        if (a2) {
                            map3 = this.f10819b.p;
                            map3.put(zak, new ConnectionResult(16));
                        } else {
                            map4 = this.f10819b.p;
                            map4.put(zak, connectionResult);
                        }
                    }
                } else {
                    this.f10819b.p = availabilityException.zaj();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.a());
                this.f10819b.p = Collections.emptyMap();
            }
            if (this.f10819b.isConnected()) {
                map5 = this.f10819b.o;
                map6 = this.f10819b.p;
                map5.putAll(map6);
                h2 = this.f10819b.h();
                if (h2 == null) {
                    this.f10819b.f();
                    this.f10819b.g();
                    condition = this.f10819b.i;
                    condition.signalAll();
                }
            }
            this.f10818a.onComplete();
        } finally {
            lock2 = this.f10819b.f10965f;
            lock2.unlock();
        }
    }
}
