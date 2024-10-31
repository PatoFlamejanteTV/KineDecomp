package com.mixpanel.android.viewcrawler;

/* compiled from: PropertyDescription.java */
/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f3093a;
    public final Class<?> b;
    public final a c;
    private final String d;

    public g(String str, Class<?> cls, a aVar, String str2) {
        this.f3093a = str;
        this.b = cls;
        this.c = aVar;
        this.d = str2;
    }

    public a a(Object[] objArr) throws NoSuchMethodException {
        if (this.d == null) {
            return null;
        }
        return new a(this.b, this.d, objArr, Void.TYPE);
    }

    public String toString() {
        return "[PropertyDescription " + this.f3093a + "," + this.b + ", " + this.c + "/" + this.d + "]";
    }
}
