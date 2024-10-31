package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: ItemDrawingContext.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ib, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1916ib extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Canvas f22380a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f22381b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f22382c;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f22383d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22384e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22385f;

    /* renamed from: g, reason: collision with root package name */
    private NexTimelineItem.i f22386g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22387h;
    private float i;
    private int j;
    private int k;
    private List<com.nextreaming.nexeditorui.ob> l;
    private NexTimelineItem.r m;
    private DisplayMetrics n;
    private boolean o;
    private PurchaseType p;

    public C1916ib(Context context) {
        super(context);
        this.n = getResources().getDisplayMetrics();
    }

    public void a(Canvas canvas, RectF rectF, RectF rectF2, TextPaint textPaint, boolean z, boolean z2, NexTimelineItem.i iVar, boolean z3, float f2, int i, int i2, List<com.nextreaming.nexeditorui.ob> list, NexTimelineItem.r rVar, NexTimelineItem nexTimelineItem, PurchaseType purchaseType) {
        this.f22380a = canvas;
        this.f22381b = rectF;
        this.f22382c = rectF2;
        this.f22383d = textPaint;
        this.f22384e = z;
        this.f22385f = z2;
        this.f22386g = iVar;
        this.f22387h = z3;
        this.i = f2;
        this.j = i;
        this.k = i2;
        this.l = list;
        this.m = rVar;
        this.o = false;
        this.p = purchaseType;
    }

    public List<com.nextreaming.nexeditorui.ob> b() {
        return this.l;
    }

    public NexTimelineItem.i c() {
        return this.f22386g;
    }

    public int d() {
        return this.j;
    }

    public RectF e() {
        return this.f22381b;
    }

    public int f() {
        return this.k;
    }

    public PurchaseType g() {
        return this.p;
    }

    public NexTimelineItem.r h() {
        return this.m;
    }

    public float i() {
        return this.n.density;
    }

    public TextPaint j() {
        return this.f22383d;
    }

    public RectF k() {
        return this.f22382c;
    }

    public float l() {
        return this.i;
    }

    public boolean m() {
        return this.f22387h;
    }

    public boolean n() {
        return this.o;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return this.f22384e;
    }

    public void a(Canvas canvas, RectF rectF, RectF rectF2, TextPaint textPaint, boolean z, boolean z2, NexTimelineItem.i iVar, boolean z3, float f2, int i, int i2, List<com.nextreaming.nexeditorui.ob> list, NexTimelineItem.r rVar, NexTimelineItem nexTimelineItem, boolean z4) {
        this.f22380a = canvas;
        this.f22381b = rectF;
        this.f22382c = rectF2;
        this.f22383d = textPaint;
        this.f22384e = z;
        this.f22385f = z2;
        this.f22386g = iVar;
        this.f22387h = z3;
        this.i = f2;
        this.j = i;
        this.k = i2;
        this.l = list;
        this.m = rVar;
        this.o = z4;
    }

    public Canvas a() {
        return this.f22380a;
    }

    public int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, this.n);
    }
}
