package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: AuthPromocode.java */
/* loaded from: classes.dex */
public class c extends TLP<AuthPromocodeRequest, AuthPromocodeResponse> {
    private static c b;

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

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    private c(Context context) {
        super(context, AuthPromocodeResponse.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        switch (responseCode) {
            case SUCCESS:
            case PROMOCODE_NONE:
            case ALREADYINUSE_PROMOCODE:
                return true;
            default:
                return false;
        }
    }
}
