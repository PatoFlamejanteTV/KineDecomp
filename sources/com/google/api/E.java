package com.google.api;

import com.google.api.MetricDescriptor;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
class E implements Internal.EnumLiteMap<MetricDescriptor.ValueType> {
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public MetricDescriptor.ValueType a(int i) {
        return MetricDescriptor.ValueType.forNumber(i);
    }
}
