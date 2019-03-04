package by.htp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException
    {
       
       /* Class c = Class.forName("by.htp.reflection.ConcreteComponent"); 
        Constructor[] constructors = c.getConstructors(); 
        
        Constructor constructor = constructors[0];
        
        Object obj = constructor.newInstance();
        
        SomeContainerComponent s = (SomeContainerComponent)obj;
        
        s.init();*/
        
        
    	
    	String className = "by.htp.reflection.ConcreteComponent";
    	String methodName = "execute";
    	String methodParamType1 = "java.lang.String";
    	String methodParamName1 = "params";
    	String methodReturnType = "String";
    	String methodParamValue1 = "h e l l o";
    	
    	// получаем метод
    	Class c =  Class.forName(className);
    	Object obj = c.newInstance();

    	//Class[] paramTypes = new Class[] { String.class,  }; 
    	Class[] paramTypes = new Class[] { Class.forName(methodParamType1)  }; 

    	Method method;    	
    	method = c.getDeclaredMethod(methodName, paramTypes);
    	
    	
    	// формируем аргументы метода
    	Class paramClass1 = Class.forName(methodParamType1);
    	Constructor con = paramClass1.getConstructor(paramClass1);//String(String)
    	Object param1 = con.newInstance(methodParamValue1);
    	
    	System.out.println(param1);
    	
    	//вызываем метод на объекте
    	Object[] arguments = new Object[] { param1 };
    	String s = (String)method.invoke(obj, arguments);
    	System.out.println(s);
    }
}
