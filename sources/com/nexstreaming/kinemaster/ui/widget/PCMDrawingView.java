package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.nexstreaming.kinemaster.mediainfo.L;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import java.util.Random;

/* loaded from: classes2.dex */
public class PCMDrawingView extends View implements InterfaceC2026g {

    /* renamed from: a, reason: collision with root package name */
    private transient byte[] f23786a;

    /* renamed from: b, reason: collision with root package name */
    private int f23787b;

    /* renamed from: c, reason: collision with root package name */
    private int f23788c;

    /* renamed from: d, reason: collision with root package name */
    private int f23789d;

    /* renamed from: e, reason: collision with root package name */
    private int f23790e;

    /* renamed from: f, reason: collision with root package name */
    private int f23791f;

    /* renamed from: g, reason: collision with root package name */
    private int f23792g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f23793h;
    private Bitmap i;
    private boolean j;
    private boolean k;
    private MediaInfo l;
    Random m;

    public PCMDrawingView(Context context) {
        super(context);
        this.f23793h = null;
        this.i = null;
        this.m = new Random();
    }

    public void a(NexAudioClipItem nexAudioClipItem, int i, int i2) {
        this.f23788c = nexAudioClipItem.getStartTrim();
        this.f23790e = nexAudioClipItem.getRepresentedDuration();
        this.f23787b = nexAudioClipItem.getOriginalDuration();
        this.f23789d = nexAudioClipItem.getEndTrim();
        this.f23791f = i;
        int i3 = this.f23792g;
        if (i3 != 0 && i3 != i2) {
            this.f23793h = null;
            this.i = null;
        }
        this.f23792g = i2;
        this.j = nexAudioClipItem.isLoop();
        this.k = nexAudioClipItem.isLegacyBGMusic();
        this.l = MediaInfo.a(nexAudioClipItem.getMediaPath());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public int getSerialNumber() {
        return Integer.valueOf(getTag().toString()).intValue();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(PCMDrawingView.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        Bitmap bitmap = this.f23793h;
        if (bitmap != null) {
            Bitmap bitmap2 = this.i;
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            int i = (this.f23790e / this.f23787b) + 1;
            Paint paint = new Paint();
            paint.setColor(this.f23791f);
            paint.setAntiAlias(true);
            Rect rect = new Rect();
            getDrawingRect(rect);
            Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            int width = rect.width();
            int i2 = (int) ((((this.f23787b - this.f23788c) - this.f23789d) / this.f23790e) * width);
            for (int i3 = 1; i3 <= i; i3++) {
                rect2.left += (this.f23788c * bitmap.getWidth()) / this.f23787b;
                rect2.right -= (this.f23789d * bitmap.getWidth()) / this.f23787b;
                rect.left += (i3 - 1) * i2;
                rect.right = i3 * i2;
                if (!this.j && rect.right > width) {
                    return;
                }
                canvas.save();
                canvas.clipRect(rect);
                canvas.drawBitmap(bitmap, rect2, rect, paint);
                canvas.restore();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public void setDecoData(Object obj) {
        if (obj instanceof L) {
            this.f23786a = ((L) obj).a();
            invalidate();
        } else if (obj == null) {
            this.f23786a = null;
            this.f23793h = null;
            invalidate();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public void setSerialNumber(int i) {
        setTag(Integer.valueOf(i));
    }

    public PCMDrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23793h = null;
        this.i = null;
        this.m = new Random();
    }

    public PCMDrawingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23793h = null;
        this.i = null;
        this.m = new Random();
    }

    public void a(Bitmap bitmap, int i, int i2, int i3, int i4, float f2, float f3) {
        if (i3 == 0) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ALPHA_8);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, i2 - f2, i - f3), Matrix.ScaleToFit.CENTER);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(f2, f3);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(bitmap, matrix, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(bitmap, matrix2, paint);
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(i4, BlurMaskFilter.Blur.NORMAL);
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setMaskFilter(blurMaskFilter);
        paint.setFilterBitmap(true);
        Bitmap createBitmap2 = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        paint.reset();
        paint.setColor(this.f23791f);
        paint.setAntiAlias(true);
        canvas2.drawBitmap(bitmap, matrix, paint);
        createBitmap.recycle();
        this.i = createBitmap2;
    }

    private void a(Canvas canvas) {
        Path path;
        if (this.f23786a == null) {
            return;
        }
        int min = Math.min(canvas.getMaximumBitmapWidth(), 8192);
        Bitmap bitmap = this.f23793h;
        if (bitmap == null || bitmap.isRecycled() || this.f23793h.getWidth() > min) {
            Paint paint = new Paint();
            int min2 = Math.min(this.f23787b / 15, min);
            if (min2 > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(min2, 64, Bitmap.Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                paint.setAntiAlias(true);
                Path path2 = new Path();
                float f2 = 65;
                path2.moveTo(-50.0f, f2);
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                while (i < min2) {
                    Path path3 = path2;
                    int length = (int) ((i * r7.length) / min2);
                    if (this.f23786a.length <= 0) {
                        return;
                    }
                    if (length != i3) {
                        int i5 = 0;
                        for (int i6 = i3 + 1; i6 <= length; i6++) {
                            i5 += this.f23786a[length] & 255;
                        }
                        int max = i5 / Math.max(1, length - i3);
                        i3 = length;
                        i2 = max;
                    }
                    if (i2 != i4) {
                        path = path3;
                        path.lineTo(i, 64 - ((i2 * 64) / 255));
                        i4 = i2;
                    } else {
                        path = path3;
                    }
                    i += 3;
                    path2 = path;
                }
                Path path4 = path2;
                path4.lineTo(min2 - 1, 64 - ((i2 * 64) / 255));
                path4.lineTo(min2 + 50, f2);
                path4.close();
                canvas2.drawPath(path4, paint);
                this.f23793h = createBitmap;
                Bitmap bitmap2 = this.f23793h;
                a(bitmap2, bitmap2.getHeight(), this.f23793h.getWidth(), this.f23792g, 1, 0.0f, -1.5f);
            }
        }
    }
}
