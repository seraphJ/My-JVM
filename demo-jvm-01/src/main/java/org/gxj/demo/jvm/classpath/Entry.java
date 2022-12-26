package org.gxj.demo.jvm.classpath;

import org.gxj.demo.jvm.classpath.impl.CompositeEntry;
import org.gxj.demo.jvm.classpath.impl.DirEntry;
import org.gxj.demo.jvm.classpath.impl.WildcardEntry;
import org.gxj.demo.jvm.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * @author gxj
 * @date 2022/12/26 16:46
 */
public interface Entry {
    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        //File.pathSeparator; 路径分隔符
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") || path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);


    }
}
