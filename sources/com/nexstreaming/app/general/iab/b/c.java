package com.nexstreaming.app.general.iab.b;

import android.content.Context;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.app.kinemasterfree.wxapi.b;
import com.xiaomi.gamecenter.sdk.MiErrorCode;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class c implements b.a<WXAccessToken> {

    /* renamed from: a, reason: collision with root package name */
    int f3159a = 0;
    final /* synthetic */ a.C0063a b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, a.C0063a c0063a) {
        this.c = aVar;
        this.b = c0063a;
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.b.a
    public void a(WXAccessToken wXAccessToken) {
        IABHelper.e eVar;
        Context k;
        if (wXAccessToken != null) {
            com.nexstreaming.app.kinemasterfree.wxapi.b.a().a(wXAccessToken);
            this.c.m = wXAccessToken;
            k = this.c.k();
            com.nexstreaming.kinemaster.tracelog.d.a(k, this.c.r().toLowerCase(), this.c.m.d(), "").onResultAvailable(this.b).onFailure((Task.OnFailListener) this.b);
            return;
        }
        if (3 <= this.f3159a) {
            eVar = this.c.p;
            eVar.a(false, MiErrorCode.MI_XIAOMI_ERROR_NETWORK_ERROR);
        } else {
            this.f3159a++;
            com.nexstreaming.app.kinemasterfree.wxapi.b.a().a(this.c.m, this);
        }
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.b.a
    public void a(Exception exc) {
        IABHelper.e eVar;
        if (3 <= this.f3159a) {
            eVar = this.c.p;
            eVar.a(false, MiErrorCode.MI_XIAOMI_ERROR_NETWORK_ERROR);
        } else {
            this.f3159a++;
            com.nexstreaming.app.kinemasterfree.wxapi.b.a().a(this.c.m, this);
        }
    }
}
