package c.d.b.d.b.a.a;

import android.net.Uri;

/* compiled from: MediaSet.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    String f3707a;

    /* renamed from: b */
    String f3708b;

    /* renamed from: c */
    String f3709c;

    /* renamed from: d */
    float f3710d;

    /* renamed from: e */
    int f3711e;

    /* renamed from: f */
    int f3712f;

    /* renamed from: g */
    int f3713g;

    /* renamed from: h */
    int f3714h;
    Uri i;

    public a() {
        this.f3710d = 0.0f;
        this.f3711e = 0;
        this.f3714h = -1;
    }

    public String a() {
        Uri uri = this.i;
        if (uri != null) {
            return uri.toString();
        }
        return d();
    }

    public float b() {
        return this.f3710d;
    }

    public String c() {
        return this.f3708b;
    }

    public String d() {
        return c.d.b.d.e.a.b(this.f3708b);
    }

    public int e() {
        return this.f3711e;
    }

    public int f() {
        return this.f3713g;
    }

    public String g() {
        return this.f3707a;
    }

    public String h() {
        return this.f3709c;
    }

    public int i() {
        return this.f3714h;
    }

    public int j() {
        return this.f3712f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nMediaSet ............................. ");
        sb.append("\n\t path     : " + this.f3708b);
        sb.append("\n\t mimetype : " + this.f3709c);
        sb.append("\n\t duration : " + this.f3710d);
        return sb.toString();
    }

    public a(String str, String str2, Uri uri, String str3) {
        this();
        this.f3707a = str;
        this.f3708b = str2;
        this.f3709c = str3;
        this.i = uri;
    }

    public a(String str, String str2, Uri uri, String str3, float f2) {
        this(str, str2, uri, str3);
        this.f3710d = f2;
    }

    public a(String str, String str2, Uri uri, String str3, float f2, int i, int i2) {
        this(str, str2, uri, str3, f2);
        this.f3712f = i;
        this.f3713g = i2;
    }

    public a(String str, String str2, Uri uri, String str3, float f2, int i, int i2, int i3, int i4) {
        this(str, str2, uri, str3, f2, i, i2);
        this.f3711e = i3;
        this.f3714h = i4;
    }
}
