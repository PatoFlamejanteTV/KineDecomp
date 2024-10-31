package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.kinemasterfree.wxapi.WXUserInfo;
import com.nexstreaming.app.kinemasterfree.wxapi.e;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class Z implements e.a<WXUserInfo> {
    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void onError(Exception exc) {
        kotlin.jvm.internal.h.b(exc, "error");
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void a(WXUserInfo wXUserInfo) {
        kotlin.jvm.internal.h.b(wXUserInfo, "result");
        com.nexstreaming.app.kinemasterfree.wxapi.e.c().a(wXUserInfo);
    }
}
