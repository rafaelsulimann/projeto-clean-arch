package com.sulimann.cleanarch.core.utils.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

public class FluentValidation<T> {
    private final T value;
    private boolean isValid = true;
    private Resultado<?, ErroResponse> erro;
    private Map<String, Object> entities = new HashMap<>();

    private FluentValidation(T value) {
        this.value = value;
    }

    public static <T> FluentValidation<T> of(T value) {
        return new FluentValidation<>(value);
    }

    public FluentValidation<T> ifIsTrue(boolean condition) {
        if (isValid && condition) {
            isValid = false;
        }
        return this;
    }

    public <U> FluentValidation<T> ifNotPresent(String key, Optional<U> optional) {
        if (!optional.isPresent()) {
            isValid = false;
        } else {
            entities.put(key, optional.get());
        }
        return this;
    }

    public FluentValidation<T> thenReturn(Supplier<Resultado<?, ErroResponse>> supplier) {
        if (!isValid && erro == null) {
            erro = supplier.get();
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public <R> Resultado<R, ErroResponse> finallyExecute(Function<T, Resultado<R, ErroResponse>> function) {
        if (isValid) {
            return function.apply(value);
        } else {
            return (Resultado<R, ErroResponse>) erro;
        }
    }

    @SuppressWarnings("unchecked")
    public <R> Resultado<R, ErroResponse> finallyExecute(
            BiFunction<T, Map<String, Object>, Resultado<R, ErroResponse>> function) {
        if (isValid) {
            return function.apply(value, entities);
        } else {
            return (Resultado<R, ErroResponse>) erro;
        }
    }
}
