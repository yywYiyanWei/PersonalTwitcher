package com.laioffer.jupiter.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.jupiter.entity.Item;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServletUtil {
    public static void writeItemMap(HttpServletResponse res, Map<String, List<Item>> itemMap) throws IOException {
        res.setContentType("application/json;charset=UTF-8");
        res.getWriter().print(new ObjectMapper().writeValueAsString(itemMap));
    }

    public static String encryptPassword(String userId, String password) throws IOException {
        return DigestUtils.md5Hex(userId + DigestUtils.md5Hex(password).toLowerCase());
    }
}
