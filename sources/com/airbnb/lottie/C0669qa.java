package com.airbnb.lottie;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.qa */
/* loaded from: classes.dex */
public class C0669qa {

    /* renamed from: a */
    private final List<AbstractC0677v<?, Path>> f7808a;

    /* renamed from: b */
    private final List<Mask> f7809b;

    public C0669qa(List<Mask> list) {
        this.f7809b = list;
        this.f7808a = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f7808a.add(list.get(i).b().a());
        }
    }

    public List<AbstractC0677v<?, Path>> a() {
        return this.f7808a;
    }

    public List<Mask> b() {
        return this.f7809b;
    }
}
