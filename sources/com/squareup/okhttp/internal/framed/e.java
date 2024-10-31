package com.squareup.okhttp.internal.framed;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public class e extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f25293b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f25294c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f25295d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ x f25296e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ j f25297f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(j jVar, String str, Object[] objArr, boolean z, int i, int i2, x xVar) {
        super(str, objArr);
        this.f25297f = jVar;
        this.f25293b = z;
        this.f25294c = i;
        this.f25295d = i2;
        this.f25296e = xVar;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        try {
            this.f25297f.a(this.f25293b, this.f25294c, this.f25295d, this.f25296e);
        } catch (IOException unused) {
        }
    }
}
