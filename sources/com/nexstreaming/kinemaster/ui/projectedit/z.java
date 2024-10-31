package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.KeyEvent;
import android.view.View;
import com.nextreaming.nexeditorui.NexEditText;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class z implements NexEditText.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f4121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FullScreenInputActivity fullScreenInputActivity) {
        this.f4121a = fullScreenInputActivity;
    }

    @Override // com.nextreaming.nexeditorui.NexEditText.a
    public boolean a(View view, KeyEvent keyEvent) {
        this.f4121a.b.hideSoftInputFromWindow(this.f4121a.f3732a.getWindowToken(), 0);
        this.f4121a.setResult(0);
        this.f4121a.finish();
        return true;
    }
}
