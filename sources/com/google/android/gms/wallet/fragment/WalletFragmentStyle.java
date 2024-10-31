package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class WalletFragmentStyle implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f2313a;
    Bundle b;
    int c;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BuyButtonAppearance {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BuyButtonText {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Dimension {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LogoImageType {
    }

    public WalletFragmentStyle() {
        this.f2313a = 1;
        this.b = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.f2313a = i;
        this.b = bundle;
        this.c = i2;
    }

    private static int a(long j, DisplayMetrics displayMetrics) {
        int i;
        int i2 = (int) (j >>> 32);
        int i3 = (int) j;
        switch (i2) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 128:
                return TypedValue.complexToDimensionPixelSize(i3, displayMetrics);
            case 129:
                return i3;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i2);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i3), displayMetrics));
    }

    private static long a(int i, float f) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return a(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    private static long a(int i, int i2) {
        return (i << 32) | (i2 & 4294967295L);
    }

    private static long a(TypedValue typedValue) {
        switch (typedValue.type) {
            case 5:
                return a(128, typedValue.data);
            case 16:
                return b(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    private void a(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (this.b.containsKey(str) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.b.putLong(str, a(peekValue));
    }

    private void a(TypedArray typedArray, int i, String str, String str2) {
        TypedValue peekValue;
        if (this.b.containsKey(str) || this.b.containsKey(str2) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        if (peekValue.type < 28 || peekValue.type > 31) {
            this.b.putInt(str2, peekValue.resourceId);
        } else {
            this.b.putInt(str, peekValue.data);
        }
    }

    private static long b(int i) {
        if (i >= 0) {
            return a(0, i);
        }
        if (i == -1 || i == -2) {
            return a(129, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    private void b(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (this.b.containsKey(str) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.b.putInt(str, peekValue.data);
    }

    public int a(String str, DisplayMetrics displayMetrics, int i) {
        return this.b.containsKey(str) ? a(this.b.getLong(str), displayMetrics) : i;
    }

    public WalletFragmentStyle a(int i) {
        this.c = i;
        return this;
    }

    public void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.c <= 0 ? R.style.WalletFragmentDefaultStyle : this.c, R.styleable.WalletFragmentStyle);
        a(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        a(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        a(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        a(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        b(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
