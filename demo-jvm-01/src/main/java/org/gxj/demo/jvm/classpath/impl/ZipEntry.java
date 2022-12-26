package org.gxj.demo.jvm.classpath.impl;

import org.gxj.demo.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author gxj
 * @date 2022/12/26 16:47
 */
public class ZipEntry implements Entry {

    private Path absolutePath;

    public ZipEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem zipFs = FileSystems.newFileSystem(absolutePath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
