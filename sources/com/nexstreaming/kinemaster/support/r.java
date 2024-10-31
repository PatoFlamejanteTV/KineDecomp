package com.nexstreaming.kinemaster.support;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SupportItem.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    String f21255a;

    /* renamed from: b */
    String f21256b;

    /* renamed from: d */
    String f21258d;

    /* renamed from: e */
    List<r> f21259e;

    /* renamed from: f */
    r f21260f;

    /* renamed from: c */
    String f21257c = null;

    /* renamed from: g */
    String f21261g = null;

    private r(String str, String str2, String str3, r rVar) {
        List<r> list;
        this.f21255a = null;
        this.f21256b = null;
        this.f21258d = null;
        this.f21259e = null;
        this.f21260f = null;
        this.f21255a = str;
        this.f21256b = str2 != null ? str2 : str;
        this.f21260f = rVar;
        this.f21258d = str3;
        this.f21259e = new ArrayList();
        r rVar2 = this.f21260f;
        if (rVar2 == null || (list = rVar2.f21259e) == null) {
            return;
        }
        list.add(this);
    }

    public static r a(String str, String str2, String str3, r rVar) {
        return new r(str, str2, str3, rVar);
    }

    public static r a(String str, String str2, String str3, String str4, r rVar) {
        r rVar2 = new r(str, str2, str4, rVar);
        rVar2.f21261g = str3;
        return rVar2;
    }
}
