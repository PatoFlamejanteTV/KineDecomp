package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class GoogleApiAvailabilityCache {

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f11110a;

    /* renamed from: b, reason: collision with root package name */
    private GoogleApiAvailabilityLight f11111b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.a());
    }

    public int a(Context context, Api.Client client) {
        Preconditions.a(context);
        Preconditions.a(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.f11110a.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.f11110a.size()) {
                int keyAt = this.f11110a.keyAt(i2);
                if (keyAt > minApkVersion && this.f11110a.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.f11111b.a(context, minApkVersion);
        }
        this.f11110a.put(minApkVersion, i);
        return i;
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f11110a = new SparseIntArray();
        Preconditions.a(googleApiAvailabilityLight);
        this.f11111b = googleApiAvailabilityLight;
    }

    public void a() {
        this.f11110a.clear();
    }
}
