package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Objects extends e {

    @Deprecated
    /* loaded from: classes2.dex */
    public static final class ToStringHelper {

        /* renamed from: a */
        private final String f15101a;

        /* renamed from: b */
        private final a f15102b;

        /* renamed from: c */
        private boolean f15103c;

        /* loaded from: classes2.dex */
        private static final class a {

            /* renamed from: a */
            String f15104a;

            /* renamed from: b */
            Object f15105b;

            /* renamed from: c */
            a f15106c;
        }

        public String toString() {
            boolean z = this.f15103c;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f15101a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f15102b.f15106c; aVar != null; aVar = aVar.f15106c) {
                if (!z || aVar.f15105b != null) {
                    sb.append(str);
                    String str2 = aVar.f15104a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(aVar.f15105b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private Objects() {
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
