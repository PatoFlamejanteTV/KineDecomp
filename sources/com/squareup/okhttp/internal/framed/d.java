package com.squareup.okhttp.internal.framed;

import java.io.IOException;

/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
class d extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25290b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f25291c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f25292d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(j jVar, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.f25292d = jVar;
        this.f25290b = i;
        this.f25291c = j;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        try {
            this.f25292d.v.a(this.f25290b, this.f25291c);
        } catch (IOException unused) {
        }
    }
}
