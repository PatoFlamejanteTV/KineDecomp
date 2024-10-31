package com.adobe.xmp.a;

/* compiled from: QName.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    private String f7512a;

    /* renamed from: b */
    private String f7513b;

    public j(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.f7512a = str.substring(0, indexOf);
            this.f7513b = str.substring(indexOf + 1);
        } else {
            this.f7512a = "";
            this.f7513b = str;
        }
    }

    public String a() {
        return this.f7512a;
    }

    public boolean b() {
        String str = this.f7512a;
        return str != null && str.length() > 0;
    }
}
