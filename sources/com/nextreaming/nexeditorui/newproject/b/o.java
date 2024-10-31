package com.nextreaming.nexeditorui.newproject.b;

import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.f4677a = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((Vibrator) view.getContext().getSystemService("vibrator")).vibrate(100L);
        Theme theme = (Theme) view.getTag();
        String a2 = theme.a(this.f4677a.getActivity());
        String str = EditorGlobal.a(this.f4677a.getActivity(), theme.c()).toString();
        if (theme.v()) {
            str = this.f4677a.getString(R.string.theme_browser_delete_popup_builtIn);
        }
        com.nexstreaming.kinemaster.ui.a.a a3 = new a.C0074a(this.f4677a.getActivity()).a(str).a();
        a3.setTitle(a2);
        if (!theme.v()) {
            a3.b(this.f4677a.getString(R.string.theme_browser_delete_popup_uninstall), new p(this, theme, i));
        }
        a3.a(this.f4677a.getString(R.string.theme_browser_delete_popup_done), new q(this));
        a3.show();
        return true;
    }
}
