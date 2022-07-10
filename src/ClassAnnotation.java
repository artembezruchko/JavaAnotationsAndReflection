import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // без этого .getAnnotations(); не найдет аннотаций
public @interface ClassAnnotation {
    String comment() default "empty";
}
