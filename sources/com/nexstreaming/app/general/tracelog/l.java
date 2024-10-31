package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpProductList.java */
/* loaded from: classes2.dex */
public class l extends TLP<CpProductListRequest, CpProductListResponse> {
    private static l l;
    private String m;

    private l(Context context, String str, String str2) {
        super(context, CpProductListResponse.class);
        this.m = "";
        this.m = str + "/" + str2;
        a(true);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    protected String f() {
        return this.m;
    }

    public static l a(Context context, String str, String str2) {
        l lVar = l;
        if (lVar == null) {
            l = new l(context, str, str2);
        } else if (lVar.f() == null) {
            l = new l(context, str, str2);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void b(CpProductListResponse cpProductListResponse) {
        super.b((l) cpProductListResponse);
        a((l) cpProductListResponse, System.currentTimeMillis() + 7200000, Long.MAX_VALUE);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = k.f19786a[responseCode.ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        b();
        return false;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void a(CpProductListResponse cpProductListResponse) {
        super.a((l) cpProductListResponse);
    }
}
