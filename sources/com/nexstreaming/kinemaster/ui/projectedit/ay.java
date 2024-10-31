package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: ItemDrawingContext.java */
/* loaded from: classes.dex */
public class ay extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Canvas f3778a;
    private RectF b;
    private RectF c;
    private TextPaint d;
    private boolean e;
    private boolean f;
    private NexTimelineItem.h g;
    private boolean h;
    private float i;
    private int j;
    private int k;
    private List<com.nextreaming.nexeditorui.ef> l;
    private NexTimelineItem.p m;
    private DisplayMetrics n;
    private boolean o;

    public ay(Context context) {
        super(context);
        this.n = getResources().getDisplayMetrics();
    }

    public void a(Canvas canvas, RectF rectF, RectF rectF2, TextPaint textPaint, boolean z, boolean z2, NexTimelineItem.h hVar, boolean z3, float f, int i, int i2, List<com.nextreaming.nexeditorui.ef> list, NexTimelineItem.p pVar, NexTimelineItem nexTimelineItem) {
        this.f3778a = canvas;
        this.b = rectF;
        this.c = rectF2;
        this.d = textPaint;
        this.e = z;
        this.f = z2;
        this.g = hVar;
        this.h = z3;
        this.i = f;
        this.j = i;
        this.k = i2;
        this.l = list;
        this.m = pVar;
        this.o = false;
    }

    public void a(Canvas canvas, RectF rectF, RectF rectF2, TextPaint textPaint, boolean z, boolean z2, NexTimelineItem.h hVar, boolean z3, float f, int i, int i2, List<com.nextreaming.nexeditorui.ef> list, NexTimelineItem.p pVar, NexTimelineItem nexTimelineItem, boolean z4) {
        this.f3778a = canvas;
        this.b = rectF;
        this.c = rectF2;
        this.d = textPaint;
        this.e = z;
        this.f = z2;
        this.g = hVar;
        this.h = z3;
        this.i = f;
        this.j = i;
        this.k = i2;
        this.l = list;
        this.m = pVar;
        this.o = z4;
    }

    public NexTimelineItem.p a() {
        return this.m;
    }

    public Canvas b() {
        return this.f3778a;
    }

    public RectF c() {
        return this.b;
    }

    public RectF d() {
        return this.c;
    }

    public TextPaint e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.o;
    }

    public float j() {
        return this.n.density;
    }

    public int a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.n);
    }

    public NexTimelineItem.h k() {
        return this.g;
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public float n() {
        return this.i;
    }

    public List<com.nextreaming.nexeditorui.ef> o() {
        return this.l;
    }
}
