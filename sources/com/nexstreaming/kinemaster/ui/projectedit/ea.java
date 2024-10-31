package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.view.View;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ea implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f21824a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21825b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(FullScreenInputActivity fullScreenInputActivity, String str) {
        this.f21825b = fullScreenInputActivity;
        this.f21824a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        FullScreenInputActivity fullScreenInputActivity = this.f21825b;
        fullScreenInputActivity.f21854b.hideSoftInputFromWindow(fullScreenInputActivity.f21853a.getWindowToken(), 0, null);
        Intent intent = new Intent(this.f21825b, (Class<?>) FontBrowserActivity.class);
        intent.putExtra("SELECTED_PROJECT", this.f21824a);
        str = this.f21825b.f21856d;
        intent.putExtra("default_font_id", str);
        str2 = this.f21825b.f21857e;
        intent.putExtra("selected_font_id", str2);
        this.f21825b.startActivityForResult(intent, 100);
    }
}
