package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: NetworkResponse.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    public final int f8070a;

    /* renamed from: b */
    public final byte[] f8071b;

    /* renamed from: c */
    public final Map<String, String> f8072c;

    /* renamed from: d */
    public final List<g> f8073d;

    /* renamed from: e */
    public final boolean f8074e;

    /* renamed from: f */
    public final long f8075f;

    @Deprecated
    public j(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }

    public j(int i, byte[] bArr, boolean z, long j, List<g> list) {
        this(i, bArr, a(list), list, z, j);
    }

    @Deprecated
    public j(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private j(int i, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j) {
        this.f8070a = i;
        this.f8071b = bArr;
        this.f8072c = map;
        if (list == null) {
            this.f8073d = null;
        } else {
            this.f8073d = Collections.unmodifiableList(list);
        }
        this.f8074e = z;
        this.f8075f = j;
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
