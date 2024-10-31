package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0469s;
import com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0382ed;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;

/* compiled from: AdobeOneUpMultiPageViewPagerController.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private float f6326a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private float f6327b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f6328c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f6329d;

    /* renamed from: e, reason: collision with root package name */
    private C0533a f6330e;

    /* renamed from: f, reason: collision with root package name */
    private Context f6331f;

    /* renamed from: g, reason: collision with root package name */
    private C0469s f6332g;

    /* renamed from: h, reason: collision with root package name */
    private AdobeHackyViewPager f6333h;
    private a i;
    private View j;
    private p k;
    private WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> l;

    /* JADX INFO: Access modifiers changed from: private */
    public C0469s b() {
        return this.f6332g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.adobe.creativesdk.foundation.internal.storage.controllers.a.f c() {
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void a(View view) {
        this.j = view;
    }

    public void a(C0533a c0533a) {
        this.f6330e = c0533a;
    }

    public void a(p pVar) {
        this.k = pVar;
    }

    public void a(C0469s c0469s) {
        this.f6332g = c0469s;
    }

    /* compiled from: AdobeOneUpMultiPageViewPagerController.java */
    /* loaded from: classes.dex */
    public class a extends PagerAdapter implements InterfaceC0382ed {

        /* renamed from: c, reason: collision with root package name */
        Context f6334c;

        /* renamed from: d, reason: collision with root package name */
        LayoutInflater f6335d;

        public a(Context context) {
            this.f6334c = context;
            this.f6335d = (LayoutInflater) this.f6334c.getSystemService("layout_inflater");
        }

        private C0402f a(View view, DisplayMetrics displayMetrics) {
            C0402f c0402f = new C0402f();
            c0402f.a(view);
            c0402f.a(displayMetrics);
            c0402f.a(this.f6334c);
            c0402f.a();
            c0402f.a(this);
            c0402f.b().f(u.this.f6328c);
            c0402f.b().g(u.this.f6326a);
            c0402f.b().h(u.this.f6327b);
            return c0402f;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((RelativeLayout) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (!(u.this.f6330e instanceof AdobeAssetFile)) {
                return -1;
            }
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) u.this.f6330e;
            if (adobeAssetFile.getOptionalMetadata() != null) {
                u.this.f6329d = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
            }
            return u.this.f6329d;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            BitmapDrawable c2;
            boolean z = false;
            View inflate = this.f6335d.inflate(c.a.a.a.b.g.fragment_vertical_pager, viewGroup, false);
            DisplayMetrics displayMetrics = this.f6334c.getResources().getDisplayMetrics();
            Double.isNaN(displayMetrics.widthPixels);
            Double.isNaN(displayMetrics.heightPixels);
            C0582ma c0582ma = new C0582ma((int) (r4 * 0.7d), (int) (r8 * 0.7d));
            C0402f a2 = a(inflate, displayMetrics);
            a2.b().a(new s(this, i));
            if (u.this.f6330e instanceof AdobeAssetFile) {
                t tVar = new t(this, a2, c0582ma, i);
                if (AbstractActivityC0427k.y()) {
                    a2.f();
                    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f c3 = u.this.c();
                    if (c3 == null || (c2 = c3.c(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(u.this.f6330e, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i))) == null) {
                        z = true;
                    } else {
                        a2.a(c2);
                    }
                    if (z) {
                        ((AdobeAssetFile) u.this.f6330e).getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i, tVar);
                    }
                } else {
                    a2.d();
                }
            }
            inflate.setId(i);
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return (obj instanceof RelativeLayout) && view == obj;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0382ed
        public C0469s a() {
            return u.this.b();
        }
    }

    public void a(Context context) {
        this.f6331f = context;
        this.f6333h = (AdobeHackyViewPager) this.j.findViewById(c.a.a.a.b.e.adobe_csdk_multipage_vertical_pager);
        this.i = new a(this.f6331f);
        this.f6333h.setOffscreenPageLimit(1);
        this.f6333h.setPageMargin(15);
    }

    public void a(int i) {
        this.f6328c = 1.0f;
        this.f6326a = 0.0f;
        this.f6327b = 0.0f;
        this.f6333h.setAdapter(this.i);
        this.f6333h.setCurrentItem(i);
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        if (fVar == null) {
            return;
        }
        this.l = new WeakReference<>(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, C0402f c0402f, C0582ma c0582ma, int i) {
        if (this.j == null) {
            return;
        }
        if (bArr == null) {
            c0402f.e();
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f c2 = c();
        if (c2 != null) {
            c2.a(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(this.f6330e, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i), bArr, new q(this, c0402f), new r(this, c0402f));
        } else {
            c0402f.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        }
    }

    public void a() {
        this.f6328c = 1.0f;
        for (int i = 0; i < this.f6333h.getChildCount(); i++) {
            View childAt = this.f6333h.getChildAt(i);
            if (childAt != null) {
                ((PhotoView) ((RelativeLayout) childAt).getChildAt(0)).getAttacher().f(this.f6328c);
            }
        }
    }
}
