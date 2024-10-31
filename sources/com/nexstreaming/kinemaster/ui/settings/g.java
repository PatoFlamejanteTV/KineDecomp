package com.nexstreaming.kinemaster.ui.settings;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Locale;

/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes2.dex */
public class G extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private TextView f23047a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f23048b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f23049c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f23050d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f23051e;

    /* renamed from: f, reason: collision with root package name */
    private CapabilityManager.CapabilityMode f23052f = null;

    public static G a() {
        Bundle bundle = new Bundle();
        G g2 = new G();
        g2.setArguments(bundle);
        return g2;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_capability_info_v4, viewGroup, false);
        EditorGlobal.i();
        TextView textView = (TextView) inflate.findViewById(R.id.tv_chipset);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_model);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_android_os);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_macroblock_throughtput);
        String str = CapabilityManager.f20040b.b() != null ? "" : "*";
        String f2 = CapabilityManager.f20040b.f();
        textView.setText(getResources().getString(R.string.capa_info_chipset) + " " + c.d.b.a.a.f3576b.e() + " (" + c.d.b.a.a.f3576b.d() + str + ")");
        textView2.setText(getResources().getString(R.string.capability_model) + " " + Build.MODEL + " (" + Build.MANUFACTURER + "/" + Build.PRODUCT + ")");
        textView3.setText(getResources().getString(R.string.capability_android) + " " + Build.VERSION.RELEASE + " (KM " + U.b(getActivity()) + ", " + f2 + ")");
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.peak_codec_performance));
        sb.append(" ");
        sb.append(String.format(Locale.ENGLISH, "%.1f", Float.valueOf(((float) deviceProfile.getHardwareCodecMemSize()) / 1048576.0f)));
        sb.append(" MPixel/s");
        textView4.setText(sb.toString());
        this.f23047a = (TextView) inflate.findViewById(R.id.edit_share_value_tv);
        this.f23048b = (TextView) inflate.findViewById(R.id.video_layers_value_tv);
        this.f23050d = (TextView) inflate.findViewById(R.id.edit_share_name_tv);
        this.f23049c = (TextView) inflate.findViewById(R.id.tv_reencoding_limit);
        this.f23051e = (TextView) inflate.findViewById(R.id.diagnosticInfo);
        return inflate;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        a(this.f23052f);
    }

    public void a(CapabilityManager.CapabilityMode capabilityMode) {
        String str;
        this.f23052f = capabilityMode;
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        boolean b2 = EditorGlobal.i().b();
        int maxImportHeight = deviceProfile.getMaxImportHeight(b2, true);
        int maxTranscodingHeight = deviceProfile.getMaxTranscodingHeight(b2);
        if (maxTranscodingHeight != maxImportHeight) {
            this.f23049c.setText(getResources().getString(R.string.dci_reencode_title) + " " + maxTranscodingHeight + "p");
            this.f23049c.setVisibility(0);
        } else {
            this.f23049c.setVisibility(8);
        }
        this.f23047a.setText(maxImportHeight + "p");
        if (deviceProfile.getLableResource(maxImportHeight) != 0) {
            this.f23050d.setText("(" + getResources().getString(deviceProfile.getLableResource(maxImportHeight)) + ")");
        }
        this.f23048b.setText(deviceProfile.getVideoLayerCountAndResolution(getActivity()));
        String l = CapabilityManager.f20040b.l();
        CapabilityManager.CapabilityMode capabilityMode2 = this.f23052f;
        if (capabilityMode2 != null) {
            if (capabilityMode2 == CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES) {
                str = "(R)";
            } else if (capabilityMode2 == CapabilityManager.CapabilityMode.MAXIMIZE_RESOLUTION) {
                str = "(F)";
            }
            this.f23051e.setText(l + str);
        }
        str = "";
        this.f23051e.setText(l + str);
    }
}
