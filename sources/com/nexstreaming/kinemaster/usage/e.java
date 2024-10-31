package com.nexstreaming.kinemaster.usage;

import com.nextreaming.nexeditorui.NexAudioClipItem;

/* compiled from: KMUsage.java */
/* loaded from: classes2.dex */
/* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f23943a = new int[NexAudioClipItem.AudioType.values().length];

    static {
        try {
            f23943a[NexAudioClipItem.AudioType.BackgroundAudio.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23943a[NexAudioClipItem.AudioType.ExtractedAudio.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23943a[NexAudioClipItem.AudioType.Music.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f23943a[NexAudioClipItem.AudioType.VoiceRecording.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f23943a[NexAudioClipItem.AudioType.PendingVoiceRecording.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
