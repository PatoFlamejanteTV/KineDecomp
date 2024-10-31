package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.framed.j;
import java.io.IOException;

/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
class k extends j.b {
    @Override // com.squareup.okhttp.internal.framed.j.b
    public void a(p pVar) throws IOException {
        pVar.a(ErrorCode.REFUSED_STREAM);
    }
}
