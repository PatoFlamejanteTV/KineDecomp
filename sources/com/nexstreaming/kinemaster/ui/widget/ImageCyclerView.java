package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1705i;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class ImageCyclerView extends View {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f23759a = {"BG03_16v9.jpg", "BG04_16v9.jpg", "BG06_16v9.jpg"};

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, WeakReference<Bitmap>> f23760b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Executor f23761c = Executors.newSingleThreadExecutor();

    /* renamed from: d, reason: collision with root package name */
    private static List<String> f23762d = null;

    /* renamed from: e, reason: collision with root package name */
    private static List<String> f23763e = null;

    /* renamed from: f, reason: collision with root package name */
    private float f23764f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f23765g;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f23766h;
    private RectF i;
    private RectF j;
    private Paint k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f23767a;

        /* renamed from: b, reason: collision with root package name */
        Bitmap f23768b;

        /* renamed from: c, reason: collision with root package name */
        Bitmap f23769c;

        /* renamed from: d, reason: collision with root package name */
        ResultTask<Bitmap> f23770d;

        private a() {
        }

        /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ImageCyclerView(Context context) {
        super(context);
        this.f23765g = true;
        this.f23766h = new ArrayList();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Paint(2);
        a((AttributeSet) null);
    }

    private boolean b() {
        List<String> list = f23763e;
        return list != null && list.size() > 0;
    }

    public float getBlur() {
        return this.f23764f;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(ImageCyclerView.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ImageCyclerView imageCyclerView;
        int size = (b() ? f23763e : f23762d).size();
        long nanoTime = System.nanoTime() / 1000000;
        long j = nanoTime / 14500;
        int i = (int) (j % size);
        int i2 = ((i + size) - 1) % size;
        int i3 = (i + 1) % size;
        long j2 = j * 14500;
        long j3 = j2 + 18000;
        long j4 = (j - 1) * 14500;
        long j5 = j4 + 18000;
        int size2 = this.f23766h.size();
        int i4 = 0;
        boolean z = false;
        while (i4 < size2) {
            a aVar = this.f23766h.get(i4);
            int i5 = aVar.f23767a;
            if (i5 != i && i5 != i2 && i5 != i3) {
                this.f23766h.remove(i4);
                size2--;
                i4--;
            }
            if (aVar.f23767a == i3) {
                z = true;
            }
            i4++;
        }
        a(canvas, i2, nanoTime, j4, j5);
        a(canvas, i, nanoTime, j2, j3);
        if (z) {
            imageCyclerView = this;
        } else {
            imageCyclerView = this;
            imageCyclerView.a(i3, false);
        }
        if (imageCyclerView.f23765g) {
            postInvalidateOnAnimation();
        }
    }

    public void setAnimationEnabled(boolean z) {
        if (this.f23765g != z) {
            this.f23765g = z;
            if (z) {
                postInvalidateOnAnimation();
            }
        }
    }

    public void setBlur(float f2) {
        this.f23764f = f2;
    }

    public void b(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        b(extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ImageCyclerView> f23771a;

        /* renamed from: b, reason: collision with root package name */
        int f23772b;

        /* renamed from: c, reason: collision with root package name */
        int f23773c;

        /* renamed from: d, reason: collision with root package name */
        int f23774d;

        /* renamed from: e, reason: collision with root package name */
        private ResultTask<Bitmap> f23775e;

        /* renamed from: f, reason: collision with root package name */
        private String f23776f;

        b(ImageCyclerView imageCyclerView, ResultTask<Bitmap> resultTask, String str) {
            this.f23775e = resultTask;
            this.f23776f = str;
            this.f23771a = new WeakReference<>(imageCyclerView);
            if (this.f23771a.get() != null) {
                this.f23772b = Math.min(1024, (this.f23771a.get().getResources().getDisplayMetrics().widthPixels * 4) / 3);
                this.f23773c = Math.min(1024, (this.f23771a.get().getResources().getDisplayMetrics().heightPixels * 4) / 3);
                this.f23774d = Math.max(this.f23772b, this.f23773c);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            try {
                InputStream a2 = a(this.f23776f);
                try {
                    return NexImageLoader.loadBitmap(a2, this.f23774d, this.f23774d, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).a();
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            } catch (IOException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                ImageCyclerView.f23760b.put(this.f23776f, new WeakReference(bitmap));
                this.f23775e.sendResult(bitmap);
            } else {
                this.f23775e.sendFailure(null);
            }
            super.onPostExecute(bitmap);
        }

        private InputStream a(String str) throws IOException {
            if (str.startsWith(EditorGlobal.p().getAbsolutePath())) {
                return new BufferedInputStream(new FileInputStream(str));
            }
            ImageCyclerView imageCyclerView = this.f23771a.get();
            if (imageCyclerView != null) {
                return imageCyclerView.getResources().getAssets().open(str);
            }
            return null;
        }
    }

    private void a(AttributeSet attributeSet) {
        File[] listFiles;
        if (f23762d == null) {
            f23762d = new ArrayList();
            for (String str : f23759a) {
                f23762d.add("backgrounds/16v9/" + str);
            }
        }
        if (f23763e == null && (listFiles = new File(EditorGlobal.c(), "UserBackground").listFiles()) != null && listFiles.length > 0) {
            f23763e = new ArrayList();
            for (File file : listFiles) {
                f23763e.add(file.getAbsolutePath());
            }
        }
        if (attributeSet != null) {
            this.f23764f = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.ImageCyclerView, 0, 0).getFloat(0, 0.0f);
        }
    }

    public void b(Bundle bundle) {
        int[] intArray = bundle.getIntArray("com.kinemaster.imagecycler.activeBitmapCount");
        if (intArray != null) {
            for (int i : intArray) {
                Parcelable parcelable = bundle.getParcelable("com.kinemaster.imagecycler.bm." + i);
                Parcelable parcelable2 = bundle.getParcelable("com.kinemaster.imagecycler.bbm." + i);
                if (parcelable != null && (parcelable instanceof Bitmap) && parcelable2 != null && (parcelable2 instanceof Bitmap)) {
                    a aVar = new a(null);
                    aVar.f23768b = (Bitmap) parcelable;
                    aVar.f23769c = (Bitmap) parcelable2;
                    aVar.f23767a = i;
                    this.f23766h.add(aVar);
                }
            }
        }
    }

    public ImageCyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23765g = true;
        this.f23766h = new ArrayList();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Paint(2);
        a(attributeSet);
    }

    public ImageCyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23765g = true;
        this.f23766h = new ArrayList();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Paint(2);
        a(attributeSet);
    }

    private void a(Canvas canvas, int i, long j, long j2, long j3) {
        if (j < j2 || j > j3) {
            return;
        }
        int i2 = (int) (j - j2);
        int i3 = i2 < 3500 ? (i2 * 255) / 3500 : 255;
        int i4 = (int) (this.f23764f * 255.0f);
        float f2 = i2 / 18000.0f;
        a a2 = a(i, true);
        if (a2 == null) {
            return;
        }
        float f3 = f2 * 250.0f;
        float f4 = 0.0f - f3;
        this.i.set(f4, f4, (getWidth() + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) - f3, (getHeight() + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) - f3);
        this.k.setAlpha(i3);
        float f5 = this.f23764f;
        if (f5 > 0.995d) {
            Bitmap bitmap = a2.f23769c;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.i, this.k);
                return;
            }
            return;
        }
        if (f5 < 0.001d) {
            Bitmap bitmap2 = a2.f23768b;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, this.i, this.k);
                return;
            }
            return;
        }
        this.j.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.saveLayerAlpha(this.j, i3, 31);
        Bitmap bitmap3 = a2.f23768b;
        if (bitmap3 != null) {
            canvas.drawBitmap(bitmap3, (Rect) null, this.i, (Paint) null);
        }
        this.k.setAlpha(i4);
        Bitmap bitmap4 = a2.f23769c;
        if (bitmap4 != null) {
            canvas.drawBitmap(bitmap4, (Rect) null, this.i, this.k);
        }
        canvas.restore();
    }

    @TargetApi(21)
    public ImageCyclerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23765g = true;
        this.f23766h = new ArrayList();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Paint(2);
        a(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, float f2) {
        return C1705i.a(bitmap, (int) f2);
    }

    public void a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
            intent.putExtras(extras);
        }
        a(extras);
    }

    public void a(Bundle bundle) {
        int size = this.f23766h.size();
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f23766h.get(i2);
            if (aVar.f23768b != null && aVar.f23769c != null) {
                iArr[i] = aVar.f23767a;
                bundle.putParcelable("com.kinemaster.imagecycler.bm." + aVar.f23767a, aVar.f23768b);
                bundle.putParcelable("com.kinemaster.imagecycler.bbm." + aVar.f23767a, aVar.f23769c);
                i++;
            }
        }
        if (i > 0) {
            bundle.putInt("com.kinemaster.imagecycler.activeBitmapCount", i);
        }
    }

    private String a(int i) {
        return (b() ? f23763e : f23762d).get(i);
    }

    private a a(int i, boolean z) {
        int size = this.f23766h.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f23766h.get(i2);
            if (aVar.f23767a == i) {
                return aVar;
            }
        }
        a aVar2 = new a(null);
        aVar2.f23767a = i;
        aVar2.f23770d = a(a(i), z);
        this.f23766h.add(aVar2);
        aVar2.f23770d.onResultAvailable(new g(this, aVar2)).onFailure((Task.OnFailListener) new f(this, aVar2));
        return aVar2;
    }

    private ResultTask<Bitmap> a(String str, boolean z) {
        Bitmap bitmap;
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        WeakReference<Bitmap> weakReference = f23760b.get(str);
        if (weakReference != null && (bitmap = weakReference.get()) != null) {
            resultTask.sendResult(bitmap);
            return resultTask;
        }
        int min = Math.min(1024, (getResources().getDisplayMetrics().widthPixels * 4) / 3);
        int min2 = Math.min(1024, (getResources().getDisplayMetrics().heightPixels * 4) / 3);
        Crashlytics.log("[loadImage]assetPath:" + str + ", w:" + min + ", h:" + min2 + ", s:" + Math.max(min, min2));
        AsyncTask<Void, Void, Bitmap> executeOnExecutor = new b(this, resultTask, str).executeOnExecutor(f23761c, new Void[0]);
        if (z) {
            try {
                executeOnExecutor.get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                throw new RuntimeException(e2);
            }
        }
        return resultTask;
    }
}
