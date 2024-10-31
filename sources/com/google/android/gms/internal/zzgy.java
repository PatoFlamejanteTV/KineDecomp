package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;

@zzgr
/* loaded from: classes.dex */
public final class zzgy {
    public final int zzEx;
    public final int zzEy;
    public final float zzEz;
    public final boolean zzGA;
    public final String zzGB;
    public final String zzGC;
    public final int zzGD;
    public final int zzGE;
    public final int zzGF;
    public final int zzGG;
    public final int zzGH;
    public final int zzGI;
    public final double zzGJ;
    public final boolean zzGK;
    public final boolean zzGL;
    public final int zzGM;
    public final String zzGN;
    public final int zzGs;
    public final boolean zzGt;
    public final boolean zzGu;
    public final String zzGv;
    public final String zzGw;
    public final boolean zzGx;
    public final boolean zzGy;
    public final boolean zzGz;

    /* loaded from: classes.dex */
    public static final class zza {
        private int zzEx;
        private int zzEy;
        private float zzEz;
        private boolean zzGA;
        private String zzGB;
        private String zzGC;
        private int zzGD;
        private int zzGE;
        private int zzGF;
        private int zzGG;
        private int zzGH;
        private int zzGI;
        private double zzGJ;
        private boolean zzGK;
        private boolean zzGL;
        private int zzGM;
        private String zzGN;
        private int zzGs;
        private boolean zzGt;
        private boolean zzGu;
        private String zzGv;
        private String zzGw;
        private boolean zzGx;
        private boolean zzGy;
        private boolean zzGz;

        public zza(Context context) {
            DisplayMetrics displayMetrics;
            PackageManager packageManager = context.getPackageManager();
            zzz(context);
            zza(context, packageManager);
            zzA(context);
            Locale locale = Locale.getDefault();
            this.zzGt = zza(packageManager, "geo:0,0?q=donuts") != null;
            this.zzGu = zza(packageManager, "http://www.google.com") != null;
            this.zzGw = locale.getCountry();
            this.zzGx = com.google.android.gms.ads.internal.client.zzl.a().a();
            this.zzGy = GooglePlayServicesUtil.g(context);
            this.zzGB = locale.getLanguage();
            this.zzGC = zza(packageManager);
            Resources resources = context.getResources();
            if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
                return;
            }
            this.zzEz = displayMetrics.density;
            this.zzEx = displayMetrics.widthPixels;
            this.zzEy = displayMetrics.heightPixels;
        }

        public zza(Context context, zzgy zzgyVar) {
            PackageManager packageManager = context.getPackageManager();
            zzz(context);
            zza(context, packageManager);
            zzA(context);
            zzB(context);
            this.zzGt = zzgyVar.zzGt;
            this.zzGu = zzgyVar.zzGu;
            this.zzGw = zzgyVar.zzGw;
            this.zzGx = zzgyVar.zzGx;
            this.zzGy = zzgyVar.zzGy;
            this.zzGB = zzgyVar.zzGB;
            this.zzGC = zzgyVar.zzGC;
            this.zzEz = zzgyVar.zzEz;
            this.zzEx = zzgyVar.zzEx;
            this.zzEy = zzgyVar.zzEy;
        }

        private void zzA(Context context) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                this.zzGJ = -1.0d;
                this.zzGK = false;
            } else {
                int intExtra = registerReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
                this.zzGJ = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
                this.zzGK = intExtra == 2 || intExtra == 5;
            }
        }

        private void zzB(Context context) {
            this.zzGN = Build.FINGERPRINT;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        }

        private static String zza(PackageManager packageManager) {
            ActivityInfo activityInfo;
            ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (zza == null || (activityInfo = zza.activityInfo) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode + "." + activityInfo.packageName;
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzGv = telephonyManager.getNetworkOperator();
            this.zzGF = telephonyManager.getNetworkType();
            this.zzGG = telephonyManager.getPhoneType();
            this.zzGE = -2;
            this.zzGL = false;
            this.zzGM = -1;
            if (com.google.android.gms.ads.internal.zzp.e().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzGE = activeNetworkInfo.getType();
                    this.zzGM = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzGE = -1;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.zzGL = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void zzz(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.zzGs = audioManager.getMode();
            this.zzGz = audioManager.isMusicActive();
            this.zzGA = audioManager.isSpeakerphoneOn();
            this.zzGD = audioManager.getStreamVolume(3);
            this.zzGH = audioManager.getRingerMode();
            this.zzGI = audioManager.getStreamVolume(2);
        }

        public zzgy zzfX() {
            return new zzgy(this.zzGs, this.zzGt, this.zzGu, this.zzGv, this.zzGw, this.zzGx, this.zzGy, this.zzGz, this.zzGA, this.zzGB, this.zzGC, this.zzGD, this.zzGE, this.zzGF, this.zzGG, this.zzGH, this.zzGI, this.zzEz, this.zzEx, this.zzEy, this.zzGJ, this.zzGK, this.zzGL, this.zzGM, this.zzGN);
        }
    }

    zzgy(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5) {
        this.zzGs = i;
        this.zzGt = z;
        this.zzGu = z2;
        this.zzGv = str;
        this.zzGw = str2;
        this.zzGx = z3;
        this.zzGy = z4;
        this.zzGz = z5;
        this.zzGA = z6;
        this.zzGB = str3;
        this.zzGC = str4;
        this.zzGD = i2;
        this.zzGE = i3;
        this.zzGF = i4;
        this.zzGG = i5;
        this.zzGH = i6;
        this.zzGI = i7;
        this.zzEz = f;
        this.zzEx = i8;
        this.zzEy = i9;
        this.zzGJ = d;
        this.zzGK = z7;
        this.zzGL = z8;
        this.zzGM = i10;
        this.zzGN = str5;
    }
}
