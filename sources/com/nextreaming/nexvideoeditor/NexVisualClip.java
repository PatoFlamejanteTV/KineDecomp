package com.nextreaming.nexvideoeditor;

import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes3.dex */
public final class NexVisualClip {
    public String mClipEffectID;
    public String mClipPath;
    public String mFilterID;
    public int mManualVolumeControl;
    public String mThumbnailPath;
    public String mTitle;
    public String mTitleEffectID;
    public int mClipID = 0;
    public int mClipType = 0;
    public int mTotalAudioTime = 0;
    public int mTotalVideoTime = 0;
    public int mTotalTime = 0;
    public int mStartTime = 0;
    public int mEndTime = 0;
    public int mStartTrimTime = 0;
    public int mEndTrimTime = 0;
    public int mWidth = 0;
    public int mHeight = 0;
    public int mExistVideo = 0;
    public int mExistAudio = 0;
    public int mTitleStyle = 0;
    public int mTitleStartTime = 0;
    public int mTitleEndTime = 0;
    public NexRectangle mStartRect = new NexRectangle(0, 0, 0, 0);
    public NexRectangle mEndRect = new NexRectangle(0, 0, 0, 0);
    public NexRectangle mDestRect = new NexRectangle(0, 0, 0, 0);
    public int mAudioOnOff = 0;
    public int mClipVolume = 0;
    public int mBGMVolume = 0;
    public int mRotateState = 0;
    public int mBrightness = 0;
    public int mContrast = 0;
    public int mSaturation = 0;
    public int mTintcolor = 0;
    public int mHue = 0;
    public int mCustomLUT_A = 0;
    public int mCustomLUT_B = 0;
    public int mCustomLUT_Power = 0;
    public int mLUT = 0;
    public int mVignette = 0;
    public int mSpeedControl = 0;
    public int mKeepPitch = 0;
    public int mVoiceChanger = 0;
    public int mCompressor = 0;
    public int mPitchFactor = 0;
    public int mMusicEffector = 0;
    public int mProcessorStrength = -1;
    public int mBassStrength = -1;
    public int mPanLeft = -111;
    public int mPanRight = -111;
    public int mEffectDuration = 0;
    public int mEffectOffset = 0;
    public int mEffectOverlap = 0;
    public int[] mVolumeEnvelopeLevel = null;
    public int[] mVolumeEnvelopeTime = null;
    public float[] mStartMatrix = null;
    public float[] mEndMatrix = null;
    public int mSlowMotion = 0;
    public int mMotionTracked = 0;
    Vector<NexAudioClip> mAudioClipVec = new Vector<>();
    public int mFreezeDuration = 0;
    public int mIframePlay = 0;
    public String mEnhancedAudioFilter = null;
    public String mEqualizer = null;

    public int addAudioClip(NexAudioClip nexAudioClip) {
        this.mAudioClipVec.add(nexAudioClip);
        return 0;
    }

    public void clearAudioClips() {
        this.mAudioClipVec.clear();
    }

