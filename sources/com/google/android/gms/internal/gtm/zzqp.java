package com.google.android.gms.internal.gtm;

import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.gtm.zzrc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzqp {
    private static volatile boolean zzaxh = false;
    private static volatile zzqp zzaxj;
    private final Map<a, zzrc.zzd<?, ?>> zzaxl;
    private static final Class<?> zzaxi = zzop();
    static final zzqp zzaxk = new zzqp(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final Object f13345a;

        /* renamed from: b */
        private final int f13346b;

        a(Object obj, int i) {
            this.f13345a = obj;
            this.f13346b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13345a == aVar.f13345a && this.f13346b == aVar.f13346b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f13345a) * SupportMenu.USER_MASK) + this.f13346b;
        }
    }

    zzqp() {
        this.zzaxl = new HashMap();
    }

    public static zzqp zzoo() {
        return AbstractC1338wa.a(zzqp.class);
    }

    private static Class<?> zzop() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzqp zzoq() {
        return C1323oa.a();
    }

    public static zzqp zzor() {
        zzqp zzqpVar = zzaxj;
        if (zzqpVar == null) {
            synchronized (zzqp.class) {
                zzqpVar = zzaxj;
                if (zzqpVar == null) {
                    zzqpVar = C1323oa.b();
                    zzaxj = zzqpVar;
                }
            }
        }
        return zzqpVar;
    }

    public final <ContainingType extends zzsk> zzrc.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzrc.zzd) this.zzaxl.get(new a(containingtype, i));
    }

    private zzqp(boolean z) {
        this.zzaxl = Collections.emptyMap();
    }
}
