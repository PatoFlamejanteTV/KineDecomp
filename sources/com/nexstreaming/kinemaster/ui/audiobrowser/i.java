package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.ComponentCallbacks2;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.bp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f3674a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Toolbar toolbar;
        Toolbar toolbar2;
        ComponentCallbacks2 activity = this.f3674a.getActivity();
        if (activity != null && (activity instanceof bp) && view.getId() == R.id.deleteIcon) {
            i = this.f3674a.m;
            ((bp) activity).a(null, null, i);
            toolbar = this.f3674a.r;
            if (toolbar != null) {
                toolbar2 = this.f3674a.r;
                toolbar2.a(1);
                return;
            }
            return;
        }
        if (view.getId() == R.id.accept_button) {
            this.f3674a.getFragmentManager().popBackStackImmediate();
        }
    }
}
