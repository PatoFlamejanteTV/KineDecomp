package com.nexstreaming.kinemaster.editorwrapper;

import android.util.SparseArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* loaded from: classes.dex */
public enum LayerExpression {
    None(0, Type.None, R.string.expression_none, (a) null),
    DrawByStroke(76, HandwritingLayer.class, Type.In, R.string.expression_draw_by_stroke, new b()),
    DrawInOrder(77, HandwritingLayer.class, Type.In, R.string.expression_draw_in_order, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.m
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            runnable.run();
        }
    }),
    UnDrawByStroke(78, HandwritingLayer.class, Type.Out, R.string.expression_undraw_by_stroke, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.x
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            runnable.run();
        }
    }),
    UnDrawInOrder(79, HandwritingLayer.class, Type.Out, R.string.expression_undraw_in_order, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ag
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            runnable.run();
        }
    }),
    FadeIn(50, Type.In, R.string.expression_fade, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ah

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3309a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3309a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    FadeOut(51, Type.Out, R.string.expression_fade, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ai

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3310a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3310a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    PopIn(52, Type.In, R.string.expression_pop, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.aj

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3311a = new OvershootInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3311a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(interpolation);
            layerRenderer.a(interpolation, interpolation, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideRightIn(53, Type.In, R.string.expression_slide_right, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ak

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3312a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3312a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a((1.0f - interpolation) * (-100.0f), 0.0f);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideRightOut(54, Type.Out, R.string.expression_slide_right, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.al

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3313a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3313a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(interpolation * 100.0f, 0.0f);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideLeftIn(55, Type.In, R.string.expression_slide_left, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.c

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3353a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3353a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a((1.0f - interpolation) * 100.0f, 0.0f);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideLeftOut(56, Type.Out, R.string.expression_slide_left, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.d

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3369a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3369a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(interpolation * (-100.0f), 0.0f);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideUpIn(71, Type.In, R.string.expression_slide_up, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.e

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3370a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3370a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a(0.0f, (1.0f - interpolation) * 100.0f);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideUpOut(72, Type.Out, R.string.expression_slide_up, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.f

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3371a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3371a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(0.0f, interpolation * (-100.0f));
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideDownIn(69, Type.In, R.string.expression_slide_down, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.g

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3372a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3372a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a(0.0f, (1.0f - interpolation) * (-100.0f));
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SlideDownOut(70, Type.Out, R.string.expression_slide_down, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.h

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3373a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3373a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(0.0f, interpolation * 100.0f);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SpinCWIn(73, Type.In, R.string.expression_spin_cw, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.i

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3374a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3374a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.b(720.0f * interpolation, f, f2);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SpinCWOut(58, Type.Out, R.string.expression_spin_cw, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.j

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3375a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3375a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.b(interpolation * 720.0f, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SpinCCWOut(74, Type.Out, R.string.expression_spin_ccw, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.k

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3376a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3376a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.b((1.0f - interpolation) * 720.0f, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    SpinCCWIn(57, Type.In, R.string.expression_spin_ccw, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.l

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3377a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3377a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.b(720.0f * (1.0f - interpolation), f, f2);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    DropIn(59, Type.In, R.string.expression_drop, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.n

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3378a = new BounceInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3378a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a(0.0f, (1.0f - interpolation) * (-1200.0f));
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    ScaleUpIn(60, Type.In, R.string.expression_scale_up, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.o

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3379a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3379a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(interpolation);
            layerRenderer.a(interpolation, interpolation, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    ScaleDownOut(61, Type.Out, R.string.expression_scale_down, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.p

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3380a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3380a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(1.0f - interpolation, 1.0f - interpolation, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    ScaleDownIn(62, Type.In, R.string.expression_scale_down, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.q

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3381a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3381a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(interpolation);
            layerRenderer.a(2.0f - interpolation, 2.0f - interpolation, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    ScaleUpOut(63, Type.Out, R.string.expression_scale_up, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.r

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3382a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3382a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.d(1.0f - interpolation);
            layerRenderer.a(interpolation + 1.0f, interpolation + 1.0f, f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    BlinkSlowOverall(84, Type.Overall, R.string.expression_blink_slow, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.s
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            if ((i * f3) % 900.0f < 450.0f) {
                layerRenderer.d(0.0f);
            }
            runnable.run();
            layerRenderer.m();
        }
    }),
    FlickerOverall(82, Type.Overall, R.string.expression_flicker, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.t
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            double r = layerRenderer.r();
            layerRenderer.d((float) Math.abs(com.nexstreaming.app.general.util.t.a((f / 500.0f) + (i * 10), (i * 10) + (f2 / 500.0f), (i * f3) / 200.0f) * r));
            runnable.run();
            layerRenderer.m();
        }
    }),
    PulseSlowOverall(89, Type.Overall, R.string.expression_pulse, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.u
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            layerRenderer.d((Math.abs(((i * f3) % 900.0f) - 450.0f) / 450.0f) * layerRenderer.r());
            runnable.run();
            layerRenderer.m();
        }
    }),
    JitterOverall(85, Type.Overall, R.string.expression_jitter, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.v
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float f6 = i * f3;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 20) {
                    float f7 = (f / 500.0f) + (i * 10);
                    float f8 = (f2 / 500.0f) + (i * 10);
                    double a2 = 10.0d * com.nexstreaming.app.general.util.t.a(f7, f8, f6 / 500.0f);
                    double a3 = 30.0d * com.nexstreaming.app.general.util.t.a(f7 + (7534.5431d * i3), f8 + 123.432d + i3, f6 / 500.0f);
                    double a4 = 4.0d * com.nexstreaming.app.general.util.t.a(543.0f + f7 + i3, f8 + (823.25d * i3), (f6 / 300.0f) + 234.0f);
                    double a5 = 10.0d * com.nexstreaming.app.general.util.t.a(f7 + (734.5431d * i3), f8 + 13.432d + i3, (f6 / 300.0f) + 567.0f);
                    float abs = Math.abs((float) (com.nexstreaming.app.general.util.t.a(f7 + (4734.121d * i3), f8 + 913.422d + i3, (f6 / 300.0f) + 80.0f) * 1.5d)) + 0.1f;
                    layerRenderer.l();
                    layerRenderer.d((float) Math.abs(com.nexstreaming.app.general.util.t.a(f7, f8, f6 / (1000.0f * i3)) * layerRenderer.r()));
                    layerRenderer.b(abs, abs);
                    layerRenderer.a((float) (a2 + a4), (float) (a3 + a5));
                    runnable.run();
                    layerRenderer.m();
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }),
    FountainOverall(86, Type.Overall, R.string.expression_fountain, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.w
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            boolean a2;
            com.nexstreaming.kinemaster.a.b bVar;
            com.nexstreaming.kinemaster.a.b bVar2;
            com.nexstreaming.kinemaster.a.b bVar3;
            com.nexstreaming.kinemaster.a.b bVar4;
            com.nexstreaming.kinemaster.a.b bVar5;
            com.nexstreaming.kinemaster.a.b bVar6;
            int i2;
            Object g = layerRenderer.g();
            a2 = LayerExpression.a(g, layerExpression);
            if (a2) {
                com.nexstreaming.kinemaster.a.a aVar = new com.nexstreaming.kinemaster.a.a(500);
                aVar.a(0.35d);
                aVar.a(200, 301);
                aVar.b(0.001d, 0.015d);
                aVar.a(0.0d, 1.0E-4d);
                aVar.a(0.0d, 1.0d, 1.0d, 1.0d, 1.0d, 0.5d, 0.25d, 0.0d);
                aVar.b(0.01d, 0.2d, 0.3d, 0.3d, 0.3d, 0.2d, 0.01d);
                i2 = layerExpression.id;
                g = com.nexstreaming.kinemaster.a.e.a(aVar, 120, i2);
                layerRenderer.a(g);
            }
            com.nexstreaming.kinemaster.a.e eVar = (com.nexstreaming.kinemaster.a.e) g;
            eVar.a((int) (i * f3));
            int a3 = eVar.a();
            for (int i3 = 0; i3 < a3; i3++) {
                bVar = LayerExpression.particleInfo;
                eVar.a(i3, bVar);
                layerRenderer.l();
                bVar2 = LayerExpression.particleInfo;
                float f6 = bVar2.f3258a * 300.0f;
                bVar3 = LayerExpression.particleInfo;
                layerRenderer.a(f6, bVar3.b * 300.0f);
                bVar4 = LayerExpression.particleInfo;
                float f7 = bVar4.c;
                bVar5 = LayerExpression.particleInfo;
                layerRenderer.b(f7, bVar5.c);
                bVar6 = LayerExpression.particleInfo;
                layerRenderer.d(bVar6.d * layerRenderer.r());
                runnable.run();
                layerRenderer.m();
            }
        }
    }),
    Ring3D(67, Type.Overall, R.string.expression_ring, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.y
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.n();
            float f6 = 3.4199727f * 0.5f * f4;
            for (int i2 = 0; i2 < 10; i2++) {
                layerRenderer.l();
                layerRenderer.a(0.0f, 0.0f, -f6);
                layerRenderer.b(((i2 * 360.0f) / 10.0f) + (360.0f * f3), 0.0f, 1.0f, 0.0f);
                layerRenderer.a(0.0f, 0.0f, f6);
                runnable.run();
                layerRenderer.m();
            }
            layerRenderer.o();
        }
    }),
    FloatingOverall(64, Type.Overall, R.string.expression_floating, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.z
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            float f6 = i * f3;
            float f7 = (f / 500.0f) + (i * 10);
            float f8 = (f2 / 500.0f) + (i * 10);
            layerRenderer.a((float) ((10.0d * com.nexstreaming.app.general.util.t.a(f7, f8, f6 / 500.0f)) + (4.0d * com.nexstreaming.app.general.util.t.a(543.0f + f7, f8 + 823.25d, (f6 / 300.0f) + 234.0f))), (float) ((com.nexstreaming.app.general.util.t.a(f7 + 734.5431d, f8 + 13.432d, (f6 / 300.0f) + 567.0f) * 10.0d) + (30.0d * com.nexstreaming.app.general.util.t.a(f7 + 7534.5431d, f8 + 123.432d, f6 / 500.0f))));
            runnable.run();
            layerRenderer.m();
        }
    }),
    DriftingOverall(65, Type.Overall, R.string.expression_drifting, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.aa
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            float f6 = i * f3;
            float f7 = (f / 500.0f) + (i * 10);
            float f8 = (f2 / 500.0f) + (i * 10);
            layerRenderer.a((float) ((40.0d * com.nexstreaming.app.general.util.t.a(f7, f8, f6 / 1000.0f)) + (10.0d * com.nexstreaming.app.general.util.t.a(543.0f + f7, f8 + 823.25d, (f6 / 500.0f) + 234.0f))), (float) ((com.nexstreaming.app.general.util.t.a(f7 + 734.5431d, f8 + 13.432d, (f6 / 500.0f) + 567.0f) * 10.0d) + (40.0d * com.nexstreaming.app.general.util.t.a(f7 + 7534.5431d, f8 + 123.432d, f6 / 1000.0f))));
            runnable.run();
            layerRenderer.m();
        }
    }),
    SquishingOverall(66, Type.Overall, R.string.expression_squishing, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ab
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            layerRenderer.l();
            float f6 = i * f3;
            layerRenderer.a((float) ((Math.sin(f6 / 400.0f) * 0.20000000298023224d) + 1.0d), (float) ((Math.cos(f6 / 400.0f) * 0.20000000298023224d) + 1.0d), f, f2);
            runnable.run();
            layerRenderer.m();
        }
    }),
    Converge(68, Type.In, R.string.expression_converge, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ac

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3307a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3307a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a((1.0f - interpolation) * (-100.0f), 0.0f);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
            layerRenderer.l();
            layerRenderer.a((1.0f - interpolation) * 100.0f, 0.0f);
            layerRenderer.d(interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    Diverge(75, Type.Out, R.string.expression_diverge, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ad

        /* renamed from: a, reason: collision with root package name */
        Interpolator f3308a = new AccelerateDecelerateInterpolator();

        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            float interpolation = this.f3308a.getInterpolation(f3);
            layerRenderer.l();
            layerRenderer.a((-100.0f) * interpolation, 0.0f);
            layerRenderer.d(1.0f - interpolation);
            runnable.run();
            layerRenderer.m();
            layerRenderer.l();
            layerRenderer.a(100.0f * interpolation, 0.0f);
            layerRenderer.d(1.0f - interpolation);
            runnable.run();
            layerRenderer.m();
        }
    }),
    LetterByLetter(80, TextLayer.class, Type.In, R.string.expression_letter_by_letter, new a() { // from class: com.nexstreaming.kinemaster.editorwrapper.ae
        @Override // com.nexstreaming.kinemaster.editorwrapper.LayerExpression.a
        void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5) {
            runnable.run();
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

    private static final SparseArray<LayerExpression> idToItemMap = new SparseArray<LayerExpression>() { // from class: com.nexstreaming.kinemaster.editorwrapper.af
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            for (LayerExpression layerExpression : LayerExpression.values()) {
                if (get(layerExpression.getId()) != null) {
                    throw new IllegalStateException("Duplicate layer expression ID");
                }
                put(layerExpression.getId(), layerExpression);
            }
        }
    };
    private static com.nexstreaming.kinemaster.a.b particleInfo = new com.nexstreaming.kinemaster.a.b();
    private final Class<? extends NexLayerItem> appliesTo;
    private final Type expressionType;
    private final int id;
    private final a imp;
    private final int labelResource;
    private final LayerExpression legacyIn;
    private final LayerExpression legacyOut;
    private final LayerExpression legacyOverall;

    public Type getType() {
        return this.expressionType;
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

    public int getLabelResource() {
        return this.labelResource;
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

    public int getId() {
        return this.id;
    }

    public static LayerExpression fromId(int i) {
        return idToItemMap.get(i, None);
    }

    public void render(LayerRenderer layerRenderer, float f, float f2, int i, int i2, int i3, Runnable runnable, float f3, float f4) {
        if (runnable != null) {
            if (this.imp == null || this.expressionType == Type.None) {
                runnable.run();
                return;
            }
            int min = Math.min(i3, i2 / 2);
            if (this.expressionType == Type.In) {
                if (i <= min) {
                    this.imp.a(layerRenderer, f, f2, i / min, min, runnable, this, f3, f4);
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            if (this.expressionType == Type.Out) {
                if (i >= i2 - min) {
                    this.imp.a(layerRenderer, f, f2, (i - (i2 - min)) / min, min, runnable, this, f3, f4);
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            if (this.expressionType == Type.Overall) {
                this.imp.a(layerRenderer, f, f2, i / i2, i2, runnable, this, f3, f4);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        abstract void a(LayerRenderer layerRenderer, float f, float f2, float f3, int i, Runnable runnable, LayerExpression layerExpression, float f4, float f5);

        private a() {
        }

        public /* synthetic */ a(b bVar) {
            this();
        }
    }

    public static boolean a(Object obj, LayerExpression layerExpression) {
        return (obj != null && (obj instanceof com.nexstreaming.kinemaster.a.e) && ((com.nexstreaming.kinemaster.a.e) obj).e() == layerExpression.id) ? false : true;
    }
}
