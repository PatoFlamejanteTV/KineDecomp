package com.nextreaming.nexvideoeditor;

/* loaded from: classes.dex */
public final class NexAudioClip {
    public int mAudioOnOff;
    public int mAutoEnvelop;
    public int mBassStrength;
    public int mClipID;
    public String mClipPath;
    public int mClipType;
    public int mClipVolume;
    public int mCompressor;
    public int mEndTime;
    public int mEndTrimTime;
    public int mMusicEffector;
    public int mPanLeft;
    public int mPanRight;
    public int mPitchFactor;
    public int mProcessorStrength;
    public int mStartTime;
    public int mStartTrimTime;
    public int mTotalTime;
    public int mVisualClipID;
    public int mVoiceChanger;
    public int[] mVolumeEnvelopeLevel;
    public int[] mVolumeEnvelopeTime;

    public NexAudioClip() {
        this.mClipID = 0;
        this.mVisualClipID = 0;
        this.mClipType = 3;
        this.mTotalTime = 0;
        this.mStartTime = 0;
        this.mEndTime = 0;
        this.mStartTrimTime = 0;
        this.mEndTrimTime = 0;
        this.mAudioOnOff = 0;
        this.mAutoEnvelop = 0;
        this.mClipVolume = 0;
        this.mVolumeEnvelopeLevel = null;
        this.mVolumeEnvelopeTime = null;
        this.mVoiceChanger = 0;
        this.mCompressor = 0;
        this.mPitchFactor = 0;
        this.mMusicEffector = 0;
        this.mProcessorStrength = -1;
        this.mBassStrength = -1;
        this.mPanLeft = -111;
        this.mPanRight = -111;
    }

    public NexAudioClip(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mClipID = i;
        this.mVisualClipID = i2;
        this.mClipType = i3;
        this.mTotalTime = i4;
        this.mStartTime = i5;
        this.mEndTime = i6;
        this.mStartTrimTime = i7;
        this.mEndTrimTime = i8;
        this.mAudioOnOff = i9;
        this.mClipVolume = i10;
    }

    public NexAudioClip(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mClipID = i;
        this.mVisualClipID = i2;
        this.mClipType = i3;
        this.mTotalTime = i4;
        this.mStartTime = i5;
        this.mEndTime = i6;
        this.mStartTrimTime = i7;
        this.mEndTrimTime = i8;
        this.mAudioOnOff = i9;
        this.mAutoEnvelop = i10;
        this.mClipVolume = i11;
    }
}
