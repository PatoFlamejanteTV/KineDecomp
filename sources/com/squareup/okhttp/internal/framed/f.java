package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public class f extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25298b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f25299c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f25300d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.f25300d = jVar;
        this.f25298b = i;
        this.f25299c = list;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        z zVar;
        Set set;
        zVar = this.f25300d.m;
        if (zVar.a(this.f25298b, this.f25299c)) {
            try {
                this.f25300d.v.a(this.f25298b, ErrorCode.CANCEL);
                synchronized (this.f25300d) {
                    set = this.f25300d.x;
                    set.remove(Integer.valueOf(this.f25298b));
                }
            } catch (IOException unused) {
            }
        }
    }
}
