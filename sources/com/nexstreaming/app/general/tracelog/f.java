package com.nexstreaming.app.general.tracelog;

import android.content.Context;

/* compiled from: CpOrderList.java */
/* loaded from: classes.dex */
public class f extends TLP<CpOrderListRequest, CpOrderListResponse> {
    private static f b;
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

    public static f a(Context context, String str, String str2) {
        if (b == null) {
            b = new f(context, str, str2);
        } else if (b.d() == null) {
            b = new f(context, str, str2);
        }
        return b;
    }

    private f(Context context, String str, String str2) {
        super(context, CpOrderListResponse.class);
        this.c = "";
        this.c = str + "/" + str2;
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        switch (responseCode) {
            case SUCCESS:
            case APPAUTH_FAILED:
            case INVALID_APIVERSION:
            case ERR_NORMAL:
            case AUTH_FAILED_XIAOMI_UID:
            case NOT_FOUND_LIST:
            case SOMETHING_WRONG:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(CpOrderListResponse cpOrderListResponse) {
        super.b((f) cpOrderListResponse);
        a((f) cpOrderListResponse, 21600000 + System.currentTimeMillis(), Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(CpOrderListResponse cpOrderListResponse) {
        super.a((f) cpOrderListResponse);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    protected String d() {
        return this.c;
    }
}
