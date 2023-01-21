package org.gxj.demo.jvm;

import org.gxj.demo.jvm.classfile.ClassFile;
import org.gxj.demo.jvm.classfile.MemberInfo;
import org.gxj.demo.jvm.classpath.Classpath;

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
        Classpath classpath = new Classpath(cmd.jre, cmd.classPath);
        System.out.printf("classpath:%s class:%s args:%s\n", classpath, cmd.getMainClass(), cmd.getAppArgs());
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, classpath);
        MemberInfo mainMethod = getMainMethod(classFile);
        if (mainMethod == null) {
            System.out.println("Main method not found in class " + cmd.classPath);
            return;
        }
        new Interpret(mainMethod);
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

    //找到主函数入口方法
    private static MemberInfo getMainMethod(ClassFile cf) {
        if (cf == null) return null;
        MemberInfo[] methods = cf.methods();
        for (MemberInfo m : methods) {
            if ("main".equals(m.name()) && "([Ljava/lang/String;)V".equals(m.descriptor())) {
                return m;
            }
        }
        return null;
    }
}

