package com.example;

import com.example.pojo.table;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FreeCoderApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testAddTable(){
        table table = new table();
        table.setRestID("0000008");
        table.setTableID("10");
        table.setTableLimit(8);
        table.setTableUse(3);
        table.setTableType("包房");
        table.setTableStatus("0");
    }

}
