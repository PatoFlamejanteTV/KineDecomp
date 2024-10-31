package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes3.dex */
class y implements z {
    @Override // com.squareup.okhttp.internal.framed.z
    public void a(int i, ErrorCode errorCode) {
    }

    @Override // com.squareup.okhttp.internal.framed.z
    public boolean a(int i, List<q> list) {
        return true;
    }

    @Override // com.squareup.okhttp.internal.framed.z
    public boolean a(int i, List<q> list, boolean z) {
        return true;
    }

    @Override // com.squareup.okhttp.internal.framed.z
    public boolean a(int i, okio.i iVar, int i2, boolean z) throws IOException {
        iVar.skip(i2);
        return true;
    }
}
