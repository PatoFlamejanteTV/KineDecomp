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
import android.util.AttributeSet;
import android.view.View;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class ImageCyclerView extends View {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f4375a = null;
    private static final Map<String, WeakReference<Bitmap>> b = new WeakHashMap();
    private static final Executor c = Executors.newSingleThreadExecutor();
    private List<a> d;
    private RectF e;
    private RectF f;
    private Paint g;
    private float h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Bitmap f4376a;
        Bitmap b;
        int c;
        ResultTask<Bitmap> d;

        private a() {
        }

        /* synthetic */ a(d dVar) {
            this();
        }
    }

    public ImageCyclerView(Context context) {
        super(context);
        this.d = new ArrayList();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Paint(2);
        this.i = true;
        a((AttributeSet) null);
    }

    public ImageCyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Paint(2);
        this.i = true;
        a(attributeSet);
    }

    public ImageCyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Paint(2);
        this.i = true;
        a(attributeSet);
    }

    @TargetApi(21)
    public ImageCyclerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new ArrayList();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Paint(2);
        this.i = true;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (f4375a == null) {
                try {
                    String[] list = getResources().getAssets().list("backgrounds");
                    f4375a = new ArrayList();
                    for (String str : list) {
                        if (str.startsWith("gallery_")) {
                            f4375a.add("backgrounds/" + str);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Cannot load background list", e);
                }
            }
            if (attributeSet != null) {
                this.h = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.ImageCyclerView, 0, 0).getFloat(0, 0.0f);
            }
        }
    }

    public float getBlur() {
        return this.h;
    }

    public void setBlur(float f) {
        this.h = f;
    }

    public void setAnimationEnabled(boolean z) {
        if (this.i != z) {
            this.i = z;
            if (z) {
                postInvalidateOnAnimation();
            }
        }
    }

    public boolean getAnimationEnabled() {
        return this.i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int size = f4375a.size();
        long nanoTime = System.nanoTime() / 1000000;
        long j = nanoTime / 14500;
        int i = (int) (j % size);
        int i2 = ((i + size) - 1) % size;
        int i3 = (i + 1) % size;
        long j2 = j * 14500;
        long j3 = j2 + 18000;
        long j4 = 14500 * (j - 1);
        long j5 = j4 + 18000;
        int size2 = this.d.size();
        boolean z = false;
        int i4 = 0;
        while (i4 < size2) {
            a aVar = this.d.get(i4);
            if (aVar.c != i && aVar.c != i2 && aVar.c != i3) {
                this.d.remove(i4);
                size2--;
                i4--;
            }
            i4++;
            z = aVar.c == i3 ? true : z;
        }
        a(canvas, i2, nanoTime, j4, j5);
        a(canvas, i, nanoTime, j2, j3);
        if (!z) {
            a(i3, false);
        }
        if (this.i) {
            postInvalidateOnAnimation();
        }
    }

    private void a(Canvas canvas, int i, long j, long j2, long j3) {
        if (j >= j2 && j <= j3) {
            int i2 = (int) (j - j2);
            int i3 = 255;
            if (i2 < 3500) {
                i3 = (i2 * 255) / 3500;
            }
            int i4 = (int) (this.h * 255.0f);
            float f = i2 / 18000.0f;
            a a2 = a(i, true);
            if (a2 != null) {
                float f2 = f * 250.0f;
                this.e.set(0.0f - f2, 0.0f - f2, (getWidth() + 250) - f2, (getHeight() + 250) - f2);
                this.g.setAlpha(i3);
                if (this.h > 0.995d) {
                    if (a2.b != null) {
                        canvas.drawBitmap(a2.b, (Rect) null, this.e, this.g);
                    }
                } else {
                    if (this.h < 0.001d) {
                        if (a2.f4376a != null) {
                            canvas.drawBitmap(a2.f4376a, (Rect) null, this.e, this.g);
                            return;
                        }
                        return;
                    }
                    this.f.set(0.0f, 0.0f, getWidth(), getHeight());
                    canvas.saveLayerAlpha(this.f, i3, 31);
                    if (a2.f4376a != null) {
                        canvas.drawBitmap(a2.f4376a, (Rect) null, this.e, (Paint) null);
                    }
                    this.g.setAlpha(i4);
                    if (a2.b != null) {
                        canvas.drawBitmap(a2.b, (Rect) null, this.e, this.g);
                    }
                    canvas.restore();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, float f) {
        return com.nexstreaming.app.general.util.e.a(bitmap, (int) f);
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
        int i;
        int size = this.d.size();
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            a aVar = this.d.get(i2);
            if (aVar.f4376a == null || aVar.b == null) {
                i = i3;
            } else {
                iArr[i3] = aVar.c;
                bundle.putParcelable("com.kinemaster.imagecycler.bm." + aVar.c, aVar.f4376a);
                bundle.putParcelable("com.kinemaster.imagecycler.bbm." + aVar.c, aVar.b);
                i = i3 + 1;
            }
            i2++;
            i3 = i;
        }
        if (i3 > 0) {
            bundle.putInt("com.kinemaster.imagecycler.activeBitmapCount", i3);
        }
    }

    public void b(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            b(extras);
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
                    aVar.f4376a = (Bitmap) parcelable;
                    aVar.b = (Bitmap) parcelable2;
                    aVar.c = i;
                    this.d.add(aVar);
                }
            }
        }
    }

    private a a(int i, boolean z) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.d.get(i2);
            if (aVar.c == i) {
                return aVar;
            }
        }
        a aVar2 = new a(null);
        aVar2.c = i;
        aVar2.d = a(f4375a.get(i), z);
        this.d.add(aVar2);
        aVar2.d.onResultAvailable(new e(this, aVar2)).onFailure((Task.OnFailListener) new d(this, aVar2));
        return aVar2;
    }

    private ResultTask<Bitmap> a(String str, boolean z) {
        Bitmap bitmap;
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        WeakReference<Bitmap> weakReference = b.get(str);
        if (weakReference != null && (bitmap = weakReference.get()) != null) {
            resultTask.sendResult(bitmap);
        } else {
            AsyncTask<String, Void, Bitmap> executeOnExecutor = new f(this, getResources().getAssets(), str, Math.max(Math.min(2048, (getResources().getDisplayMetrics().widthPixels * 4) / 3), Math.min(2048, (getResources().getDisplayMetrics().heightPixels * 4) / 3)), resultTask).executeOnExecutor(c, new String[0]);
            if (z) {
                try {
                    executeOnExecutor.get();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return resultTask;
    }
}
