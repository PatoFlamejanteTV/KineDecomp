package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpLoginInfo.java */
/* loaded from: classes2.dex */
public class f extends TLP<CpLoginInfoRequest, CpLoginInfoResponse> {
    private static f l;

    private f(Context context) {
        super(context, CpLoginInfoResponse.class);
    }

    public static f a(Context context) {
        if (l == null) {
            l = new f(context);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = e.f19783a[responseCode.ordinal()];
        return i == 1 || i == 2;
    }
}
