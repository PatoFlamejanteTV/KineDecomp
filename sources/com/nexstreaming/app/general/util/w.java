package com.nexstreaming.app.general.util;

import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: TextLoader.java */
/* loaded from: classes.dex */
public class w {
    public static void a(int i, TextView textView) {
        new x(textView.getResources().openRawResource(i), new WeakReference(textView)).execute(new Void[0]);
    }
}
