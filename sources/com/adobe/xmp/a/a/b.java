package com.adobe.xmp.a.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: XMPPath.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private List f7497a = new ArrayList(5);

    public void a(d dVar) {
        this.f7497a.add(dVar);
    }

    public String toString() {
        int b2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < a(); i++) {
            stringBuffer.append(a(i));
            if (i < a() - 1 && ((b2 = a(i + 1).b()) == 1 || b2 == 2)) {
                stringBuffer.append('/');
            }
        }
        return stringBuffer.toString();
    }

    public d a(int i) {
        return (d) this.f7497a.get(i);
    }

    public int a() {
        return this.f7497a.size();
    }
}
