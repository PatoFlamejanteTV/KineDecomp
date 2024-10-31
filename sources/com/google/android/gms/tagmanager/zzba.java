package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzba implements p {

    /* renamed from: a */
    private int f14230a = 5;

    @Override // com.google.android.gms.tagmanager.p
    public final void a(String str) {
        if (this.f14230a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.p
    public final void b(String str, Throwable th) {
        if (this.f14230a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.p
    public final void c(String str) {
        if (this.f14230a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.p
    public final void d(String str) {
        if (this.f14230a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.p
    public final void a(String str, Throwable th) {
        if (this.f14230a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.p
    public final void b(String str) {
        if (this.f14230a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}
