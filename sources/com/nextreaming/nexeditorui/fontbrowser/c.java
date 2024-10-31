package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.kmpackage.y;
import java.util.List;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FontBrowserActivity fontBrowserActivity) {
        this.f4627a = fontBrowserActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        this.f4627a.g = i;
        list = this.f4627a.e;
        this.f4627a.a((y) list.get(i));
    }
}
