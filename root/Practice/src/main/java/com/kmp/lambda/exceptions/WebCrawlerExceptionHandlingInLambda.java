package com.kmp.lambda.exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WebCrawlerExceptionHandlingInLambda {

    public static void main(String args[]) {
        List<String> urls = Arrays.asList("http://www.google.com");

        WebCrawlerExceptionHandlingInLambda crawler = new WebCrawlerExceptionHandlingInLambda();
        crawler.crawl(urls);
        crawler.customCrawl(urls);
    }

    //Crawl WITH new custom ThrowingFunction and custom ThrowableConsumer
    private void customCrawl(List<String> urls) {
        urls.stream()
                .map(ThrowingFunction.unchecked(URL::new))
                .forEach(ThrowableConsumer.unchecked(this::save));
    }

    //Crawl without new custom Function and custom Consumer
    private void crawl(List<String> urls) {

        urls.stream()
                .map(urlToCrawl -> {
                    try {
                        return new URL(urlToCrawl);
                    } catch (MalformedURLException e) {
                        new RuntimeException(e);
                    }
                    return null;
                })
                .forEach(url -> {
                    try {
                        this.save(url);
                    } catch (IOException e) {
                        new RuntimeException(e);
                    }
                });
    }

    private void save(URL url) throws IOException {
        String uuid = UUID.randomUUID().toString();
        InputStream inputStream = url.openConnection().getInputStream();
            Files.copy(inputStream, Paths.get(uuid+".txt"), StandardCopyOption.REPLACE_EXISTING);
    }

}
