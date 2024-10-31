package com.nextreaming.nexeditorui;

import android.os.Handler;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class W implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24184a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(I i) {
        this.f24184a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        boolean z;
        handler = this.f24184a.y;
        handler.removeCallbacks(this);
        z = I.f24041d;
        if (z || !this.f24184a.D() || this.f24184a.isFinishing()) {
            return;
        }
        I.f24041d = true;
        e.a aVar = new e.a(this.f24184a);
        aVar.c(this.f24184a.getString(R.string.promo_code_need_refresh_title));
        aVar.a(this.f24184a.getString(R.string.promo_code_need_refresh_text));
        aVar.c(R.string.button_ok, V.f24181a);
        aVar.a().show();
    }
}
