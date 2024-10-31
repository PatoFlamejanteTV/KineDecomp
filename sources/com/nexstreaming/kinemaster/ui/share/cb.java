package com.nexstreaming.kinemaster.ui.share;

import android.content.res.Resources;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.sdk2.nexsns.Privacy;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class cb extends com.nexstreaming.kinemaster.ui.widget.m<Privacy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(ShareSNSActivity shareSNSActivity, List list) {
        super(list);
        this.f4340a = shareSNSActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.widget.m
    public String a(Resources resources, Privacy privacy) {
        return privacy.name();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.widget.m
    public int a(Privacy privacy) {
        switch (privacy) {
            case EVERYONE:
                return R.drawable.n2_privacy_public;
            case FRIENDS:
                return R.drawable.n2_privacy_friends;
            case ONLY_ME:
                return R.drawable.n2_privacy_private;
            case UNLISTED:
                return R.drawable.n2_privacy_unlisted;
            default:
                return 0;
        }
    }
}
