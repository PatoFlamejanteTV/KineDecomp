package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import com.google.protos.datapol.SemanticAnnotations;
import com.larvalabs.svgandroid.SVGParser;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.nexasset.overlay.OverlaySpec;
import com.nexstreaming.app.general.util.B;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedOverlayAsset.java */
/* loaded from: classes2.dex */
public class c extends com.nexstreaming.app.general.nexasset.overlay.a.a {

    /* renamed from: b, reason: collision with root package name */
    private OverlaySpec f19592b;

    public c(r rVar) throws IOException, XmlPullParserException {
        super(rVar);
        InputStream inputStream;
        AssetPackageReader assetPackageReader;
        InputStream inputStream2 = null;
        try {
            assetPackageReader = d();
            try {
                inputStream = assetPackageReader.g(rVar.getFilePath());
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            assetPackageReader = null;
        }
        try {
            this.f19592b = OverlaySpec.a(inputStream);
            if ((this.f19592b.f19578b <= 0 || this.f19592b.f19579c <= 0) && this.f19592b.f19577a != null && this.f19592b.f19577a.size() > 0) {
                OverlaySpec.b bVar = this.f19592b.f19577a.get(0);
                if (bVar.f19586a != null && bVar.f19586a.size() > 0) {
                    OverlaySpec.a aVar = bVar.f19586a.get(0);
                    if (!aVar.f19584b) {
                        inputStream2 = assetPackageReader.g(aVar.f19583a);
                        Picture d2 = SVGParser.a(inputStream2).d();
                        this.f19592b.f19578b = d2.getWidth();
                        this.f19592b.f19579c = d2.getHeight();
                    }
                }
            }
            if (this.f19592b.f19578b <= 0 || this.f19592b.f19579c <= 0) {
                this.f19592b.f19578b = 100;
                this.f19592b.f19579c = 100;
            }
            C1702f.a(inputStream2);
            C1702f.a(inputStream);
            C1702f.a(assetPackageReader);
        } catch (Throwable th3) {
            th = th3;
            C1702f.a(inputStream2);
            C1702f.a(inputStream);
            C1702f.a(assetPackageReader);
            throw th;
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int a() {
        return this.f19592b.f19579c;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int b() {
        return this.f19592b.f19578b;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int c() {
        OverlaySpec overlaySpec = this.f19592b;
        int i = overlaySpec.f19582f;
        if (i > 0) {
            return (i * 1000) / overlaySpec.f19580d;
        }
        int i2 = 0;
        for (OverlaySpec.b bVar : overlaySpec.f19577a) {
            int i3 = bVar.f19587b;
            if (i3 < 0) {
                return 0;
            }
            i2 = Math.max(i2, ((bVar.f19588c * i3) * 1000) / this.f19592b.f19580d);
        }
        if (i2 > 30000) {
            return 0;
        }
        if (i2 < 1000) {
            return 1000;
        }
        return i2;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public com.nexstreaming.app.general.nexasset.overlay.a a(LayerRenderer layerRenderer, NexLayerItem.c cVar, RectF rectF, String str, Map<String, String> map) {
        AssetPackageReader assetPackageReader;
        try {
            assetPackageReader = d();
        } catch (IOException e2) {
            Log.e("AnimOverlayAsset", "Error getting package reader", e2);
            assetPackageReader = null;
        }
        AssetPackageReader assetPackageReader2 = assetPackageReader;
        OverlaySpec overlaySpec = this.f19592b;
        return new a(rectF, this.f19592b, assetPackageReader2, e().getFilePath(), Math.min(Math.min(cVar.f20240c * 2.0f, cVar.f20239b), SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE / Math.max(overlaySpec.f19578b, overlaySpec.f19579c)));
    }

    /* compiled from: AnimatedOverlayAsset.java */
    /* loaded from: classes2.dex */
    private static class a implements com.nexstreaming.app.general.nexasset.overlay.a {

        /* renamed from: a, reason: collision with root package name */
        private final RectF f19593a;

        /* renamed from: b, reason: collision with root package name */
        private final OverlaySpec f19594b;

        /* renamed from: c, reason: collision with root package name */
        private final AssetPackageReader f19595c;

        /* renamed from: d, reason: collision with root package name */
        private final String f19596d;

        /* renamed from: e, reason: collision with root package name */
        private final float f19597e;

        /* renamed from: f, reason: collision with root package name */
        int[] f19598f = {-1, -1};

        /* renamed from: g, reason: collision with root package name */
        private int[] f19599g = {0, 0};

        /* renamed from: h, reason: collision with root package name */
        String f19600h = "";
        Bitmap i = null;

        a(RectF rectF, OverlaySpec overlaySpec, AssetPackageReader assetPackageReader, String str, float f2) {
            this.f19593a = new RectF(rectF);
            this.f19594b = overlaySpec;
            this.f19595c = assetPackageReader;
            this.f19596d = str;
            this.f19597e = f2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader] */
        private Bitmap b(String str) {
            InputStream inputStream;
            Bitmap a2;
            ?? b2 = B.b(this.f19596d, str);
            String b3 = B.b(str);
            try {
                try {
                    inputStream = this.f19595c.g(b2);
                } catch (IOException e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    b2 = 0;
                    C1702f.a(b2);
                    throw th;
                }
                try {
                    if (b3.equalsIgnoreCase("svg")) {
                        a2 = b(inputStream);
                    } else {
                        a2 = a(inputStream);
                    }
                    C1702f.a(inputStream);
                    return a2;
                } catch (IOException e3) {
                    e = e3;
                    Log.e("AnimOverlayAsset", "Error reading frame image", e);
                    C1702f.a(inputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                C1702f.a(b2);
                throw th;
            }
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public void a(LayerRenderer layerRenderer) {
            C1702f.a(this.f19595c);
            NexEditor i = EditorGlobal.i();
            if (i == null || this.f19598f[layerRenderer.l().id] < 0) {
                return;
            }
            i.d(this.f19598f[layerRenderer.l().id], layerRenderer.l().id);
            this.f19598f[layerRenderer.l().id] = -1;
            this.f19599g[layerRenderer.l().id] = 0;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public boolean a() {
            return true;
        }

        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        public boolean a(LayerRenderer layerRenderer, String str) {
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0046  */
        @Override // com.nexstreaming.app.general.nexasset.overlay.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.nextreaming.nexvideoeditor.LayerRenderer r23, com.nexstreaming.kinemaster.editorwrapper.NexLayerItem.b r24, int r25, int r26, int r27) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.nexasset.overlay.a.c.a.a(com.nextreaming.nexvideoeditor.LayerRenderer, com.nexstreaming.kinemaster.editorwrapper.NexLayerItem$b, int, int, int):void");
        }

        private Bitmap b(InputStream inputStream) {
            PictureDrawable a2 = SVGParser.a(inputStream).a();
            Bitmap createBitmap = Bitmap.createBitmap((int) Math.floor(this.f19594b.f19578b * this.f19597e), (int) Math.floor(this.f19594b.f19579c * this.f19597e), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            a2.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            a2.draw(canvas);
            return createBitmap;
        }

        private Bitmap a(String str) {
            Bitmap bitmap;
            if (this.f19595c == null) {
                return null;
            }
            if (this.f19600h == str && (bitmap = this.i) != null) {
                return bitmap;
            }
            this.f19600h = str;
            this.i = b(str);
            return this.i;
        }

        private Bitmap a(InputStream inputStream) {
            return BitmapFactory.decodeStream(inputStream);
        }
    }
}
