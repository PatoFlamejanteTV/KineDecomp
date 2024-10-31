package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

/* loaded from: classes2.dex */
public final /* synthetic */ class k {

    /* renamed from: a */
    public static final /* synthetic */ int[] f22238a = new int[AudioPlayStatus.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f22239b;

    /* renamed from: c */
    public static final /* synthetic */ int[] f22240c;

    static {
        f22238a[AudioPlayStatus.PLAY.ordinal()] = 1;
        f22238a[AudioPlayStatus.PENDING.ordinal()] = 2;
        f22238a[AudioPlayStatus.STOP.ordinal()] = 3;
        f22239b = new int[AudioPlayStatus.values().length];
        f22239b[AudioPlayStatus.PLAY.ordinal()] = 1;
        f22239b[AudioPlayStatus.PENDING.ordinal()] = 2;
        f22239b[AudioPlayStatus.STOP.ordinal()] = 3;
        f22240c = new int[AudioEffectType.values().length];
        f22240c[AudioEffectType.VOICE_CHANGER.ordinal()] = 1;
        f22240c[AudioEffectType.EQ.ordinal()] = 2;
        f22240c[AudioEffectType.NORMAL.ordinal()] = 3;
    }
}
