package com.google.android.gms.vision;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Frame {

    /* renamed from: a, reason: collision with root package name */
    private Metadata f2250a;
    private ByteBuffer b;
    private Bitmap c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Frame f2251a = new Frame();
    }

    /* loaded from: classes.dex */
    public static class Metadata {
    }

    private Frame() {
        this.f2250a = new Metadata();
        this.b = null;
        this.c = null;
    }
}
