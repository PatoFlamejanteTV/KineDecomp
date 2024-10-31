package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;

/* compiled from: AdobeOneUpSinglePageAssetController.java */
/* loaded from: classes.dex */
public class C implements InterfaceC0382ed {

    /* renamed from: a, reason: collision with root package name */
    protected View f5597a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f5598b;

    /* renamed from: c, reason: collision with root package name */
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f f5599c;

    /* renamed from: d, reason: collision with root package name */
    protected C0417i f5600d;

    /* renamed from: e, reason: collision with root package name */
    protected DisplayMetrics f5601e;

    /* renamed from: f, reason: collision with root package name */
    protected C0533a f5602f;

    /* renamed from: g, reason: collision with root package name */
    protected int f5603g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> f5604h;
    private C0469s i;
    private int j;
    float k;

    private C0402f.a f() {
        return new B(this);
    }

    private C0469s g() {
        return this.i;
    }

    public void b() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar;
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.f5604h;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.a(this.f5602f.getGUID() + ((AdobeAssetFile) this.f5602f).getMd5Hash());
    }

    public void c() {
        if (this.f5599c.a() != null) {
            this.f5599c.a().a(this.f5602f);
        }
    }

    public int d() {
        return this.j;
    }

    public void e() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar;
        C0533a c0533a = this.f5602f;
        if (c0533a == null || !(c0533a instanceof AdobeAssetFile)) {
            return;
        }
        if (AbstractActivityC0427k.y()) {
            this.f5600d.f();
            boolean z = true;
            WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.f5604h;
            if (weakReference != null && (fVar = weakReference.get()) != null) {
                BitmapDrawable c2 = fVar.c(this.f5602f.getGUID() + ((AdobeAssetFile) this.f5602f).getMd5Hash());
                if (c2 != null) {
                    this.f5600d.a(c2);
                    if (((AdobeAssetFile) this.f5602f).getType().startsWith("video/")) {
                        this.f5600d.h();
                    }
                    z = false;
                }
            }
            if (z) {
                A a2 = new A(this);
                AdobeAssetFile adobeAssetFile = (AdobeAssetFile) this.f5602f;
                AdobeAssetFileRenditionType adobeAssetFileRenditionType = AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG;
                DisplayMetrics displayMetrics = this.f5601e;
                adobeAssetFile.getRenditionWithType(adobeAssetFileRenditionType, new C0582ma(displayMetrics.widthPixels, displayMetrics.heightPixels), 0, a2);
                return;
            }
            return;
        }
        this.f5600d.d();
    }

    public void a(C0469s c0469s) {
        this.i = c0469s;
    }

    public void a(View view) {
        this.f5597a = view;
        if (this.f5597a == null) {
            this.f5598b = null;
            C0417i c0417i = this.f5600d;
            if (c0417i != null) {
                c0417i.b((Context) null);
            }
        }
    }

    public void b(int i) {
        this.j = i;
    }

    public void a(int i) {
        this.f5603g = i;
    }

    public void a(C0533a c0533a) {
        this.f5602f = c0533a;
    }

    public void a(Context context, com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f fVar) {
        this.f5598b = context;
        this.f5599c = fVar;
        this.f5601e = this.f5598b.getResources().getDisplayMetrics();
        this.f5600d = new C0417i();
        this.f5600d.a(this.f5597a);
        this.f5600d.a(this.f5601e);
        this.f5600d.c(this.f5603g);
        this.f5600d.a(this.f5598b);
        this.f5600d.a(this);
        this.f5600d.d(d());
        this.f5600d.a(f());
        this.f5600d.a();
        this.f5600d.b().a(new C0493x(this));
        this.f5600d.i();
        this.k = TypedValue.applyDimension(1, 14.0f, this.f5598b.getResources().getDisplayMetrics());
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f5604h = new WeakReference<>(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        if (this.f5597a == null) {
            return;
        }
        if (bArr == null) {
            this.f5600d.e();
            return;
        }
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.f5604h;
        if (weakReference != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = weakReference.get();
            if (fVar != null) {
                fVar.a(this.f5602f.getGUID() + ((AdobeAssetFile) this.f5602f).getMd5Hash(), bArr);
                fVar.a(this.f5602f.getGUID() + ((AdobeAssetFile) this.f5602f).getMd5Hash(), bArr, new C0497y(this), new C0501z(this));
                return;
            }
            return;
        }
        this.f5600d.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        C0533a c0533a = this.f5602f;
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
        if (c0533a == null || !adobeAssetFile.getType().startsWith("video/")) {
            return;
        }
        this.f5600d.h();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0382ed
    public C0469s a() {
        return g();
    }
}
