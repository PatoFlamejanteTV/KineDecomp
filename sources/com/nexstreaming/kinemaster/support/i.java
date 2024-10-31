package com.nexstreaming.kinemaster.support;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.general.util.z;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* compiled from: SupportMailer.java */
/* loaded from: classes.dex */
public class i {
    public static void a(Activity activity, String str, File... fileArr) {
        a(activity, null, str, fileArr);
    }

    public static void a(Activity activity, g gVar, String str, File... fileArr) {
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("KineMaster Version: ").append(z.e(activity)).append("\n");
        sb.append("Android Version: ").append(Build.VERSION.RELEASE).append(" (").append(Build.VERSION.SDK_INT).append(")").append("\n");
        sb.append("Build.DEVICE: ").append(Build.DEVICE).append("\n");
        sb.append("Build.MODEL: ").append(Build.MODEL).append("\n");
        sb.append("Build.MANUFACTURER: ").append(Build.MANUFACTURER).append("\n");
        sb.append("Platform: ").append(z.g()).append("\n");
        sb.append("Ref: ").append(str).append("\n");
        sb.append("UID: ").append(KMUsage.getMixpanelInstance(activity).b()).append("\n");
        sb.append("Resource Qualifiers: ");
        Resources resources = activity.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        sb.append(configuration.locale.getLanguage().toLowerCase(Locale.US)).append(configuration.locale.getCountry().length() > 0 ? "-r" + configuration.locale.getCountry().toUpperCase(Locale.US) : "");
        sb.append(" sw").append(configuration.smallestScreenWidthDp).append("dp");
        sb.append(" ").append(configuration.screenWidthDp).append("x").append(configuration.screenHeightDp).append("dp ").append(displayMetrics.widthPixels).append("x").append(displayMetrics.heightPixels).append("px");
        switch (configuration.screenLayout & 15) {
            case 1:
                str2 = "small ";
                break;
            case 2:
                str2 = "normal ";
                break;
            case 3:
                str2 = "large ";
                break;
            case 4:
                str2 = "xlarge ";
                break;
            default:
                str2 = "unknown-screen-size ";
                break;
        }
        switch (configuration.screenLayout & 48) {
            case 16:
                str2 = str2 + "notlong ";
                break;
            case 32:
                str2 = str2 + "long ";
                break;
        }
        switch (configuration.orientation) {
            case 1:
                str2 = str2 + "port ";
                break;
            case 2:
                str2 = str2 + "land ";
                break;
        }
        sb.append(" ").append(str2);
        switch (activity.getResources().getDisplayMetrics().densityDpi) {
            case 120:
                str3 = "ldpi ";
                break;
            case 160:
                str3 = "mdpi ";
                break;
            case 213:
                str3 = "tvdpi ";
                break;
            case 240:
                str3 = "hdpi ";
                break;
            case 320:
                str3 = "xhdpi ";
                break;
            case 480:
                str3 = "xxhdpi ";
                break;
            case 640:
                str3 = "xxxhdpi ";
                break;
            default:
                str3 = "? ";
                break;
        }
        sb.append(" ").append(str3).append(" (").append(displayMetrics.densityDpi).append("dpi; scale=").append(displayMetrics.density).append("x) \n");
        sb.append("\n");
        sb.append(SupportLogger.f3223a.a());
        sb.append("\n\n");
        sb.append("Additional Comments:\n");
        if (gVar != null) {
            sb.append(gVar.c);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        if (gVar != null) {
            if (gVar.f != null && gVar.f.d != null) {
                str5 = gVar.f.d + "-" + gVar.d;
            } else {
                str5 = gVar.d;
            }
            str4 = "[KineMaster Support] [" + str5 + "] 3.5.4 / " + simpleDateFormat.format(date);
        } else {
            str4 = "[KineMaster Support] 3.5.4 / " + simpleDateFormat.format(date);
        }
        if (fileArr == null || fileArr.length < 1) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@kinemaster.com"});
            intent.putExtra("android.intent.extra.SUBJECT", str4);
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.EMAIL", new String[]{"support@kinemaster.com"});
        intent2.putExtra("android.intent.extra.SUBJECT", str4);
        intent2.putExtra("android.intent.extra.TEXT", sb.toString());
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (File file : fileArr) {
            arrayList.add(Uri.fromFile(file));
        }
        intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        activity.startActivity(intent2);
    }
}
