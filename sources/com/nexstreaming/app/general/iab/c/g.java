package com.nexstreaming.app.general.iab.c;

import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class g implements IABHelper.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f3174a;
    final /* synthetic */ IABHelper.DeveloperPayLoad b;
    final /* synthetic */ int c;
    final /* synthetic */ IABHelper.a d;
    final /* synthetic */ a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, int i, IABHelper.a aVar2) {
        this.e = aVar;
        this.f3174a = sKUDetails;
        this.b = developerPayLoad;
        this.c = i;
        this.d = aVar2;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.e
    public void a(boolean z, int i) {
        MiAccountInfo miAccountInfo;
        if (z) {
            a aVar = this.e;
            miAccountInfo = a.m;
            aVar.a(miAccountInfo, this.f3174a, this.b, this.c, this.d);
            return;
        }
        this.d.a(false, null, IABError.StartupError + "service disconnected");
    }
}
