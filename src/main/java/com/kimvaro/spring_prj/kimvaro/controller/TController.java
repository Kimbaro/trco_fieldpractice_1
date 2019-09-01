package com.kimvaro.spring_prj.kimvaro.controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.RedirectView;

import javax.net.ssl.SSLException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Controller
public class TController {
//    @Bean
//    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/static/mainMonitoring.html") final Resource indexHtml) {
//        return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
//    }

    @Bean
    public RouterFunction<ServerResponse> staticResourceRouter() {
        return RouterFunctions.resources("/**", new ClassPathResource("/static"));
    }

    @Bean
    public RouterFunction<ServerResponse> mainRouter(@Value("classpath:/static/index.html") final Resource indexHtml) {
        return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
    }

    @Bean
    public RouterFunction<ServerResponse> sslforfree1(@Value("classpath:/.well-known/acme-challenge/_aCiKi_hj5ozXRF0wBpI_EP_wpg7XfAmUqYxai8GJsY") final Resource indexHtml) {
        return route(GET("/.well-known/acme-challenge/_aCiKi_hj5ozXRF0wBpI_EP_wpg7XfAmUqYxai8GJsY"), request -> ok().contentType(MediaType.TEXT_PLAIN).syncBody(indexHtml));
    }

    @Bean
    public RouterFunction<ServerResponse> sslforfree2(@Value("classpath:/.well-known/acme-challenge/6aDbkhIcpbZyrfBe0SqljrBXBNSa-EJ_OWMvmEVAqhw") final Resource indexHtml) {
        return route(GET("/.well-known/acme-challenge/6aDbkhIcpbZyrfBe0SqljrBXBNSa-EJ_OWMvmEVAqhw"), request -> ok().contentType(MediaType.TEXT_PLAIN).syncBody(indexHtml));
    }

    @Bean
    public RouterFunction<ServerResponse> downloadRouter(@Value("classpath:/static/d.html") final Resource indexHtml) {
        return route(GET("/d"), request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
    }

    @Bean
    public RouterFunction<ServerResponse> download1(@Value("classpath:/public/final2.apk") final Resource indexHtml) {
        return route(GET("/trco"), request -> ok().contentType(MediaType.parseMediaType("application/octet-stream")).syncBody(indexHtml));
    }
//    @Bean
//    public RouterFunction<ServerResponse> download2(@Value("classpath:/public/final2.apk") final Resource indexHtml) {
//        return route(GET("/d"), request -> ok().contentType(MediaType.parseMediaType("application/octet-stream")).syncBody(indexHtml));
//    }

    //플레이스토어 다운로드 링크
    @RequestMapping("/play")
    public RedirectView download() {
        return new RedirectView("https://play.app.goo.gl/?link=https://play.google.com/store/apps/details?id=com.kimbaro.android.bluetoothlegatt&ddl=1&pcampaignid=web_ddl_1");
    }
}
