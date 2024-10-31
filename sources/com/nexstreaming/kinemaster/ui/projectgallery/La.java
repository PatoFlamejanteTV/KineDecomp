package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class La implements TencentAdListener.NativeExpressAdListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22857a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(ProjectGalleryActivity projectGalleryActivity) {
        this.f22857a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeClosed(ViewGroup viewGroup) {
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener.NativeExpressAdListener
    public void onNativeLoaded(ViewGroup viewGroup) {
        Eb eb;
        FrameLayout frameLayout = (FrameLayout) viewGroup;
        if (frameLayout != null) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setImageResource(R.drawable.ad_badge_china);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-2, -2, 8388659));
        }
        eb = this.f22857a.ua;
        eb.a(frameLayout);
    }
}
