package com.squareup.okhttp.internal.framed;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* renamed from: com.squareup.okhttp.internal.framed.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2386c extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25287b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f25288c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f25289d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2386c(j jVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f25289d = jVar;
        this.f25287b = i;
        this.f25288c = errorCode;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        try {
            this.f25289d.b(this.f25287b, this.f25288c);
        } catch (IOException unused) {
        }
    }
}
