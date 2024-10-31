package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* loaded from: classes2.dex */
public class OptionCroppingFragment extends Bg implements InterfaceC1866cf, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnDoubleTapListener {
    private float B;
    private float C;
    private float D;
    private float H;
    private float I;
    private boolean L;
    private boolean O;
    private ImageButton l;
    private ImageButton m;
    private ImageButton n;
    private View o;
    private int p;
    private int q;
    private float r;
    private Bitmap s;
    private Bitmap t;
    private Bitmap u;
    private Bitmap v;
    private Canvas w;
    private Canvas x;
    private Paint y = new Paint();
    private Path z = new Path();
    private RectF A = new RectF();
    private RectF E = new RectF();
    private Rect F = new Rect();
    private Rect G = new Rect();
    private boolean J = false;
    private EditMode K = null;
    private GestureDetector M = null;
    private ScaleGestureDetector N = null;
    private boolean P = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum EditMode {
        Start,
        End,
        Link
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        Rect rect = new Rect();
        sa().getStartPosition(rect);
        a(this.l, this.s, this.u, this.w, rect);
        if (!sa().isCropLink()) {
            sa().getEndPosition(rect);
        }
        a(this.m, this.t, this.v, this.x, rect);
    }

    private void Ba() {
        int i;
        int wa = wa();
        int va = va();
        int i2 = wa * 6;
        int i3 = va * 6;
        Rect rect = this.G;
        RectF rectF = this.E;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        int width = this.G.width();
        int height = this.G.height();
        if (width < 160) {
            height = (height * 160) / width;
            width = 160;
        }
        if (height < 90) {
            width = (width * 90) / height;
            height = 90;
        }
        if (width > i2) {
            i = (int) ((height * i2) / width);
        } else {
            i2 = width;
            i = height;
        }
        if (i > i3) {
            i2 = (int) ((i2 * i3) / i);
        } else {
            i3 = i;
        }
        int n = (EditorGlobal.n() * i3) / EditorGlobal.m();
        int m = (EditorGlobal.m() * i2) / EditorGlobal.n();
        int abs = Math.abs(n - i2);
        int abs2 = Math.abs(m - i3);
        if (abs > 2 && abs2 > 2) {
            if (abs < abs2) {
                i2 = n;
            } else {
                i3 = m;
            }
        }
        if (i2 != this.G.width()) {
            Rect rect2 = this.G;
            rect2.left = rect2.centerX() - (i2 / 2);
            Rect rect3 = this.G;
            rect3.right = rect3.left + i2;
        }
        if (i3 != this.G.height()) {
            Rect rect4 = this.G;
            rect4.top = rect4.centerY() - (i3 / 2);
            Rect rect5 = this.G;
            rect5.bottom = rect5.top + i3;
        }
        Rect rect6 = this.G;
        int i4 = rect6.left;
        if (i4 > wa) {
            rect6.offset(wa - i4, 0);
        }
        Rect rect7 = this.G;
        int i5 = rect7.right;
        if (i5 < 0) {
            rect7.offset(-i5, 0);
        }
        Rect rect8 = this.G;
        int i6 = rect8.top;
        if (i6 > va) {
            rect8.offset(0, va - i6);
        }
        Rect rect9 = this.G;
        int i7 = rect9.bottom;
        if (i7 < 0) {
            rect9.offset(0, -i7);
        }
        if (this.n.isSelected()) {
            sa().setStartPosition(this.G);
            sa().setEndPosition(this.G);
            sa().getStartPositionRaw(this.G);
        } else if (this.K == EditMode.Start) {
            sa().setStartPosition(this.G);
            sa().getStartPositionRaw(this.G);
        } else {
            sa().setEndPosition(this.G);
            sa().getEndPositionRaw(this.G);
        }
        NexEditor.c n2 = da().n();
        n2.a(NexEditor.FastPreviewOption.nofx, 1);
        n2.a(this.G);
        n2.execute();
        Aa();
    }

    private int va() {
        NexVideoClipItem sa = sa();
        int rotation = sa.getRotation();
        if (rotation != 90 && rotation != 270) {
            return sa.getHeight();
        }
        return sa.getWidth();
    }

    private int wa() {
        NexVideoClipItem sa = sa();
        int rotation = sa.getRotation();
        if (rotation != 90 && rotation != 270) {
            return sa.getWidth();
        }
        return sa.getHeight();
    }

    private void xa() {
        new AsyncTaskC2005sc(this).execute(sa());
    }

    private void ya() {
        new AsyncTaskC1988qc(this).execute(sa());
    }

