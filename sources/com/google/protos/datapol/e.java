package com.google.protos.datapol;

import com.google.protobuf.Internal;
import com.google.protos.datapol.SemanticAnnotations;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
class e implements Internal.ListAdapter.Converter<Integer, SemanticAnnotations.SemanticType> {
    @Override // com.google.protobuf.Internal.ListAdapter.Converter
    public SemanticAnnotations.SemanticType a(Integer num) {
        SemanticAnnotations.SemanticType forNumber = SemanticAnnotations.SemanticType.forNumber(num.intValue());
        return forNumber == null ? SemanticAnnotations.SemanticType.ST_NOT_SPECIFIED : forNumber;
    }
}
