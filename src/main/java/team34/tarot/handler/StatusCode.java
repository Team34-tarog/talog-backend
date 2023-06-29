package team34.tarot.handler;

import org.springframework.http.HttpStatus;

import java.util.Date;

public interface StatusCode {
    String message();
    HttpStatus status();


}
