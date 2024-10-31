package com.umeng.commonsdk.statistics.idtracking;

import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AbstractIdTracker.java */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a */
    private final int f26395a = 10;

    /* renamed from: b */
    private final int f26396b = 20;

    /* renamed from: c */
    private final String f26397c;

    /* renamed from: d */
    private List<com.umeng.commonsdk.statistics.proto.a> f26398d;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.proto.b f26399e;

    public a(String str) {
        this.f26397c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f26399e;
        String b2 = bVar == null ? null : bVar.b();
        int h2 = bVar == null ? 0 : bVar.h();
        String a2 = a(f());
        if (a2 == null || a2.equals(b2)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a2);
        bVar.a(System.currentTimeMillis());
        bVar.a(h2 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f26397c);
        aVar.c(a2);
        aVar.b(b2);
        aVar.a(bVar.e());
        if (this.f26398d == null) {
            this.f26398d = new ArrayList(2);
        }
        this.f26398d.add(aVar);
        if (this.f26398d.size() > 10) {
            this.f26398d.remove(0);
        }
        this.f26399e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f26397c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f26399e;
        return bVar == null || bVar.h() <= 20;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f26399e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f26398d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f26399e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f26398d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f26399e = cVar.c().get(this.f26397c);
        List<com.umeng.commonsdk.statistics.proto.a> h2 = cVar.h();
        if (h2 == null || h2.size() <= 0) {
            return;
        }
        if (this.f26398d == null) {
            this.f26398d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h2) {
            if (this.f26397c.equals(aVar.f26474a)) {
                this.f26398d.add(aVar);
            }
        }
    }
}
