package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class f implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FontBrowserActivity f24267a;

    public f(FontBrowserActivity fontBrowserActivity) {
        this.f24267a = fontBrowserActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        Context context;
        Context context2;
        this.f24267a.f24258h = i;
        list = this.f24267a.f24256f;
        com.nexstreaming.kinemaster.fonts.c cVar = (com.nexstreaming.kinemaster.fonts.c) list.get(i);
        this.f24267a.a(cVar);
        context = this.f24267a.f24252b;
        if (cVar.getId().equals(PreferenceManager.getDefaultSharedPreferences(context).getString("shared_default_font", null))) {
            return;
        }
        context2 = this.f24267a.f24252b;
        PreferenceManager.getDefaultSharedPreferences(context2).edit().putString("shared_default_font", cVar.getId()).apply();
    }
}
