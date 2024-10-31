package com.nexstreaming.kinemaster.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import java.util.Arrays;

/* compiled from: PermissionHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f21563a = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f21564b = {"android.permission.CAMERA"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f21565c = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f21566d = {"android.permission.RECORD_AUDIO"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f21567e = {"android.permission.READ_PHONE_STATE"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f21568f = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"};

    public static boolean a(Context context, String[] strArr) {
        int i;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 23) {
            i = 0;
            for (String str : strArr) {
                i |= context.checkSelfPermission(str);
                if ((context instanceof Activity) && ((Activity) context).shouldShowRequestPermissionRationale(str)) {
                    defaultSharedPreferences.edit().remove(str).apply();
                }
            }
        } else {
            i = 0;
        }
        return i == 0;
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        activity.requestPermissions(strArr, i);
    }

    public static void a(Fragment fragment, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        fragment.requestPermissions(strArr, i);
    }

    public static boolean a(Activity activity, String[] strArr, int[] iArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        int min = Math.min(strArr.length, iArr.length);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (iArr[i2] == 0) {
                i++;
            } else if (!activity.shouldShowRequestPermissionRationale(strArr[i2])) {
                defaultSharedPreferences.edit().putBoolean(strArr[i2], true).apply();
            }
        }
        return i == min;
    }

    public static boolean a(Activity activity, String[] strArr) {
        if (Build.VERSION.SDK_INT <= 23) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        for (String str : strArr) {
            if (defaultSharedPreferences.getBoolean(str, false)) {
                return false;
            }
        }
        return true;
    }

    private static e.a a(Context context, String[] strArr, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        int i2 = z ? R.string.permission_storage_allow : R.string.permission_app_settings;
        if (Arrays.equals(f21565c, strArr)) {
            i = z ? R.string.permission_content_camcorder_primary : R.string.permission_content_camcorder_secondary;
        } else if (Arrays.equals(f21564b, strArr)) {
            i = z ? R.string.permission_content_camera_primary : R.string.permission_content_camera_secondary;
        } else if (Arrays.equals(f21566d, strArr)) {
            i = z ? R.string.permission_content_audio_record_primary : R.string.permission_content_audio_record_secondary;
        } else if (Arrays.equals(f21567e, strArr)) {
            i = z ? R.string.permission_content_phone_primary : R.string.permission_content_phone_secondary;
        } else {
            if (!Arrays.equals(f21568f, strArr) && !Arrays.equals(f21563a, strArr)) {
                throw new UnsupportedOperationException("we don't need this permission : " + Arrays.toString(strArr));
            }
            i = z ? R.string.permission_content_storage_primary : R.string.permission_storage_settings;
        }
        e.a aVar = new e.a(context);
        aVar.a(false);
        aVar.e(R.string.service_permission_required);
        aVar.f(18);
        aVar.c(i);
        aVar.d(12);
        aVar.c(i2, onClickListener);
        aVar.a(R.string.button_cancel, onClickListener2);
        return aVar;
    }

    public static e.a a(final Context context, String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return a(context, strArr, false, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.e.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.a(context, dialogInterface, i);
            }
        }, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getApplicationContext().getPackageName(), null));
        intent.addFlags(268435456);
        context.startActivity(intent);
        dialogInterface.dismiss();
    }

    public static e.a a(Context context, String[] strArr, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return a(context, strArr, true, onClickListener, onClickListener2);
    }
}
