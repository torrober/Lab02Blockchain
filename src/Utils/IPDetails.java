/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.net.*;
import java.io.*;

/**
 *
 * @author guest
 */
public class IPDetails {

    public static String getIP() throws MalformedURLException, IOException {
        URL whatismyip = new URL("https://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
        String ip = in.readLine(); //you get the IP as a String
        return ip;
    }

    public static String getIPData() throws IOException {
        String ip = IPDetails.getIP();
        URL url = new URL("https://ipapi.co/" + ip + "/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
