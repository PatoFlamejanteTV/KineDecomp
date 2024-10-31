package com.nexstreaming.app.general.iab.c;

import android.content.Context;
import android.os.Handler;
import com.xiaomi.gamecenter.sdk.OnPayProcessListener;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
public class j implements OnPayProcessListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiBuyInfo f3177a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, MiBuyInfo miBuyInfo) {
        this.b = iVar;
        this.f3177a = miBuyInfo;
    }

    @Override // com.xiaomi.gamecenter.sdk.OnPayProcessListener
    public void finishPayProcess(int i) {
        Context k;
        k = this.b.d.k();
        new Handler(k.getMainLooper()).post(new k(this, i));
    }
}
