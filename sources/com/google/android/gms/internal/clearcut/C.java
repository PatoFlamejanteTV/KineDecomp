package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class C extends B<zzcg.a> {
    @Override // com.google.android.gms.internal.clearcut.B
    public final int a(Map.Entry<?, ?> entry) {
        return ((zzcg.a) entry.getKey()).f12932b;
    }

    @Override // com.google.android.gms.internal.clearcut.B
    public final F<zzcg.a> a(Object obj) {
        return ((zzcg.zzd) obj).zzjv;
    }

    @Override // com.google.android.gms.internal.clearcut.B
    public final void a(Sa sa, Map.Entry<?, ?> entry) throws IOException {
        zzcg.a aVar = (zzcg.a) entry.getKey();
        switch (D.f12768a[aVar.f12933c.ordinal()]) {
            case 1:
                sa.a(aVar.f12932b, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                sa.a(aVar.f12932b, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                sa.e(aVar.f12932b, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                sa.d(aVar.f12932b, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                sa.f(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                sa.a(aVar.f12932b, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                sa.a(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                sa.a(aVar.f12932b, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                sa.d(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                sa.zzm(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                sa.b(aVar.f12932b, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                sa.c(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                sa.c(aVar.f12932b, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                sa.f(aVar.f12932b, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                sa.a(aVar.f12932b, (zzbb) entry.getValue());
                return;
            case 16:
                sa.a(aVar.f12932b, (String) entry.getValue());
                return;
            case 17:
                sa.b(aVar.f12932b, entry.getValue(), C1208ka.a().a((Class) entry.getValue().getClass()));
                return;
            case 18:
                sa.a(aVar.f12932b, entry.getValue(), C1208ka.a().a((Class) entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    final void a(Object obj, F<zzcg.a> f2) {
        ((zzcg.zzd) obj).zzjv = f2;
    }

    @Override // com.google.android.gms.internal.clearcut.B
    public final boolean a(zzdo zzdoVar) {
        return zzdoVar instanceof zzcg.zzd;
    }

    @Override // com.google.android.gms.internal.clearcut.B
    public final F<zzcg.a> b(Object obj) {
        F<zzcg.a> a2 = a(obj);
        if (!a2.c()) {
            return a2;
        }
        F<zzcg.a> f2 = (F) a2.clone();
        a(obj, f2);
        return f2;
    }

    @Override // com.google.android.gms.internal.clearcut.B
    public final void c(Object obj) {
        a(obj).i();
    }
}
