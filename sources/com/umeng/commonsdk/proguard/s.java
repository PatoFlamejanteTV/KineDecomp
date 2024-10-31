package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.ac;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer.java */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f26275a;

    /* renamed from: b, reason: collision with root package name */
    private final au f26276b;

    /* renamed from: c, reason: collision with root package name */
    private ai f26277c;

    public s() {
        this(new ac.a());
    }

    public byte[] a(j jVar) throws p {
        this.f26275a.reset();
        jVar.write(this.f26277c);
        return this.f26275a.toByteArray();
    }

    public String b(j jVar) throws p {
        return new String(a(jVar));
    }

    public s(ak akVar) {
        this.f26275a = new ByteArrayOutputStream();
        this.f26276b = new au(this.f26275a);
        this.f26277c = akVar.a(this.f26276b);
    }

    public String a(j jVar, String str) throws p {
        try {
            return new String(a(jVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
