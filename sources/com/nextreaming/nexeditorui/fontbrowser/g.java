package com.nextreaming.nexeditorui.fontbrowser;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.fonts.Font;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FontBrowserActivity f24268a;

    public g(FontBrowserActivity fontBrowserActivity) {
        this.f24268a = fontBrowserActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Font c2;
        String str = (String) view.getTag();
        c2 = this.f24268a.c(str);
        if (c2 != null && c2.f()) {
            if (c2.d() != null) {
                Log.d("FontBrowserActivity", "onItemClick: " + c2.d().getAssetIdx());
                this.f24268a.k = c2.d().getAssetIdx();
            }
            this.f24268a.i = str;
            this.f24268a.v();
        }
    }
}
