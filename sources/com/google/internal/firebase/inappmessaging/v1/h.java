package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
class h implements Internal.ListAdapter.Converter<Integer, CommonTypesProto.CampaignState> {
    @Override // com.google.protobuf.Internal.ListAdapter.Converter
    public CommonTypesProto.CampaignState a(Integer num) {
        CommonTypesProto.CampaignState forNumber = CommonTypesProto.CampaignState.forNumber(num.intValue());
        return forNumber == null ? CommonTypesProto.CampaignState.UNRECOGNIZED : forNumber;
    }
}
