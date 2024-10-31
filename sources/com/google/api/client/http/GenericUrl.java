package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;
import com.google.api.client.util.escape.Escaper;
import com.google.api.client.util.escape.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class GenericUrl extends GenericData {

    /* renamed from: a */
    private static final Escaper f14734a = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);

    /* renamed from: b */
    private String f14735b;

    /* renamed from: c */
    private String f14736c;

    /* renamed from: d */
    private String f14737d;

    /* renamed from: e */
    private int f14738e;

    /* renamed from: f */
    private List<String> f14739f;

    /* renamed from: g */
    private String f14740g;

    public GenericUrl() {
        this.f14738e = -1;
    }

    public final void a(String str) {
        Preconditions.a(str);
        this.f14736c = str;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        if (this.f14739f != null) {
            a(sb);
        }
        a(entrySet(), sb);
        String str = this.f14740g;
        if (str != null) {
            sb.append('#');
            sb.append(f14734a.a(str));
        }
        return sb.toString();
    }

    public final String build() {
        return a() + b();
    }

    public final void c(String str) {
        Preconditions.a(str);
        this.f14735b = str;
    }

    public String d() {
        return this.f14736c;
    }

    public List<String> e() {
        return this.f14739f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof GenericUrl)) {
            return build().equals(((GenericUrl) obj).build());
        }
        return false;
    }

    public int f() {
        return this.f14738e;
    }

    public final String g() {
        return this.f14735b;
    }

    public final URL h() {
        return f(build());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return build().hashCode();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return build();
    }

    public static List<String> d(String str) {
        String substring;
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i = 0;
        while (z) {
            int indexOf = str.indexOf(47, i);
            boolean z2 = indexOf != -1;
            if (z2) {
                substring = str.substring(i, indexOf);
            } else {
                substring = str.substring(i);
            }
            arrayList.add(CharEscapers.a(substring));
            i = indexOf + 1;
            z = z2;
        }
        return arrayList;
    }

    private static URL f(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final void a(int i) {
        Preconditions.a(i >= -1, "expected port >= -1");
        this.f14738e = i;
    }

    public String c() {
        return this.f14740g;
    }

    public final URL e(String str) {
        try {
            return new URL(h(), str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.google.api.client.util.GenericData
    public GenericUrl set(String str, Object obj) {
        super.set(str, obj);
        return this;
    }

    public GenericUrl(String str) {
        this(f(str));
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericUrl clone() {
        GenericUrl genericUrl = (GenericUrl) super.clone();
        List<String> list = this.f14739f;
        if (list != null) {
            genericUrl.f14739f = new ArrayList(list);
        }
        return genericUrl;
    }

    public GenericUrl(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    public void a(List<String> list) {
        this.f14739f = list;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.f14735b;
        Preconditions.a(str);
        sb.append(str);
        sb.append("://");
        String str2 = this.f14737d;
        if (str2 != null) {
            sb.append(CharEscapers.f(str2));
            sb.append('@');
        }
        String str3 = this.f14736c;
        Preconditions.a(str3);
        sb.append(str3);
        int i = this.f14738e;
        if (i != -1) {
            sb.append(':');
            sb.append(i);
        }
        return sb.toString();
    }

    public void b(String str) {
        this.f14739f = d(str);
    }

    private GenericUrl(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        this.f14738e = -1;
        this.f14735b = str.toLowerCase(Locale.US);
        this.f14736c = str2;
        this.f14738e = i;
        this.f14739f = d(str3);
        this.f14740g = str4 != null ? CharEscapers.a(str4) : null;
        if (str5 != null) {
            UrlEncodedParser.a(str5, this);
        }
        this.f14737d = str6 != null ? CharEscapers.a(str6) : null;
    }

    private void a(StringBuilder sb) {
        int size = this.f14739f.size();
        for (int i = 0; i < size; i++) {
            String str = this.f14739f.get(i);
            if (i != 0) {
                sb.append('/');
            }
            if (str.length() != 0) {
                sb.append(CharEscapers.c(str));
            }
        }
    }

    public static void a(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String e2 = CharEscapers.e(entry.getKey());
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        z = a(z, sb, e2, it.next());
                    }
                } else {
                    z = a(z, sb, e2, value);
                }
            }
        }
    }

    private static boolean a(boolean z, StringBuilder sb, String str, Object obj) {
        if (z) {
            z = false;
            sb.append('?');
        } else {
            sb.append('&');
        }
        sb.append(str);
        String e2 = CharEscapers.e(obj.toString());
        if (e2.length() != 0) {
            sb.append('=');
            sb.append(e2);
        }
        return z;
    }
}
