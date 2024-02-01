package com.tobeto.rentACar.core.utilities.results;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result {

    private T data;

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    //TDD
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DataResult<?>)) return false;
        if (this.isSuccess() != ((DataResult<?>) obj).isSuccess()) return false;
        if (this.getMessage() != ((DataResult<?>) obj).getMessage()) return false;
        if (this.data.getClass() != ((DataResult<?>) obj).getData().getClass()) return false;
        return true;
    }
}
