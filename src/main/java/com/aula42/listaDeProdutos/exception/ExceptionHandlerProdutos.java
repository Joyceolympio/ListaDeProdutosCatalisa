package com.aula42.listaDeProdutos.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerProdutos extends ResponseEntityExceptionHandler{

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida", null, null);
        String mensagemDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new MensagemErro(mensagemUser, mensagemDev), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro{

        private String mensagemDoUsuario;
        private String mensagemDoDev;

    }

    // Outro modo de fazer uma exceção utilizando o @ExceptionHandler

    //    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> exceptionHandlerCampoInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
//        return new ResponseEntity<>("O campo inserido é inválido", HttpStatus.BAD_REQUEST);
//    }

}
