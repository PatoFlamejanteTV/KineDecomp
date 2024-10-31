package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Headers.java */
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a */
    private final String[] f29223a;

    z(a aVar) {
        List<String> list = aVar.f29224a;
        this.f29223a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(int i) {
        return this.f29223a[i * 2];
    }

    @Nullable
    public String b(String str) {
        return a(this.f29223a, str);
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

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof z) && Arrays.equals(((z) obj).f29223a, this.f29223a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f29223a);
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

    /* compiled from: Headers.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final List<String> f29224a = new ArrayList(20);

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

        public a b(String str, String str2) {
            this.f29224a.add(str);
            this.f29224a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            z.a(str);
            z.a(str2, str);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f29224a.size()) {
                if (str.equalsIgnoreCase(this.f29224a.get(i))) {
                    this.f29224a.remove(i);
                    this.f29224a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            z.a(str);
            z.a(str2, str);
            b(str, str2);
            return this;
        }

        public z a() {
            return new z(this);
        }
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f29224a, this.f29223a);
        return aVar;
    }

    public int b() {
        return this.f29223a.length / 2;
    }

    private z(String[] strArr) {
        this.f29223a = strArr;
    }

    public String b(int i) {
        return this.f29223a[(i * 2) + 1];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static z a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    if (strArr2[i] != null) {
                        strArr2[i] = strArr2[i].trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str = strArr2[i2];
                    String str2 = strArr2[i2 + 1];
                    a(str);
                    a(str2, str);
                }
                return new z(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    static void a(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(okhttp3.a.e.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(okhttp3.a.e.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}
