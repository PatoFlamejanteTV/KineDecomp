package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar) {
        this.f4644a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (view.getId() == R.id.button_font_install) {
            this.f4644a.a(view, str);
        }
    }
}
