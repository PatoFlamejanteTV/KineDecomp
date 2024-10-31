package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BailActivity extends AppCompatActivity {

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        int i;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.bail);
        if (getIntent().getExtras().containsKey("msg_rsrc")) {
            i = getIntent().getExtras().getInt("msg_rsrc");
            string = null;
        } else {
            string = getIntent().getExtras().getString("msg_str");
            i = 0;
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
        textView2.setOnLongClickListener(new ViewOnLongClickListenerC2296a(this));
    }

    public static void a(Activity activity, int i, ReasonCode reasonCode, int i2) {
        activity.getResources().getDisplayMetrics();
        HashMap hashMap = new HashMap();
        hashMap.put("bail_reason", reasonCode.name());
        hashMap.put("bail_code", reasonCode.getCode() + "/" + i2);
        hashMap.put("model", Build.MODEL);
        hashMap.put("product", Build.PRODUCT);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("board_platform_r", com.nexstreaming.app.general.util.N.a());
        hashMap.put(com.umeng.commonsdk.proguard.e.w, "" + Build.VERSION.SDK_INT + "/" + Build.VERSION.RELEASE);
        KMEvents.BAIL_REPORT.logEvent(hashMap);
        Intent intent = new Intent(activity, (Class<?>) BailActivity.class);
        intent.putExtra("msg_rsrc", i);
        intent.putExtra("reason_code", reasonCode.getCode());
        intent.putExtra("extra_code", i2);
        activity.startActivityForResult(intent, 0);
        activity.finish();
    }

    public static void a(Activity activity, String str, ReasonCode reasonCode, int i) {
        activity.getResources().getDisplayMetrics();
        Intent intent = new Intent(activity, (Class<?>) BailActivity.class);
        intent.putExtra("msg_str", str);
        intent.putExtra("reason_code", reasonCode.getCode());
        intent.putExtra("extra_code", i);
        activity.startActivityForResult(intent, 0);
        activity.finish();
    }
}
