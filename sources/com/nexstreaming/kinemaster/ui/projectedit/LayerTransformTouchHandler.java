package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexvideoeditor.NexEditor;

/* loaded from: classes.dex */
public class LayerTransformTouchHandler implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    private NexLayerItem f3736a;
    private VideoEditor b;
    private NexLayerItem.b d;
    private ScaleGestureDetector f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private DragMode l;
    private int m;
    private int n;
    private boolean r;
    private long s;
    private float t;
    private float u;
    private float v;
    private float w;
    private NexLayerItem.b c = new NexLayerItem.b();
    private NexLayerItem.b e = new NexLayerItem.b();
    private float[] o = {0.0f, 0.0f};
    private Matrix p = new Matrix();
    private Rect q = new Rect();

    /* loaded from: classes.dex */
    public enum DragMode {
        Scale,
        Rotate,
        Move,
        PinchGesture,
        Split
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.l == DragMode.PinchGesture) {
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float f = focusX - this.t;
            float f2 = focusY - this.u;
            this.c.b *= scaleGestureDetector.getScaleFactor();
            NexLayerItem.b bVar = this.c;
            bVar.c = f + bVar.c;
            NexLayerItem.b bVar2 = this.c;
            bVar2.d = f2 + bVar2.d;
            if (this.c.b < 0.01f) {
                this.c.b = 0.01f;
            }
            this.d.a(this.c);
            this.f3736a.fitKeyframeToSplitscreenRect(this.d);
            this.t = focusX;
            this.u = focusY;
            return true;
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        if (this.l != DragMode.PinchGesture) {
            if (this.l != null) {
                this.d.a(this.e);
                this.l = null;
            }
            if (this.d != null) {
                this.c.a(this.d);
                this.l = DragMode.PinchGesture;
                this.t = scaleGestureDetector.getFocusX();
                this.u = scaleGestureDetector.getFocusY();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public LayerTransformTouchHandler(Context context, NexLayerItem nexLayerItem, VideoEditor videoEditor) {
        this.m = context.getResources().getDimensionPixelOffset(R.dimen.layer_anim_thumb_width);
        this.n = context.getResources().getDimensionPixelSize(R.dimen.marchingAnts_handle_touch_zone_size);
        this.f = new ScaleGestureDetector(context, this);
        this.f3736a = nexLayerItem;
        this.b = videoEditor;
    }

    public void a(NexLayerItem nexLayerItem) {
        this.f3736a = nexLayerItem;
    }

    public NexLayerItem a() {
        return this.f3736a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean a(View view, MotionEvent motionEvent) {
        float f;
        if (this.f3736a == null || this.b == null) {
            return false;
        }
        float scaledTime = this.f3736a.getScaledTime(this.b.u());
        if (motionEvent.getActionMasked() == 0) {
            if (this.f3736a == null || this.f3736a.getKeyFrames() == null || this.f3736a.getKeyFrames().size() <= 1) {
                f = scaledTime;
            } else {
                float clipWidth = this.m / this.f3736a.getClipWidth();
                f = this.f3736a.getClosestKeyframe(scaledTime).f3299a;
                if (Math.abs(scaledTime - f) >= clipWidth) {
                    return false;
                }
            }
            this.d = this.f3736a.getClosestKeyframe(f);
            this.c.a(this.d);
            this.e.a(this.d);
        }
        if (this.d == null) {
            return false;
        }
        this.f.onTouchEvent(motionEvent);
        float[] fArr = this.o;
        Matrix matrix = this.p;
        matrix.reset();
        matrix.postScale(1280.0f / view.getWidth(), 720.0f / view.getHeight());
        matrix.postTranslate(-this.d.c, -this.d.d);
        matrix.postScale(1.0f / this.d.b, 1.0f / this.d.b);
        matrix.postRotate(-this.d.e, 0.0f, 0.0f);
        fArr[0] = motionEvent.getX();
        fArr[1] = motionEvent.getY();
        matrix.mapPoints(fArr);
        float f2 = fArr[0];
        float f3 = fArr[1];
        int width = (int) ((((this.n * 1280) / view.getWidth()) / 2) * (1.0f / this.d.b));
        float x = (motionEvent.getX() * 1280.0f) / view.getWidth();
        float y = (motionEvent.getY() * 720.0f) / view.getHeight();
        float hypot = (float) Math.hypot(x - this.d.c, y - this.d.d);
        float atan2 = (float) (Math.atan2(y - this.d.d, x - this.d.c) * 57.29577951308232d);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.s = 0L;
                this.w = 0.0f;
                this.v = 0.0f;
                this.f3736a.getBounds(this.q);
                if (this.f3736a.isSplitScreenEnabled()) {
                    int splitScreenSize = this.f3736a.getSplitScreenSize();
                    int i = -1;
                    int i2 = -1;
                    switch (this.f3736a.getSplitScreenType()) {
                        case LEFT:
                            i2 = 360;
                            i = splitScreenSize;
                            break;
                        case BOTTOM:
                            i = 640;
                            i2 = 720 - splitScreenSize;
                            break;
                        case RIGHT:
                            i = 1280 - splitScreenSize;
                            i2 = 360;
                            break;
                        case TOP:
                            i = 640;
                            i2 = splitScreenSize;
                            break;
                    }
                    if (i > -1 && i2 > -1 && x >= i - width && x <= i + width && y >= i2 - width && y <= i2 + width) {
                        this.l = DragMode.Split;
                        this.k = splitScreenSize;
                    } else if (this.f3736a.isPointInSplitScreenLayer(x, y)) {
                        this.l = DragMode.Move;
                    } else {
                        return false;
                    }
                } else if (f2 >= this.q.right - width && f2 <= this.q.right + width && f3 >= this.q.bottom - width && f3 <= this.q.bottom + width) {
                    this.l = DragMode.Scale;
                } else if (f2 >= this.q.right - width && f2 <= this.q.right + width && f3 >= this.q.top - width && f3 <= this.q.top + width) {
                    this.l = DragMode.Rotate;
                } else if (f2 >= this.q.left && f2 <= this.q.right && f3 >= this.q.top && f3 <= this.q.bottom) {
                    this.l = DragMode.Move;
                } else {
                    return false;
                }
                this.g = x;
                this.h = y;
                this.j = hypot;
                this.i = atan2;
                this.r = false;
                return true;
            case 1:
                if (this.l != null) {
                    a(x - this.g, y - this.h, atan2 - this.i, hypot / this.j, true);
                    if (this.r) {
                        this.b.l();
                    }
                }
                this.g = x;
                this.h = y;
                this.j = hypot;
                this.i = atan2;
                this.l = null;
                this.d = null;
                return true;
            case 2:
                if (this.l != null) {
                    a(x - this.g, y - this.h, atan2 - this.i, hypot / this.j, false);
                    this.r = true;
                }
                this.g = x;
                this.h = y;
                this.j = hypot;
                this.i = atan2;
                return true;
            default:
                return true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(float f, float f2, float f3, float f4, boolean z) {
        MarchingAnts marchingAnts;
        boolean z2;
        boolean z3;
        int i;
        VideoEditor.b E = this.b.E();
        if (E == null || !(E instanceof MarchingAnts)) {
            marchingAnts = null;
        } else {
            marchingAnts = (MarchingAnts) E;
            marchingAnts.b();
        }
        switch (this.l) {
            case Split:
                switch (this.f3736a.getSplitScreenType()) {
                    case LEFT:
                        this.k += f;
                        i = 1280;
                        break;
                    case BOTTOM:
                        this.k -= f2;
                        i = 720;
                        break;
                    case RIGHT:
                        this.k -= f;
                        i = 1280;
                        break;
                    case TOP:
                        this.k += f2;
                        i = 720;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i > 0 && Math.abs(this.k - (i / 2)) < 10.0f) {
                    this.f3736a.setSplitScreenSize(i / 2);
                } else {
                    this.f3736a.setSplitScreenSize((int) Math.min(Math.max(25.0f, this.k), i - 25));
                }
                this.f3736a.fitKeyframeToSplitscreenRect(this.d);
                if (marchingAnts != null) {
                    marchingAnts.i();
                    z2 = false;
                    z3 = false;
                    break;
                }
                z2 = false;
                z3 = false;
                break;
            case Move:
                this.c.c += f;
                this.c.d += f2;
                this.d.a(this.c);
                if (Math.abs(this.d.c - 640.0f) < 10.0f) {
                    if (this.v == 0.0f) {
                        this.v = this.d.d;
                    } else if (Math.abs(this.d.d - this.v) > 10.0f) {
                        this.v = 0.0f;
                        this.s = 0L;
                    }
                    this.d.c = 640.0f;
                    if (marchingAnts != null) {
                        marchingAnts.d();
                        z2 = false;
                        z3 = true;
                    } else {
                        z2 = false;
                        z3 = true;
                    }
                } else if (Math.abs(this.d.c - 640.0f) < 20.0f) {
                    z2 = true;
                    z3 = false;
                } else {
                    z2 = false;
                    z3 = false;
                }
                if (Math.abs(this.d.d - 360.0f) < 10.0f) {
                    if (this.w == 0.0f) {
                        this.w = this.d.c;
                    } else if (Math.abs(this.d.c - this.w) > 10.0f) {
                        this.w = 0.0f;
                        this.s = 0L;
                    }
                    this.d.d = 360.0f;
                    if (marchingAnts != null) {
                        marchingAnts.e();
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                } else if (Math.abs(this.d.d - 360.0f) < 20.0f) {
                    z2 = true;
                }
                this.f3736a.fitKeyframeToSplitscreenRect(this.d);
                break;
            case Rotate:
                this.c.e = ((this.c.e + f3) + 360.0f) % 360.0f;
                this.d.a(this.c);
                float f5 = this.d.e % 45.0f;
                if (f5 >= 4.5f) {
                    if (f5 < 40.5f) {
                        if (f5 >= 9.0f) {
                            if (f5 >= 36.0f) {
                                z2 = true;
                                z3 = false;
                                break;
                            }
                            z2 = false;
                            z3 = false;
                            break;
                        } else {
                            z2 = true;
                            z3 = false;
                            break;
                        }
                    } else {
                        NexLayerItem.b bVar = this.d;
                        bVar.e = (45.0f - f5) + bVar.e;
                        if (marchingAnts != null) {
                            marchingAnts.c();
                            z2 = false;
                            z3 = true;
                            break;
                        }
                        z2 = false;
                        z3 = true;
                    }
                } else {
                    this.d.e -= f5;
                    if (marchingAnts != null) {
                        marchingAnts.c();
                        z2 = false;
                        z3 = true;
                        break;
                    }
                    z2 = false;
                    z3 = true;
                    break;
                }
            case Scale:
                this.c.b *= f4;
                if (this.c.b < 0.01f) {
                    this.c.b = 0.01f;
                }
                this.d.a(this.c);
                z2 = false;
                z3 = false;
                break;
            default:
                z2 = false;
                z3 = false;
                break;
        }
        if (z3) {
            if (this.s == 0) {
                this.s = System.nanoTime();
            } else if ((System.nanoTime() - this.s) / 1000000 > 2000) {
                this.d.a(this.c);
                if (marchingAnts != null) {
                    marchingAnts.b();
                }
            }
        } else if (!z2) {
            this.s = 0L;
        }
        if (marchingAnts != null && z) {
            marchingAnts.b();
        }
        this.b.a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
