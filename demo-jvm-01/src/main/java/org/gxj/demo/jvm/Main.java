package org.gxj.demo.jvm;

import org.gxj.demo.jvm.classfile.ClassFile;
import org.gxj.demo.jvm.classfile.MemberInfo;
import org.gxj.demo.jvm.classpath.Classpath;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.LocalVars;
import org.gxj.demo.jvm.rtda.OperandStack;

import java.math.BigInteger;
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

//    private static void startJVM(Cmd cmd) {
//        Classpath cp = new Classpath(cmd.jre, cmd.classPath);
//        System.out.printf("classpath: %s class: %s args: %s\n", cp, cmd.getMainClass(), cmd.getAppArgs());
//        String className = cmd.getMainClass().replace(".", "/");
//        ClassFile classFile = loadClass(className, cp);
//        assert classFile != null;
//        printClassInfo(classFile);
//    }

    private static void startJVM(Cmd cmd) {
        Frame frame = new Frame(100, 100);
        test_localVars(frame.localVars());
        test_operandStack(frame.operandStack());
    }

    private static void test_localVars(LocalVars vars) {
        System.out.println("=====test LocalVars=====");
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        vars.setLong(2, 2997924580L);
        vars.setLong(4, -2997924580L);
        vars.setFloat(6, -3.141592616516515f);
        vars.setDouble(7, 0.1);
        vars.setRef(9, null);

        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
        System.out.println(vars.getLong(2));
        System.out.println(vars.getLong(4));
        System.out.println(vars.getFloat(6));
        System.out.println(vars.getDouble(7));
        System.out.println(vars.getRef(9));
    }

    private static void test_operandStack(OperandStack ops) {
        System.out.println("\n=====test OperandStack=====");
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popInt());
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

