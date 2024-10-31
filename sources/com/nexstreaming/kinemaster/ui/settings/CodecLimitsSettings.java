package com.nexstreaming.kinemaster.ui.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;

/* loaded from: classes2.dex */
public class CodecLimitsSettings extends com.nextreaming.nexeditorui.I {
    private View H;
    private int I;
    private boolean J;

    public static int c(int i, int i2) {
        return (((i - 1) | 15) + 1) * (((i2 - 1) | 15) + 1);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        setContentView(R.layout.codec_limits_settings);
        this.H = findViewById(R.id.disableView);
        this.H.setOnClickListener(new ViewOnClickListenerC2205z(this));
        Spinner spinner = (Spinner) findViewById(R.id.codecCapabilitySource);
        int i = 0;
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Automatic (default)", "Use old DB only", "CUSTOM"}));
        spinner.setSelection(CapabilityManager.f20040b.e().ordinal());
        spinner.setOnItemSelectedListener(new A(this, spinner));
        Spinner spinner2 = (Spinner) findViewById(R.id.maxImportRes);
        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"2160p (4K)", "1440p (2K)", "1080p (FHD)", "720p (HD)", "630p", "540p (SD)", "450p", "360p"}));
        spinner2.setOnItemSelectedListener(new B(this));
        Spinner spinner3 = (Spinner) findViewById(R.id.maxCodecCount);
        spinner3.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1", AppEventsConstants.EVENT_PARAM_VALUE_NO}));
        spinner3.setOnItemSelectedListener(new C(this));
        Spinner spinner4 = (Spinner) findViewById(R.id.maxTranscodeRes);
        spinner4.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"2160p (4K)", "1440p (2K)", "1080p (FHD)", "720p (HD)", "630p", "540p (SD)", "450p", "360p"}));
        EditText editText = (EditText) findViewById(R.id.mcmsEditText);
        View findViewById = findViewById(R.id.calculate);
        findViewById.setOnClickListener(new D(this, spinner2, spinner3, editText));
        int i2 = CapabilityManager.f20040b.i();
        int i3 = 0;
        while (true) {
            if (i3 >= spinner2.getAdapter().getCount()) {
                break;
            }
            if (((String) spinner2.getAdapter().getItem(i3)).startsWith(String.valueOf(i2))) {
                spinner2.setSelection(i3);
                break;
            }
            i3++;
        }
        int h2 = CapabilityManager.f20040b.h();
        int i4 = 0;
        while (true) {
            if (i4 >= spinner3.getAdapter().getCount()) {
                break;
            }
            if (((String) spinner3.getAdapter().getItem(i4)).equals(String.valueOf(h2))) {
                spinner3.setSelection(i4);
                break;
            }
            i4++;
        }
        int j = CapabilityManager.f20040b.j();
        while (true) {
            if (i >= spinner4.getAdapter().getCount()) {
                break;
            }
            if (((String) spinner4.getAdapter().getItem(i)).startsWith(String.valueOf(j))) {
                spinner4.setSelection(i);
                break;
            }
            i++;
        }
        int g2 = CapabilityManager.f20040b.g();
        if (g2 > 0) {
            editText.setText(String.valueOf(g2));
        }
        findViewById(R.id.cancel).setOnClickListener(new E(this));
        findViewById(R.id.save).setOnClickListener(new F(this, spinner2, spinner3, spinner4, editText, findViewById));
        super.onCreate(bundle);
    }
}
