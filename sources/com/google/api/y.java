package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
class y implements Internal.EnumLiteMap<LabelDescriptor.ValueType> {
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public LabelDescriptor.ValueType a(int i) {
        return LabelDescriptor.ValueType.forNumber(i);
    }
}
