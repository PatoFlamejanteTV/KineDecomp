package io.grpc.a.a;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: ProtoLiteUtils.java */
/* loaded from: classes3.dex */
class b extends ThreadLocal<Reference<byte[]>> {
    @Override // java.lang.ThreadLocal
    public Reference<byte[]> initialValue() {
        return new WeakReference(new byte[4096]);
    }
}
