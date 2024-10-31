package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.View;
import android.widget.VideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f4728a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaBrowserFragment mediaBrowserFragment, VideoView videoView) {
        this.b = mediaBrowserFragment;
        this.f4728a = videoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4728a.setVisibility(0);
        this.f4728a.start();
    }
}
