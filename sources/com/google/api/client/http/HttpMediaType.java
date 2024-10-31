package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class HttpMediaType {

    /* renamed from: a */
    private static final Pattern f14756a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");

    /* renamed from: b */
    private static final Pattern f14757b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");

    /* renamed from: c */
    private static final Pattern f14758c = Pattern.compile("\\s*([^\\s/=;\"]+)/([^\\s/=;\"]+)\\s*(;.*)?", 32);

    /* renamed from: d */
    private static final Pattern f14759d;

    /* renamed from: e */
    private String f14760e = "application";

    /* renamed from: f */
    private String f14761f = "octet-stream";

    /* renamed from: g */
    private final SortedMap<String, String> f14762g = new TreeMap();

    /* renamed from: h */
    private String f14763h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("\"([^\"]*)\"");
        sb.append("|");
        sb.append("[^\\s;\"]*");
        f14759d = Pattern.compile("\\s*;\\s*([^\\s/=;\"]+)=(" + sb.toString() + ")");
    }

    public HttpMediaType(String str) {
        f(str);
    }

    private HttpMediaType f(String str) {
        Matcher matcher = f14758c.matcher(str);
        Preconditions.a(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        e(matcher.group(1));
        d(matcher.group(2));
        String group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = f14759d.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                b(group2, group3);
            }
        }
        return this;
    }

    private static String g(String str) {
        return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    public String a(String str) {
        return this.f14762g.get(str.toLowerCase(Locale.US));
    }

    public HttpMediaType b(String str, String str2) {
        if (str2 == null) {
            c(str);
            return this;
        }
        Preconditions.a(f14757b.matcher(str).matches(), "Name contains reserved characters");
        this.f14763h = null;
        this.f14762g.put(str.toLowerCase(Locale.US), str2);
        return this;
    }

    public String c() {
        return this.f14761f;
    }

    public String d() {
        return this.f14760e;
    }

    public HttpMediaType e(String str) {
        Preconditions.a(f14756a.matcher(str).matches(), "Type contains reserved characters");
        this.f14760e = str;
        this.f14763h = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpMediaType)) {
            return false;
        }
        HttpMediaType httpMediaType = (HttpMediaType) obj;
        return a(httpMediaType) && this.f14762g.equals(httpMediaType.f14762g);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a();
    }

    public String a() {
        String str = this.f14763h;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14760e);
        sb.append('/');
        sb.append(this.f14761f);
        SortedMap<String, String> sortedMap = this.f14762g;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                String value = entry.getValue();
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=");
                if (!b(value)) {
                    value = g(value);
                }
                sb.append(value);
            }
        }
        this.f14763h = sb.toString();
        return this.f14763h;
    }

    public HttpMediaType c(String str) {
        this.f14763h = null;
        this.f14762g.remove(str.toLowerCase(Locale.US));
        return this;
    }

    public HttpMediaType d(String str) {
        Preconditions.a(f14756a.matcher(str).matches(), "Subtype contains reserved characters");
        this.f14761f = str;
        this.f14763h = null;
        return this;
    }

    public static boolean b(String str) {
        return f14757b.matcher(str).matches();
    }

    public Charset b() {
        String a2 = a("charset");
        if (a2 == null) {
            return null;
        }
        return Charset.forName(a2);
    }

    public boolean a(HttpMediaType httpMediaType) {
        return httpMediaType != null && d().equalsIgnoreCase(httpMediaType.d()) && c().equalsIgnoreCase(httpMediaType.c());
    }

    public static boolean a(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new HttpMediaType(str).a(new HttpMediaType(str2)));
    }

    public HttpMediaType a(Charset charset) {
        b("charset", charset == null ? null : charset.name());
        return this;
    }
}
