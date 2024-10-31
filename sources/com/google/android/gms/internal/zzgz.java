package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzgy;
import java.util.WeakHashMap;

@zzgr
/* loaded from: classes.dex */
public final class zzgz {
    private WeakHashMap<Context, a> zzGO = new WeakHashMap<>();

    /* loaded from: classes.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f1722a = com.google.android.gms.ads.internal.zzp.i().currentTimeMillis();
        public final zzgy b;

        public a(zzgy zzgyVar) {
            this.b = zzgyVar;
        }

        public boolean a() {
            return zzby.zzvn.get().longValue() + this.f1722a < com.google.android.gms.ads.internal.zzp.i().currentTimeMillis();
        }
    }

    public zzgy zzC(Context context) {
        a aVar = this.zzGO.get(context);
        zzgy zzfX = (aVar == null || aVar.a() || !zzby.zzvm.get().booleanValue()) ? new zzgy.zza(context).zzfX() : new zzgy.zza(context, aVar.b).zzfX();
        this.zzGO.put(context, new a(zzfX));
        return zzfX;
    }
}
