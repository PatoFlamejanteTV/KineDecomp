package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: HttpUrl.java */
/* loaded from: classes3.dex */
public final class A {

    /* renamed from: a */
    private static final char[] f28742a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    final String f28743b;

    /* renamed from: c */
    private final String f28744c;

    /* renamed from: d */
    private final String f28745d;

    /* renamed from: e */
    final String f28746e;

    /* renamed from: f */
    final int f28747f;

    /* renamed from: g */
    private final List<String> f28748g;

    /* renamed from: h */
    @Nullable
    private final List<String> f28749h;

    @Nullable
    private final String i;
    private final String j;

    /* compiled from: HttpUrl.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        @Nullable
        String f28750a;

        /* renamed from: d */
        @Nullable
        String f28753d;

        /* renamed from: g */
        @Nullable
        List<String> f28756g;

        /* renamed from: h */
        @Nullable
        String f28757h;

        /* renamed from: b */
        String f28751b = "";

        /* renamed from: c */
        String f28752c = "";

        /* renamed from: e */
        int f28754e = -1;

        /* renamed from: f */
        final List<String> f28755f = new ArrayList();

        public a() {
            this.f28755f.add("");
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i) {
            if (i > 0 && i <= 65535) {
                this.f28754e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public a b(String str) {
            if (str != null) {
                String a2 = a(str, 0, str.length());
                if (a2 != null) {
                    this.f28753d = a2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public a c(String str) {
            if (str != null) {
                this.f28752c = A.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a d(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f28750a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f28750a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a e(String str) {
            if (str != null) {
                this.f28751b = A.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f28750a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f28751b.isEmpty() || !this.f28752c.isEmpty()) {
                sb.append(this.f28751b);
                if (!this.f28752c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f28752c);
                }
                sb.append('@');
            }
            String str2 = this.f28753d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f28753d);
                    sb.append(']');
                } else {
                    sb.append(this.f28753d);
                }
            }
            if (this.f28754e != -1 || this.f28750a != null) {
                int b2 = b();
                String str3 = this.f28750a;
                if (str3 == null || b2 != A.a(str3)) {
                    sb.append(':');
                    sb.append(b2);
                }
            }
            A.b(sb, this.f28755f);
            if (this.f28756g != null) {
                sb.append('?');
                A.a(sb, this.f28756g);
            }
            if (this.f28757h != null) {
                sb.append('#');
                sb.append(this.f28757h);
            }
            return sb.toString();
        }

        private static int f(String str, int i, int i2) {
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

        private static int e(String str, int i, int i2) {
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

        public a a(@Nullable String str) {
            this.f28756g = str != null ? A.d(A.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a c() {
            int size = this.f28755f.size();
            for (int i = 0; i < size; i++) {
                this.f28755f.set(i, A.a(this.f28755f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f28756g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f28756g.get(i2);
                    if (str != null) {
                        this.f28756g.set(i2, A.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f28757h;
            if (str2 != null) {
                this.f28757h = A.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        int b() {
            int i = this.f28754e;
            return i != -1 ? i : A.a(this.f28750a);
        }

        public a a(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f28756g == null) {
                    this.f28756g = new ArrayList();
                }
                this.f28756g.add(A.a(str, " \"'<>#&=", true, false, true, true));
                this.f28756g.add(str2 != null ? A.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public a b(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f28756g == null) {
                    this.f28756g = new ArrayList();
                }
                this.f28756g.add(A.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                this.f28756g.add(str2 != null ? A.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f28755f;
                list.set(list.size() - 1, "");
            } else {
                this.f28755f.clear();
                this.f28755f.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.a.e.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void d() {
            if (this.f28755f.remove(r0.size() - 1).isEmpty() && !this.f28755f.isEmpty()) {
                this.f28755f.set(r0.size() - 1, "");
            } else {
                this.f28755f.add("");
            }
        }

        private static int b(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(A.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public A a() {
            if (this.f28750a != null) {
                if (this.f28753d != null) {
                    return new A(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int c(String str, int i, int i2) {
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

        a a(@Nullable A a2, String str) {
            int a3;
            int i;
            int a4 = okhttp3.a.e.a(str, 0, str.length());
            int b2 = okhttp3.a.e.b(str, a4, str.length());
            int e2 = e(str, a4, b2);
            if (e2 != -1) {
                if (str.regionMatches(true, a4, "https:", 0, 6)) {
                    this.f28750a = "https";
                    a4 += 6;
                } else if (str.regionMatches(true, a4, "http:", 0, 5)) {
                    this.f28750a = "http";
                    a4 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, e2) + "'");
                }
            } else if (a2 != null) {
                this.f28750a = a2.f28743b;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f2 = f(str, a4, b2);
            char c2 = '?';
            char c3 = '#';
            if (f2 < 2 && a2 != null && a2.f28743b.equals(this.f28750a)) {
                this.f28751b = a2.f();
                this.f28752c = a2.b();
                this.f28753d = a2.f28746e;
                this.f28754e = a2.f28747f;
                this.f28755f.clear();
                this.f28755f.addAll(a2.d());
                if (a4 == b2 || str.charAt(a4) == '#') {
                    a(a2.e());
                }
            } else {
                int i2 = a4 + f2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a3 = okhttp3.a.e.a(str, i2, b2, "@/\\?#");
                    char charAt = a3 != b2 ? str.charAt(a3) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a5 = okhttp3.a.e.a(str, i2, a3, ':');
                            i = a3;
                            String a6 = A.a(str, i2, a5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a6 = this.f28751b + "%40" + a6;
                            }
                            this.f28751b = a6;
                            if (a5 != i) {
                                this.f28752c = A.a(str, a5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a3;
                            this.f28752c += "%40" + A.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int c4 = c(str, i2, a3);
                int i3 = c4 + 1;
                if (i3 < a3) {
                    this.f28753d = a(str, i2, c4);
                    this.f28754e = b(str, i3, a3);
                    if (this.f28754e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a3) + '\"');
                    }
                } else {
                    this.f28753d = a(str, i2, c4);
                    this.f28754e = A.a(this.f28750a);
                }
                if (this.f28753d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, c4) + '\"');
                }
                a4 = a3;
            }
            int a7 = okhttp3.a.e.a(str, a4, b2, "?#");
            d(str, a4, a7);
            if (a7 < b2 && str.charAt(a7) == '?') {
                int a8 = okhttp3.a.e.a(str, a7, b2, '#');
                this.f28756g = A.d(A.a(str, a7 + 1, a8, " \"'<>#", true, false, true, true, null));
                a7 = a8;
            }
            if (a7 < b2 && str.charAt(a7) == '#') {
                this.f28757h = A.a(str, 1 + a7, b2, "", true, false, false, false, null);
            }
            return this;
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = A.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a2)) {
                return;
            }
            if (g(a2)) {
                d();
                return;
            }
            if (this.f28755f.get(r11.size() - 1).isEmpty()) {
                this.f28755f.set(r11.size() - 1, a2);
            } else {
                this.f28755f.add(a2);
            }
            if (z) {
                this.f28755f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            return okhttp3.a.e.a(A.a(str, i, i2, false));
        }
    }

    A(a aVar) {
        this.f28743b = aVar.f28750a;
        this.f28744c = a(aVar.f28751b, false);
        this.f28745d = a(aVar.f28752c, false);
        this.f28746e = aVar.f28753d;
        this.f28747f = aVar.b();
        this.f28748g = a(aVar.f28755f, false);
        List<String> list = aVar.f28756g;
        this.f28749h = list != null ? a(list, true) : null;
        String str = aVar.f28757h;
        this.i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f28745d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f28743b.length() + 3) + 1, this.j.indexOf(64));
    }

    public String c() {
        int indexOf = this.j.indexOf(47, this.f28743b.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.a.e.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.j.indexOf(47, this.f28743b.length() + 3);
        String str = this.j;
        int a2 = okhttp3.a.e.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = okhttp3.a.e.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public String e() {
        if (this.f28749h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.a.e.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof A) && ((A) obj).j.equals(this.j);
    }

    public String f() {
        if (this.f28744c.isEmpty()) {
            return "";
        }
        int length = this.f28743b.length() + 3;
        String str = this.j;
        return this.j.substring(length, okhttp3.a.e.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f28746e;
    }

    public boolean h() {
        return this.f28743b.equals("https");
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f28750a = this.f28743b;
        aVar.f28751b = f();
        aVar.f28752c = b();
        aVar.f28753d = this.f28746e;
        aVar.f28754e = this.f28747f != a(this.f28743b) ? this.f28747f : -1;
        aVar.f28755f.clear();
        aVar.f28755f.addAll(d());
        aVar.a(e());
        aVar.f28757h = a();
        return aVar;
    }

    public List<String> j() {
        return this.f28748g;
    }

    public int k() {
        return this.f28747f;
    }

    @Nullable
    public String l() {
        if (this.f28749h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f28749h);
        return sb.toString();
    }

    public String m() {
        a c2 = c("/...");
        c2.e("");
        c2.c("");
        return c2.a().toString();
    }

    public String n() {
        return this.f28743b;
    }

    public URI o() {
        a i = i();
        i.c();
        String aVar = i.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String toString() {
        return this.j;
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

    @Nullable
    public a c(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    @Nullable
    public A e(String str) {
        a c2 = c(str);
        if (c2 != null) {
            return c2.a();
        }
        return null;
    }

    static List<String> d(String str) {
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

    public static A b(String str) {
        a aVar = new a();
        aVar.a((A) null, str);
        return aVar.a();
    }

    @Nullable
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
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
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
                int a2 = okhttp3.a.e.a(str.charAt(i + 1));
                int a3 = okhttp3.a.e.a(str.charAt(i3));
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

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.a.e.a(str.charAt(i + 1)) != -1 && okhttp3.a.e.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            okio.g gVar = new okio.g();
            gVar.a(str, i, i3);
            a(gVar, str, i3, i2, str2, z, z2, z3, z4, charset);
            return gVar.s();
        }
        return str.substring(i, i2);
    }

    static void a(okio.g gVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        okio.g gVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    gVar.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    gVar.c(codePointAt);
                } else {
                    if (gVar2 == null) {
                        gVar2 = new okio.g();
                    }
                    if (charset != null && !charset.equals(okhttp3.a.e.j)) {
                        gVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        gVar2.c(codePointAt);
                    }
                    while (!gVar2.l()) {
                        int readByte = gVar2.readByte() & 255;
                        gVar.writeByte(37);
                        gVar.writeByte((int) f28742a[(readByte >> 4) & 15]);
                        gVar.writeByte((int) f28742a[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
