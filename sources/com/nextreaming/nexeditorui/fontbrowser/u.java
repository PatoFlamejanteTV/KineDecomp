package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class u implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(l lVar) {
        this.f4645a = lVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        String str = (String) view.getTag();
        context = this.f4645a.b;
        Font f = EffectLibrary.a(context).f(str);
        if (f.d()) {
            int h = f.h();
            context2 = this.f4645a.b;
            String a2 = f.a(context2);
            context3 = this.f4645a.b;
            String str2 = EditorGlobal.a(context3, h).toString();
            if (f.g()) {
                context7 = this.f4645a.b;
                str2 = context7.getString(R.string.font_message_built_in);
            }
            context4 = this.f4645a.b;
            com.nexstreaming.kinemaster.ui.a.a a3 = new a.C0074a(context4).a(str2).a();
            a3.setTitle(a2 == null ? "" : a2);
            if (!f.g()) {
                context6 = this.f4645a.b;
                a3.b(context6.getString(R.string.theme_download_item_delete_popup_uninstall), new v(this, a3, f, view));
            }
            context5 = this.f4645a.b;
            a3.a(context5.getString(R.string.theme_download_item_delete_popup_done), new x(this, a3));
            a3.show();
        }
        return true;
    }
}
