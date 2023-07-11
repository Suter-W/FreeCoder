package com.freecoder.response.httpResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.util.WebUtils;

import java.lang.annotation.Annotation;

@Slf4j
@RestControllerAdvice
public class HttpResultBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = HttpResultBody.class;

    /** �ж�����߷����Ƿ�ʹ���� @ResponseResultBody */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    /** ������߷���ʹ���� @ResponseResultBody �ͻ����������� */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof HttpResult) {
            return body;
        }
        return new HttpResult(HttpStatus.OK, body);
    }


    /**
     * �ṩ�Ա�׼Spring MVC�쳣�Ĵ���
     *
     * @param ex      the target exception
     * @param request the current request
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<HttpResult<?>> exceptionHandler(Exception ex, WebRequest request) {
        log.error("ExceptionHandler: {}", ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof HttpResultException) {
            return this.handleHttpResultException((HttpResultException) ex, headers, request);
        }
        // ��������Զ����������쳣����
        return this.handleException(ex, headers, request);
    }

    /** ��HttpResultException�෵�ط��ؽ���Ĵ��� */
    protected ResponseEntity<HttpResult<?>> handleHttpResultException(HttpResultException ex, HttpHeaders headers, WebRequest request) {
        HttpResult<?> body = new HttpResult(HttpStatus.INTERNAL_SERVER_ERROR, ex.getHttpStatus());
        HttpStatus status = ex.getHttpStatus();
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

    /** �쳣���ͳһ���� */
    protected ResponseEntity<HttpResult<?>> handleException(Exception ex, HttpHeaders headers, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        HttpResult<?> body = new HttpResult(status, null);
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

    /**
     * org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleExceptionInternal(java.lang.Exception, java.lang.Object, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
     * <p>
     * A single place to customize the response body of all exception types.
     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
     * request attribute and creates a {@link ResponseEntity} from the given
     * body, headers, and status.
     */
    protected ResponseEntity<HttpResult<?>> handleExceptionInternal(
            Exception ex, HttpResult<?> body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
