package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* loaded from: classes.dex */
public class OptionCroppingFragment extends kp implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, ht {
    private boolean A;
    private boolean D;

    /* renamed from: a, reason: collision with root package name */
    private ImageButton f3738a;
    private ImageButton b;
    private ImageButton c;
    private View d;
    private int e;
    private int f;
    private float g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Canvas l;
    private Canvas m;
    private float q;
    private float r;
    private float s;
    private float w;
    private float x;
    private Paint n = new Paint();
    private Path o = new Path();
    private RectF p = new RectF();
    private RectF t = new RectF();
    private Rect u = new Rect();
    private Rect v = new Rect();
    private boolean y = false;
    private EditMode z = null;
    private GestureDetector B = null;
    private ScaleGestureDetector C = null;
    private boolean E = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum EditMode {
        Start,
        End,
        Link
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pedit_option_crop_fragment, viewGroup, false);
        b(inflate);
        f(R.string.opt_crop);
        d(true);
        this.e = getResources().getDimensionPixelSize(R.dimen.crop_thumb_width);
        this.f = getResources().getDimensionPixelSize(R.dimen.crop_thumb_height);
        this.g = getResources().getDimension(R.dimen.crop_thumb_corner);
        this.q = getResources().getDimension(R.dimen.crop_border_black);
        this.r = getResources().getDimension(R.dimen.crop_border_white);
        this.s = getResources().getDimension(R.dimen.crop_border_corner_radius);
        this.j = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
        this.l = new Canvas(this.j);
        this.k = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
        this.m = new Canvas(this.k);
        this.n.setAntiAlias(true);
        this.f3738a = (ImageButton) inflate.findViewById(R.id.buttonStartCrop);
        this.b = (ImageButton) inflate.findViewById(R.id.buttonEndCrop);
        this.c = (ImageButton) inflate.findViewById(R.id.cropLinkButton);
        this.d = inflate.findViewById(R.id.cropLinkLine);
        this.f3738a.setOnClickListener(new dg(this));
        this.b.setOnClickListener(new dl(this));
        this.c.setOnClickListener(new dm(this));
        f();
        i(false);
        this.B = new GestureDetector(getActivity(), this);
        this.C = new ScaleGestureDetector(getActivity(), this);
        this.B.setOnDoubleTapListener(this);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditMode editMode) {
        if (this.z != editMode) {
            this.z = editMode;
            if (isAdded()) {
                if (editMode == EditMode.Start || editMode == EditMode.Link) {
                    this.f3738a.setActivated(true);
                    if (editMode == EditMode.Link) {
                        this.b.setActivated(true);
                    } else {
                        this.b.setActivated(false);
                    }
                    int absStartTime = a().getAbsStartTime() + a().getStartOverlap() + 1;
                    h(true);
                    f(true);
                    VideoEditor o = o();
                    this.E = true;
                    o.a(absStartTime, true, a().isVideo()).onComplete(new Cdo(this, o)).onFailure(new dn(this, o));
                    return;
                }
                if (editMode == EditMode.End) {
                    this.f3738a.setActivated(false);
                    this.b.setActivated(true);
                    int absStartTime2 = ((a().getAbsStartTime() + a().getStartOverlap()) + a().getRepresentedDuration()) - 1;
                    h(true);
                    g(true);
                    VideoEditor o2 = o();
                    this.E = true;
                    o2.a(absStartTime2, true, a().isVideo()).onComplete(new dq(this, o2)).onFailure(new dp(this, o2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Rect rect = new Rect();
        a().getStartPosition(rect);
        a(this.f3738a, this.h, this.j, this.l, rect);
        if (!a().isCropLink()) {
            a().getEndPosition(rect);
        }
        a(this.b, this.i, this.k, this.m, rect);
    }

    private void a(ImageButton imageButton, Bitmap bitmap, Bitmap bitmap2, Canvas canvas, Rect rect) {
        if (imageButton != null && bitmap2 != null && canvas != null) {
            if (bitmap == null) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                imageButton.setImageBitmap(bitmap2);
                return;
            }
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float width2 = bitmap2.getWidth();
            float height2 = bitmap2.getHeight();
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.o.rewind();
            this.o.addRoundRect(new RectF(0.0f, 0.0f, this.e, this.f), this.g, this.g, Path.Direction.CCW);
            canvas.save();
            canvas.clipPath(this.o);
            float f = width / height > width2 / height2 ? width2 / width : height2 / height;
            RectF rectF = this.p;
            rectF.left = (width2 / 2.0f) - ((width * f) / 2.0f);
            rectF.top = (height2 / 2.0f) - ((height * f) / 2.0f);
            rectF.right = rectF.left + (width * f);
            rectF.bottom = rectF.top + (height * f);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            float j = (f * width) / j();
            float f2 = (rect.left * j) + ((width2 - (width * f)) / 2.0f);
            float f3 = (rect.right * j) + ((width2 - (width * f)) / 2.0f);
            float f4 = (rect.bottom * j) + ((height2 - (height * f)) / 2.0f);
            float f5 = (rect.top * j) + ((height2 - (f * height)) / 2.0f);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setARGB(125, 0, 0, 0);
            canvas.drawRect(0.0f, 0.0f, f3, f5, this.n);
            canvas.drawRect(0.0f, f5, f2, f4, this.n);
            canvas.drawRect(0.0f, f4, f3, canvas.getHeight(), this.n);
            canvas.drawRect(f3, 0.0f, canvas.getWidth(), canvas.getHeight(), this.n);
            this.n.setStyle(Paint.Style.STROKE);
            rectF.set(f2, f5, f3, f4);
            this.n.setStrokeWidth(this.q);
            this.n.setColor(-16777216);
            canvas.drawRoundRect(rectF, this.s, this.s, this.n);
            this.n.setStrokeWidth(this.r);
            this.n.setColor(-1);
            canvas.drawRoundRect(rectF, this.s, this.s, this.n);
            canvas.restore();
            imageButton.setImageBitmap(bitmap2);
        }
    }

    public NexVideoClipItem a() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof NexVideoClipItem)) {
            return null;
        }
        return (NexVideoClipItem) m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        if (m() != null) {
            int u = o().u();
            int absStartTime = a().getAbsStartTime() + a().getFirstRepresentedTime();
            int representedDuration = a().getRepresentedDuration() + absStartTime;
            if (a().isCropLink()) {
                this.d.setVisibility(0);
                this.c.setSelected(true);
                a().setCropLink(true);
                a(EditMode.Link);
                c();
            } else if (Math.abs(u - absStartTime) < Math.abs(representedDuration - u)) {
                this.d.setVisibility(8);
                this.c.setSelected(false);
                a().setCropLink(false);
                a(EditMode.Start);
            } else {
                this.d.setVisibility(8);
                this.c.setSelected(false);
                a().setCropLink(false);
                a(EditMode.End);
            }
            c();
            NexVideoClipItem a2 = a();
            if (a2.isImage() || a2.isPreset()) {
                a().getStartThumbnail(this.f).onResultAvailable(new dr(this));
                a().getEndThumbnail(this.f).onResultAvailable(new ds(this));
            } else if (a2.isVideo()) {
                e();
                h();
            }
        }
        super.f();
    }

    private void e() {
        new dh(this).execute(a());
    }

    private void h() {
        new dj(this).execute(a());
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3738a = null;
        this.b = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded()) {
            return false;
        }
        this.C.onTouchEvent(motionEvent);
        if (!this.C.isInProgress()) {
            this.B.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 1:
                if (this.y) {
                    this.y = false;
                    this.A = true;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // android.app.Fragment
    public void onStop() {
        if (this.A) {
            d();
        }
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        i(true);
        h(false);
        super.onStop();
    }

    private void i() {
        if (!this.y) {
            this.y = true;
            if (this.z == EditMode.Link || this.z == EditMode.Start) {
                a().getStartPosition(this.u);
            } else {
                a().getEndPosition(this.u);
            }
            this.t.set(this.u.left, this.u.top, this.u.right, this.u.bottom);
        }
    }

    private int j() {
        NexVideoClipItem a2 = a();
        int rotation = a2.getRotation();
        return (rotation == 90 || rotation == 270) ? a2.getHeight() : a2.getWidth();
    }

    private int H() {
        NexVideoClipItem a2 = a();
        int rotation = a2.getRotation();
        return (rotation == 90 || rotation == 270) ? a2.getWidth() : a2.getHeight();
    }

    private void I() {
        int i;
        int i2;
        int i3 = 160;
        int i4 = 90;
        int j = j();
        int H = H();
        int i5 = j * 6;
        int i6 = H * 6;
        this.v.set((int) this.t.left, (int) this.t.top, (int) this.t.right, (int) this.t.bottom);
        int width = this.v.width();
        int height = this.v.height();
        if (width < 160) {
            height = (height * 160) / width;
        } else {
            i3 = width;
        }
        if (height < 90) {
            i = (i3 * 90) / height;
        } else {
            i4 = height;
            i = i3;
        }
        if (i > i5) {
            i4 = (int) ((i4 * i5) / i);
        } else {
            i5 = i;
        }
        if (i4 > i6) {
            i2 = (int) ((i5 * i6) / i4);
        } else {
            i6 = i4;
            i2 = i5;
        }
        int i7 = (i6 * 16) / 9;
        int i8 = (i2 * 9) / 16;
        int abs = Math.abs(i7 - i2);
        int abs2 = Math.abs(i8 - i6);
        if (abs > 2 && abs2 > 2) {
            if (abs < abs2) {
                i2 = i7;
            } else {
                i6 = i8;
            }
        }
        if (i2 != this.v.width()) {
            this.v.left = this.v.centerX() - (i2 / 2);
            this.v.right = i2 + this.v.left;
        }
        if (i6 != this.v.height()) {
            this.v.top = this.v.centerY() - (i6 / 2);
            this.v.bottom = i6 + this.v.top;
        }
        if (this.v.left > j) {
            this.v.offset(j - this.v.left, 0);
        }
        if (this.v.right < 0) {
            this.v.offset(-this.v.right, 0);
        }
        if (this.v.top > H) {
            this.v.offset(0, H - this.v.top);
        }
        if (this.v.bottom < 0) {
            this.v.offset(0, -this.v.bottom);
        }
        if (this.z == EditMode.Link || this.z == EditMode.Start) {
            a().setStartPosition(this.v);
            a().getStartPositionRaw(this.v);
        } else {
            a().setEndPosition(this.v);
            a().getEndPositionRaw(this.v);
        }
        o().z().a(NexEditor.FastPreviewOption.nofx, 1).a(this.v).a();
        c();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float centerX = this.t.centerX();
        float centerY = this.t.centerY();
        float height = this.t.height() / y();
        float focusX = (scaleGestureDetector.getFocusX() - this.w) * height;
        float focusY = height * (scaleGestureDetector.getFocusY() - this.x);
        float scaleFactor = 1.0f / scaleGestureDetector.getScaleFactor();
        if (this.y) {
            this.t.offset(-centerX, -centerY);
            this.t.left *= scaleFactor;
            this.t.top *= scaleFactor;
            this.t.right *= scaleFactor;
            RectF rectF = this.t;
            rectF.bottom = scaleFactor * rectF.bottom;
            this.t.offset(centerX, centerY);
            this.t.offset(-focusX, -focusY);
            I();
        }
        this.w = scaleGestureDetector.getFocusX();
        this.x = scaleGestureDetector.getFocusY();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.w = scaleGestureDetector.getFocusX();
        this.x = scaleGestureDetector.getFocusY();
        i();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        i();
        float height = this.t.height() / y();
        this.t.offset(f * height, height * f2);
        I();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.y) {
            NexVideoClipItem a2 = a();
            this.D = !this.D;
            Rect rect = new Rect(0, 0, j(), H());
            if (this.D) {
                b(rect, 1.7777778f);
            } else {
                a(rect, 1.7777778f);
            }
            if (this.z == EditMode.Link || this.z == EditMode.Start) {
                a2.setStartPosition(rect);
                a2.getStartPositionRaw(this.v);
            } else {
                a2.setEndPosition(rect);
                a2.getEndPositionRaw(this.v);
            }
            o().z().a(NexEditor.FastPreviewOption.nofx, 1).a(this.v).a();
            c();
            this.A = true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    private static void a(Rect rect, float f) {
        if (rect.width() / rect.height() < f) {
            int width = (int) (rect.width() / f);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = width + rect.top;
        } else {
            int height = (int) (rect.height() * f);
            rect.left = rect.centerX() - (height / 2);
            rect.right = height + rect.left;
        }
    }

    private static void b(Rect rect, float f) {
        if (rect.width() / rect.height() < f) {
            int height = (int) (rect.height() * f);
            rect.left = rect.centerX() - (height / 2);
            rect.right = height + rect.left;
        } else {
            int width = (int) (rect.width() / f);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = width + rect.top;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public boolean b() {
        return true;
    }
}