    private void za() {
        if (this.J) {
            return;
        }
        this.J = true;
        sa().getStartPosition(this.F);
        if (this.K == EditMode.End) {
            sa().getEndPosition(this.F);
        }
        RectF rectF = this.E;
        Rect rect = this.F;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        if (Y() != null) {
            int v = da().v();
            int absStartTime = sa().getAbsStartTime() + sa().getFirstRepresentedTime();
            if (Math.abs(v - absStartTime) < Math.abs((sa().getRepresentedDuration() + absStartTime) - v)) {
                a(EditMode.Start);
            } else {
                a(EditMode.End);
            }
            if (sa().isCropLink()) {
                this.o.setVisibility(0);
                this.n.setSelected(true);
                sa().setCropLink(true);
                Aa();
            } else {
                this.o.setVisibility(8);
                this.n.setSelected(false);
                sa().setCropLink(false);
            }
            Aa();
            NexVideoClipItem sa = sa();
            if (!sa.isImage() && !sa.isPreset()) {
                if (sa.isVideo()) {
                    ya();
                    xa();
                }
            } else {
                sa().getStartThumbnail(this.q).onResultAvailable(new Ac(this));
                sa().getEndThumbnail(this.q).onResultAvailable(new Bc(this));
            }
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pedit_option_crop_fragment, viewGroup, false);
        a(inflate);
        n(R.string.opt_pan_and_zoom);
        f(true);
        this.p = getResources().getDimensionPixelSize(R.dimen.crop_thumb_width);
        this.q = getResources().getDimensionPixelSize(R.dimen.crop_thumb_height);
        this.r = getResources().getDimension(R.dimen.crop_thumb_corner);
        this.B = getResources().getDimension(R.dimen.crop_border_black);
        this.C = getResources().getDimension(R.dimen.crop_border_white);
        this.D = getResources().getDimension(R.dimen.crop_border_corner_radius);
        this.u = Bitmap.createBitmap(this.p, this.q, Bitmap.Config.ARGB_8888);
        this.w = new Canvas(this.u);
        this.v = Bitmap.createBitmap(this.p, this.q, Bitmap.Config.ARGB_8888);
        this.x = new Canvas(this.v);
        this.y.setAntiAlias(true);
        this.l = (ImageButton) inflate.findViewById(R.id.buttonStartCrop);
        this.m = (ImageButton) inflate.findViewById(R.id.buttonEndCrop);
        this.n = (ImageButton) inflate.findViewById(R.id.cropLinkButton);
        this.o = inflate.findViewById(R.id.cropLinkLine);
        this.l.setOnClickListener(new ViewOnClickListenerC2014tc(this));
        this.m.setOnClickListener(new ViewOnClickListenerC2046uc(this));
        this.n.setOnClickListener(new ViewOnClickListenerC2055vc(this));
        na();
        l(false);
        this.M = new GestureDetector(getActivity(), this);
        this.N = new ScaleGestureDetector(getActivity(), this);
        this.M.setOnDoubleTapListener(this);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.l = null;
        this.m = null;
        super.onDestroyView();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.J) {
            NexVideoClipItem sa = sa();
            this.O = !this.O;
            Rect rect = new Rect(0, 0, wa(), va());
            if (this.O) {
                a(rect, EditorGlobal.l());
            } else {
                b(rect, EditorGlobal.l());
            }
            if (this.n.isSelected()) {
                sa.setStartPosition(rect);
                sa.getStartPositionRaw(this.G);
                sa.setEndPosition(rect);
                sa.getEndPositionRaw(this.G);
            } else if (this.K == EditMode.Start) {
                sa.setStartPosition(rect);
                sa.getStartPositionRaw(this.G);
            } else {
                sa.setEndPosition(rect);
                sa.getEndPositionRaw(this.G);
            }
            NexEditor.c n = da().n();
            n.a(NexEditor.FastPreviewOption.nofx, 1);
            n.a(this.G);
            n.execute();
            Aa();
            this.L = true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float centerX = this.E.centerX();
        float centerY = this.E.centerY();
        float height = this.E.height() / R().intValue();
        float focusX = (scaleGestureDetector.getFocusX() - this.H) * height;
        float focusY = (scaleGestureDetector.getFocusY() - this.I) * height;
        float scaleFactor = 1.0f / scaleGestureDetector.getScaleFactor();
        if (this.J) {
            this.E.offset(-centerX, -centerY);
            RectF rectF = this.E;
            rectF.left *= scaleFactor;
            rectF.top *= scaleFactor;
            rectF.right *= scaleFactor;
            rectF.bottom *= scaleFactor;
            rectF.offset(centerX, centerY);
            this.E.offset(-focusX, -focusY);
            Ba();
        }
        this.H = scaleGestureDetector.getFocusX();
        this.I = scaleGestureDetector.getFocusY();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.H = scaleGestureDetector.getFocusX();
        this.I = scaleGestureDetector.getFocusY();
        za();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        za();
        float height = this.E.height() / R().intValue();
        this.E.offset(f2 * height, f3 * height);
        Ba();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (this.L) {
            G();
        }
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        l(true);
        n(false);
        super.onStop();
    }

