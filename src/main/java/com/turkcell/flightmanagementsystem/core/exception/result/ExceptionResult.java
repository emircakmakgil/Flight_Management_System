package com.turkcell.flightmanagementsystem.core.exception.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResult {
    private String type;
    public ExceptionResult(String type) {
        this.type = type;
    }
}