    public void deleteAudioClip(int i) {
        for (int i2 = 0; i2 < this.mAudioClipVec.size(); i2++) {
            if (this.mAudioClipVec.get(i2).mClipID == i) {
                this.mAudioClipVec.remove(i2);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NexVisualClip.class != obj.getClass()) {
            return false;
        }
        NexVisualClip nexVisualClip = (NexVisualClip) obj;
        if (this.mClipID != nexVisualClip.mClipID || this.mClipType != nexVisualClip.mClipType || this.mTotalAudioTime != nexVisualClip.mTotalAudioTime || this.mTotalVideoTime != nexVisualClip.mTotalVideoTime || this.mTotalTime != nexVisualClip.mTotalTime || this.mStartTime != nexVisualClip.mStartTime || this.mEndTime != nexVisualClip.mEndTime || this.mStartTrimTime != nexVisualClip.mStartTrimTime || this.mEndTrimTime != nexVisualClip.mEndTrimTime || this.mWidth != nexVisualClip.mWidth || this.mHeight != nexVisualClip.mHeight || this.mExistVideo != nexVisualClip.mExistVideo || this.mExistAudio != nexVisualClip.mExistAudio || this.mTitleStyle != nexVisualClip.mTitleStyle || this.mTitleStartTime != nexVisualClip.mTitleStartTime || this.mTitleEndTime != nexVisualClip.mTitleEndTime || this.mAudioOnOff != nexVisualClip.mAudioOnOff || this.mClipVolume != nexVisualClip.mClipVolume || this.mBGMVolume != nexVisualClip.mBGMVolume || this.mRotateState != nexVisualClip.mRotateState || this.mBrightness != nexVisualClip.mBrightness || this.mContrast != nexVisualClip.mContrast || this.mSaturation != nexVisualClip.mSaturation || this.mHue != nexVisualClip.mHue || this.mTintcolor != nexVisualClip.mTintcolor || this.mLUT != nexVisualClip.mLUT || this.mCustomLUT_A != nexVisualClip.mCustomLUT_A || this.mCustomLUT_B != nexVisualClip.mCustomLUT_B || this.mCustomLUT_Power != nexVisualClip.mCustomLUT_Power || this.mVignette != nexVisualClip.mVignette || this.mSpeedControl != nexVisualClip.mSpeedControl || this.mKeepPitch != nexVisualClip.mKeepPitch || this.mVoiceChanger != nexVisualClip.mVoiceChanger || this.mEffectDuration != nexVisualClip.mEffectDuration || this.mEffectOffset != nexVisualClip.mEffectOffset || this.mEffectOverlap != nexVisualClip.mEffectOverlap || this.mCompressor != nexVisualClip.mCompressor || this.mPitchFactor != nexVisualClip.mPitchFactor || this.mMusicEffector != nexVisualClip.mMusicEffector || this.mProcessorStrength != nexVisualClip.mProcessorStrength || this.mBassStrength != nexVisualClip.mBassStrength || this.mManualVolumeControl != nexVisualClip.mManualVolumeControl || this.mPanLeft != nexVisualClip.mPanLeft || this.mPanRight != nexVisualClip.mPanRight || this.mSlowMotion != nexVisualClip.mSlowMotion || this.mMotionTracked != nexVisualClip.mMotionTracked) {
            return false;
        }
        String str = this.mTitle;
        if (str == null ? nexVisualClip.mTitle != null : !str.equals(nexVisualClip.mTitle)) {
            return false;
        }
        String str2 = this.mClipEffectID;
        if (str2 == null ? nexVisualClip.mClipEffectID != null : !str2.equals(nexVisualClip.mClipEffectID)) {
            return false;
        }
        String str3 = this.mTitleEffectID;
        if (str3 == null ? nexVisualClip.mTitleEffectID != null : !str3.equals(nexVisualClip.mTitleEffectID)) {
            return false;
        }
        String str4 = this.mFilterID;
        if (str4 == null ? nexVisualClip.mFilterID != null : !str4.equals(nexVisualClip.mFilterID)) {
            return false;
        }
        NexRectangle nexRectangle = this.mStartRect;
        if (nexRectangle == null ? nexVisualClip.mStartRect != null : !nexRectangle.equals(nexVisualClip.mStartRect)) {
            return false;
        }
        NexRectangle nexRectangle2 = this.mEndRect;
        if (nexRectangle2 == null ? nexVisualClip.mEndRect != null : !nexRectangle2.equals(nexVisualClip.mEndRect)) {
            return false;
        }
        NexRectangle nexRectangle3 = this.mDestRect;
        if (nexRectangle3 == null ? nexVisualClip.mDestRect != null : !nexRectangle3.equals(nexVisualClip.mDestRect)) {
            return false;
        }
        if (!Arrays.equals(this.mStartMatrix, nexVisualClip.mStartMatrix) || !Arrays.equals(this.mEndMatrix, nexVisualClip.mEndMatrix) || !this.mClipPath.equals(nexVisualClip.mClipPath)) {
            return false;
        }
        String str5 = this.mThumbnailPath;
        if (str5 == null ? nexVisualClip.mThumbnailPath != null : !str5.equals(nexVisualClip.mThumbnailPath)) {
            return false;
        }
        if (!Arrays.equals(this.mVolumeEnvelopeLevel, nexVisualClip.mVolumeEnvelopeLevel) || !Arrays.equals(this.mVolumeEnvelopeTime, nexVisualClip.mVolumeEnvelopeTime) || this.mFreezeDuration != nexVisualClip.mFreezeDuration || this.mIframePlay != nexVisualClip.mIframePlay) {
            return false;
        }
        String str6 = this.mEnhancedAudioFilter;
        if (str6 == null ? nexVisualClip.mEnhancedAudioFilter != null : !str6.equals(nexVisualClip.mEnhancedAudioFilter)) {
            return false;
        }
        String str7 = this.mEqualizer;
        if (str7 == null ? nexVisualClip.mEqualizer != null : !str7.equals(nexVisualClip.mEqualizer)) {
            return false;
        }
        Vector<NexAudioClip> vector = this.mAudioClipVec;
        if (vector != null) {
            if (vector.equals(nexVisualClip.mAudioClipVec)) {
                return true;
            }
        } else if (nexVisualClip.mAudioClipVec == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = ((((((((((((((((((((((((this.mClipID * 31) + this.mClipType) * 31) + this.mTotalAudioTime) * 31) + this.mTotalVideoTime) * 31) + this.mTotalTime) * 31) + this.mStartTime) * 31) + this.mEndTime) * 31) + this.mStartTrimTime) * 31) + this.mEndTrimTime) * 31) + this.mWidth) * 31) + this.mHeight) * 31) + this.mExistVideo) * 31) + this.mExistAudio) * 31;
        String str = this.mTitle;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.mTitleStyle) * 31) + this.mTitleStartTime) * 31) + this.mTitleEndTime) * 31) + this.mAudioOnOff) * 31) + this.mClipVolume) * 31) + this.mBGMVolume) * 31) + this.mRotateState) * 31) + this.mBrightness) * 31) + this.mContrast) * 31) + this.mSaturation) * 31) + this.mHue) * 31) + this.mTintcolor) * 31) + this.mLUT) * 31) + this.mCustomLUT_A) * 31) + this.mCustomLUT_B) * 31) + this.mCustomLUT_Power) * 31) + this.mVignette) * 31) + this.mSpeedControl) * 31) + this.mKeepPitch) * 31) + this.mVoiceChanger) * 31) + this.mEffectDuration) * 31) + this.mEffectOffset) * 31) + this.mEffectOverlap) * 31;
        String str2 = this.mClipEffectID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mTitleEffectID;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mFilterID;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        NexRectangle nexRectangle = this.mStartRect;
        int hashCode5 = (hashCode4 + (nexRectangle != null ? nexRectangle.hashCode() : 0)) * 31;
        NexRectangle nexRectangle2 = this.mEndRect;
        int hashCode6 = (hashCode5 + (nexRectangle2 != null ? nexRectangle2.hashCode() : 0)) * 31;
        NexRectangle nexRectangle3 = this.mDestRect;
        int hashCode7 = (hashCode6 + (nexRectangle3 != null ? nexRectangle3.hashCode() : 0)) * 31;
        float[] fArr = this.mStartMatrix;
        int hashCode8 = (hashCode7 + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31;
        float[] fArr2 = this.mEndMatrix;
        int hashCode9 = (((hashCode8 + (fArr2 != null ? Arrays.hashCode(fArr2) : 0)) * 31) + this.mClipPath.hashCode()) * 31;
        String str5 = this.mThumbnailPath;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        int[] iArr = this.mVolumeEnvelopeLevel;
        int hashCode11 = (hashCode10 + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        int[] iArr2 = this.mVolumeEnvelopeTime;
        int hashCode12 = (hashCode11 + (iArr2 != null ? Arrays.hashCode(iArr2) : 0)) * 31;
        String str6 = this.mEnhancedAudioFilter;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mEqualizer;
        int hashCode14 = (((((((((((((((((((((hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.mCompressor) * 31) + this.mPitchFactor) * 31) + this.mMusicEffector) * 31) + this.mProcessorStrength) * 31) + this.mBassStrength) * 31) + this.mManualVolumeControl) * 31) + this.mPanLeft) * 31) + this.mPanRight) * 31) + this.mSlowMotion) * 31) + this.mMotionTracked) * 31;
        Vector<NexAudioClip> vector = this.mAudioClipVec;
        return ((((hashCode14 + (vector != null ? vector.hashCode() : 0)) * 31) + this.mFreezeDuration) * 31) + this.mIframePlay;
    }

    public void setDestRect(int i, int i2, int i3, int i4) {
        this.mDestRect.setRect(i, i2, i3, i4);
    }

    public void setEndRect(int i, int i2, int i3, int i4) {
        this.mEndRect.setRect(i, i2, i3, i4);
    }

    public void setStartRect(int i, int i2, int i3, int i4) {
        this.mStartRect.setRect(i, i2, i3, i4);
    }
}
