package com.freecoder.response.httpResult;

import com.freecoder.response.result.ResultException;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/web/httpResult")
@PermitAll
@CrossOrigin
@HttpResultBody
public class HttpResultController {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<String, Object>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }

    @GetMapping("hello")
    public HashMap<String, Object> hello() {
        return INFO;
    }

    /** 测试重复包裹 */
    @GetMapping("result")
    public HttpResult<Map<String, Object>> helloResult() {
        return new HttpResult(HttpStatus.OK,INFO);
    }

    @GetMapping("create")
    public ResponseEntity<HttpResult<HashMap<String, Object>>> createResult() {
        return ResponseEntity.accepted().body(new HttpResult(HttpStatus.ACCEPTED,INFO));
    }

    @GetMapping("helloError")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }

    @GetMapping("helloMyError")
    public HashMap<String, Object> helloMyError() throws Exception {
        throw new ResultException();
    }
}
