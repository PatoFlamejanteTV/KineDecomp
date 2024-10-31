package com.umeng.commonsdk.proguard;

import java.io.Serializable;

/* compiled from: FieldValueMetaData.java */
/* loaded from: classes3.dex */
public class w implements Serializable {

    /* renamed from: a */
    private final boolean f26286a;

    /* renamed from: b */
    public final byte f26287b;

    /* renamed from: c */
    private final String f26288c;

    /* renamed from: d */
    private final boolean f26289d;

    public w(byte b2, boolean z) {
        this.f26287b = b2;
        this.f26286a = false;
        this.f26288c = null;
        this.f26289d = z;
    }

    public boolean a() {
        return this.f26286a;
    }

    public String b() {
        return this.f26288c;
    }

    public boolean c() {
        return this.f26287b == 12;
    }

    public boolean d() {
        byte b2 = this.f26287b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f26289d;
    }

    public w(byte b2) {
        this(b2, false);
    }

    public w(byte b2, String str) {
        this.f26287b = b2;
        this.f26286a = true;
        this.f26288c = str;
        this.f26289d = false;
    }
}
