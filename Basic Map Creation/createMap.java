package projects;

import java.util.HashMap;
import java.util.Map;

public class createMap {

    public static Map<Integer,String> myMap(){
        HashMap<Integer,String> objMap = new HashMap<>();

        objMap.put(100,"Abdullah, OK, JavaDeveloper");
        objMap.put(101,"Sena, OK, C#");
        objMap.put(102,"Fatih, OK, QA Tester");
        return objMap;
    }
}
