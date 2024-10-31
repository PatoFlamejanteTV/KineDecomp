package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: OptionMenuFragment.java */
/* loaded from: classes.dex */
public class es extends ed {
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        if (m() instanceof NexVideoClipItem) {
            g(R.id.editmode_trim);
        } else {
            g(0);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, com.nexstreaming.kinemaster.ui.projectedit.a
    public boolean a(int i) {
        switch (i) {
            case R.id.action_play_pause /* 2131820570 */:
                o().r();
                return true;
            case R.id.action_test /* 2131820580 */:
                NexTimelineItem m = m();
                if (m != null && (m instanceof NexVideoClipItem)) {
                    a((NexVideoClipItem) m);
                }
                return true;
            default:
                return false;
        }
    }

    private void a(NexVideoClipItem nexVideoClipItem) {
        MediaInfo.a(nexVideoClipItem.getMediaPath()).a(800, 450, 0, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, 15, 0, new ev(this)).onFailure(new eu(this)).onComplete(new et(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        NexTimelineItem m = m();
        View findViewById = onCreateView.findViewById(R.id.descTitleSm);
        if (findViewById != null && (m instanceof NexVideoClipItem)) {
            String mediaPath = ((NexVideoClipItem) m).getMediaPath();
            findViewById.setLongClickable(true);
            findViewById.setOnClickListener(new ew(this, mediaPath));
        }
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        NexTimelineItem m = m();
        String descriptiveTitle = m.getDescriptiveTitle(i());
        String descriptiveSubtitle = m.getDescriptiveSubtitle(i());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            return m.getClass().getSimpleName();
        }
        return !((descriptiveSubtitle != null) & (descriptiveTitle == null)) ? descriptiveTitle : descriptiveSubtitle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    public String j_() {
        NexTimelineItem m = m();
        String descriptiveTitle = m.getDescriptiveTitle(i());
        String descriptiveSubtitle = m.getDescriptiveSubtitle(i());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            m.getClass().getSimpleName();
            return descriptiveSubtitle;
        }
        if ((descriptiveSubtitle != null) & (descriptiveTitle == null)) {
            return null;
        }
        return descriptiveSubtitle;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return m().getOptionMenuItems();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean b(int i) {
        return m().isOptionApplied(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean e() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() instanceof NexVideoClipItem) {
            g(R.id.editmode_trim);
        }
    }
}
