package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4625a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FontBrowserActivity fontBrowserActivity) {
        this.f4625a = fontBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Toolbar toolbar;
        Toolbar toolbar2;
        String str;
        String str2;
        String str3;
        switch (view.getId()) {
            case R.id.deleteIcon /* 2131821583 */:
                toolbar = this.f4625a.d;
                if (toolbar != null) {
                    toolbar2 = this.f4625a.d;
                    toolbar2.a(1);
                }
                this.f4625a.h = null;
                return;
            case R.id.accept_button /* 2131821587 */:
                str = this.f4625a.h;
                if (str != null) {
                    KMUsage kMUsage = KMUsage.FontBrowser_SelectFont;
                    str2 = this.f4625a.h;
                    kMUsage.logEvent("font", str2);
                    Intent intent = new Intent();
                    str3 = this.f4625a.h;
                    intent.putExtra("selected_font_id", str3);
                    this.f4625a.setResult(-1, intent);
                } else {
                    this.f4625a.setResult(1, new Intent());
                }
                this.f4625a.finish();
                return;
            default:
                return;
        }
    }
}
