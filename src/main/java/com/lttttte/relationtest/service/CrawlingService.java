package com.lttttte.relationtest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class CrawlingService {

    public String getHtmlSourceCode(String url) throws IOException {
        return new BufferedReader(new InputStreamReader(new URL(url).openConnection().getInputStream())).lines().collect(Collectors.joining());
    }

    public List<String> getHtmlSourceCodeByList(String url) throws IOException {
        return new BufferedReader(new InputStreamReader(new URL(url).openConnection().getInputStream())).lines().collect(Collectors.toList());
    }

}
