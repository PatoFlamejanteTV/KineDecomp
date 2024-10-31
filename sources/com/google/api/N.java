package com.google.api;

import com.google.api.Property;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
class N implements Internal.EnumLiteMap<Property.PropertyType> {
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public Property.PropertyType a(int i) {
        return Property.PropertyType.forNumber(i);
    }
}
