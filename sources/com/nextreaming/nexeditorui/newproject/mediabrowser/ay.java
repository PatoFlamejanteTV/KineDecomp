package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ay implements MediaStore.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(MediaBrowserFragment mediaBrowserFragment) {
        this.f4721a = mediaBrowserFragment;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStore.a
    public Bitmap a(MediaStoreItem mediaStoreItem, Bitmap bitmap) {
        MediaStore mediaStore;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap a2;
        Bitmap a3;
        MediaStore mediaStore2;
        if (this.f4721a.isAdded()) {
            mediaStore = this.f4721a.s;
            if (mediaStore != null) {
                mediaStore2 = this.f4721a.s;
                if (mediaStore2.a(mediaStoreItem) != 1) {
                    return bitmap;
                }
            }
            bitmap2 = this.f4721a.P;
            if (bitmap2 == null) {
                Drawable drawable = this.f4721a.getResources().getDrawable(R.drawable.panel_media_browser_folder_item_background_fill_mask);
                MediaBrowserFragment mediaBrowserFragment = this.f4721a;
                a3 = this.f4721a.a(drawable);
                mediaBrowserFragment.P = a3;
            }
            MediaBrowserFragment mediaBrowserFragment2 = this.f4721a;
            bitmap3 = this.f4721a.P;
            a2 = mediaBrowserFragment2.a(bitmap3, bitmap);
            return a2;
        }
        return null;
    }
}
