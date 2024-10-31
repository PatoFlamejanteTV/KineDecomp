package com.squareup.okhttp.internal.framed;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NameValueBlockReader.java */
/* loaded from: classes3.dex */
public class u extends okio.l {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ w f25402b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(w wVar, okio.z zVar) {
        super(zVar);
        this.f25402b = wVar;
    }

    @Override // okio.l, okio.z
    public long b(okio.g gVar, long j) throws IOException {
        int i;
        int i2;
        int i3;
        i = this.f25402b.f25405b;
        if (i == 0) {
            return -1L;
        }
        i2 = this.f25402b.f25405b;
        long b2 = super.b(gVar, Math.min(j, i2));
        if (b2 == -1) {
            return -1L;
        }
        w wVar = this.f25402b;
        i3 = wVar.f25405b;
        wVar.f25405b = (int) (i3 - b2);
        return b2;
    }
}
