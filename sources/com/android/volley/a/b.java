package com.android.volley.a;

import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.a;
import com.android.volley.p;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: BasicNetwork.java */
/* loaded from: classes.dex */
public class b implements com.android.volley.h {

    /* renamed from: a, reason: collision with root package name */
    protected static final boolean f7989a = p.f8092b;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    protected final h f7990b;

    /* renamed from: c, reason: collision with root package name */
    private final a f7991c;

    /* renamed from: d, reason: collision with root package name */
    protected final d f7992d;

    public b(a aVar) {
        this(aVar, new d(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:            throw new java.io.IOException();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // com.android.volley.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.android.volley.j a(com.android.volley.Request<?> r29) throws com.android.volley.VolleyError {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.a.b.a(com.android.volley.Request):com.android.volley.j");
    }

    public b(a aVar, d dVar) {
        this.f7991c = aVar;
        this.f7990b = aVar;
        this.f7992d = dVar;
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (f7989a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.n().a());
            p.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        com.android.volley.o n = request.n();
        int o = request.o();
        try {
            n.a(volleyError);
            request.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(o)));
        } catch (VolleyError e2) {
            request.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(o)));
            throw e2;
        }
    }

    private Map<String, String> a(a.C0040a c0040a) {
        if (c0040a == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = c0040a.f7982b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = c0040a.f7984d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", f.a(j));
        }
        return hashMap;
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, ServerError {
        o oVar = new o(this.f7992d, i);
        try {
            if (inputStream != null) {
                byte[] a2 = this.f7992d.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    oVar.write(a2, 0, read);
                }
                byte[] byteArray = oVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        p.c("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f7992d.a(a2);
                oVar.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    p.c("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f7992d.a((byte[]) null);
            oVar.close();
            throw th;
        }
    }

    private static List<com.android.volley.g> a(List<com.android.volley.g> list, a.C0040a c0040a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.android.volley.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.android.volley.g> list2 = c0040a.f7988h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.android.volley.g gVar : c0040a.f7988h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!c0040a.f7987g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0040a.f7987g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.android.volley.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
