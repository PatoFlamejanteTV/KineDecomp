package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class HttpMediaType {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2464a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private static final Pattern b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern c;
    private static final Pattern d;
    private String e = "application";
    private String f = "octet-stream";
    private final SortedMap<String, String> g = new TreeMap();
    private String h;

    static {
        String valueOf = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        String valueOf2 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        String valueOf3 = String.valueOf(String.valueOf(";.*"));
        c = Pattern.compile(new StringBuilder(valueOf.length() + 14 + valueOf2.length() + valueOf3.length()).append("\\s*(").append(valueOf).append(")/(").append(valueOf2).append(")").append("\\s*(").append(valueOf3).append(")?").toString(), 32);
        String valueOf4 = String.valueOf(String.valueOf("\"([^\"]*)\""));
        String valueOf5 = String.valueOf(String.valueOf("[^\\s;\"]*"));
        String sb = new StringBuilder(valueOf4.length() + 1 + valueOf5.length()).append(valueOf4).append("|").append(valueOf5).toString();
        String valueOf6 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        String valueOf7 = String.valueOf(String.valueOf(sb));
        d = Pattern.compile(new StringBuilder(valueOf6.length() + 12 + valueOf7.length()).append("\\s*;\\s*(").append(valueOf6).append(")").append("=(").append(valueOf7).append(")").toString());
    }

    public HttpMediaType(String str) {
        f(str);
    }

    public HttpMediaType a(String str) {
        Preconditions.a(f2464a.matcher(str).matches(), "Type contains reserved characters");
        this.e = str;
        this.h = null;
        return this;
    }

    public String a() {
        return this.e;
    }

    public HttpMediaType b(String str) {
        Preconditions.a(f2464a.matcher(str).matches(), "Subtype contains reserved characters");
        this.f = str;
        this.h = null;
        return this;
    }

    public String b() {
        return this.f;
    }

    private HttpMediaType f(String str) {
        Matcher matcher = c.matcher(str);
        Preconditions.a(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        a(matcher.group(1));
        b(matcher.group(2));
        String group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = d.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                a(group2, group3);
            }
        }
        return this;
    }

    public HttpMediaType a(String str, String str2) {
        if (str2 == null) {
            d(str);
        } else {
            Preconditions.a(b.matcher(str).matches(), "Name contains reserved characters");
            this.h = null;
            this.g.put(str.toLowerCase(), str2);
        }
        return this;
    }

    public String c(String str) {
        return this.g.get(str.toLowerCase());
    }

    public HttpMediaType d(String str) {
        this.h = null;
        this.g.remove(str.toLowerCase());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        return b.matcher(str).matches();
    }

    private static String g(String str) {
        String valueOf = String.valueOf(String.valueOf(str.replace("\\", "\\\\").replace("\"", "\\\"")));
        return new StringBuilder(valueOf.length() + 2).append("\"").append(valueOf).append("\"").toString();
    }

    public String c() {
        if (this.h != null) {
            return this.h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('/');
        sb.append(this.f);
        if (this.g != null) {
            for (Map.Entry<String, String> entry : this.g.entrySet()) {
                String value = entry.getValue();
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=");
                if (!e(value)) {
                    value = g(value);
                }
                sb.append(value);
            }
        }
        this.h = sb.toString();
        return this.h;
    }

    public String toString() {
        return c();
    }

    public boolean a(HttpMediaType httpMediaType) {
        return httpMediaType != null && a().equalsIgnoreCase(httpMediaType.a()) && b().equalsIgnoreCase(httpMediaType.b());
    }

    public static boolean b(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new HttpMediaType(str).a(new HttpMediaType(str2)));
    }

    public HttpMediaType a(Charset charset) {
        a("charset", charset == null ? null : charset.name());
        return this;
    }

    public Charset d() {
        String c2 = c("charset");
        if (c2 == null) {
            return null;
        }
        return Charset.forName(c2);
    }

    public int hashCode() {
        return c().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpMediaType)) {
            return false;
        }
        HttpMediaType httpMediaType = (HttpMediaType) obj;
        return a(httpMediaType) && this.g.equals(httpMediaType.g);
    }
}
