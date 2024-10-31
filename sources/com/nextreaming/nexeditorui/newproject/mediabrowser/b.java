package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MediaBrowserFragment mediaBrowserFragment) {
        this.f4723a = mediaBrowserFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WeakReference weakReference;
        Toolbar toolbar;
        WeakReference weakReference2;
        weakReference = this.f4723a.D;
        if (weakReference != null) {
            weakReference2 = this.f4723a.D;
            if (((com.nexstreaming.kinemaster.ui.a.a) weakReference2.get()) != null) {
                return;
            }
        }
        switch (view.getId()) {
            case R.id.titleHolder /* 2131821574 */:
                toolbar = this.f4723a.m;
                if (toolbar.getTitleMode() == Toolbar.TitleMode.Back) {
                    this.f4723a.l_();
                    return;
                }
                return;
            case R.id.accept_button /* 2131821587 */:
                this.f4723a.getFragmentManager().popBackStack();
                return;
            default:
                return;
        }
    }
}
