package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.u;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;

/* compiled from: AdobeOneUpMultiPageViewPagerController.java */
/* loaded from: classes.dex */
class s implements com.adobe.creativesdk.foundation.internal.utils.photoview.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f6320a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ u.a f6321b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(u.a aVar, int i) {
        this.f6321b = aVar;
        this.f6320a = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.d
    public void a(float f2, float f3, float f4) {
        AdobeHackyViewPager adobeHackyViewPager;
        AdobeHackyViewPager adobeHackyViewPager2;
        Context context;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        adobeHackyViewPager = u.this.f6333h;
        View findViewById = adobeHackyViewPager.findViewById(this.f6320a - 1);
        adobeHackyViewPager2 = u.this.f6333h;
        View findViewById2 = adobeHackyViewPager2.findViewById(this.f6320a + 1);
        u.this.f6328c = f2;
        u.this.f6327b = f4;
        if (f2 > 0.5f) {
            if (findViewById != null) {
                com.adobe.creativesdk.foundation.internal.utils.photoview.g attacher = ((PhotoView) ((RelativeLayout) findViewById).getChildAt(0)).getAttacher();
                context = u.this.f6331f;
                attacher.a(f2, context.getResources().getDisplayMetrics().widthPixels, u.this.f6327b, false);
            }
            if (findViewById2 != null) {
                ((PhotoView) ((RelativeLayout) findViewById2).getChildAt(0)).getAttacher().a(f2, 0.0f, u.this.f6327b, false);
                return;
            }
            return;
        }
        pVar = u.this.k;
        if (pVar.c() == AdobeMultiPageViewState.AdobeMultiPageGridView) {
            pVar4 = u.this.k;
            pVar4.a();
            return;
        }
        pVar2 = u.this.k;
        if (pVar2.c() == AdobeMultiPageViewState.AdobeMultiPageListView) {
            pVar3 = u.this.k;
            pVar3.b();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.d
    public void a(float f2, float f3) {
        AdobeHackyViewPager adobeHackyViewPager;
        AdobeHackyViewPager adobeHackyViewPager2;
        Context context;
        adobeHackyViewPager = u.this.f6333h;
        View findViewById = adobeHackyViewPager.findViewById(this.f6320a - 1);
        adobeHackyViewPager2 = u.this.f6333h;
        View findViewById2 = adobeHackyViewPager2.findViewById(this.f6320a + 1);
        if (f2 > 0.0f) {
            u uVar = u.this;
            context = uVar.f6331f;
            uVar.f6326a = context.getResources().getDisplayMetrics().widthPixels;
            if (findViewById != null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById;
                ((PhotoView) relativeLayout.getChildAt(0)).getAttacher().g(u.this.f6326a);
                ((PhotoView) relativeLayout.getChildAt(0)).getAttacher().h(u.this.f6327b);
                return;
            }
            return;
        }
        if (f2 < 0.0f) {
            u.this.f6326a = 0.0f;
            if (findViewById2 != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) findViewById2;
                ((PhotoView) relativeLayout2.getChildAt(0)).getAttacher().g(u.this.f6326a);
                ((PhotoView) relativeLayout2.getChildAt(0)).getAttacher().h(u.this.f6327b);
            }
        }
    }
}
