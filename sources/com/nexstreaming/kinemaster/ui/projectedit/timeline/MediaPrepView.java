package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* loaded from: classes2.dex */
public class MediaPrepView extends View implements MediaPrepManager.a {

    /* renamed from: a, reason: collision with root package name */
    private MediaPrepManager f22601a;

    /* renamed from: b, reason: collision with root package name */
    private NexTimelineItem f22602b;

    /* renamed from: c, reason: collision with root package name */
    private int f22603c;

    /* renamed from: d, reason: collision with root package name */
    private int f22604d;

    /* renamed from: e, reason: collision with root package name */
    private int f22605e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f22606f;

    /* renamed from: g, reason: collision with root package name */
    private int f22607g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f22608h;
    private Path i;
    private a j;
    private int k;
    private int l;
    private int m;
    private final C1803a n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Scroller f22609a;

        /* renamed from: b, reason: collision with root package name */
        int f22610b;

        /* renamed from: c, reason: collision with root package name */
        int f22611c;

        /* renamed from: d, reason: collision with root package name */
        boolean f22612d;

        a() {
            this.f22609a = new Scroller(MediaPrepView.this.getContext(), new LinearInterpolator());
        }

        void a(int i, int i2) {
            if (!this.f22609a.isFinished()) {
                this.f22609a.abortAnimation();
            }
            this.f22612d = false;
            this.f22610b = MediaPrepView.this.l;
            this.f22611c = (int) ((i / i2) * MediaPrepView.this.m);
            int i3 = this.f22610b;
            int i4 = this.f22611c;
            if (i3 < i4) {
                this.f22609a.startScroll(0, 0, i4 - i3, 0, Math.max(3000 - ((i - MediaPrepView.this.k) * 10), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                MediaPrepView.this.postOnAnimation(this);
            }
        }

        void b() {
            if (this.f22612d) {
                return;
            }
            this.f22609a.abortAnimation();
            this.f22612d = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22612d) {
                return;
            }
            if (this.f22609a.computeScrollOffset()) {
                MediaPrepView.this.l = this.f22610b + this.f22609a.getCurrX();
                MediaPrepView.this.postOnAnimation(this);
            } else {
                MediaPrepView.this.l = this.f22611c;
            }
            MediaPrepView.this.postInvalidate();
        }
    }

    public MediaPrepView(Context context) {
        this(context, null, 0);
    }

    private void d(Canvas canvas) {
        if (this.f22606f != null) {
            int max = Math.max((getHeight() * 2) / 3, this.f22607g);
            int i = max / 2;
            int width = (getWidth() / 2) - i;
            int height = (getHeight() / 2) - i;
            this.f22606f.setBounds(width, height, width + max, max + height);
            this.f22606f.draw(canvas);
        }
    }

    private Paint getPaint() {
        if (this.f22608h == null) {
            this.f22608h = new Paint();
            this.f22608h.setAntiAlias(true);
            this.f22608h.setDither(true);
        }
        return this.f22608h;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        com.nexstreaming.kinemaster.usage.analytics.b.a(MediaPrepView.class.getName());
        super.onAttachedToWindow();
        UniformTimelineView g2 = UniformTimelineView.g((View) getParent());
        if (g2 != null) {
            this.f22601a = g2.getMediaPrepManager();
            this.f22601a.a(this);
            NexTimelineItem nexTimelineItem = this.f22602b;
            if (nexTimelineItem == null || nexTimelineItem.getMediaMSID() == null) {
                return;
            }
            this.f22601a.a(this.f22602b.getMediaMSID(), this.n);
            MediaPrepState mediaPrepState = this.n.f20781a;
            if (mediaPrepState != MediaPrepState.None) {
                a(mediaPrepState);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        MediaPrepManager mediaPrepManager = this.f22601a;
        if (mediaPrepManager != null) {
            mediaPrepManager.b(this);
            this.f22601a = null;
        }
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.n.f20781a == MediaPrepState.None) {
            return;
        }
        c(canvas);
        a(canvas);
        d(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        if (size != this.m) {
            a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            this.l = (int) (this.l * (size / this.m));
            this.m = size;
        }
        Path path = this.i;
        if (path != null) {
            path.reset();
        }
    }

    public void setTimelineItem(NexTimelineItem nexTimelineItem) {
        this.f22602b = nexTimelineItem;
        postInvalidate();
    }

    public MediaPrepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Canvas canvas) {
        Paint paint = getPaint();
        if (this.i == null) {
            this.i = new Path();
        }
        if (this.i.isEmpty()) {
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.i.addRect(rectF, Path.Direction.CW);
            Path path = this.i;
            int i = this.f22603c;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
            this.i.setFillType(Path.FillType.EVEN_ODD);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.i, paint);
        paint.setXfermode(null);
    }

    private void c(Canvas canvas) {
        if (this.f22604d != 0) {
            Paint paint = getPaint();
            paint.setColor(this.f22604d);
            canvas.drawPaint(paint);
        }
    }

    public MediaPrepView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new C1803a();
        this.f22603c = getResources().getDimensionPixelSize(R.dimen.timeline3_itemCornerRadius);
        this.f22607g = getResources().getDimensionPixelSize(R.dimen.timeline3_min_status_icon_size);
    }

    private void a() {
        a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        this.l = 0;
        this.n.a();
    }

    private void a(Canvas canvas) {
        if (this.f22605e != 0) {
            Paint paint = getPaint();
            paint.setColor(this.f22605e);
            canvas.drawRect(0.0f, 0.0f, this.l, getHeight(), paint);
        }
    }

    private void a(MediaPrepState mediaPrepState) {
        this.f22604d = 0;
        this.f22605e = 0;
        this.f22606f = null;
        switch (C2030k.f22682a[mediaPrepState.ordinal()]) {
            case 1:
                this.f22604d = getResources().getColor(R.color.timeline_progress_download_bg);
                this.f22605e = getResources().getColor(R.color.timeline_progress_download_fg);
                this.f22606f = getResources().getDrawable(R.drawable.clip_status_downloading);
                return;
            case 2:
                this.f22604d = getResources().getColor(R.color.timeline_progress_transcode_bg);
                this.f22605e = getResources().getColor(R.color.timeline_progress_transcode_fg);
                this.f22606f = getResources().getDrawable(R.drawable.clip_status_transcoding);
                return;
            case 3:
                this.f22604d = getResources().getColor(R.color.timeline_progress_download_bg);
                this.f22606f = getResources().getDrawable(R.drawable.clip_status_busy);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                this.f22604d = getResources().getColor(R.color.timeline_progress_download_bg);
                this.f22606f = getResources().getDrawable(R.drawable.clip_status_notsupport);
                return;
            case 9:
            case 10:
            case 11:
                this.f22604d = getResources().getColor(R.color.timeline_progress_download_bg);
                return;
            default:
                return;
        }
    }

    @Override // com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a
    public void a(MediaStoreItemId mediaStoreItemId, C1803a c1803a) {
        NexTimelineItem nexTimelineItem = this.f22602b;
        if (nexTimelineItem == null || !mediaStoreItemId.equals(nexTimelineItem.getMediaMSID())) {
            return;
        }
        boolean z = this.n.f20781a != c1803a.f20781a;
        this.n.a(c1803a);
        if (z) {
            a(c1803a.f20781a);
        }
        if (this.k != c1803a.f20782b) {
            if (this.j == null) {
                this.j = new a();
            }
            this.j.a(c1803a.f20782b, c1803a.f20783c);
            this.k = c1803a.f20782b;
        }
        postInvalidate();
    }
}
