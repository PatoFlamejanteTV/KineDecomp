package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.KeyEvent;
import android.view.View;
import com.nextreaming.nexeditorui.NexEditText;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Da implements NexEditText.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(FullScreenInputActivity fullScreenInputActivity) {
        this.f21812a = fullScreenInputActivity;
    }

    @Override // com.nextreaming.nexeditorui.NexEditText.a
    public boolean a(View view, KeyEvent keyEvent) {
        FullScreenInputActivity fullScreenInputActivity = this.f21812a;
        fullScreenInputActivity.f21854b.hideSoftInputFromWindow(fullScreenInputActivity.f21853a.getWindowToken(), 0);
        this.f21812a.setResult(0);
        this.f21812a.finish();
        return true;
    }
}
