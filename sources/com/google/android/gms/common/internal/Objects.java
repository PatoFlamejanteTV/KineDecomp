package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
/* loaded from: classes.dex */
public final class Objects {
    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @KeepForSdk
    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ToStringHelper {

        /* renamed from: a */
        private final List<String> f11117a;

        /* renamed from: b */
        private final Object f11118b;

        private ToStringHelper(Object obj) {
            Preconditions.a(obj);
            this.f11118b = obj;
            this.f11117a = new ArrayList();
        }

        @KeepForSdk
        public final ToStringHelper a(String str, Object obj) {
            List<String> list = this.f11117a;
            Preconditions.a(str);
            String str2 = str;
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @KeepForSdk
        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f11118b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f11117a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.f11117a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        /* synthetic */ ToStringHelper(Object obj, l lVar) {
            this(obj);
        }
    }

    @KeepForSdk
    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(obj);
    }
}
