package com.yulikexuan.java.refactoring.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Supplier;


public sealed interface JsonObjectConverter<T> permits JsonObjectConverterImpl {

    Optional<T> toObject(String json);

    Optional<String> toJson(T obj);

    enum JsonObjectMapperSupplier implements Supplier<ObjectMapper> {

        DEFAULT;

        private ObjectMapper objMapper;

        private JsonObjectMapperSupplier() {

            objMapper = new ObjectMapper();

            objMapper.registerModule(new JavaTimeModule());
            objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objMapper.setVisibility(
                    PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            objMapper.setVisibility(
                    PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            objMapper.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        }

        @Override
        public ObjectMapper get() {
            return objMapper;
        }

    }

    static <T> JsonObjectConverter<T> of(Class<T> type) {

        return new JsonObjectConverterImpl<>(
                JsonObjectMapperSupplier.DEFAULT.get(), type);
    }

    static <T> T deserialize(
            @NonNull final String json, @NonNull final Class<T> type) {

        return of(type).toObject(json).orElseThrow(IllegalArgumentException::new);
    }

}

@Slf4j
final class JsonObjectConverterImpl<T> implements JsonObjectConverter<T> {

    private final Class<T> type_;
    private final ObjectMapper objMapper_;

    JsonObjectConverterImpl(ObjectMapper objMapper, Class<T> type) {

        this.type_ = type;
        objMapper_ = objMapper;
    }

    @Override
    public Optional<String> toJson(T obj) {

        String json = null;

        try {
            json = objMapper_.writeValueAsString(obj);
        }
        catch (Exception e) {
            String errMsg = String.format(
                    "[JSON] - Failed to serialize %s to JSON.",
                    obj.getClass().toString());
            log.error(errMsg, e);
            return Optional.empty();
        }

        return Optional.ofNullable(json);
    }

    @Override
    public Optional<T> toObject(String json) {

        try {
            return Optional.ofNullable(objMapper_.readValue(json, type_));
        }
        catch (Exception e) {
            String errMsg = String.format(
                    "[JSON] - Failed to deserialize JSON '%s' to %s.", json,
                    type_.toString());
            log.error(errMsg, e);
            return Optional.empty();
        }
    }

}