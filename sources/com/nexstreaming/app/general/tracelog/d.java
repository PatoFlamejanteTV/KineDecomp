package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpLoginInfo.java */
/* loaded from: classes.dex */
public class d extends TLP<CpLoginInfoRequest, CpLoginInfoResponse> {
    private static d b;

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ long a() {
        return super.a();
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ long b() {
        return super.b();
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void b(boolean z) {
        super.b(z);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private d(Context context) {
        super(context, CpLoginInfoResponse.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        switch (responseCode) {
            case SUCCESS:
            case ALREADY_IAP_REGISTERED:
                return true;
            default:
                return false;
        }
    }
}
