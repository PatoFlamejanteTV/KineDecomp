package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.LruCache;
import com.airbnb.lottie.C0657ka;
import com.airbnb.lottie.C0661ma;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/* compiled from: LottieOverlayAsset.java */
/* loaded from: classes2.dex */
public class g extends com.nexstreaming.app.general.nexasset.overlay.a.a {

    /* renamed from: b */
    private static Map<String, WeakReference<C0657ka>> f19609b = new HashMap();

    /* renamed from: c */
    private final Rect f19610c;

    /* renamed from: d */
    private final int f19611d;

    public g(r rVar) {
        super(rVar);
        C0657ka f2 = f();
        this.f19610c = f2.a();
        this.f19611d = (int) Math.min(2147483647L, f2.c());
    }

    private C0657ka f() {
        return a(e().getPackageURI(), e().getAssetPackage().getAssetId(), e().getFilePath());
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int a() {
        return this.f19610c.height();
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int b() {
        return this.f19610c.width();
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int c() {
        return this.f19611d;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public com.nexstreaming.app.general.nexasset.overlay.a a(LayerRenderer layerRenderer, NexLayerItem.c cVar, RectF rectF, String str, Map<String, String> map) {
        return new a(f(), rectF, Math.min(Math.min(cVar.f20240c * 2.0f, cVar.f20239b), 2000.0f / Math.max(rectF.width(), rectF.height())));
    }

    private static C0657ka a(String str, String str2, String str3) {
        String str4 = str + "\u001b" + str2 + "\u001b" + str3;
        WeakReference<C0657ka> weakReference = f19609b.get(str4);
        C0657ka c0657ka = weakReference == null ? null : weakReference.get();
        if (c0657ka == null) {
            try {
                AssetPackageReader a2 = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), str, str2);
                try {
                    InputStream g2 = a2.g(str3);
                    try {
                        try {
                            c0657ka = C0657ka.a.a(KineMasterApplication.f24056d.getApplicationContext(), g2);
                        } catch (JSONException e2) {
                            Log.e("LottieOverlayAsset", "Error parsing Lottie JSON", e2);
                        }
                        if (c0657ka != null) {
                            f19609b.put(str4, new WeakReference<>(c0657ka));
                        }
                    } finally {
                        C1702f.a(g2);
                    }
                } finally {
                    C1702f.a(a2);
                }
            } catch (IOException e3) {
                Log.e("LottieOverlayAsset", "Error reading Lottie file", e3);
                return null;
            }
        }
        return c0657ka;
    }

    /* compiled from: LottieOverlayAsset.java */
    /* loaded from: classes2.dex */
    public static class a implements com.nexstreaming.app.general.nexasset.overlay.a {

        /* renamed from: a */
        private C0657ka f19612a;

        /* renamed from: b */
        private C0661ma f19613b;

        /* renamed from: c */
        private final RectF f19614c;

        /* renamed from: d */
        private final int f19615d;

        /* renamed from: e */
        private final float f19616e;

        /* renamed from: f */
        int[] f19617f = {-1, -1};

        /* renamed from: g */
        private int[] f19618g = {0, 0};

        /* renamed from: h */
        private LruCache<Integer, Bitmap> f19619h = new f(this, 41943040);

        a(C0657ka c0657ka, RectF rectF, float f2) {
            try {
                this.f19612a = c0657ka;
                this.f19614c = rectF;
                this.f19616e = f2;
                this.f19613b = new C0661ma();
                this.f19613b.a(c0657ka);
                this.f19615d = c0657ka.f();
            } catch (Exception e2) {
                Log.e("LottieOverlayAsset", "init failed", e2);
                throw e2;
            }
        }

        private Bitmap b(int i) {
            this.f19613b.a(i / ((float) this.f19612a.c()));
            Bitmap createBitmap = Bitmap.createBitmap((int) Math.floor(this.f19614c.width() * this.f19616e), (int) Math.floor(this.f19614c.height() * this.f19616e), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            this.f19613b.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            this.f19613b.draw(canvas);
            return createBitmap;
        }

        private int c(int i) {
            int i2 = this.f19615d;
            return (((i * i2) / 1000) * 1000) / i2;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public void a(LayerRenderer layerRenderer) {
            this.f19612a = null;
            this.f19613b.e();
            this.f19613b = null;
            NexEditor i = EditorGlobal.i();
            if (i == null || this.f19617f[layerRenderer.l().id] < 0) {
                return;
            }
            i.d(this.f19617f[layerRenderer.l().id], layerRenderer.l().id);
            this.f19617f[layerRenderer.l().id] = -1;
            this.f19618g[layerRenderer.l().id] = 0;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public boolean a() {
            return false;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public boolean a(LayerRenderer layerRenderer, String str) {
            return false;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public void a(LayerRenderer layerRenderer, NexLayerItem.b bVar, int i, int i2, int i3) {
            NexEditor i4;
            Bitmap a2 = a(layerRenderer.f() - i);
            if (a2 != null) {
                if (i3 > 0) {
                    if (this.f19618g[layerRenderer.l().id] != i3) {
                        if (this.f19617f[layerRenderer.l().id] >= 0) {
                            EditorGlobal.i().d(this.f19617f[layerRenderer.l().id], layerRenderer.l().id);
                        }
                        this.f19617f[layerRenderer.l().id] = -1;
                        this.f19618g[layerRenderer.l().id] = 0;
                    }
                    if (this.f19617f[layerRenderer.l().id] < 0 && (i4 = EditorGlobal.i()) != null) {
                        this.f19617f[layerRenderer.l().id] = i4.a(String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(i3)), layerRenderer.l().id);
                        this.f19618g[layerRenderer.l().id] = i3;
                    }
                }
                if (this.f19617f[layerRenderer.l().id] >= 0 && i3 > 0) {
                    layerRenderer.a(this.f19617f[layerRenderer.l().id], a2, "", layerRenderer.f(), 0, 1000, 0.0f, 0.0f, layerRenderer.d(), layerRenderer.i());
                } else {
                    RectF rectF = this.f19614c;
                    layerRenderer.a(a2, rectF.left, rectF.top, rectF.right, rectF.bottom);
                }
            }
        }

        private Bitmap a(int i) {
            int c2 = c(i);
            Bitmap bitmap = this.f19619h.get(Integer.valueOf(c2));
            if (bitmap != null) {
                return bitmap;
            }
            Bitmap b2 = b(c2);
            if (b2 != null) {
                this.f19619h.put(Integer.valueOf(c2), b2);
            }
            return b2;
        }
    }
}
