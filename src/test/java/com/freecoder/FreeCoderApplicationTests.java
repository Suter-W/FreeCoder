package com.freecoder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
/**
 * 所有的测试中的token均可以替换，因为测试的环境是一个mockMvc构建的，不是真实运行环境，token的值不会影响测试
 *
 *
 */
class FreeCoderApplicationTests {

    @Test
    void contextLoads() {
    }

}
