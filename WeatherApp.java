import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;


class WeatherApp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name: ");
        String city  = sc.nextLine();
        System.out.println("You entered:" + city);

        String apikey = "apikey-to-be-entered-here";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey+"&units=metric";
        System.out.println("URL formed:"+url);

        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Response code: "+responseCode);

            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }

                in.close();

                System.out.println("Response Body:\n" + response.toString());
            
                        

                System.out.println("Response body:\n"+ response.toString());
                JSONObject objJson = new JSONObject(response.toString());

                double temp = objJson.getJSONObject("main").getDouble("temp");
                int humidity = objJson.getJSONObject("main").getInt("humidity");

                String description = objJson.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println("\n Weather Report: ");
                System.out.println("Temperature: " + temp + "°C");
                System.out.println("Humidity : " + humidity + "%");
                System.out.println("Description: "+description);

                String Filename = city+"_weather_report.txt";
                try{
                    FileWriter writer = new FileWriter(Filename);
                    writer.write("City: "+city+"\n");
                    writer.write("Temperature: "+temp+"°C\n");
                    writer.write("Humidity: "+humidity+"%\n");
                    writer.write("Description: "+description+"\n");;
                    writer.close();
                    System.out.println("Weather report saved to file: " + Filename);
                }catch(Exception e){
                    System.out.println("Error saving File: " + e.getMessage());
                }
            }
            else{
                System.out.println("Error: Couldn't fetch the data");
             }  
        }
            catch(Exception e){
                System.out.println("Exception: "+e.getMessage());
            }
            finally{
                sc.close();
            }

        }

    }
