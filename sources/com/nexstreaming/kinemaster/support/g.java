package com.nexstreaming.kinemaster.support;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SupportItem.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    String f3636a;
    String b;
    String c = null;
    String d;
    List<g> e;
    g f;

    public static g a(String str, String str2, String str3, g gVar) {
        return new g(str, str2, str3, gVar);
    }

    public g(String str, String str2, String str3, g gVar) {
        this.f3636a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f3636a = str;
        this.b = str2 != null ? str2 : str;
        this.f = gVar;
        this.d = str3;
        this.e = new ArrayList();
        if (this.f != null && this.f.e != null) {
            this.f.e.add(this);
        }
    }
}
