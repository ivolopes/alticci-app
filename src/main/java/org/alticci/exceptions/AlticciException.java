package org.alticci.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class AlticciException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    public AlticciException(String msg) {
        super(msg);
    }

}
