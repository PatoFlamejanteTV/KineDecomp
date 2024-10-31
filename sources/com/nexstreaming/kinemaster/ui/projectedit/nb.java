package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: VolumeEnvelopeInterface.java */
/* loaded from: classes.dex */
public interface nb {
    void addVolumeEnvelope(int i, int i2, int i3);

    void changeVolumeLevel(int i, int i2);

    int getDiffAVDuration();

    int getEndEnvelopeTime();

    int getVolumeEnvelopeLength();

    int getVolumeEnvelopeLevel(int i);

    int getVolumeEnvelopeTimeAdj(int i);

    void removeVolumeEnvelope(int i);
}
