package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class zzw {

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f1028a;
        private final Object b;

        private zza(Object obj) {
            this.b = zzx.a(obj);
            this.f1028a = new ArrayList();
        }

        public zza a(String str, Object obj) {
            this.f1028a.add(((String) zzx.a(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.f1028a.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f1028a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza a(Object obj) {
        return new zza(obj);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
