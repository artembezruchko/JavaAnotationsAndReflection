import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) // Ограничиваем использование анотации
@Retention(RetentionPolicy.RUNTIME) // чаще всего доступ к аннотациям используется в рефлексии, поэтому удержание происходит в рантайме
public @interface MyAnnotation {
    String comment() default "";
    int innerId() default 0;

}
