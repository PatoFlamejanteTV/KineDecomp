package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmx;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@zzgr
/* loaded from: classes.dex */
public class zza {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f654a = new Handler(Looper.getMainLooper());

    private void a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, int i, int i2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setBackgroundColor(i2);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i);
        int a2 = a(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(adSizeParcel.g - a2, adSizeParcel.d - a2, 17));
        viewGroup.addView(frameLayout, adSizeParcel.g, adSizeParcel.d);
    }

    public int a(Context context, int i) {
        return a(context.getResources().getDisplayMetrics(), i);
    }

    public int a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    public String a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || a()) {
            string = "emulator";
        }
        return a(string);
    }

    public String a(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public void a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str) {
        a(viewGroup, adSizeParcel, str, -16777216, -1);
    }

    public void a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, String str2) {
        zzb.e(str2);
        a(viewGroup, adSizeParcel, str, -65536, -16777216);
    }

    public boolean a() {
        return Build.DEVICE.startsWith("generic");
    }

    public int b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return b(displayMetrics, i);
    }

    public int b(DisplayMetrics displayMetrics, int i) {
        return Math.round(i / displayMetrics.density);
    }

    public boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean b(Context context) {
        return GooglePlayServicesUtil.a(context) == 0;
    }

    public boolean c(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    public boolean d(Context context) {
        int intValue;
        int intValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (zzmx.zzqz()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public int e(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
