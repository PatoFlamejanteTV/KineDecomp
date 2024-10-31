package com.nexstreaming.kinemaster.ui.c;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.util.LruCache;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: FaceInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static LruCache<String, b> f21522a = new LruCache<>(100);

    /* renamed from: b, reason: collision with root package name */
    private static Executor f21523b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, WeakReference<ResultTask<b>>> f21524c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private float f21525d;

    /* renamed from: e, reason: collision with root package name */
    private float f21526e;

    /* renamed from: f, reason: collision with root package name */
    private float f21527f;

    /* renamed from: g, reason: collision with root package name */
    private float f21528g;

    /* renamed from: h, reason: collision with root package name */
    private int f21529h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(File file, a aVar) {
        this(file);
    }

    private b(File file) {
        float f2;
        int i;
        FaceDetector.Face[] faceArr;
        Bitmap a2 = NexImageLoader.loadBitmap(file.getAbsolutePath(), 800, 800, 2560000, Bitmap.Config.RGB_565).a();
        if (a2 == null) {
            return;
        }
        FaceDetector.Face[] faceArr2 = new FaceDetector.Face[32];
        int findFaces = new FaceDetector(a2.getWidth(), a2.getHeight(), 32).findFaces(a2, faceArr2);
        int i2 = 0;
        this.f21529h = 0;
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        PointF pointF = new PointF();
        float width = a2.getWidth();
        float height = a2.getHeight();
        float f3 = width / 30.0f;
        float f4 = height / 30.0f;
        while (i2 < findFaces) {
            if (faceArr2[i2].confidence() >= 0.4d) {
                faceArr2[i2].getMidPoint(pointF);
                float eyesDistance = faceArr2[i2].eyesDistance();
                if (eyesDistance >= f3 && eyesDistance >= f4) {
                    this.f21529h++;
                    float f5 = pointF.x;
                    float f6 = eyesDistance / 2.0f;
                    i = findFaces;
                    float f7 = pointF.y;
                    float f8 = eyesDistance / 3.0f;
                    faceArr = faceArr2;
                    rectF2.set((f5 - f6) / width, (f7 - f8) / height, (f5 + f6) / width, (f7 + (f8 * 2.0f)) / height);
                    rectF.union(rectF2);
                    i2++;
                    findFaces = i;
                    faceArr2 = faceArr;
                }
            }
            i = findFaces;
            faceArr = faceArr2;
            i2++;
            findFaces = i;
            faceArr2 = faceArr;
        }
        a2.recycle();
        if (!rectF.isEmpty()) {
            float width2 = 0.6f - rectF.width();
            float height2 = 0.6f - rectF.height();
            if (width2 > 0.0f) {
                f2 = 2.0f;
                float f9 = width2 / 2.0f;
                rectF.left -= f9;
                rectF.right += f9;
            } else {
                f2 = 2.0f;
            }
            if (height2 > 0.0f) {
                float f10 = height2 / f2;
                rectF.top -= f10;
                rectF.bottom += f10;
            }
        }
        this.f21525d = Math.max(0.0f, rectF.left);
        this.f21526e = Math.max(0.0f, rectF.top);
        this.f21527f = Math.min(rectF.right, 1.0f);
        this.f21528g = Math.min(rectF.bottom, 1.0f);
    }

    public static ResultTask<b> b(String str) {
        b bVar = f21522a.get(str);
        if (bVar != null) {
            return ResultTask.completedResultTask(bVar);
        }
        WeakReference<ResultTask<b>> weakReference = f21524c.get(str);
        if (weakReference != null) {
            ResultTask<b> resultTask = weakReference.get();
            if (resultTask.isRunning()) {
                return resultTask;
            }
        }
        ResultTask<b> resultTask2 = new ResultTask<>();
        f21524c.put(str, new WeakReference<>(resultTask2));
        new a(str, resultTask2).executeOnExecutor(f21523b, str);
        return resultTask2;
    }

    public void a(RectF rectF) {
        rectF.set(this.f21525d, this.f21526e, this.f21527f, this.f21528g);
    }

    public static b a(String str) {
        return f21522a.get(str);
    }
}
