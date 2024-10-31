package com.nexstreaming.app.general.nexasset.assetpackage;

import android.graphics.Color;
import java.util.Comparator;

/* compiled from: XMLItemDefReader.java */
/* loaded from: classes2.dex */
class w implements Comparator<Integer> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Integer num, Integer num2) {
        int red = Color.red(num.intValue()) + Color.green(num.intValue()) + Color.blue(num.intValue());
        int red2 = Color.red(num2.intValue()) + Color.green(num2.intValue()) + Color.blue(num2.intValue());
        if (red < red2) {
            return -1;
        }
        if (red > red2) {
            return 1;
        }
        if (num.intValue() < num2.intValue()) {
            return -1;
        }
        return num.intValue() > num2.intValue() ? 1 : 0;
    }
}
