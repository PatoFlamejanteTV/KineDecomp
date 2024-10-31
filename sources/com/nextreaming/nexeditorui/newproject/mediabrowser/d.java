package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.graphics.Bitmap;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f4726a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaBrowserFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaBrowserFragment mediaBrowserFragment, ImageView imageView, MediaStoreItem mediaStoreItem) {
        this.c = mediaBrowserFragment;
        this.f4726a = imageView;
        this.b = mediaStoreItem;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Bitmap a2;
        if (this.c.getActivity() != null && this.c.getResources() != null && this.f4726a != null && this.f4726a.getWidth() > 0 && this.f4726a.getWidth() > 0 && (a2 = NexImageLoader.loadBitmap(this.b.h(), this.f4726a.getWidth(), this.f4726a.getHeight()).a()) != null) {
            this.f4726a.setImageBitmap(a2);
            this.f4726a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
