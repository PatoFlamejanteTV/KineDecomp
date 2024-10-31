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
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static LruCache<String, a> f3709a = new LruCache<>(100);
    private static Executor b = Executors.newFixedThreadPool(4);
    private static Map<String, WeakReference<ResultTask<a>>> c = new HashMap();
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(File file, b bVar) {
        this(file);
    }

    public void a(RectF rectF) {
        rectF.set(this.d, this.e, this.f, this.g);
    }

    private a(File file) {
        Bitmap a2 = NexImageLoader.loadBitmap(file.getAbsolutePath(), 800, 800, 2560000, Bitmap.Config.RGB_565).a();
        if (a2 != null) {
            FaceDetector.Face[] faceArr = new FaceDetector.Face[32];
            int findFaces = new FaceDetector(a2.getWidth(), a2.getHeight(), 32).findFaces(a2, faceArr);
            this.h = 0;
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            PointF pointF = new PointF();
            float width = a2.getWidth();
            float height = a2.getHeight();
            float f = width / 30.0f;
            float f2 = height / 30.0f;
            for (int i = 0; i < findFaces; i++) {
                if (faceArr[i].confidence() >= 0.4d) {
                    faceArr[i].getMidPoint(pointF);
                    float eyesDistance = faceArr[i].eyesDistance();
                    if (eyesDistance >= f && eyesDistance >= f2) {
                        this.h++;
                        rectF2.set((pointF.x - (eyesDistance / 2.0f)) / width, (pointF.y - (eyesDistance / 3.0f)) / height, (pointF.x + (eyesDistance / 2.0f)) / width, (((eyesDistance / 3.0f) * 2.0f) + pointF.y) / height);
                        rectF.union(rectF2);
                    }
                }
            }
            a2.recycle();
            if (!rectF.isEmpty()) {
                float width2 = 0.6f - rectF.width();
                float height2 = 0.6f - rectF.height();
                if (width2 > 0.0f) {
                    rectF.left -= width2 / 2.0f;
                    rectF.right = (width2 / 2.0f) + rectF.right;
                }
                if (height2 > 0.0f) {
                    rectF.top -= height2 / 2.0f;
                    rectF.bottom += height2 / 2.0f;
                }
            }
            this.d = Math.max(0.0f, rectF.left);
            this.e = Math.max(0.0f, rectF.top);
            this.f = Math.min(rectF.right, 1.0f);
            this.g = Math.min(rectF.bottom, 1.0f);
        }
    }

    public static a a(String str) {
        return f3709a.get(str);
    }

    public static ResultTask<a> b(String str) {
        a aVar = f3709a.get(str);
        if (aVar != null) {
            return ResultTask.completedResultTask(aVar);
        }
        WeakReference<ResultTask<a>> weakReference = c.get(str);
        if (weakReference != null) {
            ResultTask<a> resultTask = weakReference.get();
            if (resultTask.isRunning()) {
                return resultTask;
            }
        }
        ResultTask<a> resultTask2 = new ResultTask<>();
        c.put(str, new WeakReference<>(resultTask2));
        new b(str, resultTask2).executeOnExecutor(b, str);
        return resultTask2;
    }
}
