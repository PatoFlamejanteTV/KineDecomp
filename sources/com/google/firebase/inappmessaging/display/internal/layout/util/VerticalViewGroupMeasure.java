package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class VerticalViewGroupMeasure {

    /* renamed from: a */
    private List<ViewMeasure> f17694a = new ArrayList();

    /* renamed from: b */
    private int f17695b = 0;

    /* renamed from: c */
    private int f17696c = 0;

    public void a(int i, int i2) {
        this.f17695b = i;
        this.f17696c = i2;
        this.f17694a = new ArrayList();
    }

    public int b() {
        Iterator<ViewMeasure> it = this.f17694a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().a();
        }
        return i;
    }

    public List<ViewMeasure> c() {
        return this.f17694a;
    }

    public void a(View view, boolean z) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z);
        viewMeasure.b(this.f17695b, this.f17696c);
        this.f17694a.add(viewMeasure);
    }

    public int a() {
        int i = 0;
        for (ViewMeasure viewMeasure : this.f17694a) {
            if (!viewMeasure.d()) {
                i += viewMeasure.a();
            }
        }
        return i;
    }

    public void a(int i) {
        float f2;
        ArrayList<ViewMeasure> arrayList = new ArrayList();
        for (ViewMeasure viewMeasure : this.f17694a) {
            if (viewMeasure.d()) {
                arrayList.add(viewMeasure);
            }
        }
        Collections.sort(arrayList, new a(this));
        int i2 = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i2 += ((ViewMeasure) it.next()).a();
        }
        if (arrayList.size() < 6) {
            float f3 = 1.0f - ((r2 - 1) * 0.2f);
            Logging.a("VVGM (minFrac, maxFrac)", 0.2f, f3);
            float f4 = 0.0f;
            for (ViewMeasure viewMeasure2 : arrayList) {
                float a2 = viewMeasure2.a() / i2;
                if (a2 > f3) {
                    f4 += a2 - f3;
                    f2 = f3;
                } else {
                    f2 = a2;
                }
                if (a2 < 0.2f) {
                    float min = Math.min(0.2f - a2, f4);
                    f4 -= min;
                    f2 = a2 + min;
                }
                Logging.a("\t(desired, granted)", a2, f2);
                viewMeasure2.b(this.f17695b, (int) (f2 * i));
            }
            return;
        }
        throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
    }
}
