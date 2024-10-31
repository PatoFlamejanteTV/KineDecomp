package com.google.android.gms.vision;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CameraSource {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2247a = new Object();
    private int b = 0;
    private float c = 30.0f;
    private int d = 1024;
    private int e = 768;
    private Map<byte[], ByteBuffer> f = new HashMap();

    /* loaded from: classes.dex */
    public static class Builder {
    }

    /* loaded from: classes.dex */
    public interface PictureCallback {
    }

    /* loaded from: classes.dex */
    public interface ShutterCallback {
    }

    private CameraSource() {
    }
}
