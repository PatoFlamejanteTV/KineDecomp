package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class Objects {
    private Objects() {
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
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

    /* loaded from: classes.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        private final String f2502a;
        private final List<a> b;
        private boolean c;

        private ToStringHelper(String str) {
            this.b = new LinkedList();
            this.c = false;
            this.f2502a = (String) Preconditions.a(str);
        }

        public ToStringHelper a(String str, @Nullable Object obj) {
            Preconditions.a(str);
            a(obj).f2503a.append(str).append('=').append(obj);
            return this;
        }

        public String toString() {
            boolean z = this.c;
            boolean z2 = false;
            StringBuilder append = new StringBuilder(32).append(this.f2502a).append('{');
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
                        append.append((CharSequence) next.f2503a);
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

        private a a(@Nullable Object obj) {
            a a2 = a();
            a2.b = obj == null;
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            final StringBuilder f2503a;
            boolean b;

            private a() {
                this.f2503a = new StringBuilder();
            }
        }
    }
}
