package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpProductList.java */
/* loaded from: classes.dex */
public class g extends TLP<CpProductListRequest, CpProductListResponse> {
    private static g b;
    private String c;

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

    public static g a(Context context, String str, String str2) {
        if (b == null) {
            b = new g(context, str, str2);
        } else if (b.d() == null) {
            b = new g(context, str, str2);
        }
        return b;
    }

    private g(Context context, String str, String str2) {
        super(context, CpProductListResponse.class);
        this.c = "";
        this.c = str + "/" + str2;
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
                c();
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(CpProductListResponse cpProductListResponse) {
        super.b((g) cpProductListResponse);
        a((g) cpProductListResponse, 7200000 + System.currentTimeMillis(), Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(CpProductListResponse cpProductListResponse) {
        super.a((g) cpProductListResponse);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    protected String d() {
        return this.c;
    }
}