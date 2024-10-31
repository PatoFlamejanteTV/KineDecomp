package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0805i extends AbstractRunnableC0812p {

    /* renamed from: b, reason: collision with root package name */
    private final Map<Api.Client, C0804h> f10838b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ zaak f10839c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0805i(zaak zaakVar, Map<Api.Client, C0804h> map) {
        super(zaakVar, null);
        this.f10839c = zaakVar;
        this.f10838b = map;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractRunnableC0812p
    public final void b() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        boolean z;
        Context context2;
        zabe zabeVar;
        zad zadVar;
        zad zadVar2;
        zabe zabeVar2;
        Context context3;
        boolean z2;
        googleApiAvailabilityLight = this.f10839c.f10875d;
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(googleApiAvailabilityLight);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f10838b.keySet()) {
            if (client.requiresGooglePlayServices()) {
                z2 = this.f10838b.get(client).f10837c;
                if (!z2) {
                    arrayList.add(client);
                }
            }
            arrayList2.add(client);
        }
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                context3 = this.f10839c.f10874c;
                i = googleApiAvailabilityCache.a(context3, (Api.Client) obj);
                if (i == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                context = this.f10839c.f10874c;
                i = googleApiAvailabilityCache.a(context, (Api.Client) obj2);
                if (i != 0) {
                    break;
                }
            }
        }
        if (i == 0) {
            z = this.f10839c.m;
            if (z) {
                zadVar = this.f10839c.k;
                if (zadVar != null) {
                    zadVar2 = this.f10839c.k;
                    zadVar2.connect();
                }
            }
            for (Api.Client client2 : this.f10838b.keySet()) {
                C0804h c0804h = this.f10838b.get(client2);
                if (client2.requiresGooglePlayServices()) {
                    context2 = this.f10839c.f10874c;
                    if (googleApiAvailabilityCache.a(context2, client2) != 0) {
                        zabeVar = this.f10839c.f10872a;
                        zabeVar.a(new C0807k(this, this.f10839c, c0804h));
                    }
                }
                client2.connect(c0804h);
            }
            return;
        }
        ConnectionResult connectionResult = new ConnectionResult(i, null);
        zabeVar2 = this.f10839c.f10872a;
        zabeVar2.a(new C0806j(this, this.f10839c, connectionResult));
    }
}
