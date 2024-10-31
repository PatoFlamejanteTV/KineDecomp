package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class HybridADSetting implements Parcelable {
    public static final Parcelable.Creator<HybridADSetting> CREATOR = new Parcelable.Creator<HybridADSetting>() { // from class: com.qq.e.ads.hybrid.HybridADSetting.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting[] newArray(int i) {
            return new HybridADSetting[i];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: a */
    private int f24839a;

    /* renamed from: b */
    private int f24840b;

    /* renamed from: c */
    private int f24841c;

    /* renamed from: d */
    private int f24842d;

    /* renamed from: e */
    private int f24843e;

    /* renamed from: f */
    private String f24844f;

    /* renamed from: g */
    private String f24845g;

    /* renamed from: h */
    private String f24846h;
    private int i;
    private int j;

    /* renamed from: com.qq.e.ads.hybrid.HybridADSetting$1 */
    /* loaded from: classes3.dex */
    static class AnonymousClass1 implements Parcelable.Creator<HybridADSetting> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting[] newArray(int i) {
            return new HybridADSetting[i];
        }
    }

    public HybridADSetting() {
        this.f24839a = 1;
        this.f24840b = 44;
        this.f24841c = -1;
        this.f24842d = -14013133;
        this.f24843e = 16;
        this.i = -1776153;
        this.j = 16;
    }

    protected HybridADSetting(Parcel parcel) {
        this.f24839a = 1;
        this.f24840b = 44;
        this.f24841c = -1;
        this.f24842d = -14013133;
        this.f24843e = 16;
        this.i = -1776153;
        this.j = 16;
        this.f24839a = parcel.readInt();
        this.f24840b = parcel.readInt();
        this.f24841c = parcel.readInt();
        this.f24842d = parcel.readInt();
        this.f24843e = parcel.readInt();
        this.f24844f = parcel.readString();
        this.f24845g = parcel.readString();
        this.f24846h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f24845g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f24846h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f24845g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f24846h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f24844f;
    }

    public int getTitleBarColor() {
        return this.f24841c;
    }

    public int getTitleBarHeight() {
        return this.f24840b;
    }

    public int getTitleColor() {
        return this.f24842d;
    }

    public int getTitleSize() {
        return this.f24843e;
    }

    public int getType() {
        return this.f24839a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f24844f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f24841c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f24840b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f24842d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f24843e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f24839a = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24839a);
        parcel.writeInt(this.f24840b);
        parcel.writeInt(this.f24841c);
        parcel.writeInt(this.f24842d);
        parcel.writeInt(this.f24843e);
        parcel.writeString(this.f24844f);
        parcel.writeString(this.f24845g);
        parcel.writeString(this.f24846h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
