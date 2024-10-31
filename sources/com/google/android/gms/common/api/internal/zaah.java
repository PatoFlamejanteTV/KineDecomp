package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaah implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f10870a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10871b = false;

    public zaah(zabe zabeVar) {
        this.f10870a = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        try {
            this.f10870a.n.y.a(t);
            zaaw zaawVar = this.f10870a.n;
            Api.Client client = zaawVar.p.get(t.h());
            Preconditions.a(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.f10870a.f10895g.containsKey(t.h())) {
                t.c(new Status(17));
            } else {
                boolean z = client instanceof SimpleClientAdapter;
                A a2 = client;
                if (z) {
                    a2 = ((SimpleClientAdapter) client).c();
                }
                t.b(a2);
            }
        } catch (DeadObjectException unused) {
            this.f10870a.a(new C0801e(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        return (T) a((zaah) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        if (this.f10871b) {
            this.f10871b = false;
            this.f10870a.a(new C0802f(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        if (this.f10871b) {
            return false;
        }
        if (this.f10870a.n.m()) {
            this.f10871b = true;
            Iterator<zacm> it = this.f10870a.n.x.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            return false;
        }
        this.f10870a.a((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
        this.f10870a.a((ConnectionResult) null);
        this.f10870a.o.a(i, this.f10871b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.f10871b) {
            this.f10871b = false;
            this.f10870a.n.y.a();
            disconnect();
        }
    }
}
