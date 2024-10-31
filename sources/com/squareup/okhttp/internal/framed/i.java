package com.squareup.okhttp.internal.framed;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public class i extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25310b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f25311c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f25312d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f25312d = jVar;
        this.f25310b = i;
        this.f25311c = errorCode;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        z zVar;
        Set set;
        zVar = this.f25312d.m;
        zVar.a(this.f25310b, this.f25311c);
        synchronized (this.f25312d) {
            set = this.f25312d.x;
            set.remove(Integer.valueOf(this.f25310b));
        }
    }
}
