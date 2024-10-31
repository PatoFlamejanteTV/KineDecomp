package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public class g extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f25301b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f25302c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f25303d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ j f25304e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.f25304e = jVar;
        this.f25301b = i;
        this.f25302c = list;
        this.f25303d = z;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        z zVar;
        Set set;
        zVar = this.f25304e.m;
        boolean a2 = zVar.a(this.f25301b, this.f25302c, this.f25303d);
        if (a2) {
            try {
                this.f25304e.v.a(this.f25301b, ErrorCode.CANCEL);
            } catch (IOException unused) {
                return;
            }
        }
        if (a2 || this.f25303d) {
            synchronized (this.f25304e) {
                set = this.f25304e.x;
                set.remove(Integer.valueOf(this.f25301b));
            }
        }
    }
}
