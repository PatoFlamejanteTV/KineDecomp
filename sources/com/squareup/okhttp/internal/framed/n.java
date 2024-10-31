package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.framed.j;
import java.io.IOException;

/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
class n extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f25335b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ j.c f25336c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j.c cVar, String str, Object[] objArr, A a2) {
        super(str, objArr);
        this.f25336c = cVar;
        this.f25335b = a2;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        try {
            j.this.v.a(this.f25335b);
        } catch (IOException unused) {
        }
    }
}
