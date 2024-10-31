package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class g implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f4729a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ ImageView c;
    final /* synthetic */ MediaBrowserFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaBrowserFragment mediaBrowserFragment, VideoView videoView, ImageView imageView, ImageView imageView2) {
        this.d = mediaBrowserFragment;
        this.f4729a = videoView;
        this.b = imageView;
        this.c = imageView2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f4729a.stopPlayback();
        this.b.setVisibility(0);
        this.f4729a.setVisibility(8);
        this.c.setVisibility(0);
        return true;
    }
}
