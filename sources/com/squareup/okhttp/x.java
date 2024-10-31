package com.squareup.okhttp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: Headers.java */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a */
    private final String[] f25539a;

    /* compiled from: Headers.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private final List<String> f25540a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= 31 || charAt >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            char charAt2 = str2.charAt(i2);
                            if (charAt2 <= 31 || charAt2 >= 127) {
                                throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str2));
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("value == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("name == null");
        }

        a b(String str, String str2) {
            this.f25540a.add(str);
            this.f25540a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            }
            b("", str);
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f25540a.size()) {
                if (str.equalsIgnoreCase(this.f25540a.get(i))) {
                    this.f25540a.remove(i);
                    this.f25540a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            d(str, str2);
            b(str, str2);
            return this;
        }

        public x a() {
            return new x(this);
        }
    }

    /* synthetic */ x(a aVar, w wVar) {
        this(aVar);
    }

    public String a(String str) {
        return a(this.f25539a, str);
    }

    public Date b(String str) {
        String a2 = a(str);
        if (a2 != null) {
            return com.squareup.okhttp.internal.http.j.a(a2);
        }
        return null;
    }

    public List<String> c(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i = 0; i < b2; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i = 0; i < b2; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private x(a aVar) {
        this.f25539a = (String[]) aVar.f25540a.toArray(new String[aVar.f25540a.size()]);
    }

    public String a(int i) {
        int i2 = i * 2;
        if (i2 < 0) {
            return null;
        }
        String[] strArr = this.f25539a;
        if (i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    public int b() {
        return this.f25539a.length / 2;
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f25540a, this.f25539a);
        return aVar;
    }

    public String b(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0) {
            return null;
        }
        String[] strArr = this.f25539a;
        if (i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
