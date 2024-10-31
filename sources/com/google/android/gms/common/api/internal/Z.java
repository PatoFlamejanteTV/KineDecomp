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
/* loaded from: classes.dex */
public final class Z implements OnCompleteListener<Map<zai<?>, String>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zax f10817a;

    private Z(zax zaxVar) {
        this.f10817a = zaxVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        ConnectionResult h2;
        Map map;
        Map map2;
        boolean a2;
        Map map3;
        Map map4;
        Map map5;
        ConnectionResult connectionResult;
        zaaw zaawVar;
        ConnectionResult connectionResult2;
        Condition condition;
        Map map6;
        Map map7;
        ConnectionResult h3;
        Map map8;
        Map map9;
        Map map10;
        lock = this.f10817a.f10965f;
        lock.lock();
        try {
            z = this.f10817a.n;
            if (z) {
                if (task.e()) {
                    zax zaxVar = this.f10817a;
                    map8 = this.f10817a.f10960a;
                    zaxVar.o = new ArrayMap(map8.size());
                    map9 = this.f10817a.f10960a;
                    for (zaw zawVar : map9.values()) {
                        map10 = this.f10817a.o;
                        map10.put(zawVar.zak(), ConnectionResult.f10647a);
                    }
                } else if (task.a() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.a();
                    z2 = this.f10817a.l;
                    if (z2) {
                        zax zaxVar2 = this.f10817a;
                        map = this.f10817a.f10960a;
                        zaxVar2.o = new ArrayMap(map.size());
                        map2 = this.f10817a.f10960a;
                        for (zaw zawVar2 : map2.values()) {
                            Object zak = zawVar2.zak();
                            ConnectionResult connectionResult3 = availabilityException.getConnectionResult(zawVar2);
                            a2 = this.f10817a.a((zaw<?>) zawVar2, connectionResult3);
                            if (a2) {
                                map3 = this.f10817a.o;
                                map3.put(zak, new ConnectionResult(16));
                            } else {
                                map4 = this.f10817a.o;
                                map4.put(zak, connectionResult3);
                            }
                        }
                    } else {
                        this.f10817a.o = availabilityException.zaj();
                    }
                    zax zaxVar3 = this.f10817a;
                    h2 = this.f10817a.h();
                    zaxVar3.r = h2;
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.a());
                    this.f10817a.o = Collections.emptyMap();
                    this.f10817a.r = new ConnectionResult(8);
                }
                map5 = this.f10817a.p;
                if (map5 != null) {
                    map6 = this.f10817a.o;
                    map7 = this.f10817a.p;
                    map6.putAll(map7);
                    zax zaxVar4 = this.f10817a;
                    h3 = this.f10817a.h();
                    zaxVar4.r = h3;
                }
                connectionResult = this.f10817a.r;
                if (connectionResult == null) {
                    this.f10817a.f();
                    this.f10817a.g();
                } else {
                    zax.a(this.f10817a, false);
                    zaawVar = this.f10817a.f10964e;
                    connectionResult2 = this.f10817a.r;
                    zaawVar.a(connectionResult2);
                }
                condition = this.f10817a.i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.f10817a.f10965f;
            lock2.unlock();
        }
    }
}
