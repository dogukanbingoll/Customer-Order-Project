package run;
import com.dogukan.customerorderproject.dto.CustDto;

import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import org.springframework.boot.CommandLineRunner;

import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.Scanner;
public class Client implements CommandLineRunner {

    private static String BASE_URL = "http://localhost:8080/";

    @Override
    public void run(String... args) throws Exception {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hoş geldiniz");
        System.out.println("Mail adresinizi giriniz");
        String mail = scanner.nextLine();
        System.out.println("Lütfen şifrenizi giriniz");
        String sifre = scanner.nextLine();

        Client client = new Client();

        System.out.println("Lütfen listedeki ürünlerden istediğinizi seçiniz");
        String cevap = scanner.nextLine();
        client.getOrderList(client.getCustomer(mail), client.getAllProducts().get(Integer.parseInt(cevap) - 1));
    }

    private CustDto getCustomer(String mail) {
        return WebClient.builder().baseUrl(BASE_URL).build().get().uri("cust/" + mail)
            .retrieve().bodyToMono(CustDto.class)
            .block();
    }

    private List<ProdDto> getAllProducts() {
        return WebClient.builder().baseUrl(BASE_URL).build().get().uri("/getAll")
            .retrieve().bodyToFlux(ProdDto.class).collectList().block();
    }

    private void getOrderList(CustDto cust, ProdDto prodDto) {
        List<OrderDto> orderDtoList = WebClient.builder().baseUrl(BASE_URL).build().post().uri("/create").
            bodyValue(new OrderDto(10L, cust.getCustId(), prodDto.getProdPrice(), prodDto.getProdId())).
            retrieve().bodyToFlux(OrderDto.class).collectList().block();

        System.out.println("Siparişiniz alındı. Sipariş numaranız: " + orderDtoList.get(0).getOrderId());
        System.out.println("Sayın "+ cust.getCustName()+"seçtiğiniz ürün " + prodDto.getProdName() + ": ve ödemeniz gereken tutar: " + prodDto.getProdPrice() + "TL");
    }
}