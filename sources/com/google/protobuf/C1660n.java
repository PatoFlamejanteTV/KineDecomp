package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* renamed from: com.google.protobuf.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1660n implements Internal.EnumLiteMap<DescriptorProtos.MethodOptions.IdempotencyLevel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public DescriptorProtos.MethodOptions.IdempotencyLevel a(int i) {
        return DescriptorProtos.MethodOptions.IdempotencyLevel.forNumber(i);
    }
}
