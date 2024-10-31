package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpOrderList.java */
/* loaded from: classes2.dex */
public class j extends TLP<CpOrderListRequest, CpOrderListResponse> {
    private static j l;
    private String m;

    private j(Context context, String str, String str2) {
        super(context, CpOrderListResponse.class);
        this.m = "";
        this.m = str + "/" + str2;
        a(true);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    protected String f() {
        return this.m;
    }

    public static j a(Context context, String str, String str2) {
        j jVar = l;
        if (jVar == null) {
            l = new j(context, str, str2);
        } else if (jVar.f() == null) {
            l = new j(context, str, str2);
        }
        return l;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void b(CpOrderListResponse cpOrderListResponse) {
        super.b((j) cpOrderListResponse);
        a((j) cpOrderListResponse, System.currentTimeMillis() + 21600000, Long.MAX_VALUE);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        switch (i.f19785a[responseCode.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void a(CpOrderListResponse cpOrderListResponse) {
        super.a((j) cpOrderListResponse);
    }
}
