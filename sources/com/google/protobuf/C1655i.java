package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* renamed from: com.google.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1655i implements Internal.EnumLiteMap<DescriptorProtos.FieldDescriptorProto.Label> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public DescriptorProtos.FieldDescriptorProto.Label a(int i) {
        return DescriptorProtos.FieldDescriptorProto.Label.forNumber(i);
    }
}
