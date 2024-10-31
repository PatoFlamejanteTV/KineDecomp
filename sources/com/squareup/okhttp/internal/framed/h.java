package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public class h extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25305b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ okio.g f25306c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f25307d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f25308e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ j f25309f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar, String str, Object[] objArr, int i, okio.g gVar, int i2, boolean z) {
        super(str, objArr);
        this.f25309f = jVar;
        this.f25305b = i;
        this.f25306c = gVar;
        this.f25307d = i2;
        this.f25308e = z;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        z zVar;
        Set set;
        try {
            zVar = this.f25309f.m;
            boolean a2 = zVar.a(this.f25305b, this.f25306c, this.f25307d, this.f25308e);
            if (a2) {
                this.f25309f.v.a(this.f25305b, ErrorCode.CANCEL);
            }
            if (a2 || this.f25308e) {
                synchronized (this.f25309f) {
                    set = this.f25309f.x;
                    set.remove(Integer.valueOf(this.f25305b));
                }
            }
        } catch (IOException unused) {
        }
    }
}
