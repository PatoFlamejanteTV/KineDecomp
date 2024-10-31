package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileRequestHandler.java */
/* loaded from: classes3.dex */
public class r extends C2401n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.C2401n, com.squareup.picasso.E
    public boolean a(C c2) {
        return "file".equals(c2.f25547e.getScheme());
    }

    @Override // com.squareup.picasso.C2401n, com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, a(c2.f25547e));
    }

    static int a(Uri uri) throws IOException {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
