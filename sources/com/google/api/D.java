package com.google.api;

import com.google.api.MetricDescriptor;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
class D implements Internal.EnumLiteMap<MetricDescriptor.MetricKind> {
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public MetricDescriptor.MetricKind a(int i) {
        return MetricDescriptor.MetricKind.forNumber(i);
    }
}
