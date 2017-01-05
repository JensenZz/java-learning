package java7;

import com.sun.javafx.collections.MappingChange;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Created by JensenZz on 16/1/13.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class ReflectMain {



	public static int aVoid(){
	return 1;
	}

	public static void main(String[] args) {
		try {
			//研究反射机制
			Class<?> demo = null;

			try {
				//下面是取得改名字的类   即通过jvm类加载器加载该类要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
				// 你要记住一个概念，静态代码是和class绑定的，class装载成功就表示执行了你的静态代码了。而且以后不会再走这段静态代码了。
				demo = Class.forName("java.io.FileInputStream");
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (Field field : demo.getDeclaredFields()) {
				System.out.println(field.getName());
			}
//			//保存所有的接口
//			Class<?> intes[] = demo.getInterfaces();
//			for (int i = 0; i < intes.length; i++) {
//				System.out.println("实现的接口   " + intes[i].getName());
//			}
//			//取得全部的构造函数
//			Constructor<?> cons[] = demo.getConstructors();
//			for (int i = 0; i < cons.length; i++) {
//				Class<?> p[] = cons[i].getParameterTypes();
//				System.out.print("构造方法：  ");
//				int mo = cons[i].getModifiers();
//				System.out.print(Modifier.toString(mo) + " ");
//				System.out.print(cons[i].getName());
//				System.out.print("(");
//				for (int j = 0; j < p.length; ++j) {
//					System.out.print(p[j].getName() + " arg" + i);
//					if (j < p.length - 1) {
//						System.out.print(",");
//					}
//				}
//				System.out.println("){}");
//			}
//			//取得详细方法信息
//			Method method[] = demo.getMethods();
//			for (int i = 0; i < method.length; ++i) {
//				Class<?> returnType = method[i].getReturnType();
//				Class<?> para[] = method[i].getParameterTypes();
//				int temp = method[i].getModifiers();
//				System.out.print(Modifier.toString(temp) + " ");
//				System.out.print(returnType.getName() + "  ");
//				System.out.print(method[i].getName() + " ");
//				System.out.print("(");
//				for (int j = 0; j < para.length; ++j) {
//					System.out.print(para[j].getName() + " " + "arg" + j);
//					if (j < para.length - 1) {
//						System.out.print(",");
//					}
//				}
//				Class<?> exce[] = method[i].getExceptionTypes();
//				if (exce.length > 0) {
//					System.out.print(") throws ");
//					for (int k = 0; k < exce.length; ++k) {
//						System.out.print(exce[k].getName() + " ");
//						if (k < exce.length - 1) {
//							System.out.print(",");
//						}
//					}
//				} else {
//					System.out.print(")");
//				}
//				System.out.println();
//			}
//			//取得父类
//			Class<?> temp = demo.getSuperclass();
//			System.out.println("继承的父类为：   " + temp.getName());
//			System.out.println("===============本类属性========================");
//			// 取得本类的全部属性
//			Field[] field = demo.getDeclaredFields();
//			for (int i = 0; i < field.length; i++) {
//				// 权限修饰符
//				int mo = field[i].getModifiers();
//				String priv = Modifier.toString(mo);
//				// 属性类型
//				Class<?> type = field[i].getType();
//				System.out.println(priv + " " + type.getName() + " "
//						+ field[i].getName() + ";");
//			}
//			System.out.println("===============实现的接口或者父类的属性========================");
//			// 取得实现的接口或者父类的属性
//			Field[] filed1 = demo.getFields();
//			for (int j = 0; j < filed1.length; j++) {
//				// 权限修饰符
//				int mo = filed1[j].getModifiers();
//				String priv = Modifier.toString(mo);
//				// 属性类型
//				Class<?> type = filed1[j].getType();
//				System.out.println(priv + " " + type.getName() + " "
//						+ filed1[j].getName() + ";");
//			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
