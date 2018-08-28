import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Read 
{
	JSONParser parser = new JSONParser();
	
	public void readSimple()
	{
		try {

            Object obj = null;
			try {
				obj = parser.parse(new FileReader("d:\\test.json"));
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("Users");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (ParseException e) {
           // e.printStackTrace();
       // }
	}
	
	public boolean readAndCheck(String login, String password)
	{
		boolean answer=false;
		try {

            Object obj = null;
            
            try {
				obj = parser.parse(new FileReader("d:\\test.json"));
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("Users");
            Iterator<String> iterator = msg.iterator();
            String log="", passwd="";
            String current;
            
            System.out.println("iterator.next(): ");
            System.out.println(iterator.next());
            
            while (iterator.hasNext()) 
            {
                System.out.println(iterator.next());
                //ciecie do srednika i przyrownanie do login,
                // a po sredniku do password i zwrocenie odpowiednio false lub true
                int i=0;
                current=iterator.next();
                while(current.charAt(i)!=';') 
                {
                	log+=current.charAt(i);
                	i++;
                }
                while(i<=current.length())
                {
                	passwd+=current.charAt(i);
                	i++;
                }
                if(login==log)
                	{
                		answer=true;
                		break;
                	};
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (ParseException e) {
		// e.printStackTrace();
       // }
		return answer;
	}
	
	public static void main(String[] args) 
	{

    }
}
