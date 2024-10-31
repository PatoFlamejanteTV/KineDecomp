package com.squareup.okhttp.internal.http;

import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.InterfaceC2376b;
import com.squareup.okhttp.x;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: OkHeaders.java */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<String> f25476a = new p();

    /* renamed from: b, reason: collision with root package name */
    static final String f25477b = com.squareup.okhttp.a.l.a().b();

    /* renamed from: c, reason: collision with root package name */
    public static final String f25478c = f25477b + "-Sent-Millis";

    /* renamed from: d, reason: collision with root package name */
    public static final String f25479d = f25477b + "-Received-Millis";

    /* renamed from: e, reason: collision with root package name */
    public static final String f25480e = f25477b + "-Selected-Protocol";

    /* renamed from: f, reason: collision with root package name */
    public static final String f25481f = f25477b + "-Response-Source";

    public static long a(E e2) {
        return a(e2.c());
    }

    private static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> c(x xVar) {
        Set<String> emptySet = Collections.emptySet();
        int b2 = xVar.b();
        Set<String> set = emptySet;
        for (int i = 0; i < b2; i++) {
            if ("Vary".equalsIgnoreCase(xVar.a(i))) {
                String b3 = xVar.b(i);
                if (set.isEmpty()) {
                    set = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : b3.split(",")) {
                    set.add(str.trim());
                }
            }
        }
        return set;
    }

    private static Set<String> d(H h2) {
        return c(h2.g());
    }

    public static long a(H h2) {
        return a(h2.g());
    }

    public static Map<String, List<String>> b(x xVar, String str) {
        TreeMap treeMap = new TreeMap(f25476a);
        int b2 = xVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = xVar.a(i);
            String b3 = xVar.b(i);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(a2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(b3);
            treeMap.put(a2, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static long a(x xVar) {
        return b(xVar.a(HttpHeaders.CONTENT_LENGTH));
    }

    public static void a(E.a aVar, Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                if (!entry.getValue().isEmpty()) {
                    aVar.a(key, a(entry.getValue()));
                }
            }
        }
    }

    private static String a(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static x c(H h2) {
        return a(h2.i().l().c(), h2.g());
    }

    public static boolean b(H h2) {
        return b(h2.g());
    }

    public static boolean b(x xVar) {
        return c(xVar).contains("*");
    }

    public static boolean a(H h2, x xVar, E e2) {
        for (String str : d(h2)) {
            if (!com.squareup.okhttp.a.o.a(xVar.c(str), e2.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static x a(x xVar, x xVar2) {
        Set<String> c2 = c(xVar2);
        if (c2.isEmpty()) {
            return new x.a().a();
        }
        x.a aVar = new x.a();
        int b2 = xVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = xVar.a(i);
            if (c2.contains(a2)) {
                aVar.a(a2, xVar.b(i));
            }
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List<com.squareup.okhttp.l> a(x xVar, String str) {
        ArrayList arrayList = new ArrayList();
        int b2 = xVar.b();
        for (int i = 0; i < b2; i++) {
            if (str.equalsIgnoreCase(xVar.a(i))) {
                String b3 = xVar.b(i);
                int i2 = 0;
                while (i2 < b3.length()) {
                    int a2 = e.a(b3, i2, " ");
                    String trim = b3.substring(i2, a2).trim();
                    int b4 = e.b(b3, a2);
                    if (!b3.regionMatches(true, b4, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i3 = b4 + 7;
                    int a3 = e.a(b3, i3, "\"");
                    String substring = b3.substring(i3, a3);
                    i2 = e.b(b3, e.a(b3, a3 + 1, ",") + 1);
                    arrayList.add(new com.squareup.okhttp.l(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static E a(InterfaceC2376b interfaceC2376b, H h2, Proxy proxy) throws IOException {
        if (h2.e() == 407) {
            return interfaceC2376b.a(proxy, h2);
        }
        return interfaceC2376b.b(proxy, h2);
    }
}
