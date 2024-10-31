package com.nexstreaming.app.general.util;

import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: TextLoader.java */
/* loaded from: classes2.dex */
public class L {
    public static void a(int i, TextView textView) {
        new K(textView.getResources().openRawResource(i), new WeakReference(textView)).execute(new Void[0]);
    }
}
