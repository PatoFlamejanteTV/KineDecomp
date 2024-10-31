package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* loaded from: classes.dex */
public class BailActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.bail);
        if (!getIntent().getExtras().containsKey("msg_rsrc")) {
            i = 0;
            string = getIntent().getExtras().getString("msg_str");
        } else {
            i = getIntent().getExtras().getInt("msg_rsrc");
            string = null;
        }
        int i2 = getIntent().getExtras().getInt("reason_code");
        int i3 = getIntent().getExtras().getInt("extra_code");
        TextView textView = (TextView) findViewById(R.id.bailtext);
        if (i != 0) {
            textView.setText(getResources().getText(i));
        } else {
            textView.setText(string);
        }
        TextView textView2 = (TextView) findViewById(R.id.detailText);
        if (i3 != 0) {
            textView2.setText(i2 + " (ex" + i3 + ")");
        } else {
            textView2.setText(i2 + "");
        }
        textView2.setClickable(true);
        textView2.setOnLongClickListener(new a(this));
    }

    /* loaded from: classes.dex */
    public enum ReasonCode {
        InitFail(10),
        LinkFail(11),
        InternalError(12),
        DeviceNoSupport(20),
        NoAVCOrMP4Support(21),
        NotEnoughAudioCodecInstances(22),
        DeviceNoSupportUnknownReason(23),
        ScreenTooSmall(30),
        SDKIntTooSmall(31),
        OSVersionTooLow(32),
        NoExportProfiles(33),
        NeedUpgrade(40);

        private final int reasonCode;

        ReasonCode(int i) {
            this.reasonCode = i;
        }

        public int getCode() {
            return this.reasonCode;
        }
    }

    public static void a(Activity activity, int i, ReasonCode reasonCode) {
        a(activity, i, reasonCode, 0);
    }

    public static void a(Activity activity, int i, ReasonCode reasonCode, int i2) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        KMUsage.BailReport.logEvent("bail_reason", reasonCode.name(), "bail_code", reasonCode.getCode() + "/" + i2, "model", Build.MODEL, "product", Build.PRODUCT, "device", Build.DEVICE, "manufacturer", Build.MANUFACTURER, "board_platform_r", com.nexstreaming.app.general.util.z.g(), "os", "" + Build.VERSION.SDK_INT + "/" + Build.VERSION.RELEASE, "screen", "" + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels, "density", "" + displayMetrics.density + " (" + displayMetrics.densityDpi + "dpi)");
        Intent intent = new Intent(activity, (Class<?>) BailActivity.class);
        intent.putExtra("msg_rsrc", i);
        intent.putExtra("reason_code", reasonCode.getCode());
        intent.putExtra("extra_code", i2);
        activity.startActivityForResult(intent, 0);
        activity.finish();
    }

    public static void a(Activity activity, String str, ReasonCode reasonCode, int i) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        KMAppUsage.a(activity).a(KMAppUsage.KMMetric.BailReport, "bail_reason", reasonCode.name(), "bail_code", reasonCode.getCode() + "/" + i, "model", Build.MODEL, "product", Build.PRODUCT, "device", Build.DEVICE, "manufacturer", Build.MANUFACTURER, "board_platform_r", com.nexstreaming.app.general.util.z.g(), "os", "" + Build.VERSION.SDK_INT + "/" + Build.VERSION.RELEASE, "screen", "" + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels, "density", "" + displayMetrics.density + " (" + displayMetrics.densityDpi + "dpi)");
        Intent intent = new Intent(activity, (Class<?>) BailActivity.class);
        intent.putExtra("msg_str", str);
        intent.putExtra("reason_code", reasonCode.getCode());
        intent.putExtra("extra_code", i);
        activity.startActivityForResult(intent, 0);
        activity.finish();
    }
}
