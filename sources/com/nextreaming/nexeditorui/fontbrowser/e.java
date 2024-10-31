package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FontBrowserActivity fontBrowserActivity) {
        this.f4629a = fontBrowserActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        String str = (String) view.getTag();
        context = this.f4629a.f4624a;
        Font f = EffectLibrary.a(context).f(str);
        if (f.d()) {
            int h = f.h();
            context2 = this.f4629a.f4624a;
            String a2 = f.a(context2);
            context3 = this.f4629a.f4624a;
            String str2 = EditorGlobal.a(context3, h).toString();
            if (f.g()) {
                str2 = this.f4629a.getString(R.string.font_message_built_in);
            }
            context4 = this.f4629a.f4624a;
            com.nexstreaming.kinemaster.ui.a.a a3 = new a.C0074a(context4).a(str2).a();
            a3.setTitle(a2 == null ? "" : a2);
            if (!f.g()) {
                a3.b(this.f4629a.getString(R.string.theme_download_item_delete_popup_uninstall), new f(this, a3, f, view));
            }
            a3.a(this.f4629a.getString(R.string.theme_download_item_delete_popup_done), new h(this, a3));
            a3.show();
        }
        return true;
    }
}
