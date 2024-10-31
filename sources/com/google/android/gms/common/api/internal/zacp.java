package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zacp {

    /* renamed from: a, reason: collision with root package name */
    public static final Status f10923a = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: b, reason: collision with root package name */
    private static final BasePendingResult<?>[] f10924b = new BasePendingResult[0];

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Set<BasePendingResult<?>> f10925c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d, reason: collision with root package name */
    private final N f10926d = new L(this);

    /* renamed from: e, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, Api.Client> f10927e;

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.f10927e = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult) {
        this.f10925c.add(basePendingResult);
        basePendingResult.a(this.f10926d);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f10925c.toArray(f10924b)) {
            basePendingResult.b(f10923a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f10925c.toArray(f10924b)) {
            com.google.android.gms.common.api.zac zacVar = null;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            com.google.android.gms.common.api.zac zacVar2 = null;
            basePendingResult.a((N) null);
            if (basePendingResult.d() == null) {
                if (basePendingResult.e()) {
                    this.f10925c.remove(basePendingResult);
                }
            } else {
                basePendingResult.a((ResultCallback) null);
                IBinder serviceBrokerBinder = this.f10927e.get(((BaseImplementation.ApiMethodImpl) basePendingResult).h()).getServiceBrokerBinder();
                if (basePendingResult.c()) {
                    basePendingResult.a(new M(basePendingResult, b5 == true ? 1 : 0, serviceBrokerBinder, b4 == true ? 1 : 0));
                } else if (serviceBrokerBinder != null && serviceBrokerBinder.isBinderAlive()) {
                    M m = new M(basePendingResult, b3 == true ? 1 : 0, serviceBrokerBinder, b2 == true ? 1 : 0);
                    basePendingResult.a(m);
                    try {
                        serviceBrokerBinder.linkToDeath(m, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.a();
                        zacVar2.a(basePendingResult.d().intValue());
                    }
                } else {
                    basePendingResult.a((N) null);
                    basePendingResult.a();
                    zacVar.a(basePendingResult.d().intValue());
                }
                this.f10925c.remove(basePendingResult);
            }
        }
    }
}
