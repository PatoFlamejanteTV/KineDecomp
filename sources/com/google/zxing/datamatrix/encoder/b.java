package com.google.zxing.datamatrix.encoder;

import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.helper.ItemTouchHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Base256Encoder.java */
/* loaded from: classes2.dex */
public final class b implements f {
    public int a() {
        return 5;
    }

    @Override // com.google.zxing.datamatrix.encoder.f
    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!gVar.h()) {
                break;
            }
            sb.append(gVar.c());
            gVar.f19127f++;
            int a2 = HighLevelEncoder.a(gVar.d(), gVar.f19127f, a());
            if (a2 != a()) {
                gVar.b(a2);
                break;
            }
        }
        int length = sb.length() - 1;
        int a3 = gVar.a() + length + 1;
        gVar.c(a3);
        boolean z = gVar.g().a() - a3 > 0;
        if (gVar.h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            gVar.a(a(sb.charAt(i), gVar.a() + 1));
        }
    }

    private static char a(char c2, int i) {
        int i2 = c2 + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
