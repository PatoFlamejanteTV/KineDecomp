package com.nexstreaming.kinemaster.layer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.SparseArray;
import com.larvalabs.svgandroid.SVGParser;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.lang.ref.WeakReference;

/* compiled from: LayerCropMask.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f20624a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f20625b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f20626c;

    /* renamed from: d, reason: collision with root package name */
    private static SparseArray<WeakReference<Bitmap>> f20627d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private static SparseArray<WeakReference<Bitmap>> f20628e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private static RenderScript f20629f;

    /* renamed from: g, reason: collision with root package name */
    private static ScriptIntrinsicBlur f20630g;

    static {
        Object[] objArr = {0, Integer.valueOf(R.raw.layer_mask_rect), "com.kinemaster.shape.rect", 1, Integer.valueOf(R.raw.layer_mask_roundrect), "com.kinemaster.shape.roundrect", 2, Integer.valueOf(R.raw.layer_mask_oval), "com.kinemaster.shape.oval", 3, Integer.valueOf(R.raw.layer_mask_triangle_sw), "com.kinemaster.shape.triangle.sw", 4, Integer.valueOf(R.raw.layer_mask_triangle_ne), "com.kinemaster.shape.triangle_ne", 5, Integer.valueOf(R.raw.layer_mask_triangle_n), "com.kinemaster.shape.triangle_n", 6, Integer.valueOf(R.raw.layer_mask_triangle_se), "com.kinemaster.shape.triangle_se", 7, Integer.valueOf(R.raw.layer_mask_triangle_nw), "com.kinemaster.shape.triangle_nw", 8, Integer.valueOf(R.raw.layer_mask_triangle_s), "com.kinemaster.shape.triangle_s", 9, Integer.valueOf(R.raw.layer_mask_heart), "com.kinemaster.shape.heart", 10, Integer.valueOf(R.raw.layer_mask_star), "com.kinemaster.shape.star", 11, Integer.valueOf(R.raw.layer_mask_diamond), "com.kinemaster.shape.diamond", 12, Integer.valueOf(R.raw.layer_mask_octa), "com.kinemaster.shape.octa", 13, Integer.valueOf(R.raw.layer_mask_hexa), "com.kinemaster.shape.hexa", 14, Integer.valueOf(R.raw.layer_mask_pentagon), "com.kinemaster.shape.pentagon", 15, Integer.valueOf(R.raw.layer_mask_roundburst), "com.kinemaster.shape.roundburst", 16, Integer.valueOf(R.raw.layer_mask_roundstep), "com.kinemaster.shape.roundstep", 17, Integer.valueOf(R.raw.layer_mask_badge), "com.kinemaster.shape.badge"};
        f20624a = new int[objArr.length / 3];
        f20625b = new int[objArr.length / 3];
        f20626c = new String[objArr.length / 3];
        for (int i = 0; i < objArr.length / 3; i++) {
            int i2 = i * 3;
            f20624a[i] = ((Integer) objArr[i2]).intValue();
            f20625b[i] = ((Integer) objArr[i2 + 1]).intValue();
            f20626c[i] = (String) objArr[i2 + 2];
        }
    }

    public static int[] a() {
        return f20624a;
    }

    public static int b(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f20624a;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return f20625b[i2];
                }
                i2++;
            } else {
                return f20625b[0];
            }
        }
    }

    private static Resources c() {
        return KineMasterApplication.f24056d.getResources();
    }

    public static String a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f20624a;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return f20626c[i2];
                }
                i2++;
            } else {
                return f20626c[0];
            }
        }
    }

    public static Bitmap c(int i) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = f20627d.get(i);
        if (weakReference != null && (bitmap = weakReference.get()) != null) {
            return bitmap;
        }
        SVGParser.c cVar = new SVGParser.c();
        cVar.a(-1841947);
        PictureDrawable a2 = SVGParser.a(c(), b(i), cVar).a();
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth() + 0, a2.getIntrinsicHeight() + 0, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        cVar.a(637534208);
        cVar.a(637534208, 2.0f);
        PictureDrawable a3 = SVGParser.a(c(), b(i), cVar).a();
        a3.setBounds(0, 0, createBitmap.getWidth() - 0, createBitmap.getHeight() - 0);
        a3.draw(canvas);
        a2.setBounds(0, 0, createBitmap.getWidth() - 0, createBitmap.getHeight() - 0);
        a2.draw(canvas);
        f20627d.put(i, new WeakReference<>(createBitmap));
        return createBitmap;
    }

    public static int b() {
        int i = 0;
        while (true) {
            int[] iArr = f20625b;
            if (i >= iArr.length) {
                return 0;
            }
            if (iArr[i] == R.raw.layer_mask_rect) {
                return f20624a[i];
            }
            i++;
        }
    }

    public static Bitmap a(int i, int i2, float f2, LayerRenderer.RenderMode renderMode) {
        com.larvalabs.svgandroid.b a2 = SVGParser.a(c(), b(i));
        if (i2 < 120) {
            i2 = 120;
        }
        if (i2 > 2048) {
            i2 = 2048;
        }
        int i3 = i2 / 2;
        float f3 = f2 / 2.0f;
        if (renderMode == LayerRenderer.RenderMode.Preview) {
            f3 = Math.max(1.0f, f3 / 4.0f);
            i3 = (int) Math.ceil(i3 / f3);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        PictureDrawable a3 = a2.a();
        if (Build.VERSION.SDK_INT >= 17) {
            int i4 = (int) f3;
            int i5 = i3 - i4;
            a3.setBounds(i4, i4, i5, i5);
        } else {
            a3.setBounds(0, 0, i3, i3);
        }
        a3.draw(new Canvas(createBitmap));
        if (f3 <= 0.0f) {
            return createBitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 17) {
            if (f20629f == null) {
                f20629f = RenderScript.create(KineMasterApplication.f24056d);
                RenderScript renderScript = f20629f;
                f20630g = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            }
            Allocation createFromBitmap = Allocation.createFromBitmap(f20629f, createBitmap);
            Allocation createTyped = Allocation.createTyped(f20629f, createFromBitmap.getType());
            f20630g.setRadius(f3);
            f20630g.setInput(createFromBitmap);
            f20630g.forEach(createTyped);
            createTyped.copyTo(createBitmap2);
        } else {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setMaskFilter(new BlurMaskFilter(f3 * 0.75f, BlurMaskFilter.Blur.NORMAL));
            new Canvas(createBitmap2).drawBitmap(createBitmap.extractAlpha(paint, new int[2]), (Rect) null, new RectF(-r11[0], -r11[1], r11[0] + i3, i3 + r11[1]), paint);
        }
        createBitmap.recycle();
        return createBitmap2;
    }
}
