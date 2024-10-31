package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Objects {
    private Objects() {
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(a(obj.getClass()));
    }

    private static String a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static <T> T b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : (T) Preconditions.a(t2);
    }

    /* loaded from: classes2.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        private final String f2582a;
        private final List<a> b;
        private boolean c;

        private ToStringHelper(String str) {
            this.b = new LinkedList();
            this.c = false;
            this.f2582a = (String) Preconditions.a(str);
        }

        public ToStringHelper a(String str, @Nullable Object obj) {
            Preconditions.a(str);
            b(obj).f2583a.append(str).append('=').append(obj);
            return this;
        }

        public ToStringHelper a(String str, int i) {
            a(str).append(i);
            return this;
        }

        public ToStringHelper a(String str, long j) {
            a(str).append(j);
            return this;
        }

        private StringBuilder a(String str) {
            Preconditions.a(str);
            return a().f2583a.append(str).append('=');
        }

        public ToStringHelper a(@Nullable Object obj) {
            b(obj).f2583a.append(obj);
            return this;
        }

        public String toString() {
            boolean z = this.c;
            boolean z2 = false;
            StringBuilder append = new StringBuilder(32).append(this.f2582a).append('{');
            Iterator<a> it = this.b.iterator();
            while (true) {
                boolean z3 = z2;
                if (it.hasNext()) {
                    a next = it.next();
                    if (!z || !next.b) {
                        if (z3) {
                            append.append(", ");
                        } else {
                            z3 = true;
                        }
                        append.append((CharSequence) next.f2583a);
                    }
                    z2 = z3;
                } else {
                    return append.append('}').toString();
                }
            }
        }

        private a a() {
            a aVar = new a();
            this.b.add(aVar);
            return aVar;
        }

        private a b(@Nullable Object obj) {
            a a2 = a();
            a2.b = obj == null;
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            final StringBuilder f2583a;
            boolean b;

            private a() {
                this.f2583a = new StringBuilder();
            }
        }
    }
}
