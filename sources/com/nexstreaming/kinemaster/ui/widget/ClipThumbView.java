package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.T;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* loaded from: classes2.dex */
public class ClipThumbView extends AppCompatImageView implements InterfaceC2026g {

    /* renamed from: c, reason: collision with root package name */
    private static RectF f23736c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private Context f23737d;

    /* renamed from: e, reason: collision with root package name */
    private int f23738e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f23739f;

    /* renamed from: g, reason: collision with root package name */
    private T f23740g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f23741h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private String q;
    private boolean r;
    private boolean s;
    private NexTimelineItem t;

    public ClipThumbView(Context context) {
        super(context);
        this.f23738e = 0;
        this.i = false;
        this.s = false;
        this.f23737d = context;
    }

    private void c() {
        NexTimelineItem nexTimelineItem = this.t;
        if (nexTimelineItem == null) {
            return;
        }
        if (nexTimelineItem instanceof NexVideoClipItem) {
            NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
            if (nexVideoClipItem.isVideo()) {
                this.j = nexVideoClipItem.getFirstRepresentedTime();
                this.k = nexVideoClipItem.getRepresentedDuration();
                this.l = nexVideoClipItem.getTrimTimeStart();
                this.p = nexVideoClipItem.getRepresentedDurationWithoutSpeedControl();
            }
            this.m = nexVideoClipItem.getRotation();
            this.n = nexVideoClipItem.getFlipH();
            this.o = nexVideoClipItem.getFlipV();
            return;
        }
        if (nexTimelineItem instanceof VideoLayer) {
            VideoLayer videoLayer = (VideoLayer) nexTimelineItem;
            this.j = videoLayer.getStartTime();
            this.k = videoLayer.getRepresentedDuration();
            this.l = videoLayer.getStartTrim();
            this.m = videoLayer.getRotation();
            this.n = videoLayer.getFlipH();
            this.o = videoLayer.getFlipV();
            this.p = 0;
            return;
        }
        if (nexTimelineItem instanceof ImageLayer) {
            ImageLayer imageLayer = (ImageLayer) nexTimelineItem;
            this.j = imageLayer.getStartTime();
            this.k = imageLayer.getRepresentedDuration();
            this.l = imageLayer.getStartTrim();
            this.m = imageLayer.getRotation();
            this.n = imageLayer.getFlipH();
            this.o = imageLayer.getFlipV();
            this.p = 0;
        }
    }

    public void a(boolean z) {
        this.f23738e = 0;
        this.i = false;
        this.q = null;
        this.r = z;
        this.f23739f = null;
        this.f23740g = null;
        this.f23741h = null;
        invalidate();
    }

    public boolean b() {
        return this.f23740g != null;
    }

