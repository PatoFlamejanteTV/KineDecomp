package com.google.android.gms.internal.firebase_auth;

import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.firebase_auth.zzft;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzfg {
    private static volatile boolean zztu = false;
    private static volatile zzfg zztw;
    private final Map<a, zzft.zzd<?, ?>> zzty;
    private static final Class<?> zztv = zzgp();
    static final zzfg zztx = new zzfg(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final Object f13111a;

        /* renamed from: b */
        private final int f13112b;

        a(Object obj, int i) {
            this.f13111a = obj;
            this.f13112b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13111a == aVar.f13111a && this.f13112b == aVar.f13112b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f13111a) * SupportMenu.USER_MASK) + this.f13112b;
        }
    }

    zzfg() {
        this.zzty = new HashMap();
    }

    public static zzfg zzgo() {
        return D.a(zzfg.class);
    }

    private static Class<?> zzgp() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzfg zzgq() {
        return C1279v.a();
    }

    public static zzfg zzgr() {
        zzfg zzfgVar = zztw;
        if (zzfgVar == null) {
            synchronized (zzfg.class) {
                zzfgVar = zztw;
                if (zzfgVar == null) {
                    zzfgVar = C1279v.b();
                    zztw = zzfgVar;
                }
            }
        }
        return zzfgVar;
    }

    public final <ContainingType extends zzhc> zzft.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzft.zzd) this.zzty.get(new a(containingtype, i));
    }

    private zzfg(boolean z) {
        this.zzty = Collections.emptyMap();
    }
}
