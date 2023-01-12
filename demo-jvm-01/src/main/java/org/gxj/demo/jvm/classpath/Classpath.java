package org.gxj.demo.jvm.classpath;

import org.gxj.demo.jvm.classpath.impl.WildcardEntry;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author gxj
 * @date 2022/12/26 16:47
 * 类路径
 */
public class Classpath {

    private Entry bootstrapClasspath; //启动类路径
    private Entry extensionClasspath; //扩展类路径
    private Entry userClasspath; //用户类路径

    public Classpath(String jreOption, String cpOption) {
        //启动类&扩展类 "E:\Java\jdk1.8.0_131\jre"
        bootstrapAndExtensionClasspath(jreOption);
        //用户类 "E:\javaProject\demo-jvm\demo-jvm-01\src\test\java\org\gxj\demo\test\HelloWorld
        parseUserClasspath(cpOption);

    }

    private void bootstrapAndExtensionClasspath(String jreOption) {
        String jreDir = getJreDir(jreOption);

        //..jre/lib/*
        String jreLibPath = Paths.get(jreDir, "lib") + File.separator + "*";
        bootstrapClasspath = new WildcardEntry(jreLibPath);

        //..jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, "lib", "ext") + File.separator + "*";
        extensionClasspath = new WildcardEntry(jreExtPath);
    }

    private static String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        if (Files.exists(Paths.get("./jre"))) {
            return "./jre";
        }
        String jh = System.getenv("JAVA_HOME");
        if (jh != null) {
            return Paths.get(jh, "jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = Entry.create(cpOption);
    }

    public byte[] readClass(String className) throws Exception {
        className = className + ".class";

        //[readClass]启动类路径
        try {
            return bootstrapClasspath.readClass(className);
        } catch (Exception ignored) {

        }

        //[readClass]扩展类路径
        try {
            return extensionClasspath.readClass(className);
        } catch (Exception ignored) {

        }

        //[readClass]用户类路径
        return userClasspath.readClass(className);

    }

//    @Override
//    public String toString() {
//        return "Classpath{" +
//                "bootstrapClasspath=" + bootstrapClasspath +
//                ", extensionClasspath=" + extensionClasspath +
//                ", userClasspath=" + userClasspath +
//                '}';
//    }
}