    public NexVideoClipItem sa() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof NexVideoClipItem)) {
            return null;
        }
        return (NexVideoClipItem) Y;
    }

    private static void b(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        } else {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditMode editMode) {
        this.K = editMode;
        if (isAdded()) {
            if (this.n.isSelected()) {
                this.l.setActivated(true);
                this.m.setActivated(true);
            } else if (editMode == EditMode.Start) {
                this.l.setActivated(true);
                this.m.setActivated(false);
            } else {
                this.l.setActivated(false);
                this.m.setActivated(true);
            }
            if (editMode == EditMode.Start) {
                int absStartTime = sa().getAbsStartTime() + sa().getStartOverlap() + 1;
                n(true);
                b(true);
                VideoEditor da = da();
                this.P = true;
                da.a(absStartTime, true, sa().isVideo()).onComplete(new C2072xc(this, da)).onFailure(new C2064wc(this, da));
                return;
            }
            int absStartTime2 = ((sa().getAbsStartTime() + sa().getStartOverlap()) + sa().getRepresentedDuration()) - 1;
            n(true);
            c(true);
            VideoEditor da2 = da();
            this.P = true;
            da2.a(absStartTime2, true, sa().isVideo()).onComplete(new C2088zc(this, da2)).onFailure(new C2080yc(this, da2));
        }
    }

    private void a(ImageButton imageButton, Bitmap bitmap, Bitmap bitmap2, Canvas canvas, Rect rect) {
        if (imageButton == null || bitmap2 == null || canvas == null) {
            return;
        }
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
        this.z.rewind();
        Path path = this.z;
        RectF rectF = new RectF(0.0f, 0.0f, this.p, this.q);
        float f2 = this.r;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.z);
        float f3 = width / height > width2 / height2 ? width2 / width : height2 / height;
        RectF rectF2 = this.A;
        float f4 = width * f3;
        rectF2.left = (width2 / 2.0f) - (f4 / 2.0f);
        float f5 = height * f3;
        rectF2.top = (height2 / 2.0f) - (f5 / 2.0f);
        rectF2.right = rectF2.left + f4;
        rectF2.bottom = rectF2.top + f5;
        canvas.drawBitmap(bitmap, (Rect) null, rectF2, (Paint) null);
        float wa = f4 / wa();
        float f6 = (width2 - f4) / 2.0f;
        float f7 = (rect.left * wa) + f6;
        float f8 = (rect.right * wa) + f6;
        float f9 = (height2 - f5) / 2.0f;
        float f10 = (rect.bottom * wa) + f9;
        float f11 = (rect.top * wa) + f9;
        this.y.setStyle(Paint.Style.FILL);
        this.y.setARGB(125, 0, 0, 0);
        canvas.drawRect(0.0f, 0.0f, f8, f11, this.y);
        canvas.drawRect(0.0f, f11, f7, f10, this.y);
        canvas.drawRect(0.0f, f10, f8, canvas.getHeight(), this.y);
        canvas.drawRect(f8, 0.0f, canvas.getWidth(), canvas.getHeight(), this.y);
        this.y.setStyle(Paint.Style.STROKE);
        rectF2.set(f7, f11, f8, f10);
        this.y.setStrokeWidth(this.B);
        this.y.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f12 = this.D;
        canvas.drawRoundRect(rectF2, f12, f12, this.y);
        this.y.setStrokeWidth(this.C);
        this.y.setColor(-1);
        float f13 = this.D;
        canvas.drawRoundRect(rectF2, f13, f13, this.y);
        canvas.restore();
        imageButton.setImageBitmap(bitmap2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded()) {
            return false;
        }
        this.N.onTouchEvent(motionEvent);
        if (!this.N.isInProgress()) {
            this.M.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 1 && this.J) {
            this.J = false;
            this.L = true;
        }
        return true;
    }

    private static void a(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        } else {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        }
    }
}
