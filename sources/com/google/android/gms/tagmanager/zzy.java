package com.google.android.gms.tagmanager;

import android.util.Log;

/* loaded from: classes.dex */
public class zzy implements n {

    /* renamed from: a, reason: collision with root package name */
    private int f2245a = 5;

    @Override // com.google.android.gms.tagmanager.n
    public void a(String str) {
        if (this.f2245a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.n
    public void a(String str, Throwable th) {
        if (this.f2245a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.n
    public void b(String str) {
        if (this.f2245a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.n
    public void b(String str, Throwable th) {
        if (this.f2245a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.n
    public void c(String str) {
        if (this.f2245a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.n
    public void d(String str) {
        if (this.f2245a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}
