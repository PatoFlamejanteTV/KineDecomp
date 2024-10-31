package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.framed.j;
import java.io.IOException;
import java.util.logging.Level;

/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
class l extends com.squareup.okhttp.a.j {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f25332b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ j.c f25333c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j.c cVar, String str, Object[] objArr, p pVar) {
        super(str, objArr);
        this.f25333c = cVar;
        this.f25332b = pVar;
    }

    @Override // com.squareup.okhttp.a.j
    public void c() {
        j.b bVar;
        try {
            bVar = j.this.f25316d;
            bVar.a(this.f25332b);
        } catch (IOException e2) {
            com.squareup.okhttp.a.h.f25191a.log(Level.INFO, "FramedConnection.Listener failure for " + j.this.f25318f, (Throwable) e2);
            try {
                this.f25332b.a(ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
