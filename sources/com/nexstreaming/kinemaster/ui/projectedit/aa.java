package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.view.View;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class aa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FullScreenInputActivity fullScreenInputActivity) {
        this.f3754a = fullScreenInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        this.f3754a.b.hideSoftInputFromWindow(this.f3754a.f3732a.getWindowToken(), 0, null);
        Intent intent = new Intent(this.f3754a, (Class<?>) FontBrowserActivity.class);
        str = this.f3754a.d;
        intent.putExtra("default_font_id", str);
        str2 = this.f3754a.e;
        intent.putExtra("selected_font_id", str2);
        this.f3754a.startActivityForResult(intent, 100);
    }
}
