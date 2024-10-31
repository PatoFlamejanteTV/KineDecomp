package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class au implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4717a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem) {
        this.b = mediaBrowserFragment;
        this.f4717a = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        MediaBrowserFragment.b bVar;
        int i;
        boolean z;
        View view;
        View view2;
        View view3;
        boolean z2;
        bVar = this.b.t;
        MediaStoreItem mediaStoreItem = this.f4717a;
        i = this.b.e;
        bVar.a(mediaStoreItem, i);
        if (!this.f4717a.p().isNotSupported()) {
            z2 = this.b.h;
            if (z2) {
                this.b.getFragmentManager().popBackStack();
            }
        }
        z = this.b.h;
        if (!z) {
            view = this.b.j;
            if (view != null) {
                view2 = this.b.j;
                if (view2.getVisibility() == 0) {
                    boolean a2 = this.b.a(this.f4717a);
                    view3 = this.b.j;
                    ImageButton imageButton = (ImageButton) view3.findViewById(R.id.imageButton_media_detail_delete);
                    if (a2) {
                        imageButton.setEnabled(false);
                        imageButton.setAlpha(0.5f);
                    } else {
                        imageButton.setEnabled(true);
                        imageButton.setAlpha(1.0f);
                    }
                }
            }
        }
        dialogInterface.dismiss();
    }
}
