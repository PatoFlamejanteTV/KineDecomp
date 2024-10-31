package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpOrderId.java */
/* loaded from: classes2.dex */
public class h extends TLP<CpOrderIdRequest, CpOrderIdResponse> {
    private static h l;

    private h(Context context) {
        super(context, CpOrderIdResponse.class);
    }

    public static h a(Context context) {
        if (l == null) {
            l = new h(context);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = g.f19784a[responseCode.ordinal()];
        return i == 1 || i == 2;
    }
}
