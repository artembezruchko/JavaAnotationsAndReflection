import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    @MyAnnotation(comment = "example of annotation", innerId = 1)
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("bla bla");
        Person person  = new Person();

        // идентичные методы получения Сlass class
        Class personClass1 = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("Person");
        System.out.println("\nReturn all methods\n");

        Method[] methods = personClass1.getDeclaredMethods();  // getDeclaredMethods() - возвращает все методы даже приватные в отличии от getMethods()
        for (Method m : methods) {
            System.out.println("Name of method: " + m.getName()
                    + ", Return type:" + m.getReturnType()
                    + ", Method parameter type" + Arrays.toString(m.getParameterTypes()));
        }
        System.out.println("\nReturn all fields\n");

        Field[] fields = personClass2.getDeclaredFields();  // getDeclaredFields() - возвращает все поля даже приватные
        for (Field f : fields) {
            System.out.println("Name of Field: " + f.getName()
                    + ", Return type:" + f.getType());
        }

        System.out.println("\nReturn all annotations\n");

        Annotation[] annotations = personClass3.getAnnotations(); // для этого обязательно @Retention(RetentionPolicy.RUNTIME) в аннотации
        System.out.println(Arrays.toString(annotations));
        for (Annotation a : annotations) {
            System.out.println(a.toString());
            System.out.println(a instanceof  ClassAnnotation);
            if(a instanceof  ClassAnnotation) {
                System.out.println("Annoteited");
            }
        }

        useReflection();
    }

    public static void useReflection() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        // Название_класса1 Название _класса2 Название_метода
        Class classObj1 = Class.forName(sc.next()); // что вводить для примера Person  || java.lang.Thread
        Class classObj2 = Class.forName(sc.next());// что вводить для примера  java.lang.String || java.lang.String
        String methodName = sc.next();// что вводить для примера  setName || setName

        Method m = classObj1.getMethod(methodName, classObj2);// на обьекте 1 класса мы вызываем  метод methodName и этому методу в качестве аргумента передается  classObj2
        Object o1 = classObj1.newInstance(); // создание нового обьекта с пустым конструктором по названию класса с 49 строки
        Object o2 = classObj2.getConstructor(String.class).newInstance("String value");  //конструктор который принмает на вход строковые занчения
        // после кода выше буедт создан обьект что соотвтетсвует Название_класса1(он будет создан с пустым конструктором)
        // будет создан обьект Название _класса2 но ему в качестве аргумента будет передано значение с 56 строки "String value"

         m.invoke(o1, o2); // на олбьекте о1 вызывется метот m c агрументом о2

        System.out.println(o1);
    }
}
