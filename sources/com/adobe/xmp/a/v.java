package com.adobe.xmp.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XMPSchemaRegistryImpl.java */
/* loaded from: classes.dex */
public class v implements com.adobe.xmp.c.a {

    /* renamed from: a */
    final /* synthetic */ w f7560a;

    /* renamed from: b */
    private final /* synthetic */ String f7561b;

    /* renamed from: c */
    private final /* synthetic */ String f7562c;

    /* renamed from: d */
    private final /* synthetic */ String f7563d;

    /* renamed from: e */
    private final /* synthetic */ com.adobe.xmp.b.a f7564e;

    public v(w wVar, String str, String str2, String str3, com.adobe.xmp.b.a aVar) {
        this.f7560a = wVar;
        this.f7561b = str;
        this.f7562c = str2;
        this.f7563d = str3;
        this.f7564e = aVar;
    }

    @Override // com.adobe.xmp.c.a
    public String a() {
        return this.f7563d;
    }

    @Override // com.adobe.xmp.c.a
    public com.adobe.xmp.b.a b() {
        return this.f7564e;
    }

    @Override // com.adobe.xmp.c.a
    public String getNamespace() {
        return this.f7561b;
    }

    @Override // com.adobe.xmp.c.a
    public String getPrefix() {
        return this.f7562c;
    }

    public String toString() {
        return String.valueOf(this.f7562c) + this.f7563d + " NS(" + this.f7561b + "), FORM (" + b() + ")";
    }
}
