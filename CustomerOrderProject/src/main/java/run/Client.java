package run;
import com.dogukan.customerorderproject.dto.CustDto;

import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.boot.CommandLineRunner;


import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Scanner;
public class Client implements CommandLineRunner {
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

        ///requests-----------------------------------------------------------------------------------
        List<CustDto> customers;
        WebClient custClient = WebClient.builder().baseUrl("http://localhost:8080/cust").build();
        customers = custClient.get().uri("/" + mail)
                .retrieve().bodyToFlux(CustDto.class)
                .collectList().block();
        CustDto cust = customers.get(0);
        String name = cust.getCustName();
        ///-------------------------------------------------------------------------------------------
        List<ProdDto> prods;
        WebClient prodClient = WebClient.builder().baseUrl("http://localhost:8080/prod").build();
        prods = prodClient.get().uri("/getAll")
                .retrieve().bodyToFlux(ProdDto.class)
                .collectList().block();




        List<OrderDto> orders;


        System.out.println("Lütfen listedeki ürünlerden istediğinizi seçiniz");
        String cevap = scanner.nextLine();
        if (cevap.equals("1")) {
            WebClient orderClient = WebClient.builder().baseUrl("http://localhost:8080/orderr").build();
            orders = orderClient.post().uri("/create").
                    syncBody(new OrderDto(10L, cust.getCustId(), prods.get(0).getProdPrice(), prods.get(0).getProdId())).
                    retrieve().bodyToFlux(OrderDto.class).collectList().block();

            System.out.println("Sayın "+cust.getCustName()+"seçtiğiniz ürün " + prods.get(0).getProdName() + ": ve ödemeniz gereken tutar: " + prods.get(0).getProdPrice() + "TL");

        }
        if (cevap.equals("2")) {
            WebClient orderClient = WebClient.builder().baseUrl("http://localhost:8080/orderr").build();
            orders = orderClient.post().uri("/create").
                    syncBody(new OrderDto(10L, cust.getCustId(), prods.get(1).getProdPrice(), prods.get(1).getProdId())).
                    retrieve().bodyToFlux(OrderDto.class).collectList().block();

            System.out.println("Sayın "+cust.getCustName()+" seçtiğiniz ürün " + prods.get(1).getProdName() + ": ve ödemeniz gereken tutar: " + prods.get(1).getProdPrice() + "TL");

        }
        if (cevap.equals("3")) {
            WebClient orderClient = WebClient.builder().baseUrl("http://localhost:8080/orderr").build();
            orders = orderClient.post().uri("/create").
                    syncBody(new OrderDto(10L, cust.getCustId(), prods.get(3).getProdPrice(), prods.get(3).getProdId())).
                    retrieve().bodyToFlux(OrderDto.class).collectList().block();

            System.out.println("Sayın "+cust.getCustName()+" seçtiğiniz ürün " + prods.get(3).getProdName() + ": ve ödemeniz gereken tutar: " + prods.get(3).getProdPrice() + "TL");

        }
    }
}