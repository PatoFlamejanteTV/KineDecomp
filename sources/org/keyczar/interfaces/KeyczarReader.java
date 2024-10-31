package org.keyczar.interfaces;

import org.keyczar.exceptions.KeyczarException;

/* loaded from: classes3.dex */
public interface KeyczarReader {
    String getKey() throws KeyczarException;

    String getKey(int i) throws KeyczarException;

    String getMetadata() throws KeyczarException;
}
