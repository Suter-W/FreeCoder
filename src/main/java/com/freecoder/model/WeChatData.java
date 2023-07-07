package com.freecoder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName WeChatData
 * @Description TODO
 * @DATE 2023/7/7 10:15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatData {

    private String sessionKey;

    private String openID;
}
