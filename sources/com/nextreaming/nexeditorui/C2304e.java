package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: ColorFilterGroup.kt */
/* renamed from: com.nextreaming.nexeditorui.e */
/* loaded from: classes.dex */
public final class C2304e implements com.nexstreaming.kinemaster.ui.d.n {

    /* renamed from: a */
    private ArrayList<C2302d> f24235a;

    /* renamed from: b */
    private final int f24236b;

    /* renamed from: c */
    private final boolean f24237c;

    /* renamed from: d */
    private final String f24238d;

    /* renamed from: e */
    private final Bitmap f24239e;

    /* renamed from: f */
    private final int f24240f;

    public C2304e(int i, boolean z, String str, Bitmap bitmap, int i2) {
        kotlin.jvm.internal.h.b(str, "title");
        this.f24236b = i;
        this.f24237c = z;
        this.f24238d = str;
        this.f24239e = bitmap;
        this.f24240f = i2;
        this.f24235a = new ArrayList<>();
    }

    public final void a(C2302d c2302d) {
        kotlin.jvm.internal.h.b(c2302d, "effect");
        this.f24235a.add(c2302d);
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public int b() {
        return this.f24240f;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public Bitmap c() {
        return this.f24239e;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public boolean d() {
        return this.f24237c;
    }

    public final ArrayList<C2302d> e() {
        return this.f24235a;
    }

    public final List<C2302d> f() {
        return this.f24235a;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public String getTitle() {
        return this.f24238d;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public int getType() {
        return this.f24236b;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.n
    public ArrayList<com.nexstreaming.kinemaster.ui.d.f> a() {
        ArrayList<C2302d> arrayList = this.f24235a;
        if (arrayList != null) {
            return arrayList;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.nexstreaming.kinemaster.ui.optiongroup.OptionChildInterface> /* = java.util.ArrayList<com.nexstreaming.kinemaster.ui.optiongroup.OptionChildInterface> */");
    }
}
