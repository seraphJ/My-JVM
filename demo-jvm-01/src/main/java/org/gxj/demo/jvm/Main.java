package org.gxj.demo.jvm;

import org.gxj.demo.jvm.classfile.ClassFile;
import org.gxj.demo.jvm.classfile.MemberInfo;
import org.gxj.demo.jvm.classpath.Classpath;

import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author gxj
 * @date 2022/12/26 15:36
 */
public class Main {
    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }
    private static void startJVM(Cmd cmd) {
        Classpath cp = new Classpath(cmd.jre, cmd.classPath);
        System.out.printf("classpath: %s class: %s args: %s\n", cp, cmd.getMainClass(), cmd.getAppArgs());
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, cp);
        assert classFile != null;
        printClassInfo(classFile);
//        try {
//            byte[] classData = cp.readClass(className);
//            System.out.println("classData: ");
//            int count = 0;
//            for (byte b : classData) {
//                //16进制输出
//                System.out.print(String.format("%02x", b & 0xff) + " ");
//                count++;
//                if (count == 16) {
//                    count = 0;
//                    System.out.println();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Could not find or load main class " + cmd.getMainClass());
//            e.printStackTrace();
//        }

    }

    private static ClassFile loadClass(String className, Classpath classpath) {
        try {
            byte[] classData = classpath.readClass(className);
            return new ClassFile(classData);
        } catch (Exception e) {
            System.out.println("Could not find or load main class" + className);
            return null;
        }
    }

    private static void printClassInfo(ClassFile cf) {
        System.out.println("version: " + cf.majorVersion() + "." + cf.minorVersion());
        System.out.println("constants count: " + cf.constantPool().getSize());
        System.out.format("access flags: 0x%x\n", cf.accessFlags());
        System.out.println("this class: " + cf.className());
        System.out.println("super class: " + cf.superClassName());
        System.out.println("interfaces: " + Arrays.toString(cf.interfaceNames()));

        System.out.println("fields count: " + cf.fields().length);
        for (MemberInfo memberInfo : cf.fields()) {
            System.out.format("%s \t\t %s\n", memberInfo.name(), memberInfo.descriptor());
        }

        System.out.println("methods count: " + cf.methods().length);
        for (MemberInfo memberInfo : cf.methods()) {
            System.out.format("%s \t\t %s\n", memberInfo.name(), memberInfo.descriptor());
        }
    }
}

