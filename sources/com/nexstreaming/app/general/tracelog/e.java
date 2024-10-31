package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpOrderId.java */
/* loaded from: classes.dex */
public class e extends TLP<CpOrderIdRequest, CpOrderIdResponse> {
    private static e b;

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

    public static e a(Context context) {
        if (b == null) {
            b = new e(context);
        }
        return b;
    }

    private e(Context context) {
        super(context, CpOrderIdResponse.class);
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
