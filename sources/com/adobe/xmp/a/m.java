package com.adobe.xmp.a;

import com.adobe.xmp.a.n;

/* compiled from: XMPIteratorImpl.java */
/* loaded from: classes.dex */
class m implements com.adobe.xmp.c.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n.a f7524a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ s f7525b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f7526c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f7527d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f7528e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n.a aVar, s sVar, String str, String str2, String str3) {
        this.f7524a = aVar;
        this.f7525b = sVar;
        this.f7526c = str;
        this.f7527d = str2;
        this.f7528e = str3;
    }

    @Override // com.adobe.xmp.c.c, com.adobe.xmp.c.b
    public com.adobe.xmp.b.e a() {
        return this.f7525b.i();
    }

    @Override // com.adobe.xmp.c.c
    public String getPath() {
        return this.f7527d;
    }

    @Override // com.adobe.xmp.c.c, com.adobe.xmp.c.b
    public String getValue() {
        return this.f7528e;
    }
}
