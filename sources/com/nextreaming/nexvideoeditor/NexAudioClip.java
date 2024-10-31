package com.nextreaming.nexvideoeditor;

import java.util.Arrays;

/* loaded from: classes3.dex */
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
    public String mEnhancedAudioFilter;
    public String mEqualizer;
    public int mKeepPitch;
    public int mMusicEffector;
    public int mPanLeft;
    public int mPanRight;
    public int mPitchFactor;
    public int mProcessorStrength;
    public int mSpeedControl;
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
        this.mSpeedControl = 100;
        this.mKeepPitch = 1;
        this.mEnhancedAudioFilter = null;
        this.mEqualizer = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NexAudioClip.class != obj.getClass()) {
            return false;
        }
        NexAudioClip nexAudioClip = (NexAudioClip) obj;
        if (this.mClipID != nexAudioClip.mClipID || this.mVisualClipID != nexAudioClip.mVisualClipID || this.mClipType != nexAudioClip.mClipType || this.mTotalTime != nexAudioClip.mTotalTime || this.mStartTime != nexAudioClip.mStartTime || this.mEndTime != nexAudioClip.mEndTime || this.mStartTrimTime != nexAudioClip.mStartTrimTime || this.mEndTrimTime != nexAudioClip.mEndTrimTime || this.mAudioOnOff != nexAudioClip.mAudioOnOff || this.mAutoEnvelop != nexAudioClip.mAutoEnvelop || this.mClipVolume != nexAudioClip.mClipVolume || this.mVoiceChanger != nexAudioClip.mVoiceChanger || this.mCompressor != nexAudioClip.mCompressor || this.mPitchFactor != nexAudioClip.mPitchFactor || this.mMusicEffector != nexAudioClip.mMusicEffector || this.mProcessorStrength != nexAudioClip.mProcessorStrength || this.mBassStrength != nexAudioClip.mBassStrength || this.mPanLeft != nexAudioClip.mPanLeft || this.mPanRight != nexAudioClip.mPanRight || this.mSpeedControl != nexAudioClip.mSpeedControl || this.mKeepPitch != nexAudioClip.mKeepPitch || !this.mClipPath.equals(nexAudioClip.mClipPath) || !Arrays.equals(this.mVolumeEnvelopeLevel, nexAudioClip.mVolumeEnvelopeLevel) || !Arrays.equals(this.mVolumeEnvelopeTime, nexAudioClip.mVolumeEnvelopeTime)) {
            return false;
        }
        String str = this.mEqualizer;
        if (str == null ? nexAudioClip.mEqualizer != null : !str.equals(nexAudioClip.mEqualizer)) {
            return false;
        }
        String str2 = this.mEnhancedAudioFilter;
        if (str2 != null) {
            if (str2.equals(nexAudioClip.mEnhancedAudioFilter)) {
                return true;
            }
        } else if (nexAudioClip.mEnhancedAudioFilter == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.mClipID * 31) + this.mVisualClipID) * 31) + this.mClipType) * 31) + this.mTotalTime) * 31) + this.mStartTime) * 31) + this.mEndTime) * 31) + this.mStartTrimTime) * 31) + this.mEndTrimTime) * 31) + this.mClipPath.hashCode()) * 31) + this.mAudioOnOff) * 31) + this.mAutoEnvelop) * 31) + this.mClipVolume) * 31;
        int[] iArr = this.mVolumeEnvelopeLevel;
        int hashCode2 = (hashCode + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        int[] iArr2 = this.mVolumeEnvelopeTime;
        int hashCode3 = (((((((((((((((((((((hashCode2 + (iArr2 != null ? Arrays.hashCode(iArr2) : 0)) * 31) + this.mVoiceChanger) * 31) + this.mCompressor) * 31) + this.mPitchFactor) * 31) + this.mMusicEffector) * 31) + this.mProcessorStrength) * 31) + this.mBassStrength) * 31) + this.mPanLeft) * 31) + this.mPanRight) * 31) + this.mSpeedControl) * 31) + this.mKeepPitch) * 31;
        String str = this.mEqualizer;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mEnhancedAudioFilter;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public NexAudioClip(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, 0);
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
        this.mClipVolume = i10;
        this.mVoiceChanger = i11;
        this.mCompressor = 0;
        this.mPitchFactor = 0;
        this.mMusicEffector = 0;
        this.mProcessorStrength = -1;
        this.mBassStrength = -1;
        this.mPanLeft = -111;
        this.mPanRight = -111;
        this.mSpeedControl = 100;
        this.mKeepPitch = 1;
    }

    public NexAudioClip(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
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
        this.mVoiceChanger = i12;
        this.mCompressor = 0;
        this.mPitchFactor = 0;
        this.mMusicEffector = 0;
        this.mProcessorStrength = -1;
        this.mBassStrength = -1;
        this.mPanLeft = -111;
        this.mPanRight = -111;
        this.mSpeedControl = 100;
        this.mKeepPitch = 1;
    }
}
