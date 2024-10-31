package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* compiled from: AdobeDCXMetadataPath.java */
/* loaded from: classes.dex */
public class Ja {

    /* renamed from: a */
    private String f4189a;

    /* renamed from: b */
    private String f4190b;

    public Ja(String str, String str2) {
        this.f4189a = str;
        this.f4190b = str2;
    }

    static Ja a(String str, String str2) {
        return new Ja(str, str2);
    }

    public String b() {
        return this.f4190b;
    }

    public String c() {
        return this.f4189a;
    }

    public static Ja a() {
        return a("http://ns.adobe.com/xap/1.0/mm/", "DocumentID");
    }
}
