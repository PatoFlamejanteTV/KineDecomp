package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: VolumeEnvelopeInterface.java */
/* loaded from: classes2.dex */
public interface Vh {
    void addVolumeEnvelope(int i, int i2, int i3);

    void changeVolumeLevel(int i, int i2);

    int getDiffAVDuration();

    int getEndEnvelopeTime();

    int getVolumeEnvelopeLength();

    int getVolumeEnvelopeLevel(int i);

    int getVolumeEnvelopeTime(int i);

    int getVolumeEnvelopeTimeAdj(int i);

    int getVolumeEnvelopeTimeForDrawing(int i);

    void removeVolumeEnvelope(int i);
}
