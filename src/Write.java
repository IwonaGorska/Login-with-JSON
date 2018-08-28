
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Write 
{

	JSONObject obj = new JSONObject();
    JSONArray list = new JSONArray();
	
	public void writeNewOne(String login, String password)
    {
        list.add(login + ";" + password);
        obj.put("Users", list);

        //try (FileWriter file = new FileWriter("f:\\test.json")) {
        try (FileWriter file = new FileWriter("d:\\test.json")) {
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }
	
    public static void main(String[] args) 
    {

    }

}