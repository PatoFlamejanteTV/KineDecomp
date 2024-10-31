package com.nexstreaming.kinemaster.ui.settings;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes.dex */
public class j extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4259a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private ProgressBar i;
    private View j;

    public static j a() {
        Bundle bundle = new Bundle();
        j jVar = new j();
        jVar.setArguments(bundle);
        return jVar;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_device_capability_info, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.deviceModel);
        TextView textView2 = (TextView) inflate.findViewById(R.id.devicePlatform);
        TextView textView3 = (TextView) inflate.findViewById(R.id.deviceOsVersion);
        String g = com.nexstreaming.app.general.util.z.g();
        String f = com.nexstreaming.app.general.util.z.f();
        if (g.equals(f)) {
            str = g + " [" + NexEditor.a("ro.product.board") + "]";
        } else {
            str = f + " (" + g + ")";
        }
        textView.setText(getResources().getString(R.string.capability_model) + " " + Build.MODEL);
        textView2.setText(getResources().getString(R.string.capability_platform) + " " + str);
        textView3.setText(getResources().getString(R.string.capability_android) + " " + Build.VERSION.RELEASE);
        this.f4259a = (TextView) inflate.findViewById(R.id.deviceSpecSub);
        this.b = inflate.findViewById(R.id.deviceSpecTvHolder);
        this.c = (TextView) inflate.findViewById(R.id.maxImportSize);
        this.d = (TextView) inflate.findViewById(R.id.maxImportSub);
        this.e = (TextView) inflate.findViewById(R.id.maxExportSize);
        this.f = (TextView) inflate.findViewById(R.id.maxExportSub);
        this.g = (TextView) inflate.findViewById(R.id.updateText);
        this.h = inflate.findViewById(R.id.updateButton);
        this.i = (ProgressBar) inflate.findViewById(R.id.busy_indicator);
        this.j = inflate.findViewById(R.id.busyView);
        this.h.setOnClickListener(new k(this));
        this.j.setOnClickListener(new l(this));
        b();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        boolean i = EditorGlobal.a().i();
        int[] deviceSpecificLimitationStringIds = deviceProfile.getDeviceSpecificLimitationStringIds(i);
        if (deviceSpecificLimitationStringIds.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < deviceSpecificLimitationStringIds.length; i2++) {
                if (i2 > 0) {
                    sb.append("\n");
                }
                sb.append(getResources().getString(deviceSpecificLimitationStringIds[i2]));
            }
            this.f4259a.setText(sb.toString());
        } else {
            this.b.setVisibility(8);
        }
        int maxImportHeight = deviceProfile.getMaxImportHeight(i);
        this.c.setText(maxImportHeight + "p");
        if (deviceProfile.getMaxTranscodingHeight(i) != maxImportHeight) {
            this.d.setText(getResources().getString(R.string.capability_max_trascoding_resolution, Integer.valueOf(deviceProfile.getMaxTranscodingHeight(i))));
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        int maxExportHeight = deviceProfile.getMaxExportHeight(i);
        this.e.setText(maxExportHeight + "p");
        if (deviceProfile.getSupportsVideoLayers(i) && deviceProfile.getMaxExportHeightWithVideoLayers(i) != maxExportHeight) {
            this.f.setText(getResources().getString(R.string.capability_max_video_layer_resolution, Integer.valueOf(deviceProfile.getMaxExportHeightWithVideoLayers(i))));
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        switch (NexEditorDeviceProfile.getDeviceProfile().getProfileSource()) {
            case Local:
                this.g.setText(getResources().getString(R.string.capability_never_update_text));
                return;
            case Server:
                TLP.TLPResponseInfo a2 = com.nexstreaming.app.general.tracelog.h.a((Object) com.nexstreaming.app.general.tracelog.h.a((Context) getActivity()).f());
                if (a2 != null && a2.dataReceived > 0) {
                    int currentTimeMillis = (int) ((System.currentTimeMillis() - a2.dataReceived) / 3600000);
                    if (currentTimeMillis < 1) {
                        this.g.setText(getResources().getString(R.string.capability_minute_update_text));
                        return;
                    } else {
                        this.g.setText(getResources().getString(R.string.capability_update_text, Integer.valueOf(currentTimeMillis)));
                        return;
                    }
                }
                this.g.setText(getResources().getString(R.string.capability_unknown_update_text));
                return;
            case Unknown:
                this.g.setText(getResources().getString(R.string.capability_never_update_text_unknown));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        com.nexstreaming.app.general.tracelog.h.a((Context) getActivity()).f();
        com.nexstreaming.kinemaster.tracelog.d.e(getActivity()).setTimeout(60000).onResultAvailable(new o(this)).onFailure((Task.OnFailListener) new m(this));
    }
}
