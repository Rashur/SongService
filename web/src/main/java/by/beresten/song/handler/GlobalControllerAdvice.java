package by.beresten.song.handler;

import by.beresten.song.dto.ErrorEntity;
import by.beresten.song.exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorEntity handleValidationException(MethodArgumentNotValidException exception) {
        var errorEntity = new ErrorEntity();
        errorEntity.setTimestamp(LocalDateTime.now());
        errorEntity.setMessage(exception.getMessage());
        errorEntity.setError(HttpStatus.BAD_REQUEST.toString());
        errorEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        return errorEntity;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SongNotFoundException.class)
    public ErrorEntity handleNotFoundException(SongNotFoundException exception) {
        var errorEntity = new ErrorEntity();
        errorEntity.setTimestamp(LocalDateTime.now());
        errorEntity.setMessage(exception.getMessage());
        errorEntity.setError(HttpStatus.NOT_FOUND.toString());
        errorEntity.setStatus(HttpStatus.NOT_FOUND.value());
        return errorEntity;
    }
}
