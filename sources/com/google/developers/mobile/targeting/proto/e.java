package com.google.developers.mobile.targeting.proto;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
class e implements Internal.EnumLiteMap<Conditions.AppVersionCondition.AppVersionOperator> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.Internal.EnumLiteMap
    public Conditions.AppVersionCondition.AppVersionOperator a(int i) {
        return Conditions.AppVersionCondition.AppVersionOperator.forNumber(i);
    }
}
