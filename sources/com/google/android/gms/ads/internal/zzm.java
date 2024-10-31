package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzm extends zzw.zza {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f664a = new Object();
    private boolean b;

    @Override // com.google.android.gms.ads.internal.client.zzw
    public void a() {
        synchronized (f664a) {
            if (this.b) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Mobile ads is initialized already.");
            } else {
                this.b = true;
            }
        }
    }
}
