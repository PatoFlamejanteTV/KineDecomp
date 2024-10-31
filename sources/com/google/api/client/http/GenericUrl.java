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
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class GenericUrl extends GenericData {

    /* renamed from: a, reason: collision with root package name */
    private static final Escaper f2456a = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
    private String b;
    private String c;
    private String d;
    private int e;
    private List<String> f;
    private String g;

    public GenericUrl() {
        this.e = -1;
    }

    public GenericUrl(String str) {
        this(f(str));
    }

    public GenericUrl(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private GenericUrl(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        this.e = -1;
        this.b = str.toLowerCase();
        this.c = str2;
        this.e = i;
        this.f = e(str3);
        this.g = str4 != null ? CharEscapers.b(str4) : null;
        if (str5 != null) {
            UrlEncodedParser.a(str5, this);
        }
        this.d = str6 != null ? CharEscapers.b(str6) : null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return j().hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof GenericUrl)) {
            return false;
        }
        return j().equals(((GenericUrl) obj).toString());
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return j();
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GenericUrl clone() {
        GenericUrl genericUrl = (GenericUrl) super.clone();
        if (this.f != null) {
            genericUrl.f = new ArrayList(this.f);
        }
        return genericUrl;
    }

    @Override // com.google.api.client.util.GenericData
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GenericUrl set(String str, Object obj) {
        return (GenericUrl) super.set(str, obj);
    }

    public final String e() {
        return this.b;
    }

    public final void a(String str) {
        this.b = (String) Preconditions.a(str);
    }

    public String f() {
        return this.c;
    }

    public final void b(String str) {
        this.c = (String) Preconditions.a(str);
    }

    public int g() {
        return this.e;
    }

    public final void a(int i) {
        Preconditions.a(i >= -1, "expected port >= -1");
        this.e = i;
    }

    public List<String> h() {
        return this.f;
    }

    public void a(List<String> list) {
        this.f = list;
    }

    public String i() {
        return this.g;
    }

    public final String j() {
        String valueOf = String.valueOf(k());
        String valueOf2 = String.valueOf(l());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) Preconditions.a(this.b));
        sb.append("://");
        if (this.d != null) {
            sb.append(CharEscapers.e(this.d)).append('@');
        }
        sb.append((String) Preconditions.a(this.c));
        int i = this.e;
        if (i != -1) {
            sb.append(':').append(i);
        }
        return sb.toString();
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            a(sb);
        }
        a(entrySet(), sb);
        String str = this.g;
        if (str != null) {
            sb.append('#').append(f2456a.a(str));
        }
        return sb.toString();
    }

    public final URL m() {
        return f(j());
    }

    public final URL c(String str) {
        try {
            return new URL(m(), str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void d(String str) {
        this.f = e(str);
    }

    public static List<String> e(String str) {
        String substring;
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i = 0;
        while (z) {
            int indexOf = str.indexOf(47, i);
            z = indexOf != -1;
            if (z) {
                substring = str.substring(i, indexOf);
            } else {
                substring = str.substring(i);
            }
            arrayList.add(CharEscapers.b(substring));
            i = indexOf + 1;
        }
        return arrayList;
    }

    private void a(StringBuilder sb) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            String str = this.f.get(i);
            if (i != 0) {
                sb.append('/');
            }
            if (str.length() != 0) {
                sb.append(CharEscapers.c(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        Iterator<Map.Entry<String, Object>> it = set.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                Object value = next.getValue();
                if (value != null) {
                    String f = CharEscapers.f(next.getKey());
                    if (value instanceof Collection) {
                        Iterator it2 = ((Collection) value).iterator();
                        while (it2.hasNext()) {
                            z2 = a(z2, sb, f, it2.next());
                        }
                    } else {
                        z2 = a(z2, sb, f, value);
                    }
                }
                z = z2;
            } else {
                return;
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
        String f = CharEscapers.f(obj.toString());
        if (f.length() != 0) {
            sb.append('=').append(f);
        }
        return z;
    }

    private static URL f(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
