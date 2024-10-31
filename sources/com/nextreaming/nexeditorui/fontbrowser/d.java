package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FontBrowserActivity fontBrowserActivity) {
        this.f4628a = fontBrowserActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Context context;
        Context context2;
        int a2;
        Context context3;
        Toolbar toolbar;
        Context context4;
        Toolbar toolbar2;
        String str = (String) view.getTag();
        context = this.f4628a.f4624a;
        Font f = EffectLibrary.a(context).f(str);
        if (f != null) {
            if (f.d()) {
                context2 = this.f4628a.f4624a;
                Bitmap c = f.c(context2);
                if (c != null) {
                    a2 = this.f4628a.a(c);
                    context3 = this.f4628a.f4624a;
                    Bitmap createBitmap = Bitmap.createBitmap(a2, f.c(context3).getHeight(), Bitmap.Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(c, 0.0f, 0.0f, new Paint());
                    int integer = this.f4628a.getResources().getInteger(R.integer.font_toolbar_title_scale);
                    if (integer > 0) {
                        context4 = this.f4628a.f4624a;
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, a2 / integer, f.c(context4).getHeight() / integer, true);
                        toolbar2 = this.f4628a.d;
                        toolbar2.a(createScaledBitmap, 1);
                    } else {
                        toolbar = this.f4628a.d;
                        toolbar.a(createBitmap, 1);
                    }
                    this.f4628a.h = str;
                    return;
                }
                return;
            }
            ((ImageButton) view.findViewById(R.id.button_font_install)).performClick();
        }
    }
}
