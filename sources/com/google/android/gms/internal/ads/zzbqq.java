package com.google.android.gms.internal.ads;

import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.ads.zzbrd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzbqq {
    private static volatile boolean zzfmq = false;
    private static volatile zzbqq zzfms;
    private final Map<a, zzbrd.zzd<?, ?>> zzfmu;
    private static final Class<?> zzfmr = zzamc();
    static final zzbqq zzfmt = new zzbqq(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final Object f12735a;

        /* renamed from: b */
        private final int f12736b;

        a(Object obj, int i) {
            this.f12735a = obj;
            this.f12736b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12735a == aVar.f12735a && this.f12736b == aVar.f12736b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f12735a) * SupportMenu.USER_MASK) + this.f12736b;
        }
    }

    zzbqq() {
        this.zzfmu = new HashMap();
    }

    public static zzbqq zzamb() {
        return Qh.a(zzbqq.class);
    }

    private static Class<?> zzamc() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzbqq zzamd() {
        return Ih.a();
    }

    public static zzbqq zzame() {
        zzbqq zzbqqVar = zzfms;
        if (zzbqqVar == null) {
            synchronized (zzbqq.class) {
                zzbqqVar = zzfms;
                if (zzbqqVar == null) {
                    zzbqqVar = Ih.b();
                    zzfms = zzbqqVar;
                }
            }
        }
        return zzbqqVar;
    }

    public final <ContainingType extends zzbsl> zzbrd.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzbrd.zzd) this.zzfmu.get(new a(containingtype, i));
    }

    private zzbqq(boolean z) {
        this.zzfmu = Collections.emptyMap();
    }
}
