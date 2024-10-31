package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpRestoreLoginInfo.java */
/* loaded from: classes2.dex */
public class n extends TLP<CpRestoreLoginInfoRequest, CpRestoreLoginInfoResponse> {
    private static n l;

    private n(Context context) {
        super(context, CpRestoreLoginInfoResponse.class);
    }

    public static n a(Context context) {
        if (l == null) {
            l = new n(context);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = m.f19787a[responseCode.ordinal()];
        return i == 1 || i == 2;
    }
}
