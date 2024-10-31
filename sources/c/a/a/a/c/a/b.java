package c.a.a.a.c.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.auth.p;
import com.adobe.creativesdk.foundation.auth.q;

/* compiled from: AdobeCommonErrorViewFragment.java */
/* loaded from: classes.dex */
public class b extends Fragment {

    /* renamed from: a */
    ViewGroup f3455a = null;

    public void e(String str) {
        ViewGroup viewGroup = this.f3455a;
        if (viewGroup != null) {
            ((TextView) viewGroup.findViewById(p.adobe_csdk_common_view_error_message)).setText(str.toCharArray(), 0, str.length());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(q.adobe_csdk_common_errorview, viewGroup, false);
        this.f3455a = viewGroup;
        return inflate;
    }
}
