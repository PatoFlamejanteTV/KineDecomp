package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public /* synthetic */ class t {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20831a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f20832b = new int[MediaSupportType.values().length];

    static {
        try {
            f20832b[MediaSupportType.NeedTranscodeAVSync.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20832b[MediaSupportType.NeedTranscodeFPS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20832b[MediaSupportType.NeedTranscodeRes.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f20831a = new int[MediaPrepManager.FailType.values().length];
        try {
            f20831a[MediaPrepManager.FailType.Download.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20831a[MediaPrepManager.FailType.Transcoding.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f20831a[MediaPrepManager.FailType.Other.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
