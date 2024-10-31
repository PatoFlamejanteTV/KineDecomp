package com.nexstreaming.kinemaster.ui;

import android.widget.TextView;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import java.util.Arrays;

/* compiled from: TencentSplashAdActivity.kt */
/* loaded from: classes.dex */
public final class s implements TencentAdListener.SplashAdListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TencentSplashAdActivity f23017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TencentSplashAdActivity tencentSplashAdActivity) {
        this.f23017a = tencentSplashAdActivity;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.SplashAdListener
    public void onSplashADClicked() {
        this.f23017a.f21304h = true;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.SplashAdListener
    public void onSplashADTick(long j) {
        String str;
        TextView s = this.f23017a.s();
        kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
        str = this.f23017a.f21301e;
        Object[] objArr = {Integer.valueOf(Math.round(((float) j) / 1000.0f))};
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(format, *args)");
        s.setText(format);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.SplashAdListener
    public void onSplashDismissed() {
        boolean z;
        z = this.f23017a.f21304h;
        if (z) {
            return;
        }
        this.f23017a.a(0L);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.SplashAdListener
    public void onSplashNoAd(long j) {
        this.f23017a.a(j);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.SplashAdListener
    public void onSplashPresented() {
        this.f23017a.t().setVisibility(4);
        this.f23017a.s().setVisibility(0);
    }
}
