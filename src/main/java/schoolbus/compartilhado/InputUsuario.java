package schoolbus.compartilhado;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InputUsuario {
    String prompt();
}
