package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
public class i implements OnFontChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FontBrowserActivity fontBrowserActivity) {
        this.f4633a = fontBrowserActivity;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener
    public void a(OnFontChangeListener.FontEvent fontEvent) {
        Context context;
        List list;
        ListView listView;
        Context context2;
        List list2;
        ListView listView2;
        ListView listView3;
        int i;
        int i2;
        if (fontEvent.equals(OnFontChangeListener.FontEvent.SERVER_UPDATE)) {
            context = this.f4633a.f4624a;
            this.f4633a.e = new ArrayList(EffectLibrary.a(context).a());
            list = this.f4633a.e;
            Collections.sort(list, new j(this));
            listView = this.f4633a.b;
            context2 = this.f4633a.f4624a;
            list2 = this.f4633a.e;
            listView.setAdapter((ListAdapter) new k(context2, list2));
            listView2 = this.f4633a.b;
            listView3 = this.f4633a.b;
            i = this.f4633a.g;
            i2 = this.f4633a.g;
            listView2.performItemClick(listView3, i, i2);
        }
    }
}
