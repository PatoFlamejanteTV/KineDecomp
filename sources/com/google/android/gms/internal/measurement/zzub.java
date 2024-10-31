package com.google.android.gms.internal.measurement;

import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzuo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzub {
    private static volatile boolean zzbva = false;
    private static volatile zzub zzbvc;
    private final Map<a, zzuo.zzd<?, ?>> zzbve;
    private static final Class<?> zzbvb = zzvq();
    static final zzub zzbvd = new zzub(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final Object f13597a;

        /* renamed from: b */
        private final int f13598b;

        a(Object obj, int i) {
            this.f13597a = obj;
            this.f13598b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13597a == aVar.f13597a && this.f13598b == aVar.f13598b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f13597a) * SupportMenu.USER_MASK) + this.f13598b;
        }
    }

    zzub() {
        this.zzbve = new HashMap();
    }

    public static zzub zzvp() {
        return AbstractC1401ya.a(zzub.class);
    }

    private static Class<?> zzvq() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzub zzvr() {
        return C1386qa.a();
    }

    public static zzub zzvs() {
        zzub zzubVar = zzbvc;
        if (zzubVar == null) {
            synchronized (zzub.class) {
                zzubVar = zzbvc;
                if (zzubVar == null) {
                    zzubVar = C1386qa.b();
                    zzbvc = zzubVar;
                }
            }
        }
        return zzubVar;
    }

    public final <ContainingType extends zzvv> zzuo.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzuo.zzd) this.zzbve.get(new a(containingtype, i));
    }

    private zzub(boolean z) {
        this.zzbve = Collections.emptyMap();
    }
}
