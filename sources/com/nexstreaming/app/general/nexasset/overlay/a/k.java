package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.io.IOException;
import java.util.Map;

/* compiled from: SVGOverlayAsset.java */
/* loaded from: classes2.dex */
public class k extends a {

    /* renamed from: b, reason: collision with root package name */
    private static int f19635b;

    /* renamed from: c, reason: collision with root package name */
    private int f19636c;

    /* renamed from: d, reason: collision with root package name */
    private int f19637d;

    public k(r rVar) throws IOException {
        super(rVar);
        com.larvalabs.svgandroid.b a2 = a(null);
        if (a2 != null) {
            this.f19636c = a2.d().getWidth();
            this.f19637d = a2.d().getHeight();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(10:3|(2:4|(3:6|(5:8|9|(1:11)|12|13)(1:15)|14)(0))|17|18|19|20|21|22|23|24)(1:43)|16|17|18|19|20|21|22|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:            r1 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:            android.util.Log.e("SVGOverlayAsset", r1.getMessage(), r1);        r2 = r2;        r7 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:            r1 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:            r2 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:            r2 = 0;        r0 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:            com.nexstreaming.app.general.util.C1702f.a(r2);        com.nexstreaming.app.general.util.C1702f.a(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:            throw r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:            r1 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:            r7 = null;        r2 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:            r7 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0075, code lost:            r2 = 0;        r0 = r7;        r7 = null;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.Iterator] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.larvalabs.svgandroid.b a(java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L53
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
            r1 = r0
        Lc:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L54
            java.lang.Object r2 = r7.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "color:svgcolor_"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto Lc
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = "#"
            java.lang.String r3 = r3.replace(r4, r5)
            int r3 = com.nexstreaming.app.general.util.C1703g.a(r3)
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            int r2 = com.nexstreaming.app.general.util.C1703g.a(r2)
            if (r1 != 0) goto L47
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L47:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r3, r2)
            goto Lc
        L53:
            r1 = r0
        L54:
            com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader r7 = r6.d()     // Catch: java.lang.Throwable -> L74 com.larvalabs.svgandroid.SVGParseException -> L79
            com.nexstreaming.app.general.nexasset.assetpackage.r r2 = r6.e()     // Catch: java.lang.Throwable -> L6d com.larvalabs.svgandroid.SVGParseException -> L71
            java.lang.String r2 = r2.getFilePath()     // Catch: java.lang.Throwable -> L6d com.larvalabs.svgandroid.SVGParseException -> L71
            java.io.InputStream r2 = r7.g(r2)     // Catch: java.lang.Throwable -> L6d com.larvalabs.svgandroid.SVGParseException -> L71
            r3 = 50
            com.larvalabs.svgandroid.b r0 = com.larvalabs.svgandroid.SVGParser.a(r2, r1, r3)     // Catch: com.larvalabs.svgandroid.SVGParseException -> L6b java.lang.Throwable -> L8c
            goto L85
        L6b:
            r1 = move-exception
            goto L7c
        L6d:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L8d
        L71:
            r1 = move-exception
            r2 = r0
            goto L7c
        L74:
            r7 = move-exception
            r2 = r0
            r0 = r7
            r7 = r2
            goto L8d
        L79:
            r1 = move-exception
            r7 = r0
            r2 = r7
        L7c:
            java.lang.String r3 = "SVGOverlayAsset"
            java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> L8c
            android.util.Log.e(r3, r4, r1)     // Catch: java.lang.Throwable -> L8c
        L85:
            com.nexstreaming.app.general.util.C1702f.a(r2)
            com.nexstreaming.app.general.util.C1702f.a(r7)
            return r0
        L8c:
            r0 = move-exception
        L8d:
            com.nexstreaming.app.general.util.C1702f.a(r2)
            com.nexstreaming.app.general.util.C1702f.a(r7)
            goto L95
        L94:
            throw r0
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.nexasset.overlay.a.k.a(java.util.Map):com.larvalabs.svgandroid.b");
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int b() {
        return this.f19636c;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int c() {
        return 0;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int a() {
        return this.f19637d;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public com.nexstreaming.app.general.nexasset.overlay.a a(LayerRenderer layerRenderer, NexLayerItem.c cVar, RectF rectF, String str, Map<String, String> map) {
        int i = f19635b;
        f19635b = i + 1;
        int[] iArr = {-1, -1};
        int[] iArr2 = {0, 0};
        try {
            com.larvalabs.svgandroid.b a2 = a(map);
            if (a2 == null) {
                return null;
            }
            float min = Math.min(Math.min(cVar.f20240c * 2.0f, cVar.f20239b), SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE / Math.max(this.f19636c, this.f19637d));
            Picture d2 = a2.d();
            Bitmap createBitmap = Bitmap.createBitmap((int) Math.floor(this.f19636c * min), (int) Math.floor(this.f19637d * min), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(min, min);
            d2.draw(canvas);
            return new j(this, i, iArr, iArr2, createBitmap, rectF);
        } catch (IOException e2) {
            Log.e("SVGOverlayAsset", "Error loading asset", e2);
            return null;
        }
    }
}
