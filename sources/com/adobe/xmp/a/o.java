package com.adobe.xmp.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XMPMetaImpl.java */
/* loaded from: classes.dex */
public class o implements com.adobe.xmp.c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f7542a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Object f7543b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ s f7544c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar, Object obj, s sVar) {
        this.f7542a = pVar;
        this.f7543b = obj;
        this.f7544c = sVar;
    }

    @Override // com.adobe.xmp.c.b
    public com.adobe.xmp.b.e a() {
        return this.f7544c.i();
    }

    @Override // com.adobe.xmp.c.b
    public String getValue() {
        Object obj = this.f7543b;
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public String toString() {
        return this.f7543b.toString();
    }
}
