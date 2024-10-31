package com.nextreaming.nexeditorui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExclusionList implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient File f24031a;
    private Map<String, Integer> m_refs;

    private ExclusionList(File file) {
        this.f24031a = null;
        this.m_refs = null;
        this.f24031a = file;
        this.m_refs = new HashMap();
    }

    public static ExclusionList exclusionListBackedBy(File file) {
        ExclusionList exclusionList = null;
        if (file.exists()) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                ExclusionList exclusionList2 = (ExclusionList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (FileNotFoundException | OptionalDataException | StreamCorruptedException | IOException | ClassNotFoundException unused) {
                }
                exclusionList = exclusionList2;
            } catch (FileNotFoundException | OptionalDataException | StreamCorruptedException | IOException | ClassNotFoundException unused2) {
            }
        }
        if (exclusionList == null) {
            return new ExclusionList(file);
        }
        exclusionList.f24031a = file;
        return exclusionList;
    }

    public synchronized void add(String str) {
        Integer num = this.m_refs.get(str);
        if (num == null) {
            this.m_refs.put(str, 1);
        } else {
            this.m_refs.put(str, Integer.valueOf(num.intValue() + 1));
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f24031a));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    public synchronized boolean isExcluded(String str) {
        Integer num = this.m_refs.get(str);
        if (num != null) {
            if (num.intValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized void remove(String str) {
        Integer num = this.m_refs.get(str);
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.m_refs.remove(str);
        } else {
            this.m_refs.put(str, Integer.valueOf(num.intValue() - 1));
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f24031a));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (FileNotFoundException | IOException unused) {
        }
    }
}
