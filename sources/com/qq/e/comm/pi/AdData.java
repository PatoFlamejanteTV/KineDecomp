package com.qq.e.comm.pi;

/* loaded from: classes3.dex */
public interface AdData {

    /* loaded from: classes3.dex */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();
}
