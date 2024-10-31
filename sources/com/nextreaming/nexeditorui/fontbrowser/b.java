package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f24263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FontBrowserActivity fontBrowserActivity) {
        this.f24263a = fontBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        Toolbar toolbar;
        Toolbar toolbar2;
        String str4;
        String str5;
        int id = view.getId();
        if (id == R.id.accept_button) {
            str = this.f24263a.i;
            if (str != null) {
                HashMap hashMap = new HashMap();
                str2 = this.f24263a.i;
                hashMap.put("name", str2);
                i = this.f24263a.k;
                hashMap.put("asset_id", Integer.toString(i));
                KMEvents.EDIT_SET_FONT.logEvent(hashMap);
                Intent intent = new Intent();
                str3 = this.f24263a.i;
                intent.putExtra("selected_font_id", str3);
                this.f24263a.setResult(-1, intent);
            } else {
                this.f24263a.setResult(1, new Intent());
            }
            this.f24263a.finish();
            return;
        }
        if (id == R.id.deleteIcon) {
            toolbar = this.f24263a.f24255e;
            if (toolbar != null) {
                toolbar2 = this.f24263a.f24255e;
                toolbar2.a(1);
            }
            this.f24263a.i = null;
            return;
        }
        if (id != R.id.toolbar_button) {
            return;
        }
        Intent intent2 = new Intent(this.f24263a, (Class<?>) StoreActivity.class);
        str4 = this.f24263a.j;
        if (str4 != null) {
            str5 = this.f24263a.j;
            intent2.putExtra("SELECTED_PROJECT", str5);
        }
        intent2.putExtra("SPECIFIC_URL", AssetCategoryAlias.Font.name());
        this.f24263a.startActivity(intent2);
    }
}
