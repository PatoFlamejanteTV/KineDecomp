package com.nexstreaming.kinemaster.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class SupportInfoV4Fragment extends Fragment {

    /* renamed from: a */
    private View f21221a;

    /* renamed from: b */
    private final String f21222b = "https://www.facebook.com/KineMaster.US/";

    /* renamed from: c */
    private final String f21223c = "https://www.facebook.com/KineMaster/";

    /* renamed from: d */
    private final String f21224d = "https://www.facebook.com/KineMaster.JP/";

    /* renamed from: e */
    private final String f21225e = "https://www.instagram.com/kinemaster/";

    /* renamed from: f */
    private final String f21226f = "https://www.instagram.com/kinemaster_korea/";

    /* renamed from: g */
    private final String f21227g = "https://www.instagram.com/kinemaster_japan/";

    /* renamed from: h */
    private final String f21228h = "https://twitter.com/KineMaster";
    private final String i = "https://twitter.com/KineMasterapp";
    private final String j = "https://twitter.com/KineMasterJapan";
    private final String k = "https://m.weibo.cn/u/5934164350";
    private final String l = "https://data.newrank.cn/m/s.html?s=PTArPjI9LDw9";
    private final String m = "https://mp.weixin.qq.com/s/XcztPLl565Tw_aMPTIKENA";

    /* loaded from: classes.dex */
    public enum WhereToGo {
        FACEBOOK,
        INSTAGRAM,
        TWITTER,
        WEIBO,
        WECHAT
    }

    public static SupportInfoV4Fragment z() {
        SupportInfoV4Fragment supportInfoV4Fragment = new SupportInfoV4Fragment();
        supportInfoV4Fragment.setArguments(new Bundle());
        return supportInfoV4Fragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(SupportInfoV4Fragment.class.getName());
        this.f21221a = layoutInflater.inflate(R.layout.fragment_support_info_v4, viewGroup, false);
        Button button = (Button) this.f21221a.findViewById(R.id.helpButton);
        Button button2 = (Button) this.f21221a.findViewById(R.id.websiteButton);
        Button button3 = (Button) this.f21221a.findViewById(R.id.emailSupportButton);
        ImageView imageView = (ImageView) this.f21221a.findViewById(R.id.twitterButton);
        ImageView imageView2 = (ImageView) this.f21221a.findViewById(R.id.instagramButton);
        ImageView imageView3 = (ImageView) this.f21221a.findViewById(R.id.facebookButton);
        LinearLayout linearLayout = (LinearLayout) this.f21221a.findViewById(R.id.global_social_container);
        LinearLayout linearLayout2 = (LinearLayout) this.f21221a.findViewById(R.id.china_social_container);
        ImageView imageView4 = (ImageView) this.f21221a.findViewById(R.id.weiboButton);
        ImageView imageView5 = (ImageView) this.f21221a.findViewById(R.id.wechatButton);
        if (c.d.b.m.e.f3850a.a()) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            button2.setVisibility(8);
            button.setText(R.string.help_support_tutorial_ch);
        } else {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            button2.setVisibility(0);
        }
        button.setOnClickListener(new f(this));
        button2.setOnClickListener(new g(this));
        button3.setOnClickListener(new h(this));
        ImageView imageView6 = (ImageView) this.f21221a.findViewById(R.id.kineLogoView);
        if (c.d.b.m.e.f3850a.a()) {
            imageView6.setImageResource(R.drawable.img_help_support_logo_cn);
        } else {
            imageView6.setImageResource(R.drawable.img_help_support_logo_global);
        }
        imageView.setOnClickListener(new i(this));
        imageView2.setOnClickListener(new j(this));
        imageView3.setOnClickListener(new k(this));
        imageView4.setOnClickListener(new l(this));
        imageView5.setOnClickListener(new m(this));
        return this.f21221a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:            if (r10.equals("ko") == false) goto L91;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:            if (r10.equals("ko") == false) goto L108;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ac, code lost:            if (r10.equals("ko") == false) goto L124;     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.nexstreaming.kinemaster.support.SupportInfoV4Fragment.WhereToGo r10) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.support.SupportInfoV4Fragment.a(com.nexstreaming.kinemaster.support.SupportInfoV4Fragment$WhereToGo):void");
    }
}
