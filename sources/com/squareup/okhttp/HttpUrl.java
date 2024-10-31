package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class HttpUrl {

    /* renamed from: a */
    private static final char[] f25108a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private final String f25109b;

    /* renamed from: c */
    private final String f25110c;

    /* renamed from: d */
    private final String f25111d;

    /* renamed from: e */
    private final String f25112e;

    /* renamed from: f */
    private final int f25113f;

    /* renamed from: g */
    private final List<String> f25114g;

    /* renamed from: h */
    private final List<String> f25115h;
    private final String i;
    private final String j;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a */
        String f25116a;

        /* renamed from: d */
        String f25119d;

        /* renamed from: g */
        List<String> f25122g;

        /* renamed from: h */
        String f25123h;

        /* renamed from: b */
        String f25117b = "";

        /* renamed from: c */
        String f25118c = "";

        /* renamed from: e */
        int f25120e = -1;

        /* renamed from: f */
        final List<String> f25121f = new ArrayList();

        /* loaded from: classes3.dex */
        public enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f25121f.add("");
        }

        private void d() {
            if (this.f25121f.remove(r0.size() - 1).isEmpty() && !this.f25121f.isEmpty()) {
                this.f25121f.set(r0.size() - 1, "");
            } else {
                this.f25121f.add("");
            }
        }

        private void e(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f25121f;
                list.set(list.size() - 1, "");
            } else {
                this.f25121f.clear();
                this.f25121f.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = HttpUrl.b(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private int h(String str, int i, int i2) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }

        private static int i(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public Builder a(int i) {
            if (i > 0 && i <= 65535) {
                this.f25120e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public Builder b(String str) {
            if (str != null) {
                String a2 = a(str, 0, str.length());
                if (a2 != null) {
                    this.f25119d = a2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new IllegalArgumentException("host == null");
        }

        public Builder c(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f25116a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f25116a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f25116a);
            sb.append("://");
            if (!this.f25117b.isEmpty() || !this.f25118c.isEmpty()) {
                sb.append(this.f25117b);
                if (!this.f25118c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f25118c);
                }
                sb.append('@');
            }
            if (this.f25119d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f25119d);
                sb.append(']');
            } else {
                sb.append(this.f25119d);
            }
            int b2 = b();
            if (b2 != HttpUrl.a(this.f25116a)) {
                sb.append(':');
                sb.append(b2);
            }
            HttpUrl.b(sb, this.f25121f);
            if (this.f25122g != null) {
                sb.append('?');
                HttpUrl.a(sb, this.f25122g);
            }
            if (this.f25123h != null) {
                sb.append('#');
                sb.append(this.f25123h);
            }
            return sb.toString();
        }

        private static int f(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public Builder a(String str) {
            this.f25122g = str != null ? HttpUrl.c(HttpUrl.a(str, " \"'<>#", true, true, true)) : null;
            return this;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt != '[') {
                    i++;
                }
                do {
                    i++;
                    if (i < i2) {
                    }
                    i++;
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        private int g(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }

        public HttpUrl a() {
            if (this.f25116a != null) {
                if (this.f25119d != null) {
                    return new HttpUrl(this, null);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        int b() {
            int i = this.f25120e;
            return i != -1 ? i : HttpUrl.a(this.f25116a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:            return null;     */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress b(java.lang.String r10, int r11, int r12) {
            /*
                r0 = 16
                byte[] r0 = new byte[r0]
                r1 = -1
                r2 = 0
                r3 = 0
                r4 = -1
                r5 = -1
            L9:
                r6 = 0
                if (r11 >= r12) goto L7c
                int r7 = r0.length
                if (r3 != r7) goto L10
                return r6
            L10:
                int r7 = r11 + 2
                if (r7 > r12) goto L29
                r8 = 2
                java.lang.String r9 = "::"
                boolean r8 = r10.regionMatches(r11, r9, r2, r8)
                if (r8 == 0) goto L29
                if (r4 == r1) goto L20
                return r6
            L20:
                int r3 = r3 + 2
                if (r7 != r12) goto L26
                r4 = r3
                goto L7c
            L26:
                r4 = r3
                r5 = r7
                goto L4d
            L29:
                if (r3 == 0) goto L4c
                r7 = 1
                java.lang.String r8 = ":"
                boolean r8 = r10.regionMatches(r11, r8, r2, r7)
                if (r8 == 0) goto L37
                int r11 = r11 + 1
                goto L4c
            L37:
                java.lang.String r8 = "."
                boolean r11 = r10.regionMatches(r11, r8, r2, r7)
                if (r11 == 0) goto L4b
                int r11 = r3 + (-2)
                boolean r10 = a(r10, r5, r12, r0, r11)
                if (r10 != 0) goto L48
                return r6
            L48:
                int r3 = r3 + 2
                goto L7c
            L4b:
                return r6
            L4c:
                r5 = r11
            L4d:
                r11 = r5
                r7 = 0
            L4f:
                if (r11 >= r12) goto L62
                char r8 = r10.charAt(r11)
                int r8 = com.squareup.okhttp.HttpUrl.a(r8)
                if (r8 != r1) goto L5c
                goto L62
            L5c:
                int r7 = r7 << 4
                int r7 = r7 + r8
                int r11 = r11 + 1
                goto L4f
            L62:
                int r8 = r11 - r5
                if (r8 == 0) goto L7b
                r9 = 4
                if (r8 <= r9) goto L6a
                goto L7b
            L6a:
                int r6 = r3 + 1
                int r8 = r7 >>> 8
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r0[r3] = r8
                int r3 = r6 + 1
                r7 = r7 & 255(0xff, float:3.57E-43)
                byte r7 = (byte) r7
                r0[r6] = r7
                goto L9
            L7b:
                return r6
            L7c:
                int r10 = r0.length
                if (r3 == r10) goto L8f
                if (r4 != r1) goto L82
                return r6
            L82:
                int r10 = r0.length
                int r11 = r3 - r4
                int r10 = r10 - r11
                java.lang.System.arraycopy(r0, r4, r0, r10, r11)
                int r10 = r0.length
                int r10 = r10 - r3
                int r10 = r10 + r4
                java.util.Arrays.fill(r0, r4, r10, r2)
            L8f:
                java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L94
                return r10
            L94:
                java.lang.AssertionError r10 = new java.lang.AssertionError
                r10.<init>()
                goto L9b
            L9a:
                throw r10
            L9b:
                goto L9a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.b(java.lang.String, int, int):java.net.InetAddress");
        }

        private static boolean d(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static String e(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (d(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        Builder c() {
            int size = this.f25121f.size();
            for (int i = 0; i < size; i++) {
                this.f25121f.set(i, HttpUrl.a(this.f25121f.get(i), "[]", true, false, true));
            }
            List<String> list = this.f25122g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f25122g.get(i2);
                    if (str != null) {
                        this.f25122g.set(i2, HttpUrl.a(str, "\\^`{|}", true, true, true));
                    }
                }
            }
            String str2 = this.f25123h;
            if (str2 != null) {
                this.f25123h = HttpUrl.a(str2, " \"#<>\\^`{|}", true, false, false);
            }
            return this;
        }

        ParseResult a(HttpUrl httpUrl, String str) {
            int b2;
            int i;
            int g2 = g(str, 0, str.length());
            int h2 = h(str, g2, str.length());
            if (f(str, g2, h2) != -1) {
                if (str.regionMatches(true, g2, "https:", 0, 6)) {
                    this.f25116a = "https";
                    g2 += 6;
                } else if (str.regionMatches(true, g2, "http:", 0, 5)) {
                    this.f25116a = "http";
                    g2 += 5;
                } else {
                    return ParseResult.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrl != null) {
                this.f25116a = httpUrl.f25109b;
            } else {
                return ParseResult.MISSING_SCHEME;
            }
            int i2 = i(str, g2, h2);
            char c2 = '?';
            char c3 = '#';
            if (i2 < 2 && httpUrl != null && httpUrl.f25109b.equals(this.f25116a)) {
                this.f25117b = httpUrl.f();
                this.f25118c = httpUrl.b();
                this.f25119d = httpUrl.f25112e;
                this.f25120e = httpUrl.f25113f;
                this.f25121f.clear();
                this.f25121f.addAll(httpUrl.d());
                if (g2 == h2 || str.charAt(g2) == '#') {
                    a(httpUrl.e());
                }
            } else {
                int i3 = g2 + i2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    b2 = HttpUrl.b(str, i3, h2, "@/\\?#");
                    char charAt = b2 != h2 ? str.charAt(b2) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int b3 = HttpUrl.b(str, i3, b2, ":");
                            i = b2;
                            String a2 = HttpUrl.a(str, i3, b3, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                            if (z2) {
                                a2 = this.f25117b + "%40" + a2;
                            }
                            this.f25117b = a2;
                            if (b3 != i) {
                                this.f25118c = HttpUrl.a(str, b3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = b2;
                            this.f25118c += "%40" + HttpUrl.a(str, i3, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                        }
                        i3 = i + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int d2 = d(str, i3, b2);
                int i4 = d2 + 1;
                if (i4 < b2) {
                    this.f25119d = a(str, i3, d2);
                    this.f25120e = c(str, i4, b2);
                    if (this.f25120e == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                } else {
                    this.f25119d = a(str, i3, d2);
                    this.f25120e = HttpUrl.a(this.f25116a);
                }
                if (this.f25119d == null) {
                    return ParseResult.INVALID_HOST;
                }
                g2 = b2;
            }
            int b4 = HttpUrl.b(str, g2, h2, "?#");
            e(str, g2, b4);
            if (b4 < h2 && str.charAt(b4) == '?') {
                int b5 = HttpUrl.b(str, b4, h2, "#");
                this.f25122g = HttpUrl.c(HttpUrl.a(str, b4 + 1, b5, " \"'<>#", true, true, true));
                b4 = b5;
            }
            if (b4 < h2 && str.charAt(b4) == '#') {
                this.f25123h = HttpUrl.a(str, 1 + b4, h2, "", true, false, false);
            }
            return ParseResult.SUCCESS;
        }

        private static int c(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.a(str, i, i2, "", false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, true);
            if (f(a2)) {
                return;
            }
            if (g(a2)) {
                d();
                return;
            }
            if (this.f25121f.get(r9.size() - 1).isEmpty()) {
                this.f25121f.set(r9.size() - 1, a2);
            } else {
                this.f25121f.add(a2);
            }
            if (z) {
                this.f25121f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            String a2 = HttpUrl.a(str, i, i2, false);
            if (a2.startsWith("[") && a2.endsWith("]")) {
                InetAddress b2 = b(a2, 1, a2.length() - 1);
                if (b2 == null) {
                    return null;
                }
                byte[] address = b2.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return e(a2);
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    }
                    i5++;
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            okio.g gVar = new okio.g();
            while (i < bArr.length) {
                if (i == i3) {
                    gVar.writeByte(58);
                    i += i4;
                    if (i == 16) {
                        gVar.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        gVar.writeByte(58);
                    }
                    gVar.f(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return gVar.s();
        }
    }

    /* synthetic */ HttpUrl(Builder builder, y yVar) {
        this(builder);
    }

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public List<String> d() {
        int indexOf = this.j.indexOf(47, this.f25109b.length() + 3);
        String str = this.j;
        int b2 = b(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < b2) {
            int i = indexOf + 1;
            int b3 = b(this.j, i, b2, "/");
            arrayList.add(this.j.substring(i, b3));
            indexOf = b3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f25115h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, b(str, indexOf + 1, str.length(), "#"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).j.equals(this.j);
    }

    public String f() {
        if (this.f25110c.isEmpty()) {
            return "";
        }
        int length = this.f25109b.length() + 3;
        String str = this.j;
        return this.j.substring(length, b(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f25112e;
    }

    public boolean h() {
        return this.f25109b.equals("https");
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public Builder i() {
        Builder builder = new Builder();
        builder.f25116a = this.f25109b;
        builder.f25117b = f();
        builder.f25118c = b();
        builder.f25119d = this.f25112e;
        builder.f25120e = this.f25113f != a(this.f25109b) ? this.f25113f : -1;
        builder.f25121f.clear();
        builder.f25121f.addAll(d());
        builder.a(e());
        builder.f25123h = a();
        return builder;
    }

    public int j() {
        return this.f25113f;
    }

    public String k() {
        if (this.f25115h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f25115h);
        return sb.toString();
    }

    public String l() {
        return this.f25109b;
    }

    public URI m() {
        try {
            Builder i = i();
            i.c();
            return new URI(i.toString());
        } catch (URISyntaxException unused) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.j);
        }
    }

    public URL n() {
        try {
            return new URL(this.j);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.j;
    }

    private HttpUrl(Builder builder) {
        this.f25109b = builder.f25116a;
        this.f25110c = a(builder.f25117b, false);
        this.f25111d = a(builder.f25118c, false);
        this.f25112e = builder.f25119d;
        this.f25113f = builder.b();
        this.f25114g = a(builder.f25121f, false);
        List<String> list = builder.f25122g;
        this.f25115h = list != null ? a(list, true) : null;
        String str = builder.f25123h;
        this.i = str != null ? a(str, false) : null;
        this.j = builder.toString();
    }

    public String b() {
        if (this.f25111d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f25109b.length() + 3) + 1, this.j.indexOf(64));
    }

    public String c() {
        int indexOf = this.j.indexOf(47, this.f25109b.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, b(str, indexOf, str.length(), "?#"));
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public HttpUrl d(String str) {
        Builder builder = new Builder();
        if (builder.a(this, str) == Builder.ParseResult.SUCCESS) {
            return builder.a();
        }
        return null;
    }

    public static HttpUrl b(String str) {
        Builder builder = new Builder();
        if (builder.a(null, str) == Builder.ParseResult.SUCCESS) {
            return builder.a();
        }
        return null;
    }

    public static int b(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public String a() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                okio.g gVar = new okio.g();
                gVar.a(str, i, i3);
                a(gVar, str, i3, i2, z);
                return gVar.s();
            }
        }
        return str.substring(i, i2);
    }

    static void a(okio.g gVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a2 = a(str.charAt(i + 1));
                int a3 = a(str.charAt(i3));
                if (a2 != -1 && a3 != -1) {
                    gVar.writeByte((a2 << 4) + a3);
                    i = i3;
                }
                gVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    gVar.writeByte(32);
                }
                gVar.c(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z3) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || z) && (codePointAt != 43 || !z2)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                okio.g gVar = new okio.g();
                gVar.a(str, i, i3);
                a(gVar, str, i3, i2, str2, z, z2, z3);
                return gVar.s();
            }
        }
        return str.substring(i, i2);
    }

    static void a(okio.g gVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        okio.g gVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z2) {
                    gVar.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z3) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || z))) {
                    gVar.c(codePointAt);
                } else {
                    if (gVar2 == null) {
                        gVar2 = new okio.g();
                    }
                    gVar2.c(codePointAt);
                    while (!gVar2.l()) {
                        int readByte = gVar2.readByte() & 255;
                        gVar.writeByte(37);
                        gVar.writeByte((int) f25108a[(readByte >> 4) & 15]);
                        gVar.writeByte((int) f25108a[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3) {
        return a(str, 0, str.length(), str2, z, z2, z3);
    }
}
