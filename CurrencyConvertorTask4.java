import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class CurrencyConvertorTask4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Base Currency : ");
        String baseCurrency = scan.next().toUpperCase();
        System.out.print("Enter the Target Currency : ");
        String targetCurrency = scan.next().toUpperCase();
        //Getting the amount from the user
        System.out.print("Enter the amount : ");
        double amount = scan.nextDouble();
        scan.close();
        // API URL
        String url = "https://open.er-api.com/v6/latest/" + baseCurrency;
        
        try {
            // Creating HttpClient
            HttpClient client = HttpClient.newHttpClient();
            // Building HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
                    .build();
            //Sending request and getting response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Finding the rate for the target currency
            String json = response.body();
            String searchKey = "\"" + targetCurrency + "\":"; // e.g. "INR":
            int index = json.indexOf(searchKey);

            if (index != -1) {
                int start = index + searchKey.length();
                int end = json.indexOf(",", start);
                if (end == -1) {
                    end = json.indexOf("}", start);
                }
                String rateStr = json.substring(start, end).trim();
                double rate = Double.parseDouble(rateStr);

                // Calculating converted amount
                double convertedAmount = amount * rate;
                System.out.println("-------------------------");
                System.out.println("         RESULT");
                System.out.println("-------------------------");
                System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
                System.out.println("-------------------------");
            } else {
                System.out.println("Currency not found in API response!");
            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }    
    }
}
