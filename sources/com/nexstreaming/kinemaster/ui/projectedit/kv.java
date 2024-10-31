package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: SpeedControlFragment.java */
/* loaded from: classes.dex */
public class kv extends kp {

    /* renamed from: a */
    private NexVideoClipItem f4046a;
    private int b = 0;
    private Slider c;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.speed_control_fragment, viewGroup, false);
        b(inflate);
        f(R.string.spcontrol_panel_title);
        d(true);
        this.c = (Slider) inflate.findViewById(R.id.speedControlSlider);
        this.c.setListener(new kw(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        if (m() != null) {
            NexTimelineItem m = m();
            if (m != null && (m instanceof NexVideoClipItem)) {
                this.f4046a = (NexVideoClipItem) m;
            }
            int representedDurationWithoutOverlap = this.f4046a.getRepresentedDurationWithoutOverlap();
            int startOverlap = this.f4046a.getStartOverlap() + this.f4046a.getEndOverlap();
            int maxSpeedCtrlValue = NexEditorDeviceProfile.getDeviceProfile().getMaxSpeedCtrlValue(this.f4046a.getWidth(), this.f4046a.getHeight());
            int minSpeedCtrlValue = NexEditorDeviceProfile.getDeviceProfile().getMinSpeedCtrlValue();
            int B = MediaInfo.a(this.f4046a.getMediaPath()).B();
            float maxSpeedControlFPS = NexEditorDeviceProfile.getDeviceProfile().getMaxSpeedControlFPS();
            if (startOverlap > 0 && this.c != null) {
                int floor = (int) Math.floor((representedDurationWithoutOverlap / (startOverlap + 750)) * 100.0f);
                if (floor < minSpeedCtrlValue) {
                    maxSpeedCtrlValue = minSpeedCtrlValue;
                } else if (floor <= maxSpeedCtrlValue) {
                    maxSpeedCtrlValue = floor;
                }
                int i = (int) ((maxSpeedControlFPS / B) * 100.0f);
                if (i >= maxSpeedCtrlValue || i <= 100) {
                    i = maxSpeedCtrlValue;
                }
                this.c.setMaxValue(i);
            } else if (representedDurationWithoutOverlap / 2 < 1000 && this.c != null) {
                int i2 = (representedDurationWithoutOverlap * 100) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                if (i2 < minSpeedCtrlValue) {
                    maxSpeedCtrlValue = minSpeedCtrlValue;
                } else if (i2 <= maxSpeedCtrlValue) {
                    maxSpeedCtrlValue = i2;
                }
                int i3 = (int) ((maxSpeedControlFPS / B) * 100.0f);
                if (i3 >= maxSpeedCtrlValue || i3 <= 100) {
                    i3 = maxSpeedCtrlValue;
                }
                this.c.setMaxValue(i3);
            } else if (this.c != null) {
                int i4 = (int) ((maxSpeedControlFPS / B) * 100.0f);
                if (i4 >= maxSpeedCtrlValue || i4 <= 100) {
                    i4 = maxSpeedCtrlValue;
                }
                this.c.setMaxValue(i4);
            }
            if (this.c != null) {
                this.c.setValue(this.f4046a.getPlaybackSpeed());
            }
        }
        super.f();
    }
}
