package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: AuthPromocode.java */
/* loaded from: classes2.dex */
public class d extends TLP<AuthPromocodeRequest, AuthPromocodeResponse> {
    private static d l;

    private d(Context context) {
        super(context, AuthPromocodeResponse.class);
    }

    public static d a(Context context) {
        if (l == null) {
            l = new d(context);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = c.f19782a[responseCode.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
