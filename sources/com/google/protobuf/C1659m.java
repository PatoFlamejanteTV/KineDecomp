package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1659m implements Internal.EnumLiteMap<DescriptorProtos.FileOptions.OptimizeMode> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public DescriptorProtos.FileOptions.OptimizeMode a(int i) {
        return DescriptorProtos.FileOptions.OptimizeMode.forNumber(i);
    }
}
