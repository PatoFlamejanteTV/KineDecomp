package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class MoreObjects {

    /* loaded from: classes2.dex */
    public static final class ToStringHelper {

        /* renamed from: a */
        private final String f15094a;

        /* renamed from: b */
        private final a f15095b;

        /* renamed from: c */
        private a f15096c;

        /* renamed from: d */
        private boolean f15097d;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a */
            String f15098a;

            /* renamed from: b */
            Object f15099b;

            /* renamed from: c */
            a f15100c;

            private a() {
            }

            /* synthetic */ a(g gVar) {
                this();
            }
        }

        /* synthetic */ ToStringHelper(String str, g gVar) {
            this(str);
        }

        private a b() {
            a aVar = new a();
            this.f15096c.f15100c = aVar;
            this.f15096c = aVar;
            return aVar;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a() {
            this.f15097d = true;
            return this;
        }

        public String toString() {
            boolean z = this.f15097d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f15094a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f15095b.f15100c; aVar != null; aVar = aVar.f15100c) {
                Object obj = aVar.f15099b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f15098a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            this.f15095b = new a();
            this.f15096c = this.f15095b;
            this.f15097d = false;
            Preconditions.a(str);
            this.f15094a = str;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, @Nullable Object obj) {
            b(str, obj);
            return this;
        }

        private ToStringHelper b(@Nullable Object obj) {
            b().f15099b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, boolean z) {
            b(str, String.valueOf(z));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, double d2) {
            b(str, String.valueOf(d2));
            return this;
        }

        private ToStringHelper b(String str, @Nullable Object obj) {
            a b2 = b();
            b2.f15099b = obj;
            Preconditions.a(str);
            b2.f15098a = str;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, int i) {
            b(str, String.valueOf(i));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, long j) {
            b(str, String.valueOf(j));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(@Nullable Object obj) {
            b(obj);
            return this;
        }
    }

    private MoreObjects() {
    }

    public static <T> T a(@Nullable T t, @Nullable T t2) {
        if (t != null) {
            return t;
        }
        Preconditions.a(t2);
        return t2;
    }

    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper a(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }
}
