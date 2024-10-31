package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* compiled from: BitmapOverlayAsset.java */
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: b, reason: collision with root package name */
    private int f19606b;

    /* renamed from: c, reason: collision with root package name */
    private int f19607c;

    public e(r rVar) throws IOException {
        super(rVar);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream g2 = d().g(rVar.getFilePath());
        try {
            BitmapFactory.decodeStream(g2, null, options);
            C1702f.a(g2);
            this.f19606b = options.outWidth;
            this.f19607c = options.outHeight;
        } catch (Throwable th) {
            C1702f.a(g2);
            throw th;
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int a() {
        return this.f19607c;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int b() {
        return this.f19606b;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int c() {
        return 0;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0028: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:16:0x0028 */
    private Bitmap a(BitmapFactory.Options options) {
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                inputStream = d().g(e().getFilePath());
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                C1702f.a(closeable2);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                C1702f.a(inputStream);
                return decodeStream;
            } catch (IOException unused2) {
                Log.e("BitmapOverlayAsset", "");
                C1702f.a(inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            C1702f.a(closeable2);
            throw th;
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public com.nexstreaming.app.general.nexasset.overlay.a a(LayerRenderer layerRenderer, NexLayerItem.c cVar, RectF rectF, String str, Map<String, String> map) {
        int[] iArr = {-1, -1};
        int[] iArr2 = {0, 0};
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        while (true) {
            int i = options.inSampleSize;
            if (i >= 16 || (this.f19606b / i <= 2000 && this.f19607c / i <= 2000)) {
                break;
            }
            options.inSampleSize *= 2;
        }
        return new d(this, iArr, iArr2, a(options), rectF);
    }
}
