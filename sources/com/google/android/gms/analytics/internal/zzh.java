package com.google.android.gms.analytics.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzh {

    /* renamed from: a, reason: collision with root package name */
    private final long f743a;
    private final String b;
    private final String c;
    private final boolean d;
    private long e;
    private final Map<String, String> f;

    public zzh(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        com.google.android.gms.common.internal.zzx.a(str);
        com.google.android.gms.common.internal.zzx.a(str2);
        this.f743a = j;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = j2;
        if (map != null) {
            this.f = new HashMap(map);
        } else {
            this.f = Collections.emptyMap();
        }
    }

    public long a() {
        return this.f743a;
    }

    public void a(long j) {
        this.e = j;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public Map<String, String> f() {
        return this.f;
    }
}
