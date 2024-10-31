package com.umeng.commonsdk.proguard;

import com.facebook.share.internal.ShareConstants;

/* compiled from: TApplicationException.java */
/* loaded from: classes3.dex */
public class i extends p {

    /* renamed from: a, reason: collision with root package name */
    public static final int f26260a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f26261b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f26262c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f26263d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f26264e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f26265f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f26266g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f26267h = 7;
    private static final an j = new an("TApplicationException");
    private static final ad k = new ad(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, (byte) 11, 1);
    private static final ad l = new ad("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public i() {
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public void b(ai aiVar) throws p {
        aiVar.a(j);
        if (getMessage() != null) {
            aiVar.a(k);
            aiVar.a(getMessage());
            aiVar.c();
        }
        aiVar.a(l);
        aiVar.a(this.i);
        aiVar.c();
        aiVar.d();
        aiVar.b();
    }

    public static i a(ai aiVar) throws p {
        aiVar.j();
        String str = null;
        int i = 0;
        while (true) {
            ad l2 = aiVar.l();
            byte b2 = l2.f26172b;
            if (b2 == 0) {
                aiVar.k();
                return new i(i, str);
            }
            short s = l2.f26173c;
            if (s != 1) {
                if (s != 2) {
                    al.a(aiVar, b2);
                } else if (b2 == 8) {
                    i = aiVar.w();
                } else {
                    al.a(aiVar, b2);
                }
            } else if (b2 == 11) {
                str = aiVar.z();
            } else {
                al.a(aiVar, b2);
            }
            aiVar.m();
        }
    }

    public i(int i) {
        this.i = 0;
        this.i = i;
    }

    public i(int i, String str) {
        super(str);
        this.i = 0;
        this.i = i;
    }

    public i(String str) {
        super(str);
        this.i = 0;
    }
}
