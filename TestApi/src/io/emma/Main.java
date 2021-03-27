package io.emma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "file:///C:/Users/emz_d/Desktop/Grit%20Academy/7-Web-services/RockPaperScissors-Api/play.html";
    private static final String GET_POST = "http://localhost:8080/start/multi-play?first=rock&second=paper";
    private static final String POST_PARAMS = "first=paper";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new URL("http://localhost:8080/start/multi-play?first=rock&second=paper").openStream());
        while (sc.hasNext())
            System.out.println(sc.nextLine());

        sendGET();

        sendPOST();


    }

    private static void sendPOST() {



    }







    private static void sendGET() throws IOException {

        URL obj = new URL(GET_URL);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();
        System.out.println("GET ResponseCode: " + responseCode);

        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer respone = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {

                respone.append(inputLine);

            }

            in.close();

            System.out.println(respone.toString());
        } else {

            System.out.println("Not working");

        }
    }
}
