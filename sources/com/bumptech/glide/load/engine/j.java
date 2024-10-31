package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f8917a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f8918b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f8919c = new int[EncodeStrategy.values().length];

    static {
        try {
            f8919c[EncodeStrategy.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8919c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f8918b = new int[DecodeJob.Stage.values().length];
        try {
            f8918b[DecodeJob.Stage.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8918b[DecodeJob.Stage.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f8918b[DecodeJob.Stage.SOURCE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f8918b[DecodeJob.Stage.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f8918b[DecodeJob.Stage.INITIALIZE.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        f8917a = new int[DecodeJob.RunReason.values().length];
        try {
            f8917a[DecodeJob.RunReason.INITIALIZE.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f8917a[DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f8917a[DecodeJob.RunReason.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
