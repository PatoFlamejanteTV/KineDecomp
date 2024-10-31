package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC1839q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1839q(C1829g c1829g) {
        this.f21701a = c1829g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VideoView videoView;
        VideoView videoView2;
        ImageView imageView;
        VideoView videoView3;
        VideoView videoView4;
        VideoView videoView5;
        ImageView imageView2;
        videoView = this.f21701a.p;
        Boolean valueOf = videoView != null ? Boolean.valueOf(videoView.isPlaying()) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (valueOf.booleanValue()) {
            videoView4 = this.f21701a.p;
            if (videoView4 != null) {
                videoView4.stopPlayback();
            }
            videoView5 = this.f21701a.p;
            if (videoView5 != null) {
                videoView5.setVisibility(8);
            }
            imageView2 = this.f21701a.n;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        videoView2 = this.f21701a.p;
        if (videoView2 != null) {
            videoView2.setVisibility(0);
        }
        imageView = this.f21701a.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        videoView3 = this.f21701a.p;
        if (videoView3 != null) {
            videoView3.start();
        }
    }
}
