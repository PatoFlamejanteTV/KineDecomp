package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes.dex */
public enum LayerExpression {
    None(0, Type.None, R.string.expression_none, (a) null),
    DrawByStroke(76, HandwritingLayer.class, Type.In, R.string.expression_draw_by_stroke, new C1754m()),
    DrawInOrder(77, HandwritingLayer.class, Type.In, R.string.expression_draw_in_order, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.x
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }
    }),
    UnDrawByStroke(78, HandwritingLayer.class, Type.Out, R.string.expression_undraw_by_stroke, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.I
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }
    }),
    UnDrawInOrder(79, HandwritingLayer.class, Type.Out, R.string.expression_undraw_in_order, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.U
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }
    }),
    FadeIn(50, Type.In, R.string.expression_fade, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.fa

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20313a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20313a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    FadeOut(51, Type.Out, R.string.expression_fade, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.ma

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20332a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20332a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopIn(52, Type.In, R.string.expression_pop, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.na

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20336a = new OvershootInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20336a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(interpolation);
            layerRenderer.b(interpolation, interpolation, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideRightIn(53, Type.In, R.string.expression_slide_right, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.oa

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20341a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20341a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b((1.0f - interpolation) * (-100.0f), 0.0f);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideRightOut(54, Type.Out, R.string.expression_slide_right, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.pa

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20343a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20343a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            layerRenderer.b(interpolation * 100.0f, 0.0f);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideLeftIn(55, Type.In, R.string.expression_slide_left, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.c

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20299a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20299a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b((1.0f - interpolation) * 100.0f, 0.0f);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideLeftOut(56, Type.Out, R.string.expression_slide_left, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.d

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20303a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20303a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            layerRenderer.b(interpolation * (-100.0f), 0.0f);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideUpIn(71, Type.In, R.string.expression_slide_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.e

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20306a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20306a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b(0.0f, (1.0f - interpolation) * 100.0f);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideUpOut(72, Type.Out, R.string.expression_slide_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.f

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20312a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20312a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            layerRenderer.b(0.0f, interpolation * (-100.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideDownIn(69, Type.In, R.string.expression_slide_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.g

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20315a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20315a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b(0.0f, (1.0f - interpolation) * (-100.0f));
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideDownOut(70, Type.Out, R.string.expression_slide_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.h

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20318a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20318a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            layerRenderer.b(0.0f, interpolation * 100.0f);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCWIn(73, Type.In, R.string.expression_spin_cw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.i

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20323a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20323a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(720.0f * interpolation, f2, f3);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCWOut(58, Type.Out, R.string.expression_spin_cw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.j

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20326a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20326a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            layerRenderer.a(interpolation * 720.0f, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCCWOut(74, Type.Out, R.string.expression_spin_ccw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.k

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20328a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20328a.getInterpolation(f4);
            layerRenderer.x();
            float f5 = 1.0f - interpolation;
            layerRenderer.a(f5);
            layerRenderer.a(f5 * 720.0f, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCCWIn(57, Type.In, R.string.expression_spin_ccw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.l

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20331a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20331a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a((1.0f - interpolation) * 720.0f, f2, f3);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    DropIn(59, Type.In, R.string.expression_drop, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.n

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20335a = new BounceInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20335a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b(0.0f, (1.0f - interpolation) * (-1200.0f));
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    ScaleUpIn(60, Type.In, R.string.expression_scale_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.o

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20340a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20340a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(interpolation);
            layerRenderer.b(interpolation, interpolation, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    ScaleDownOut(61, Type.Out, R.string.expression_scale_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.p

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20342a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20342a.getInterpolation(f4);
            layerRenderer.x();
            float f5 = 1.0f - interpolation;
            layerRenderer.a(f5);
            layerRenderer.b(f5, f5, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    ScaleDownIn(62, Type.In, R.string.expression_scale_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.q

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20347a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20347a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(interpolation);
            float f5 = 2.0f - interpolation;
            layerRenderer.b(f5, f5, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    ScaleUpOut(63, Type.Out, R.string.expression_scale_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.r

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20352a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20352a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(1.0f - interpolation);
            float f5 = interpolation + 1.0f;
            layerRenderer.b(f5, f5, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    BlinkSlowOverall(84, Type.Overall, R.string.expression_blink_slow, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.s
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            if ((i * f4) % 900.0f < 450.0f) {
                layerRenderer.a(0.0f);
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    FlickerOverall(82, Type.Overall, R.string.expression_flicker, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.t
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float f5 = i * f4;
            float f6 = i * 10;
            double d2 = layerRenderer.d();
            double a2 = com.nexstreaming.app.general.util.E.a((f2 / 500.0f) + f6, (f3 / 500.0f) + f6, f5 / 200.0f);
            Double.isNaN(d2);
            layerRenderer.a((float) Math.abs(d2 * a2));
            runnable.run();
            layerRenderer.w();
        }
    }),
    PulseSlowOverall(89, Type.Overall, R.string.expression_pulse, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.u
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            layerRenderer.a(layerRenderer.d() * (Math.abs(((i * f4) % 900.0f) - 450.0f) / 450.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    JitterOverall(85, Type.Overall, R.string.expression_jitter, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.v
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = i * f4;
            for (int i3 = 0; i3 < 20; i3++) {
                float f6 = i * 10;
                double d2 = (f2 / 500.0f) + f6;
                double d3 = (f3 / 500.0f) + f6;
                double d4 = f5 / 500.0f;
                double a2 = com.nexstreaming.app.general.util.E.a(d2, d3, d4) * 10.0d;
                double d5 = i3;
                Double.isNaN(d5);
                Double.isNaN(d2);
                Double.isNaN(d3);
                Double.isNaN(d5);
                double a3 = com.nexstreaming.app.general.util.E.a((7534.5431d * d5) + d2, 123.432d + d3 + d5, d4) * 30.0d;
                float f7 = i3;
                Double.isNaN(d5);
                Double.isNaN(d3);
                float f8 = f5 / 300.0f;
                double a4 = com.nexstreaming.app.general.util.E.a(r5 + 543.0f + f7, d3 + (823.25d * d5), 234.0f + f8) * 4.0d;
                Double.isNaN(d5);
                Double.isNaN(d2);
                Double.isNaN(d3);
                Double.isNaN(d5);
                double a5 = 10.0d * com.nexstreaming.app.general.util.E.a(d2 + (d5 * 734.5431d), 13.432d + d3 + d5, 567.0f + f8);
                Double.isNaN(d5);
                Double.isNaN(d2);
                Double.isNaN(d3);
                Double.isNaN(d5);
                float abs = Math.abs((float) (com.nexstreaming.app.general.util.E.a(d2 + (d5 * 4734.121d), 913.422d + d3 + d5, f8 + 80.0f) * 1.5d)) + 0.1f;
                layerRenderer.x();
                double d6 = layerRenderer.d();
                double a6 = com.nexstreaming.app.general.util.E.a(d2, d3, f5 / (f7 * 1000.0f));
                Double.isNaN(d6);
                layerRenderer.a((float) Math.abs(d6 * a6));
                layerRenderer.a(abs, abs);
                layerRenderer.b((float) (a2 + a4), (float) (a3 + a5));
                runnable.run();
                layerRenderer.w();
            }
        }
    }),
    FountainOverall(86, Type.Overall, R.string.expression_fountain, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.w
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            boolean a2;
            c.d.b.e.b bVar;
            c.d.b.e.b bVar2;
            c.d.b.e.b bVar3;
            c.d.b.e.b bVar4;
            c.d.b.e.b bVar5;
            c.d.b.e.b bVar6;
            int i3;
            Object h2 = layerRenderer.h();
            a2 = LayerExpression.a(h2, layerExpression);
            if (a2) {
                c.d.b.e.a aVar = new c.d.b.e.a(500);
                aVar.a(0.35d);
                aVar.a(200, ErrorCode.InitError.INIT_ADMANGER_ERROR);
                aVar.c(0.001d, 0.015d);
                aVar.a(0.0d, 1.0E-4d);
                aVar.a(0.0d, 1.0d, 1.0d, 1.0d, 1.0d, 0.5d, 0.25d, 0.0d);
                aVar.b(0.01d, 0.2d, 0.3d, 0.3d, 0.3d, 0.2d, 0.01d);
                i3 = layerExpression.id;
                h2 = c.d.b.e.f.a(aVar, 120, i3);
                layerRenderer.a(h2);
            }
            c.d.b.e.f fVar = (c.d.b.e.f) h2;
            fVar.a((int) (f4 * i));
            int a3 = fVar.a();
            for (int i4 = 0; i4 < a3; i4++) {
                bVar = LayerExpression.particleInfo;
                fVar.a(i4, bVar);
                layerRenderer.x();
                bVar2 = LayerExpression.particleInfo;
                float f5 = bVar2.f3784a * 300.0f;
                bVar3 = LayerExpression.particleInfo;
                layerRenderer.b(f5, bVar3.f3785b * 300.0f);
                bVar4 = LayerExpression.particleInfo;
                float f6 = bVar4.f3786c;
                bVar5 = LayerExpression.particleInfo;
                layerRenderer.a(f6, bVar5.f3786c);
                bVar6 = LayerExpression.particleInfo;
                layerRenderer.a(bVar6.f3787d * layerRenderer.d());
                runnable.run();
                layerRenderer.w();
            }
        }
    }),
    Ring3D(67, Type.Overall, R.string.expression_ring, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.y
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            if (layerRenderer.d() >= 1.0f) {
                layerRenderer.z();
            }
            float width = rectF.width() * 0.5f * 3.4199727f;
            for (int i3 = 0; i3 < 10; i3++) {
                layerRenderer.x();
                layerRenderer.b(0.0f, 0.0f, -width);
                layerRenderer.a(((i3 * 360.0f) / 10.0f) + (360.0f * f4), 0.0f, 1.0f, 0.0f);
                layerRenderer.b(0.0f, 0.0f, width);
                runnable.run();
                layerRenderer.w();
            }
            layerRenderer.t();
        }
    }),
    FloatingOverall(64, Type.Overall, R.string.expression_floating, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.z
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float f5 = i * f4;
            float f6 = i * 10;
            double d2 = (f2 / 500.0f) + f6;
            double d3 = (f3 / 500.0f) + f6;
            double d4 = f5 / 500.0f;
            double a2 = com.nexstreaming.app.general.util.E.a(d2, d3, d4) * 10.0d;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double a3 = com.nexstreaming.app.general.util.E.a(7534.5431d + d2, 123.432d + d3, d4) * 30.0d;
            Double.isNaN(d3);
            float f7 = f5 / 300.0f;
            double a4 = com.nexstreaming.app.general.util.E.a(r3 + 543.0f, d3 + 823.25d, 234.0f + f7) * 4.0d;
            Double.isNaN(d2);
            Double.isNaN(d3);
            layerRenderer.b((float) (a2 + a4), (float) (a3 + (com.nexstreaming.app.general.util.E.a(d2 + 734.5431d, d3 + 13.432d, f7 + 567.0f) * 10.0d)));
            runnable.run();
            layerRenderer.w();
        }
    }),
    DriftingOverall(65, Type.Overall, R.string.expression_drifting, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.A
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float f5 = i * f4;
            float f6 = i * 10;
            double d2 = (f2 / 500.0f) + f6;
            double d3 = (f3 / 500.0f) + f6;
            double d4 = f5 / 1000.0f;
            double a2 = com.nexstreaming.app.general.util.E.a(d2, d3, d4) * 40.0d;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double a3 = com.nexstreaming.app.general.util.E.a(7534.5431d + d2, 123.432d + d3, d4) * 40.0d;
            Double.isNaN(d3);
            float f7 = f5 / 500.0f;
            double a4 = com.nexstreaming.app.general.util.E.a(r3 + 543.0f, d3 + 823.25d, 234.0f + f7) * 10.0d;
            Double.isNaN(d2);
            Double.isNaN(d3);
            layerRenderer.b((float) (a2 + a4), (float) (a3 + (com.nexstreaming.app.general.util.E.a(d2 + 734.5431d, d3 + 13.432d, f7 + 567.0f) * 10.0d)));
            runnable.run();
            layerRenderer.w();
        }
    }),
    SquishingOverall(66, Type.Overall, R.string.expression_squishing, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.B
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            double d2 = (i * f4) / 400.0f;
            layerRenderer.b((float) ((Math.sin(d2) * 0.20000000298023224d) + 1.0d), (float) ((Math.cos(d2) * 0.20000000298023224d) + 1.0d), f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    Converge(68, Type.In, R.string.expression_converge, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.C

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20183a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20183a.getInterpolation(f4);
            layerRenderer.x();
            float f5 = 1.0f - interpolation;
            layerRenderer.b((-100.0f) * f5, 0.0f);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
            layerRenderer.x();
            layerRenderer.b(f5 * 100.0f, 0.0f);
            layerRenderer.a(interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    Diverge(75, Type.Out, R.string.expression_diverge, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.D

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20186a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20186a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.b((-100.0f) * interpolation, 0.0f);
            float f5 = 1.0f - interpolation;
            layerRenderer.a(f5);
            runnable.run();
            layerRenderer.w();
            layerRenderer.x();
            layerRenderer.b(interpolation * 100.0f, 0.0f);
            layerRenderer.a(f5);
            runnable.run();
            layerRenderer.w();
        }
    }),
    LetterByLetter(80, TextLayer.class, Type.In, R.string.expression_letter_by_letter, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.E
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }
    }),
    WipeRight(90, Type.In, R.string.expression_wipe_right, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.F
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * f5), rectF.right, rectF.bottom);
            } else if (i2 == 180) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * f5) + f6, rectF.bottom);
            } else if (i2 == 270) {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * f5));
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * f5), rectF.top, rectF.right, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    RainOverall(91, Type.Overall, R.string.expression_rain, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.G
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            boolean a2;
            c.d.b.e.b bVar;
            c.d.b.e.b bVar2;
            c.d.b.e.b bVar3;
            c.d.b.e.b bVar4;
            c.d.b.e.b bVar5;
            c.d.b.e.b bVar6;
            int i3;
            Object h2 = layerRenderer.h();
            a2 = LayerExpression.a(h2, layerExpression);
            if (a2) {
                c.d.b.e.a aVar = new c.d.b.e.a(120);
                aVar.a(0.25d);
                aVar.a(350, 351);
                aVar.c(0.0d, 0.0d);
                aVar.a(0.0d, 1.0E-4d);
                aVar.a(0.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 0.0d);
                aVar.b(0.01d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.2d, 0.02d);
                aVar.b(0.0d, 2.5d);
                aVar.a(i * (-6068514594564262882L));
                i3 = layerExpression.id;
                h2 = c.d.b.e.f.a(aVar, 120, i3);
                layerRenderer.a(h2);
            }
            c.d.b.e.f fVar = (c.d.b.e.f) h2;
            fVar.a((int) (f4 * i));
            int a3 = fVar.a();
            for (int i4 = 0; i4 < a3; i4++) {
                bVar = LayerExpression.particleInfo;
                fVar.a(i4, bVar);
                layerRenderer.x();
                bVar2 = LayerExpression.particleInfo;
                float f5 = bVar2.f3784a * 300.0f;
                bVar3 = LayerExpression.particleInfo;
                layerRenderer.b(f5, bVar3.f3785b * 300.0f);
                bVar4 = LayerExpression.particleInfo;
                float f6 = bVar4.f3786c;
                bVar5 = LayerExpression.particleInfo;
                layerRenderer.a(f6, bVar5.f3786c);
                bVar6 = LayerExpression.particleInfo;
                layerRenderer.a(bVar6.f3787d * layerRenderer.d());
                runnable.run();
                layerRenderer.w();
            }
        }
    }),
    WipeLeft(92, Type.In, R.string.expression_wipe_left, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.H
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                float f6 = rectF.left;
                float f7 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7, rectF.right, f7 + (rectF.height() * f5));
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * f5), rectF.top, rectF.right, rectF.bottom);
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * f5), rectF.right, rectF.bottom);
            } else {
                float f8 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f8, rectF.top, (rectF.width() * f5) + f8, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeUp(93, Type.In, R.string.expression_wipe_up, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.J
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * f5), rectF.top, rectF.right, rectF.bottom);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * f5), rectF.right, rectF.bottom);
            } else if (i2 == 270) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * f5) + f6, rectF.bottom);
            } else {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * f5));
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeDown(94, Type.In, R.string.expression_wipe_down, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.K
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * f5) + f6, rectF.bottom);
            } else if (i2 == 180) {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * f5));
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * f5), rectF.top, rectF.right, rectF.bottom);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * f5), rectF.right, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeLeftOut(95, Type.Out, R.string.expression_wipe_left, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.L
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * (1.0f - f5)), rectF.right, rectF.bottom);
            } else if (i2 == 180) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * (1.0f - f5)) + f6, rectF.bottom);
            } else if (i2 == 270) {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * (1.0f - f5)));
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * (1.0f - f5)), rectF.top, rectF.right, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeRightOut(96, Type.Out, R.string.expression_wipe_right, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.M
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                float f6 = rectF.left;
                float f7 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7, rectF.right, f7 + (rectF.height() * (1.0f - f5)));
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * (1.0f - f5)), rectF.top, rectF.right, rectF.bottom);
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * (1.0f - f5)), rectF.right, rectF.bottom);
            } else {
                float f8 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f8, rectF.top, (rectF.width() * (1.0f - f5)) + f8, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeDownOut(97, Type.Out, R.string.expression_wipe_down, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.N
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * (1.0f - f5)), rectF.top, rectF.right, rectF.bottom);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * (1.0f - f5)), rectF.right, rectF.bottom);
            } else if (i2 == 270) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * (1.0f - f5)) + f6, rectF.bottom);
            } else {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * (1.0f - f5)));
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    WipeUpOut(98, Type.Out, R.string.expression_wipe_up, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.O
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            float f5 = 1.0f - f4;
            if (i2 == 90) {
                float f6 = rectF.left;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, rectF.top, (rectF.width() * (1.0f - f5)) + f6, rectF.bottom);
            } else if (i2 == 180) {
                float f7 = rectF.left;
                float f8 = rectF.top;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7, f8, rectF.right, f8 + (rectF.height() * (1.0f - f5)));
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.right - (rectF.width() * (1.0f - f5)), rectF.top, rectF.right, rectF.bottom);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.bottom - (rectF.height() * (1.0f - f5)), rectF.right, rectF.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticIn(99, Type.In, R.string.expression_pop_out, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.P

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20242a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20242a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f4 * 10.0f));
            layerRenderer.a(1.0f, interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticDownIn(100, Type.In, R.string.expression_pop_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.Q

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20245a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20245a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f4 * 10.0f));
            layerRenderer.b(1.0f, interpolation, f2, f3 - (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticUpIn(101, Type.In, R.string.expression_pop_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.S

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20250a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20250a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f4 * 10.0f));
            layerRenderer.b(1.0f, interpolation, f2, f3 + (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlidePopIn(102, Type.In, R.string.expression_pop_open, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.T

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20253a = new AccelerateInterpolator();

        /* renamed from: b, reason: collision with root package name */
        Interpolator f20254b = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = f4 * 2.0f;
            float interpolation = this.f20253a.getInterpolation(Math.max(0.0f, Math.min(1.0f, f5)));
            float interpolation2 = this.f20254b.getInterpolation(Math.max(0.0f, Math.min(1.0f, f5 - 1.0f)));
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f4 * 10.0f));
            layerRenderer.b(interpolation, Math.max(0.05f, interpolation2), f2, f3 - (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindUp(103, Type.In, R.string.expression_enter_slide_up, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.V

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20258a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20258a.getInterpolation(f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - 1.0f) - rectF.width(), rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - 1.0f) - rectF.height(), rectF.right + 1.0f, rectF.top + 1.0f);
            } else if (i2 == 270) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5 - 1.0f, rectF.top - 1.0f, f5 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            } else {
                float f6 = rectF.left - 1.0f;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7 - 1.0f, rectF.right + 1.0f, f7 + rectF.height() + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else if (i2 == 180) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else if (i2 == 270) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindDown(104, Type.In, R.string.expression_enter_slide_down, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.W

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20279a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20279a.getInterpolation(f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5 - 1.0f, rectF.top - 1.0f, f5 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 180) {
                float f6 = rectF.left - 1.0f;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7 - 1.0f, rectF.right + 1.0f, f7 + rectF.height() + 1.0f);
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - rectF.width()) - 1.0f, rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - rectF.height()) - 1.0f, rectF.right + 1.0f, rectF.top + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else if (i2 == 180) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else if (i2 == 270) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindLeft(105, Type.In, R.string.expression_enter_slide_left, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.X

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20280a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20280a.getInterpolation(f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                float f5 = rectF.left - 1.0f;
                float f6 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5, f6 - 1.0f, rectF.right + 1.0f, f6 + rectF.height() + 1.0f);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - rectF.width()) - 1.0f, rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - rectF.height()) - 1.0f, rectF.right + 1.0f, rectF.top + 1.0f);
            } else {
                float f7 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7 - 1.0f, rectF.top - 1.0f, f7 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else if (i2 == 180) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else if (i2 == 270) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindRight(106, Type.In, R.string.expression_enter_slide_right, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.Y

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20282a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20282a.getInterpolation(f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - rectF.height()) - 1.0f, rectF.right + 1.0f, rectF.top + 1.0f);
            } else if (i2 == 180) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5 - 1.0f, rectF.top - 1.0f, f5 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 270) {
                float f6 = rectF.left - 1.0f;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7 - 1.0f, rectF.right + 1.0f, f7 + rectF.height() + 1.0f);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - rectF.width()) - 1.0f, rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else if (i2 == 180) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else if (i2 == 270) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    Stamp(107, Type.In, R.string.expression_rubber_stamp, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.Z

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20284a = new AccelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20284a.getInterpolation(f4);
            layerRenderer.x();
            layerRenderer.a((float) Math.pow(f4, 5.0d));
            float f5 = (2.0f - interpolation) * 2.0f;
            layerRenderer.b(f5, f5, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SnapClosed(108, Type.Out, R.string.expression_snap_closed, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.aa

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20293a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = 1.0f - f4;
            float interpolation = this.f20293a.getInterpolation(f5);
            float interpolation2 = this.f20293a.getInterpolation(f5);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f5 * 10.0f));
            layerRenderer.b(interpolation, Math.min(1.0f, interpolation2), f2, f3 - (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticOut(109, Type.Out, R.string.expression_snap_in, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.ba

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20295a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = 1.0f - f4;
            float interpolation = this.f20295a.getInterpolation(f5);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f5 * 10.0f));
            layerRenderer.a(1.0f, interpolation);
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticDownOut(110, Type.Out, R.string.expression_snap_up, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.ca

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20300a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = 1.0f - f4;
            float interpolation = this.f20300a.getInterpolation(f5);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f5 * 10.0f));
            layerRenderer.b(1.0f, interpolation, f2, f3 - (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    PopElasticUpOut(111, Type.Out, R.string.expression_snap_down, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.da

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20304a = new c.d.a.a.b.a(0.3f, 1.0f);

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float f5 = 1.0f - f4;
            float interpolation = this.f20304a.getInterpolation(f5);
            layerRenderer.x();
            layerRenderer.a(Math.min(1.0f, f5 * 10.0f));
            layerRenderer.b(1.0f, interpolation, f2, f3 + (rectF.height() / 2.0f));
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindUpOut(112, Type.Out, R.string.expression_exit_slide_down, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.ea

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20307a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20307a.getInterpolation(1.0f - f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - rectF.width(), rectF.top, rectF.left, rectF.bottom);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.top - rectF.height(), rectF.right, rectF.top);
            } else if (i2 == 270) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5, rectF.top, f5 + rectF.width(), rectF.bottom);
            } else {
                float f6 = rectF.left;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7, rectF.right, f7 + rectF.height());
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else if (i2 == 180) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else if (i2 == 270) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindDownOut(113, Type.Out, R.string.expression_exit_slide_up, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.ga

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20316a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20316a.getInterpolation(1.0f - f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5, rectF.top, f5 + rectF.width(), rectF.bottom);
            } else if (i2 == 180) {
                float f6 = rectF.left;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7, rectF.right, f7 + rectF.height());
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - rectF.width(), rectF.top, rectF.left, rectF.bottom);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left, rectF.top - rectF.height(), rectF.right, rectF.top);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else if (i2 == 180) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else if (i2 == 270) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindLeftOut(114, Type.Out, R.string.expression_exit_slide_right, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.ha

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20319a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20319a.getInterpolation(1.0f - f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                float f5 = rectF.left - 1.0f;
                float f6 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5, f6 - 1.0f, rectF.right + 1.0f, f6 + rectF.height() + 1.0f);
            } else if (i2 == 180) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - rectF.width()) - 1.0f, rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 270) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - rectF.height()) - 1.0f, rectF.right + 1.0f, rectF.top + 1.0f);
            } else {
                float f7 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f7 - 1.0f, rectF.top - 1.0f, f7 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else if (i2 == 180) {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            } else if (i2 == 270) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SlideBehindRightOut(115, Type.Out, R.string.expression_exit_slide_left, new b() { // from class: com.nexstreaming.kinemaster.editorwrapper.ia

        /* renamed from: a, reason: collision with root package name */
        Interpolator f20324a = new DecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            float interpolation = this.f20324a.getInterpolation(1.0f - f4);
            layerRenderer.x();
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            if (i2 == 90) {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, rectF.left - 1.0f, (rectF.top - rectF.height()) - 1.0f, rectF.right + 1.0f, rectF.top + 1.0f);
            } else if (i2 == 180) {
                float f5 = rectF.right;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f5 - 1.0f, rectF.top - 1.0f, f5 + rectF.width() + 1.0f, rectF.bottom + 1.0f);
            } else if (i2 == 270) {
                float f6 = rectF.left - 1.0f;
                float f7 = rectF.bottom;
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, f6, f7 - 1.0f, rectF.right + 1.0f, f7 + rectF.height() + 1.0f);
            } else {
                layerRenderer.c(ViewCompat.MEASURED_STATE_MASK, (rectF.left - rectF.width()) - 1.0f, rectF.top - 1.0f, rectF.left + 1.0f, rectF.bottom + 1.0f);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
            if (i2 == 90) {
                layerRenderer.b(0.0f, (-(1.0f - interpolation)) * rectF.height());
            } else if (i2 == 180) {
                layerRenderer.b((1.0f - interpolation) * rectF.width(), 0.0f);
            } else if (i2 == 270) {
                layerRenderer.b(0.0f, (1.0f - interpolation) * rectF.height());
            } else {
                layerRenderer.b((-(1.0f - interpolation)) * rectF.width(), 0.0f);
            }
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCCWOverall(116, Type.Overall, R.string.expression_spin_ccw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.ja
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            layerRenderer.a(((-((i * f4) % 1000.0f)) * 360.0f) / 500.0f, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    SpinCWOverall(117, Type.Overall, R.string.expression_spin_cw, new c() { // from class: com.nexstreaming.kinemaster.editorwrapper.ka
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            layerRenderer.x();
            layerRenderer.a((((i * f4) % 1000.0f) * 360.0f) / 500.0f, f2, f3);
            runnable.run();
            layerRenderer.w();
        }
    }),
    Fade(1, FadeIn, FadeOut),
    Pop(2, PopIn, ScaleUpOut),
    Slide(3, SlideRightIn, SlideRightOut),
    Spin(4, SpinCCWIn, SpinCWOut),
    Drop(5, DropIn, FadeOut),
    Scale(6, ScaleUpIn, ScaleDownOut),
    Floating(7, FadeIn, FadeOut, FloatingOverall),
    Drifting(8, FadeIn, FadeOut, DriftingOverall),
    Squishing(9, FadeIn, FadeOut, SquishingOverall);

    private static final SparseArray<LayerExpression> idToItemMap = new SparseArray<LayerExpression>() { // from class: com.nexstreaming.kinemaster.editorwrapper.la
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            for (LayerExpression layerExpression : LayerExpression.values()) {
                if (get(layerExpression.getId()) == null) {
                    put(layerExpression.getId(), layerExpression);
                } else {
                    throw new IllegalStateException("Duplicate layer expression ID");
                }
            }
        }
    };
    private static c.d.b.e.b particleInfo = new c.d.b.e.b();
    private final Class<? extends NexLayerItem> appliesTo;
    private final Type expressionType;
    private final int id;
    private final a imp;
    private final int labelResource;
    private final LayerExpression legacyIn;
    private final LayerExpression legacyOut;
    private final LayerExpression legacyOverall;

    /* loaded from: classes.dex */
    public enum Type {
        In,
        Out,
        Overall,
        Legacy,
        None;

        public boolean hasDuration() {
            return this == In || this == Out;
        }

        public boolean hasSpeed() {
            return this == Overall;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a {
        private a() {
        }

        abstract void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2);

        abstract void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2);

        /* synthetic */ a(C1754m c1754m) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends a {
        private b() {
            super(null);
        }

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        final void b(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(C1754m c1754m) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c extends a {
        private c() {
            super(null);
        }

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        final void a(LayerRenderer layerRenderer, float f2, float f3, float f4, int i, Runnable runnable, LayerExpression layerExpression, RectF rectF, int i2) {
            runnable.run();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(C1754m c1754m) {
            this();
        }
    }

    LayerExpression(int i, Class cls, Type type, int i2, a aVar) {
        this.id = i;
        this.imp = aVar;
        this.labelResource = i2;
        this.expressionType = type;
        this.legacyIn = null;
        this.legacyOut = null;
        this.legacyOverall = null;
        this.appliesTo = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Object obj, LayerExpression layerExpression) {
        return (obj != null && (obj instanceof c.d.b.e.f) && ((c.d.b.e.f) obj).d() == layerExpression.id) ? false : true;
    }

    public static LayerExpression fromId(int i) {
        return idToItemMap.get(i, None);
    }

    public static boolean requiresMask(int i) {
        return fromId(i).imp instanceof b;
    }

    public int getId() {
        return this.id;
    }

    public int getLabelResource() {
        return this.labelResource;
    }

    public LayerExpression getLegacyInExpression() {
        return this.legacyIn;
    }

    public LayerExpression getLegacyOutExpression() {
        return this.legacyOut;
    }

    public LayerExpression getLegacyOverallExpression() {
        return this.legacyOverall;
    }

    public Type getType() {
        return this.expressionType;
    }

    public void render(LayerRenderer layerRenderer, float f2, float f3, int i, int i2, int i3, Runnable runnable, RectF rectF, int i4, boolean z) {
        if (runnable == null) {
            return;
        }
        if (this.imp != null && this.expressionType != Type.None) {
            int min = Math.min(i3, i2 / 2);
            Type type = this.expressionType;
            if (type == Type.In) {
                if (i > min) {
                    runnable.run();
                    return;
                } else if (z) {
                    this.imp.a(layerRenderer, f2, f3, i / min, min, runnable, this, rectF, i4);
                    return;
                } else {
                    this.imp.b(layerRenderer, f2, f3, i / min, min, runnable, this, rectF, i4);
                    return;
                }
            }
            if (type != Type.Out) {
                if (type == Type.Overall) {
                    if (z) {
                        this.imp.a(layerRenderer, f2, f3, i / i2, i2, runnable, this, rectF, i4);
                        return;
                    } else {
                        this.imp.b(layerRenderer, f2, f3, i / i2, i2, runnable, this, rectF, i4);
                        return;
                    }
                }
                return;
            }
            if (i < i2 - min) {
                runnable.run();
                return;
            } else if (z) {
                this.imp.a(layerRenderer, f2, f3, (i - r1) / min, min, runnable, this, rectF, i4);
                return;
            } else {
                this.imp.b(layerRenderer, f2, f3, (i - r1) / min, min, runnable, this, rectF, i4);
                return;
            }
        }
        runnable.run();
    }

    public static LayerExpression[] values(Type type, NexLayerItem nexLayerItem) {
        LayerExpression[] values = values();
        int i = 0;
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].expressionType == Type.None || (values[i2].expressionType == type && values[i2].appliesTo.isInstance(nexLayerItem))) {
                i++;
            }
        }
        LayerExpression[] layerExpressionArr = new LayerExpression[i];
        int i3 = 0;
        for (int i4 = 0; i4 < values.length; i4++) {
            if (values[i4].expressionType == Type.None || (values[i4].expressionType == type && values[i4].appliesTo.isInstance(nexLayerItem))) {
                layerExpressionArr[i3] = values[i4];
                i3++;
            }
        }
        return layerExpressionArr;
    }

    LayerExpression(int i, Type type, int i2, a aVar) {
        this.id = i;
        this.imp = aVar;
        this.labelResource = i2;
        this.expressionType = type;
        this.legacyIn = null;
        this.legacyOut = null;
        this.legacyOverall = null;
        this.appliesTo = NexLayerItem.class;
    }

    LayerExpression(int i, LayerExpression layerExpression, LayerExpression layerExpression2) {
        this.id = i;
        this.imp = null;
        this.labelResource = 0;
        this.expressionType = Type.Legacy;
        this.legacyIn = layerExpression;
        this.legacyOut = layerExpression2;
        this.legacyOverall = null;
        this.appliesTo = NexLayerItem.class;
    }

    LayerExpression(int i, LayerExpression layerExpression, LayerExpression layerExpression2, LayerExpression layerExpression3) {
        this.id = i;
        this.imp = null;
        this.labelResource = 0;
        this.expressionType = Type.Legacy;
        this.legacyIn = layerExpression;
        this.legacyOut = layerExpression2;
        this.legacyOverall = layerExpression3;
        this.appliesTo = NexLayerItem.class;
    }
}
