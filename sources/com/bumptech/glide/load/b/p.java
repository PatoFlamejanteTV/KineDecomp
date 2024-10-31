package com.bumptech.glide.load.b;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class p implements n {

    /* renamed from: a */
    private final Map<String, List<o>> f8627a;

    /* renamed from: b */
    private volatile Map<String, String> f8628b;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private static final String f8629a = b();

        /* renamed from: b */
        private static final Map<String, List<o>> f8630b;

        /* renamed from: c */
        private boolean f8631c = true;

        /* renamed from: d */
        private Map<String, List<o>> f8632d = f8630b;

        /* renamed from: e */
        private boolean f8633e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f8629a)) {
                hashMap.put(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, Collections.singletonList(new b(f8629a)));
            }
            f8630b = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public p a() {
            this.f8631c = true;
            return new p(this.f8632d);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements o {

        /* renamed from: a */
        private final String f8634a;

        b(String str) {
            this.f8634a = str;
        }

        @Override // com.bumptech.glide.load.b.o
        public String a() {
            return this.f8634a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f8634a.equals(((b) obj).f8634a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8634a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f8634a + "'}";
        }
    }

    p(Map<String, List<o>> map) {
        this.f8627a = Collections.unmodifiableMap(map);
    }

    private Map<String, String> a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<o>> entry : this.f8627a.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f8627a.equals(((p) obj).f8627a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.b.n
    public Map<String, String> getHeaders() {
        if (this.f8628b == null) {
            synchronized (this) {
                if (this.f8628b == null) {
                    this.f8628b = Collections.unmodifiableMap(a());
                }
            }
        }
        return this.f8628b;
    }

    public int hashCode() {
        return this.f8627a.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f8627a + '}';
    }

    private String a(List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
