package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: GoogleProductList.java */
/* loaded from: classes.dex */
public class i extends TLP<GoogleProductListRequest, GoogleProductListResponse> {
    private static i b;

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

    public static i a(Context context) {
        if (b == null) {
            b = new i(context);
        }
        return b;
    }

    private i(Context context) {
        super(context, GoogleProductListResponse.class);
        b(true);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(GoogleProductListResponse googleProductListResponse) {
        super.b((i) googleProductListResponse);
        a((i) googleProductListResponse, 7200000 + System.currentTimeMillis(), Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(GoogleProductListResponse googleProductListResponse) {
        super.a((i) googleProductListResponse);
    }
}
