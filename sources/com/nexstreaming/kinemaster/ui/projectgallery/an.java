package com.nexstreaming.kinemaster.ui.projectgallery;

import android.widget.PopupWindow;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class an implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ am f4140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f4140a = amVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4140a.f4139a.findViewById(R.id.projectOverflow).setSelected(false);
    }
}