    public String getPath() {
        return this.q;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public int getSerialNumber() {
        return Integer.valueOf(getTag().toString()).intValue();
    }

    public int getStartTime() {
        return this.j;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap b2;
        super.onDraw(canvas);
        Log.d("ClipThumbView", "[onDraw] +");
        if (this.s) {
            setBackgroundColor(this.f23738e);
            return;
        }
        Rect rect = new Rect();
        getDrawingRect(rect);
        Paint paint = new Paint();
        Log.d("ClipThumbView", "[onDraw] drawingRect: " + rect + ", startTime: " + this.j + ", duration: " + this.k + ", isLayer: " + this.i);
        if (!this.r) {
            canvas.drawColor(1426063360);
        }
        rect.height();
        c();
        T t = this.f23740g;
        if (t != null) {
            if (!this.i) {
                RectF rectF = f23736c;
                float a2 = this.f23740g.a(this.m, rect.height());
                int i = this.j;
                int i2 = this.k;
                if (((int) a2) > 5) {
                    rectF.top = rect.top;
                    rectF.bottom = rect.bottom;
                    if (i2 >= 1) {
                        int width = (rect.width() * i) / i2;
                        if (width < 0) {
                            width = 0;
                        }
                        float f2 = rect.left - width;
                        Drawable drawable = null;
                        while (f2 < rect.right) {
                            rectF.left = f2;
                            float f3 = f2 + a2;
                            rectF.right = f3;
                            if (!canvas.quickReject(rectF, Canvas.EdgeType.AA)) {
                                Bitmap b3 = this.f23740g.b(this.m, ((int) (((f2 - rect.left) / (rect.right - r12)) * this.p)) + i, this.n, this.o);
                                if (b3 != null) {
                                    canvas.drawBitmap(b3, (Rect) null, rectF, paint);
                                } else {
                                    if (drawable == null) {
                                        drawable = this.f23737d.getResources().getDrawable(R.drawable.n2_loading_image_1_img);
                                    }
                                    drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                    drawable.draw(canvas);
                                }
                            }
                            f2 = f3;
                        }
                    }
                }
            } else {
                RectF rectF2 = f23736c;
                float b4 = t.b(0);
                float a3 = this.f23740g.a(this.m, b4);
                float height = rect.height() / 2.0f;
                rect.top = (int) (rect.top - height);
                rect.bottom = (int) (rect.bottom + height);
                float height2 = (int) (((a3 * rect.height()) / b4) + 0.5f);
                int i3 = rect.left;
                int i4 = (int) (rect.right + height2 + 1.0f);
                canvas.save();
                canvas.clipRect(rect);
                rectF2.top = rect.top;
                rectF2.bottom = rect.bottom;
                int i5 = i3;
                while (i5 < i4) {
                    int i6 = (((i5 - i3) * this.k) / (i4 - i3)) + this.l;
                    float f4 = i5;
                    rectF2.left = f4;
                    float f5 = f4 + height2;
                    rectF2.right = f5;
                    if (!canvas.quickReject(rectF2, Canvas.EdgeType.AA) && (b2 = this.f23740g.b(this.m, i6, this.n, this.o)) != null) {
                        canvas.drawBitmap(b2, (Rect) null, rectF2, (Paint) null);
                    }
                    i5 = (int) f5;
                }
                canvas.restore();
            }
        } else {
            Bitmap bitmap = this.f23739f;
            if (bitmap != null) {
                Bitmap a4 = a(bitmap);
                if (!this.i) {
                    RectF rectF3 = f23736c;
                    float width2 = a4.getWidth();
                    rectF3.top = rect.top;
                    rectF3.bottom = rect.bottom;
                    float f6 = rect.left;
                    while (f6 < rect.right) {
                        rectF3.left = f6;
                        f6 += width2;
                        rectF3.right = f6;
                        if (!canvas.quickReject(rectF3, Canvas.EdgeType.AA)) {
                            canvas.drawBitmap(a4, (Rect) null, rectF3, paint);
                        }
                    }
                } else {
                    int width3 = a4.getWidth();
                    int height3 = a4.getHeight();
                    float height4 = rect.height() / 2.0f;
                    rect.top = (int) (rect.top - height4);
                    rect.bottom = (int) (rect.bottom + height4);
                    int max = (int) Math.max(1.0f, ((width3 * rect.height()) / height3) + 0.5f);
                    int i7 = rect.left;
                    int i8 = rect.right + max + 1;
                    canvas.save();
                    canvas.clipRect(rect);
                    while (i7 < i8) {
                        rect.left = i7;
                        i7 += max;
                        rect.right = i7;
                        canvas.drawBitmap(a4, (Rect) null, rect, (Paint) null);
                    }
                    canvas.restore();
                }
            } else if (bitmap == null && this.f23741h != null) {
                RectF rectF4 = f23736c;
                float height5 = rect.height();
                this.f23741h.getIntrinsicHeight();
                rectF4.top = rect.top;
                rectF4.bottom = rect.bottom;
                float intrinsicHeight = (int) ((height5 / this.f23741h.getIntrinsicHeight()) * this.f23741h.getIntrinsicWidth());
                rectF4.top = rect.top;
                rectF4.bottom = rect.bottom;
                float f7 = rect.left;
                while (f7 < rect.right) {
                    rectF4.left = f7;
                    f7 += intrinsicHeight;
                    rectF4.right = f7;
                    if (!canvas.quickReject(rectF4, Canvas.EdgeType.AA)) {
                        this.f23741h.setBounds((int) rectF4.left, (int) rectF4.top, (int) rectF4.right, (int) rectF4.bottom);
                        this.f23741h.draw(canvas);
                    }
                }
            }
        }
        Log.d("ClipThumbView", "[onDraw] -");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public void setDecoData(Object obj) {
        if (obj instanceof T) {
            setImageBitmaps((T) obj);
        }
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f23739f = bitmap;
        this.f23741h = null;
        invalidate();
    }

    public void setImageBitmaps(T t) {
        if (this.f23740g != null) {
            this.f23740g = null;
        }
        this.f23740g = t;
        this.f23739f = null;
        this.f23741h = null;
        invalidate();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f23737d != null) {
            this.f23739f = BitmapFactory.decodeResource(getResources(), i);
        }
        super.setImageResource(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2026g
    public void setSerialNumber(int i) {
        setTag(Integer.valueOf(i));
    }

    public void setStartTime(int i) {
        this.j = i;
    }

    public ClipThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23738e = 0;
        this.i = false;
        this.s = false;
        this.f23737d = context;
    }

    public void a(String str) {
        this.f23738e = this.f23738e;
        boolean z = false;
        this.i = false;
        this.q = str;
        if (str != null && str.startsWith("@solid")) {
            z = true;
        }
        this.s = z;
        this.r = true;
        this.f23739f = null;
        this.f23740g = null;
        this.f23741h = null;
        invalidate();
    }

    public ClipThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23738e = 0;
        this.i = false;
        this.s = false;
        this.f23737d = context;
    }

    public void a(String str, NexTimelineItem nexTimelineItem) {
        boolean z = false;
        this.f23738e = 0;
        this.i = nexTimelineItem instanceof NexLayerItem;
        this.q = str;
        this.r = nexTimelineItem.checkResourceState(this.f23737d);
        if (str != null && str.startsWith("@solid")) {
            z = true;
        }
        this.s = z;
        this.t = nexTimelineItem;
        this.f23739f = null;
        this.f23740g = null;
        this.f23741h = null;
        invalidate();
    }

    public void a(int i, String str, NexTimelineItem nexTimelineItem) {
        this.f23738e = i;
        this.i = nexTimelineItem instanceof NexLayerItem;
        this.q = str;
        this.r = nexTimelineItem.checkResourceState(this.f23737d);
        this.s = str != null && str.startsWith("@solid");
        this.t = nexTimelineItem;
        this.f23739f = null;
        this.f23740g = null;
        this.f23741h = null;
        invalidate();
    }

    private Bitmap a(Bitmap bitmap) {
        int i = this.m;
        if (i == 180) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            if (this.n && this.o) {
                canvas.scale(-1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (this.n) {
                canvas.scale(-1.0f, 1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (this.o) {
                canvas.scale(1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            }
            canvas.rotate(180.0f, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
            return createBitmap;
        }
        if (i == 0) {
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap2);
            if (this.n && this.o) {
                canvas2.scale(-1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (this.n) {
                canvas2.scale(-1.0f, 1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (this.o) {
                canvas2.scale(1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            }
            canvas2.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
            return createBitmap2;
        }
        if (i == 90) {
            Bitmap createBitmap3 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
            Canvas canvas3 = new Canvas(createBitmap3);
            if (this.n && this.o) {
                canvas3.scale(-1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (this.n) {
                canvas3.scale(1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (this.o) {
                canvas3.scale(-1.0f, 1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            }
            canvas3.rotate(270.0f, 0.0f, 0.0f);
            canvas3.drawBitmap(bitmap, (Rect) null, new Rect(-bitmap.getWidth(), 0, 0, bitmap.getHeight()), (Paint) null);
            return createBitmap3;
        }
        if (i != 270) {
            return bitmap;
        }
        Bitmap createBitmap4 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        Canvas canvas4 = new Canvas(createBitmap4);
        if (this.n && this.o) {
            canvas4.scale(-1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (this.n) {
            canvas4.scale(1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (this.o) {
            canvas4.scale(-1.0f, 1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        }
        canvas4.rotate(90.0f, 0.0f, 0.0f);
        canvas4.drawBitmap(bitmap, (Rect) null, new Rect(0, -bitmap.getHeight(), bitmap.getWidth(), 0), (Paint) null);
        return createBitmap4;
    }

    public boolean a() {
        return this.f23739f != null;
    }

    public void a(NexTimelineItem nexTimelineItem) {
        this.t = nexTimelineItem;
        invalidate();
    }
}
