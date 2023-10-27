package br.com.fiap.estoque.utils;

import java.util.HashMap;
import java.util.Map;

public class Mappers {
	
    public static Map<Integer, String> sizeMapper() {
        Map<Integer, String> messageMap = new HashMap<>();
        
        messageMap.put(0, "Produto Pequeno");
        messageMap.put(1, "Produto Médio");
        messageMap.put(2, "Produto Grande");
        
        return messageMap;
    }

}
