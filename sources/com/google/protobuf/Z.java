package com.google.protobuf;

import com.google.protobuf.aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFormatEscaper.java */
/* loaded from: classes2.dex */
public class Z implements aa.a {

    /* renamed from: a */
    final /* synthetic */ ByteString f18742a;

    public Z(ByteString byteString) {
        this.f18742a = byteString;
    }

    @Override // com.google.protobuf.aa.a
    public byte a(int i) {
        return this.f18742a.byteAt(i);
    }

    @Override // com.google.protobuf.aa.a
    public int size() {
        return this.f18742a.size();
    }
}
