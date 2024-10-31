package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageViewAction.java */
/* loaded from: classes3.dex */
public class s extends AbstractC2388a<ImageView> {
    InterfaceC2399l m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Picasso picasso, ImageView imageView, C c2, int i, int i2, int i3, Drawable drawable, String str, Object obj, InterfaceC2399l interfaceC2399l, boolean z) {
        super(picasso, imageView, c2, i, i2, i3, drawable, str, obj, z);
        this.m = interfaceC2399l;
    }

    @Override // com.squareup.picasso.AbstractC2388a
    public void a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f25624c.get();
            if (imageView == null) {
                return;
            }
            Picasso picasso = this.f25622a;
            z.a(imageView, picasso.f25609g, bitmap, loadedFrom, this.f25625d, picasso.o);
            InterfaceC2399l interfaceC2399l = this.m;
            if (interfaceC2399l != null) {
                interfaceC2399l.onSuccess();
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
    }

    @Override // com.squareup.picasso.AbstractC2388a
    public void b() {
        ImageView imageView = (ImageView) this.f25624c.get();
        if (imageView == null) {
            return;
        }
        int i = this.f25628g;
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            Drawable drawable = this.f25629h;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        InterfaceC2399l interfaceC2399l = this.m;
        if (interfaceC2399l != null) {
            interfaceC2399l.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.AbstractC2388a
    public void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
