package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f2312a;
    private int b;
    private int c;
    private WalletFragmentStyle d;
    private int e;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    private WalletFragmentOptions() {
        this.f2312a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.f2312a = i;
        this.b = i2;
        this.c = i3;
        this.d = walletFragmentStyle;
        this.e = i4;
    }

    public static WalletFragmentOptions a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.c = i;
        walletFragmentOptions.b = i2;
        walletFragmentOptions.d = new WalletFragmentStyle().a(resourceId);
        walletFragmentOptions.d.a(context);
        walletFragmentOptions.e = i3;
        return walletFragmentOptions;
    }

    public int a() {
        return this.b;
    }

    public void a(Context context) {
        if (this.d != null) {
            this.d.a(context);
        }
    }

    public int b() {
        return this.c;
    }

    public WalletFragmentStyle c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
